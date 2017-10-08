package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TrangNguoiDungForm;
import model.bo.NguoiDungBO;
import model.bo.RaoBanBO;

public class TrangNguoiDungAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		System.out.println("Trang Nguoi Dung Action");

		// neu chua dang nhap --> dua ve trang chu
		if (session.getAttribute("userID") == null) {
			return mapping.findForward("trangChu");
		}
		
		/**
		 * get data for showing
		 */
		TrangNguoiDungForm trangNguoiDungForm = (TrangNguoiDungForm) form;

		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		RaoBanBO raoBanBO = new RaoBanBO();
		
		System.out.println("Bat dau lay du lieu nguoi dung");
		// lay thong tin nguoi dung
		trangNguoiDungForm.setNguoiDung(nguoiDungBO.layNguoiDung((String) session.getAttribute("userID")));

		if(trangNguoiDungForm.getNguoiDung() == null){
			System.out.println("Nguoi dung khong ton tai");
			return mapping.findForward("dangXuat");
		}
		
		// lay ds goi y
		trangNguoiDungForm.setDsGoiY(raoBanBO.layDanhSachGoiYMoiNguoiCungXem());
		
		System.out.println("lay ds cho duyet");
		// lay ds cho duyet
		trangNguoiDungForm.setDsChoDuyet(raoBanBO.layDanhSachChoDuyet((String) session.getAttribute("userID")));

		System.out.println("lay ds dang ban");
		// lay ds dang ban
		trangNguoiDungForm.setDsDangBan(raoBanBO.layDanhSachDangBan((String) session.getAttribute("userID")));

		System.out.println("lay ds da ban");
		// lay ds da ban
		trangNguoiDungForm.setDsDaBan(raoBanBO.layDanhSachDaBan((String) session.getAttribute("userID")));

		// lay ds da mua
		// trangNguoiDungForm.setDsDaMua(raoBanBO.layD)

		return mapping.findForward("trangCaNhan");
	}

}
