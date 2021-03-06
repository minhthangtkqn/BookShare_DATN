package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DangKyForm;
import model.bo.NguoiDungBO;

public class DangKyAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("--- DANG KY ACTION ---");
		HttpSession session = request.getSession();

		// kiem tra dang nhap
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));
		if(type == 1 || type == 2 || type == 3){
			return mapping.findForward("trangChu");
		}
		
		DangKyForm dangKiForm = (DangKyForm) form;

		String taiKhoan = dangKiForm.getTaiKhoan();
		String matKhau = dangKiForm.getMatKhau();
		String nhapLaiMatKhau = dangKiForm.getNhapLaiMatKhau();

		if (taiKhoan.length() == 0) {
			System.out.println("Tài khoản không được để trống >_<!");
			dangKiForm.setLoiTaiKhoan("Username cannot be empty !");
			return mapping.findForward("loi");

		}
		if ((matKhau.length() == 0)) {
			System.out.println("Mật khẩu không phải là nơi để bỏ trống!");
			dangKiForm.setLoiMatKhau("Password cannot be empty !");
			return mapping.findForward("loi");

		}
		if (nguoiDungBO.kiemTraTaiKhoanTonTai(taiKhoan)) {
			System.out.println("Tài khoản này đã tồn tại!");
			dangKiForm.setLoiTaiKhoan("This username is existed !");
			return mapping.findForward("loi");
		}
		if (!(matKhau.equals(nhapLaiMatKhau))) {
			System.out.println("Nhập lại mật khẩu không khớp!");
			dangKiForm.setLoiNhapLaiMatKhau("Confirmation password is not match !");
			return mapping.findForward("loi");
		}
		
		if(nguoiDungBO.dangKi(taiKhoan, matKhau)){
			System.out.println("Đăng kí tài khoản thành công!");
			session.setAttribute("thongBao", "Registering successfully, now you can use that account !");
			return mapping.findForward("thanhcong");
		}else{
			System.out.println("Đã xảy ra lỗi khi đăng ký");
			dangKiForm.setLoiDangKy("There are some problems in register process");
			return mapping.findForward("loi");
		}
	}

}
