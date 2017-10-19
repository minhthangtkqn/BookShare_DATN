package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachNguoiDungForm;
import form.NguoiDungForm;
import form.TrangQuanLyForm;
import model.bo.NguoiDungBO;
import model.bo.RaoBanBO;
import model.bo.TinhBO;

public class DanhSachNguoiDungAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		System.out.println(" --- DANH SACH NGUOI DUNG ACTION ---");
		DanhSachNguoiDungForm danhSachNguoiDungForm = (DanhSachNguoiDungForm) form;
		
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		TinhBO tinhBO = new TinhBO();

		// Kiem tra admin dang nhap
		if (nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password")) != 0) {
			System.out.println("chua dang nhap hoac khong phai admin");
			return mapping.findForward("trangChu");
		}
		
		// lay danh sach nguoi dung
		danhSachNguoiDungForm.setDsNguoiDung(nguoiDungBO.layDanhSachNguoiDung());
		
		// lay danh sach Tinh
		danhSachNguoiDungForm.setDsTinh(tinhBO.getListTinh());
		
		return mapping.findForward("danhSachNguoiDung");
	}

}
