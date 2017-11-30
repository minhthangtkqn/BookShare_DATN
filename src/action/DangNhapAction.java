package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.NguoiDungBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.Constant;
import common.StringProcess;
import form.DangNhapForm;
import form.NguoiDungForm;

/**
 * NguoiDungAction.java
 * 
 * Version 1.0
 * 
 * Date: Jan 21, 2015
 * 
 * Copyright
 * 
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * ----------------------------------------------------------------------- Jan
 * 21, 2015 DaiLV2 Create
 */

public class DangNhapAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("--- DANG NHAP ACTION ---");

		HttpSession session = request.getSession();
		DangNhapForm dangNhapForm = (DangNhapForm) form;

		// set time out session
		// session.setMaxInactiveInterval(30000);
		dangNhapForm.setThongBao((String) session.getAttribute("thongBao"));

		NguoiDungBO nguoiDungBO = new NguoiDungBO();

		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));

		if (type == 0 || type == 1) {
			// neu da dang nhap dua ve trang chu
			System.out.println("DA DANG NHAP");
			System.out.println("TYPE: " + type);
			return mapping.findForward("trangChu");
		}
		if (type == 2) {
			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.blockedAccount.error"));
			saveErrors(request, errors);
			return mapping.findForward("errorLoggedPage");
		}

		String maNguoiDung;
		String anh;

		String taiKhoan = dangNhapForm.getTaiKhoan(); // lay ten dang nhap tu
														// form
		String matKhau = dangNhapForm.getMatKhau(); // lay mat khau tu form

		// kiem tra loai TAI KHOAN la ADMIN hay NGUOI DUNG
		int key = nguoiDungBO.kiemTraDangNhap(taiKhoan, matKhau);

		switch (key) {
		case 0: // Day la admin
			System.out.println("Tai khoan admin dang nhap");
			maNguoiDung = nguoiDungBO.layMaNguoiDung(taiKhoan, matKhau); // lay
			anh = nguoiDungBO.layAnhNguoiDung(taiKhoan, matKhau);

			session.setAttribute("userName", taiKhoan);
			session.setAttribute("type", 0);
			session.setAttribute("userID", maNguoiDung);
			session.setAttribute("password", dangNhapForm.getMatKhau());
			session.setAttribute("Avatar", StringProcess.notVaild(anh) ? Constant.NO_IMAGE_DEFAULT : anh);

			System.out.println("Forward den trang-ca-nhan.do");
			return mapping.findForward("trangQuanLy");

		case 1:// Day la nguoi dung
			System.out.println("Tai khoan user dang nhap");

			maNguoiDung = nguoiDungBO.layMaNguoiDung(taiKhoan, matKhau);
			anh = nguoiDungBO.layAnhNguoiDung(taiKhoan, matKhau);

			session.setAttribute("userName", taiKhoan);
			session.setAttribute("type", 1);
			session.setAttribute("userID", maNguoiDung);
			session.setAttribute("password", dangNhapForm.getMatKhau());
			session.setAttribute("Avatar", StringProcess.notVaild(anh) ? "images/No-image.jpg" : anh);

			System.out.println("USERID: " + maNguoiDung);
			System.out.println("TYPE: " + type);
			System.out.println("USERNAME: " + taiKhoan);
			System.out.println("LINK ANH: " + anh);

			return mapping.findForward("trangChu");

		case 2:// Day la nguoi dung bi chan

			System.out.println("Tai khoan block dang nhap");

			String liDoChan = nguoiDungBO.layLiDoKhoa(taiKhoan, matKhau);

			maNguoiDung = nguoiDungBO.layMaNguoiDung(taiKhoan, matKhau);
			anh = nguoiDungBO.layAnhNguoiDung(taiKhoan, matKhau);

			session.setAttribute("userName", taiKhoan);
			session.setAttribute("type", 2);
			session.setAttribute("userID", maNguoiDung);
			session.setAttribute("password", dangNhapForm.getMatKhau());
			session.setAttribute("Avatar", StringProcess.notVaild(anh) ? "images/No-image.jpg" : anh);

			session.setAttribute("reason", liDoChan);

			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.blockedAccount.error"));
			saveErrors(request, errors);
			return mapping.findForward("errorLoggedPage");

		case 3:
			dangNhapForm.setLoiMatKhau("LOGIN FAILED. WRONG USER NAME OR PASSWORD");
			return mapping.findForward("saimatkhau");

		case 4:
			dangNhapForm.setLoiMatKhau("LOGIN FAILED. WRONG USER NAME OR PASSWORD");
			return mapping.findForward("saitaikhoan");
		default:
			// co loi khi dang nhap
			dangNhapForm.setLoiMatKhau("AN ERROR HAS OCCURRED DURING LOGIN PROCESS. PLEASE TRY AGAIN LATER.");
			return mapping.findForward("error");
		}

	}

}
