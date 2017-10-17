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
		
		HttpSession session = request.getSession();
		DangNhapForm dangNhapForm = (DangNhapForm) form;

		// set time out session
		// session.setMaxInactiveInterval(30000);
		dangNhapForm.setThongBao((String) session.getAttribute("thongBao"));

		if (!StringProcess.notVaild((String)session.getAttribute("userName"))){
			// neu da dang nhap dua ve trang chu
			return mapping.findForward("trangchu");
		}
		String maNguoiDung;
		String anh;

		String taiKhoan = dangNhapForm.getTaiKhoan(); // lay ten dang nhap tu
														// form
		String matKhau = dangNhapForm.getMatKhau(); // lay mat khau tu form

		NguoiDungBO nguoiDungBO = new NguoiDungBO();

		// kiem tra loai TAI KHOAN la ADMIN hay NGUOI DUNG
		int key = nguoiDungBO.kiemTraDangNhap(taiKhoan, matKhau);

		switch (key) {
		case 0: // Day la admin
			System.out.println("Tai khoan admin dang nhap");
			maNguoiDung = nguoiDungBO.layMaNguoiDung(taiKhoan, matKhau); // lay

			session.setAttribute("userName", taiKhoan);
			session.setAttribute("type", 0);
			session.setAttribute("userID", maNguoiDung);
			session.setAttribute("password", dangNhapForm.getMatKhau());

			anh = nguoiDungBO.layAnhNguoiDung(taiKhoan, matKhau);
			session.setAttribute("Avatar", StringProcess.notVaild(anh) ? Constant.NO_IMAGE_DEFAULT : anh);

			System.out.println("Foward den trang-ca-nhan.do");
			return mapping.findForward("trangQuanLy");

		case 1:// Day la nguoi dung
			System.out.println("Tai khoan user dang nhap");

			maNguoiDung = nguoiDungBO.layMaNguoiDung(taiKhoan, matKhau);
			anh = nguoiDungBO.layAnhNguoiDung(taiKhoan, matKhau);

			session.setAttribute("userName", taiKhoan);
			session.setAttribute("type", 1);
			session.setAttribute("userID", maNguoiDung);
			session.setAttribute("Avatar", StringProcess.notVaild(anh) ? "images/No-image.jpg" : anh);

			return mapping.findForward("trangchu");

		case 2:// Day la nguoi dung bi chan

			System.out.println("Tai khoan block dang nhap");

			String liDoChan = nguoiDungBO.layLiDoKhoa(taiKhoan, matKhau);

			maNguoiDung = nguoiDungBO.layMaNguoiDung(taiKhoan, matKhau);
			anh = nguoiDungBO.layAnhNguoiDung(taiKhoan, matKhau);

			session.setAttribute("userName", taiKhoan);
			session.setAttribute("type", 2);
			session.setAttribute("userID", maNguoiDung);
			session.setAttribute("Avatar", StringProcess.notVaild(anh) ? "images/No-image.jpg" : anh);

			session.setAttribute("reason", liDoChan);

			return mapping.findForward("trangbichan");

		case 3:

			dangNhapForm.setLoiMatKhau("TÊN TÀI KHOẢN HOẶC MẬT KHẨU KHÔNG CHÍNH XÁC");
			return mapping.findForward("saimatkhau");

		case 4:
			dangNhapForm.setLoiMatKhau("TÊN TÀI KHOẢN HOẶC MẬT KHẨU KHÔNG CHÍNH XÁC");
			return mapping.findForward("saitaikhoan");
		default:
			// co loi khi dang nhap
			dangNhapForm.setLoiMatKhau("CÓ LỖI XẢY RA TRONG QUÁ TRÌNH ĐĂNG NHẬP");
			return mapping.findForward("error");
		}

	}

}
