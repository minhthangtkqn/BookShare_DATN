package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.DanhMucForm;
import model.bo.DanhMucBO;
import model.bo.RaoBanBO;

public class DanhMucAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");

		System.out.println("DanhMucAction");

		HttpSession session = request.getSession();
		DanhMucForm danhMucForm = (DanhMucForm) form;
		DanhMucBO danhMucBO = new DanhMucBO();
		RaoBanBO raoBanBO = new RaoBanBO();

		// lay list danh muc
		danhMucForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());

		// lay ds Goi Y chung
		danhMucForm.setDsGoiYMoiNguoiCungXem(raoBanBO.layDanhSachGoiYMoiNguoiCungXem());

		// kiem tra ma danh muc
		if (StringProcess.notVaild(danhMucForm.getMaDanhMuc())) {
			// neu khong co ma danh muc --> load cac rao ban moi' nhat
			danhMucForm.setDsRaoBanTrongDanhMuc(raoBanBO.layDanhSachMoiNhat());
		} else {
			// neu co ma danh muc --> kiem tra keyword
			System.out.println("Ma DM tim kiem: " + danhMucForm.getMaDanhMuc());
			if (StringProcess.notVaild(danhMucForm.getTuKhoa())) {
				// neu KHONG co TU KHOA
				// --> load cac rao ban moi nhat trong danh muc
				System.out.println("Khong co tu khoa");
				danhMucForm.setDsRaoBanTrongDanhMuc(raoBanBO.layDsMoiNhatTheoDanhMuc(danhMucForm.getMaDanhMuc()));
			} else {
				// neu co TU KHOA --> load cac bai tim kiem tuong ung
				// ----- luu tu khoa vao du lieu tim kiem
				raoBanBO.luuTuKhoaTimKiem(
						(session.getAttribute("userID") == null) ? "" : (String) (session.getAttribute("userID")),
						danhMucForm.getTuKhoa());
				System.out.println("TU KHOA: " + danhMucForm.getTuKhoa());
				// xu ly chuc nang tim kiem
				// ----- xu ly tu khoa
				String arrayTuKhoa[] = danhMucForm.getTuKhoa().split("\\s+");
				String arrayTuKhoaKhongDau[] = StringProcess.removeDiacritics(danhMucForm.getTuKhoa()).split("\\s+");

				// ----- chay cac ham` tim kiem
				danhMucForm.setDsRaoBanTrongDanhMuc(
						raoBanBO.timKiemTrongDanhMuc(danhMucForm.getMaDanhMuc(), danhMucForm.getTuKhoa()));
				for (String item : arrayTuKhoa) {
					danhMucForm.getDsRaoBanTrongDanhMuc().addAll(raoBanBO.timKiemTrongDanhMuc(danhMucForm.getMaDanhMuc(), item));
				}
				for (String item : arrayTuKhoaKhongDau) {
					danhMucForm.getDsRaoBanTrongDanhMuc().addAll(raoBanBO.timKiemTrongDanhMuc(danhMucForm.getMaDanhMuc(), item));
				}

				// filter duplicate results
				for (int i = 0; i < danhMucForm.getDsRaoBanTrongDanhMuc().size(); i++) {
					for (int j = i + 1; j < danhMucForm.getDsRaoBanTrongDanhMuc().size(); j++) {

						if (danhMucForm.getDsRaoBanTrongDanhMuc().get(i).getMaRaoBan()
								.equals(danhMucForm.getDsRaoBanTrongDanhMuc().get(j).getMaRaoBan())) {
							danhMucForm.getDsRaoBanTrongDanhMuc().remove(j);
							j--;
						}

					}
				}
				// END filter duplicate results
			}

		}

		// kiem tra dang nhap de phan luong`
		if (StringProcess.notVaild((String) session.getAttribute("userName"))) {
			// neu chua dang nhap
			return mapping.findForward("chuaDangNhap");
		}

		// neu da dang nhap
		return mapping.findForward("daDangNhap");

	}

}
