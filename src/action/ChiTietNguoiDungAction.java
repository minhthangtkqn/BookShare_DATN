package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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

		// Kiem tra admin dang nhap
		if (nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password")) != 0) {
			System.out.println("chua dang nhap hoac khong phai admin");
			return mapping.findForward("trangChu");
		}

		// check maNguoiDung parameter
		if(StringProcess.notVaild(nguoiDungForm.getMaNguoiDung())){
			System.out.println("KHONG CO MA NGUOI DUNG");
			return mapping.findForward("danhSachNguoiDung");
		}
		
		// check user is exist
		NguoiDung nguoiDung = nguoiDungBO.layNguoiDung(nguoiDungForm.getMaNguoiDung());
		if(nguoiDung == null){
			System.out.println("NGUOI DUNG KHONG TON TAI");
			return mapping.findForward("danhSachNguoiDung");
		}
		
		nguoiDungForm.setNguoiDung(nguoiDung);
		
		return mapping.findForward("chiTietNguoiDung");

	}

}
