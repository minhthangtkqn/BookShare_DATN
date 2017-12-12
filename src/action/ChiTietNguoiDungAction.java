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

import common.Constant;
import common.StringProcess;
import form.NguoiDungForm;
import model.bean.NguoiDung;
import model.bo.NguoiDungBO;

public class ChiTietNguoiDungAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("--- CHI TIET NGUOI DUNG ---");
		HttpSession session = request.getSession();
		NguoiDungForm nguoiDungForm = (NguoiDungForm) form;
		NguoiDungBO nguoiDungBO = new NguoiDungBO();

		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));

		NguoiDung nguoiDung = nguoiDungBO.layNguoiDung(nguoiDungForm.getMaNguoiDung());

		// Kiem tra admin dang nhap
		switch (type) {
		case 0:
			// check maNguoiDung parameter
			if (StringProcess.notVaild(nguoiDungForm.getMaNguoiDung())) {
				System.out.println("KHONG CO MA NGUOI DUNG");
				return mapping.findForward("danhSachNguoiDung");
			}

			if (nguoiDung == null) {
				System.out.println("NGUOI DUNG KHONG TON TAI");
				return mapping.findForward("danhSachNguoiDung");
			}

			nguoiDungForm.setNguoiDung(nguoiDung);

			if (nguoiDung.getLoaiNguoiDung().equals(Constant.NORMAL_ACCOUNT)) {
				nguoiDungForm.setThaoTacKhaDung(0);
			} else {
				nguoiDungForm.setThaoTacKhaDung(1);
			}
			System.out.println("Hành động: " + nguoiDungForm.getThaoTacKhaDung());
			return mapping.findForward("chiTietNguoiDung");

		default:
			if (nguoiDung == null) {
				System.out.println("NGUOI DUNG KHONG TON TAI");
				ActionErrors errors = new ActionErrors();
				errors.add("error", new ActionMessage("error.nguoiDung.null"));
				saveErrors(request, errors);
				return mapping.findForward("errorLoggedPage");
			}
			nguoiDungForm.setNguoiDung(nguoiDung);
			return mapping.findForward("chiTietNguoiDung");
		}

	}

}
