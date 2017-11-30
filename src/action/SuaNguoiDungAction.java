package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.NguoiDungForm;
import form.TrangNguoiDungForm;
import model.bean.NguoiDung;
import model.bo.NguoiDungBO;
import model.bo.RaoBanBO;
import model.bo.TinhBO;

public class SuaNguoiDungAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		System.out.println("Sua Profile Action");

		// neu chua dang nhap --> dua ve trang chu
		// Kiem tra user dang nhap
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));
		
		if(type == 2){
			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.blockedAccount.error"));
			saveErrors(request, errors);
			return mapping.findForward("errorLoggedPage");
		}
		if (type != 1) {
			System.out.println("chua dang nhap hoac khong phai tai khoan nguoi dung");
			return mapping.findForward("trangChu");
		}

		NguoiDungForm nguoiDungForm = (NguoiDungForm) form;
		RaoBanBO raoBanBO = new RaoBanBO();
		TinhBO tinhBO = new TinhBO();

		if ("submit".equals(nguoiDungForm.getSubmit())) {
			NguoiDung nguoiDung = new NguoiDung();

			if ("suaThongTin".equals(nguoiDungForm.getAction())) {
				nguoiDung.setMaNguoiDung((String) session.getAttribute("userID"));
				nguoiDung.setHoTen(nguoiDungForm.getHoTen());
				nguoiDung.setDienThoai(nguoiDungForm.getDienThoai());
				nguoiDung.setEmail(nguoiDungForm.getEmail());
				nguoiDung.setGioiTinh(nguoiDungForm.getGioiTinh());
				nguoiDung.setMaTinh(nguoiDungForm.getMaTinh());
				nguoiDung.setAnh(nguoiDungForm.getAnh());
				nguoiDung.setNamSinh(nguoiDungForm.getNamSinh());

				nguoiDungBO.suaThongTin(nguoiDung);
				return mapping.findForward("suaThongTinXong");
			} else {
				if ("suaMatKhau".equals(nguoiDungForm.getAction())) {
					nguoiDung.setMaNguoiDung((String) session.getAttribute("userID"));
					nguoiDung.setMatKhau(nguoiDungForm.getMatKhau());

					if(nguoiDungBO.suaMatKhau(nguoiDung)){
						session.setAttribute("password", nguoiDungForm.getMatKhau());
					}
					return mapping.findForward("suaMatKhauXong");
				} else {
					System.out.println("Xuat hien hanh dong dang' ngo`");
					System.out.println("Tai khoan duoc dang xuat de bao dam bao mat");
					return mapping.findForward("dangXuat");
				}
			}
		} else {
			// lay thong tin nguoi dung
			NguoiDung nguoiDung = nguoiDungBO.layNguoiDung((String) session.getAttribute("userID"));
			if (nguoiDung == null) {
				System.out.println("Nguoi dung khong ton tai");
				return mapping.findForward("dangXuat");
			}

			nguoiDungForm.setTaiKhoan(nguoiDung.getTaiKhoan());
			nguoiDungForm.setHoTen(nguoiDung.getHoTen());
			nguoiDungForm.setDienThoai(nguoiDung.getDienThoai());
			nguoiDungForm.setEmail(nguoiDung.getEmail());
			nguoiDungForm.setGioiTinh(nguoiDung.getGioiTinh());
			nguoiDungForm.setMaTinh(nguoiDung.getMaTinh());
			nguoiDungForm.setAnh(nguoiDung.getAnh());

			// lay ds Tinh
			nguoiDungForm.setDsTinh(tinhBO.getListTinh());

			// hien thi form chinh sua thong tin
			return mapping.findForward("suaND");
		}
	}

}
