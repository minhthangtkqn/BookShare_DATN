package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.ChiTietBaiDangForm;
import model.bo.NguoiDungBO;
import model.bo.RaoBanBO;

public class KhongDuyetBaiDangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("Khong Duyet Bai Dang Action");

		HttpSession session = request.getSession();

		// Kiem tra admin dang nhap
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		if (nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password")) != 0) {
			System.out.println("chua dang nhap hoac khong phai admin");
			return mapping.findForward("trangChu");
		}

		ChiTietBaiDangForm chiTietBaiDangForm = (ChiTietBaiDangForm) form;

		// Check Ma Rao Ban
		if (StringProcess.notVaild(chiTietBaiDangForm.getMaRaoBan())) {
			// neu ko co Ma Rao Ban --> trang ca nhan
			System.out.println("Khong co MA RAO BAN");
			return mapping.findForward("thatBai");
		}
		RaoBanBO raoBanBO = new RaoBanBO();

		// Check submit
		if (!StringProcess.notVaild(chiTietBaiDangForm.getSubmit())) {
			// Neu co submit --> goi ham` duyet bai dang
			System.out.println("Submit tu` trang duyet bai dang");
			raoBanBO.khongDuyetBaiDang(chiTietBaiDangForm.getMaRaoBan());
			return mapping.findForward("thanhCong");
		} else {
			// KHONG CO submit
			return mapping.findForward("thatBai");
		}
	}
}
