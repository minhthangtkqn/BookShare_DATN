package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhGiaNguoiBanForm;
import model.bo.NguoiDungBO;

public class DanhGiaNguoiBanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("--- DANH GIA NGUOI BAN ACTION ---");

		HttpSession session = request.getSession();
		DanhGiaNguoiBanForm danhGiaNguoiBanForm = (DanhGiaNguoiBanForm) form;

		// Kiem tra dang nhap - only normal account
//		NguoiDungBO nguoiDungBO = new NguoiDungBO();
//		if (nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
//				(String) session.getAttribute("password")) != 1) {
//			System.out.println("Chua dang nhap hoac khong phai tai khoan binh thuong");
//			return mapping.findForward("trangChu");
//		}

		System.out.println("Ma nguoi ban: " + danhGiaNguoiBanForm.getMaNguoiBan());
		System.out.println("Diem danh gia: " + danhGiaNguoiBanForm.getDiemDanhGia());
		System.out.println("Binh luan: " + danhGiaNguoiBanForm.getBinhLuan());
		
		return null;
	}

}
