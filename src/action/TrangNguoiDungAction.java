package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.TrangNguoiDungForm;
import model.bo.NguoiDungBO;
import model.bo.RaoBanBO;
import model.bo.YeuCauBO;

public class TrangNguoiDungAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		System.out.println("Trang Nguoi Dung Action");

		// Kiem tra dang nhap
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));
		if (type != 1 && type != 2) {
			return mapping.findForward("trangChu");
		}

		/**
		 * get data for showing
		 */
		TrangNguoiDungForm trangNguoiDungForm = (TrangNguoiDungForm) form;

		RaoBanBO raoBanBO = new RaoBanBO();
		YeuCauBO yeuCauBO = new YeuCauBO();

		System.out.println("Bat dau lay du lieu nguoi dung");
		// lay thong tin nguoi dung
		trangNguoiDungForm.setNguoiDung(nguoiDungBO.layNguoiDung((String) session.getAttribute("userID")));

		if (trangNguoiDungForm.getNguoiDung() == null) {
			System.out.println("Nguoi dung khong ton tai");
			return mapping.findForward("dangXuat");
		}
		if (StringProcess.notVaild(trangNguoiDungForm.getNguoiDung().getAnh())) {
			trangNguoiDungForm.getNguoiDung().setAnh("images/No-image.jpg");
		}

		// lay danh sach yeu cau
		trangNguoiDungForm.setDsYeuCau(yeuCauBO.layDanhSachYeuCau((String) session.getAttribute("userID")));
		
		// lay ds goi y
		trangNguoiDungForm.setDsGoiY(raoBanBO.layDanhSachGoiYMoiNguoiCungXem());

		System.out.println("lay ds cho duyet");
		// lay ds cho duyet
		trangNguoiDungForm.setDsChoDuyet(raoBanBO.layDanhSachChoDuyet((String) session.getAttribute("userID")));
		trangNguoiDungForm.setSoLuongChoDuyet(trangNguoiDungForm.getDsChoDuyet().size());
		
		System.out.println("lay ds dang ban");
		// lay ds dang ban
		trangNguoiDungForm.setDsDangBan(raoBanBO.layDanhSachDangBan((String) session.getAttribute("userID")));
		trangNguoiDungForm.setSoLuongDangBan(trangNguoiDungForm.getDsDangBan().size());
		
		System.out.println("lay ds da ban");
		// lay ds da ban
		trangNguoiDungForm.setDsDaBan(raoBanBO.layDanhSachDaBan((String) session.getAttribute("userID")));
		trangNguoiDungForm.setSoLuongDaBan(trangNguoiDungForm.getDsDaBan().size());
		
		System.out.println("Lay ds xem sau");
		//lay ds xem sau
		trangNguoiDungForm.setDsXemSau(raoBanBO.layDanhSachXemSau((String) session.getAttribute("userID")));
		trangNguoiDungForm.setSoLuongXemSau(trangNguoiDungForm.getDsXemSau().size());
		
		return mapping.findForward("giaoDienTrangCaNhan");
	}

}
