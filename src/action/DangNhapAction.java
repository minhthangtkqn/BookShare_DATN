package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.NguoiDungBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();
		DangNhapForm dangNhapForm = (DangNhapForm) form;
		// set time out session
		session.setMaxInactiveInterval(30000);
		dangNhapForm.setThongBao((String)session.getAttribute("thongBao"));
		if (session.getAttribute("userID") != null)
			// return mapping.findForward("trangchu"); // neu da dang nhap dua
			// ve
			// trang hom.jsp
			System.out.println("aaaaaaaaaaaaaaaaaa");
		String maNguoiDung;
		String anh;
		
		
		String taiKhoan = dangNhapForm.getTaiKhoan(); // lay ten dang nhap tu
		// form
		String matKhau = dangNhapForm.getMatKhau(); // lay mat khau tu form

		NguoiDungBO nguoiDungBO = new NguoiDungBO();

		int key = nguoiDungBO.kiemTraDangNhap(taiKhoan, matKhau); // kiem tra
		// dang nhap

		switch (key) {
		case 0: // Day la admin

			maNguoiDung = nguoiDungBO.layMaNguoiDung(taiKhoan, matKhau); // lay
			
			
			session.setAttribute("userName", taiKhoan);
			session.setAttribute("type", 0);
			session.setAttribute("userID", maNguoiDung);
			anh = nguoiDungBO.layAnhNguoiDung(taiKhoan, matKhau); 
			session.setAttribute("Avatar", anh);;

			return mapping.findForward("trangquanli");

		case 1:// Day la nguoi dung
			maNguoiDung = nguoiDungBO.layMaNguoiDung(taiKhoan, matKhau); // lay
			// ma
			// nguoi
			// dung

			session.setAttribute("userName", taiKhoan);
			session.setAttribute("type", 1);
			session.setAttribute("userID", maNguoiDung);
			anh = nguoiDungBO.layAnhNguoiDung(taiKhoan, matKhau); 
			session.setAttribute("Avatar", anh);
// lay


			return mapping.findForward("trangnguoidung");

		case 2:// Day la nguoi dung bi chan

			String liDoChan = nguoiDungBO.layLiDoKhoa(taiKhoan, matKhau); // Lay
			maNguoiDung = nguoiDungBO.layMaNguoiDung(taiKhoan, matKhau); // lay


			session.setAttribute("userName", taiKhoan);
			session.setAttribute("type", 2);
			session.setAttribute("userID", maNguoiDung);
			anh = nguoiDungBO.layAnhNguoiDung(taiKhoan, matKhau); 
			session.setAttribute("Avatar", anh);

			return mapping.findForward("trangbichan");

		case 3:

			dangNhapForm.setLoiMatKhau("Mật khẩu không chính xác!");
			return mapping.findForward("saimatkhau");

		case 4:
			dangNhapForm.setLoiTaiKhoan("Tài khoản không tồn tại!");
			return mapping.findForward("saitaikhoan");
		}
		return mapping.findForward("trangchu");

	}

}
