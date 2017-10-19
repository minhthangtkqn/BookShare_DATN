package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.TrangChuForm;
import model.bo.RaoBanBO;
import model.bo.BannerBO;
import model.bo.DanhMucBO;
import model.bo.NguoiDungBO;

public class TrangChuAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("TrangChuAction");

		HttpSession session = request.getSession();
		TrangChuForm trangChuForm = (TrangChuForm) form;

		BannerBO bannerBO = new BannerBO();
		DanhMucBO danhMucBO = new DanhMucBO();
		RaoBanBO baiRaoBanBO = new RaoBanBO();
		NguoiDungBO nguoiDungBO = new NguoiDungBO();

		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));
		
		if (type == 0) {
			// admin
			return mapping.findForward("trangCaNhan");
		}

		// Lay danh sach banner
		trangChuForm.setDsBanner(bannerBO.layDSBanner());

		// Lay danh sach danh muc
		trangChuForm.setDsDanhMuc(danhMucBO.layTopDanhMucBanNhieu(8));

		// Lay danh sach moi nhat
		trangChuForm.setDsMoiNhat(baiRaoBanBO.layDanhSachMoiNhat());

		// lay danh sach ngau nhien
		trangChuForm.setDsNgauNhien(baiRaoBanBO.layDanhSachNgauNhien());

		// lay ds hot
		trangChuForm.setDsDanhMucBanNhieu(baiRaoBanBO.layDanhSachDanhMucBanNhieuNhat());

		// lay ds GOI Y moi nguoi cung xem
		trangChuForm.setDsGoiYMoiNguoiCungXem(baiRaoBanBO.layDanhSachGoiYMoiNguoiCungXem());

		// Kiem tra dang nhap
		if (type != 1 && type != 2) {
			return mapping.findForward("index");
		}

		// NEU DA DANG NHAP --> Bat Dau xu li
		trangChuForm.setDsGoiY(baiRaoBanBO.layDanhSachGoiY((String) session.getAttribute("userID")));
		return mapping.findForward("home");
	}

}
