package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import form.ChiTietBaiDangForm;
import model.bean.RaoBan;
import model.bo.RaoBanBO;

public class DuyetBaiDangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("Duyet Bai Dang Action");

		HttpSession session = request.getSession();

		// Kiem tra dang nhap
		if (StringProcess.notVaild((String) session.getAttribute("userID"))) {
			System.out.println("Chua dang nhap");
			return mapping.findForward("dangNhap");
		}

		ChiTietBaiDangForm chiTietBaiDangForm = new ChiTietBaiDangForm();

		// Neu da dang nhap
		// Check Ma Rao Ban
		System.out.println("maRaoBan: " + request.getParameter("maRaoBan"));
		System.out.println("maRaoBan Form: " + chiTietBaiDangForm.getMaRaoBan());
		if (StringProcess.notVaild(request.getParameter("maRaoBan"))) {
			// neu ko co Ma Rao Ban --> trang ca nhan
			System.out.println("Khong co MA RAO BAN");
			return mapping.findForward("thatBai");
		}
		String maRaoBan = request.getParameter("maRaoBan");
		RaoBanBO raoBanBO = new RaoBanBO();

		// Check submit
		if ("submit".equals(chiTietBaiDangForm.getSubmit())) {
			// Neu co submit --> goi ham` duyet bai dang
			raoBanBO.duyetBaiDang(maRaoBan);
			return mapping.findForward("thanhCong");
		} else {
			// goi ham` lay du~ lieu va` hien thi giao dien chi tiet bai dang
			// cho admin
			RaoBan raoBan = raoBanBO.layThongTinBaiDang(maRaoBan);
			// kiem tra bai dang co ton tai khong
			if (raoBan == null) {
				System.out.println("Bai dang khong ton tai");
				ActionErrors errors = new ActionErrors();
				errors.add("error", new ActionMessage("error.baiDang.null"));
				saveErrors(request, errors);

				return mapping.findForward("error");
			}

			chiTietBaiDangForm.setChiTiet(raoBan);
			chiTietBaiDangForm.setMaRaoBan(maRaoBan);
			System.out.println("Thong tin chi tiet");
			System.out.println("Ten Sach: " + chiTietBaiDangForm.getChiTiet().getTenSach());
			System.out.println("Ma rao ban: " + chiTietBaiDangForm.getChiTiet().getMaRaoBan());
			return mapping.findForward("giaoDienDuyetBai");
		}

	}

}
