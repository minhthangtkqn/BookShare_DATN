package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TrangNguoiDungForm;
import form.TrangQuanLyForm;
import model.bo.NguoiDungBO;
import model.bo.RaoBanBO;

public class TrangQuanLyAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		System.out.println("Trang Quan Ly Action");

		// neu chua dang nhap --> dua ve trang chu
		if (session.getAttribute("userID") == null) {
			return mapping.findForward("trangChu");
		}
		
		// get data
		TrangQuanLyForm trangQuanLyForm = (TrangQuanLyForm) form;

		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		RaoBanBO raoBanBO = new RaoBanBO();
		
		System.out.println("Bat dau lay du lieu ADMIN");
		// lay thong tin nguoi dung
		trangQuanLyForm.setAdmin(nguoiDungBO.layAdmin((String) session.getAttribute("userID")));

		if(trangQuanLyForm.getAdmin() == null){
			System.out.println("Tai khoan ADMIN khong ton tai");
			System.out.println("Hệ thống sẽ đăng xuất để đảm bảo bảo mật");
			return mapping.findForward("dangXuat");
		}else{
			if(!trangQuanLyForm.getAdmin().getLoaiNguoiDung().equals("0")){
				System.out.println("Đây không phải là tài khoản ADMIN");
				return mapping.findForward("trangChu");
			}
		}
		
		System.out.println("lay ds cho duyet");
		// lay ds cho duyet
		trangQuanLyForm.setDsChoDuyet(raoBanBO.layDanhSachChoDuyet());

		System.out.println("lay ds dang ban");
		// lay ds dang ban
		trangQuanLyForm.setDsDangBan(raoBanBO.layDanhSachDangBan());

		System.out.println("lay ds da ban");
		// lay ds da ban
		trangQuanLyForm.setDsDaBan(raoBanBO.layDanhSachDaBan());

		// lay ds da mua
		// trangQuanLyForm.setDsDaMua(raoBanBO.layD)

		return mapping.findForward("trangCaNhan");
	}

}
