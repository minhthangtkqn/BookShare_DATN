package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.KetQuaTimKiemForm;
import model.bean.RaoBan;
import model.bo.RaoBanBO;

public class KetQuaTimKiemAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");

		System.out.println("Ket Qua Tim Kiem Action");

		HttpSession session = request.getSession();

		KetQuaTimKiemForm ketQuaTimKiemForm = (KetQuaTimKiemForm) form;
		RaoBanBO raoBanBO = new RaoBanBO();

		String tuKhoa = (ketQuaTimKiemForm.getTuKhoa() == null) ? "" : ketQuaTimKiemForm.getTuKhoa();

		System.out.println("Tu khoa tim kiem: -|" + tuKhoa + "|-");

		// Lưu từ khóa tìm kiếm vào CSDL
		// nếu từ khóa rỗng thì không lưu vào CSDL những vẫn tìm kiếm
		if (!StringProcess.notVaild(tuKhoa)) {
			raoBanBO.luuTuKhoaTimKiem(
					(session.getAttribute("userID") == null) ? "" : (String) (session.getAttribute("userID")), tuKhoa);
		}

		// Xử lý từ khóa tìm kiếm
		String[] arrayTuKhoa = tuKhoa.split("\\s+");
		System.out.println("Các từ khóa con:");
		for (String item : arrayTuKhoa) {
			System.out.println("-|" + item + "|-");
		}

		// loai bo dau tieng Viet
		String tuKhoaKhongDau = StringProcess.removeDiacritics(tuKhoa);
		String[] arrayTuKhoaKhongDau = tuKhoaKhongDau.split("\\s+");
		System.out.println("Các từ khóa con KHÔNG DẤU:");
		for (String item : arrayTuKhoa) {
			System.out.println("-|" + item + "|-");
		}
		// END xử lý từ khóa

		// -----------------

		// Tim kiem ten SACH dua theo cac tu khoa
		ketQuaTimKiemForm.setListRaoBan(raoBanBO.layDanhSachTimKiemTenSach(tuKhoa));
		for (String item : arrayTuKhoa) {
			ketQuaTimKiemForm.getListRaoBan().addAll(raoBanBO.layDanhSachTimKiemTenSach(item));
		}
		for (String item : arrayTuKhoaKhongDau) {
			ketQuaTimKiemForm.getListRaoBan().addAll(raoBanBO.layDanhSachTimKiemTenSach(item));
		}
		// END Tim kiem SACH dua theo cac tu khoa

		// -----------------

		// Tim kiem ten TAC GIA dua theo cac tu khoa
		ketQuaTimKiemForm.getListRaoBan().addAll(raoBanBO.layDanhSachTimKiemTenTacGia(tuKhoa));

		for (String item : arrayTuKhoa) {
			ketQuaTimKiemForm.getListRaoBan().addAll(raoBanBO.layDanhSachTimKiemTenTacGia(item));
		}
		for (String item : arrayTuKhoaKhongDau) {
			ketQuaTimKiemForm.getListRaoBan().addAll(raoBanBO.layDanhSachTimKiemTenTacGia(item));
		}
		// END Tim kiem TAC GIA dua theo cac tu khoa

		// -----------------

		// Lọc lại các kết quả tìm kiếm trùng nhau
		for (int i = 0; i < ketQuaTimKiemForm.getListRaoBan().size(); i++) {
			for (int j = i + 1; j < ketQuaTimKiemForm.getListRaoBan().size(); j++) {

				if (ketQuaTimKiemForm.getListRaoBan().get(i).getMaRaoBan()
						.equals(ketQuaTimKiemForm.getListRaoBan().get(j).getMaRaoBan())) {
					ketQuaTimKiemForm.getListRaoBan().remove(j);
					j--;
				}

			}
		}
		// END Lọc lại các kết quả tìm kiếm trùng nhau

		// -----------------

		if (StringProcess.notVaild((String) session.getAttribute("userName")))

			return mapping.findForward("ketQua");

		return mapping.findForward("ketQuaLogged");
	}

}
