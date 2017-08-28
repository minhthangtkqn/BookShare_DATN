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

		if (session.getAttribute("userID") == null) {
			return mapping.findForward("index"); // neu chua dang nhap dua ve
													// index
		}

		// NEU DA DANG NHAP --> Bat Dau xu li
//		int userType = (Integer) session.getAttribute("type");
		String userID = (String) session.getAttribute("userID");

		// lay DS goi y
		trangChuForm.setDsGoiY(baiRaoBanBO.layDanhSachGoiY(userID));

		return mapping.findForward("home");
	}

}
