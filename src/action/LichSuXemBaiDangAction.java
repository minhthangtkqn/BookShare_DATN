package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.LichSuXemBaiDangForm;
import model.bo.NguoiDungBO;
import model.bo.RaoBanBO;

public class LichSuXemBaiDangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("LichSuXemBaiDangAction");
		HttpSession session = request.getSession();
		LichSuXemBaiDangForm lichSuXemBaiDangForm = (LichSuXemBaiDangForm) form;

		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		RaoBanBO raoBanBO = new RaoBanBO();

		// Kiem tra dang nhap
		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));
		if (type != 1 && type != 2) {
			return mapping.findForward("taiKhoanKhongHopLe");
		}

		// kiem tra co maNguoiDung hay khong
		if (StringProcess.notVaild((String) session.getAttribute("userID"))) {
			System.out.println("Khong co MA NGUOI DUNG");
			return mapping.findForward("khongCoMaNguoiDung");
		}

		// lay ds cac bai dang da xem
		lichSuXemBaiDangForm.setListBaiDangDaXem(raoBanBO.layLichSuXemBaiDang((String) session.getAttribute("userID")));

		// lay ds hot
		lichSuXemBaiDangForm.setDsHot(raoBanBO.layDanhSachHot());
		
		return mapping.findForward("lichSuXemBaiDang");
	}

}
