package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.Constant;
import common.StringProcess;
import form.KetQuaTimKiemForm;
import model.bean.RaoBan;
import model.bo.DanhMucBO;
import model.bo.RaoBanBO;
import model.bo.TinhBO;

public class KetQuaTimKiemAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("Ket Qua Tim Kiem Action");

		HttpSession session = request.getSession();
		KetQuaTimKiemForm ketQuaTimKiemForm = (KetQuaTimKiemForm) form;

		TinhBO tinhBO = new TinhBO();
		RaoBanBO raoBanBO = new RaoBanBO();
		DanhMucBO danhMucBO = new DanhMucBO();

		// lay DS tinh va Danh Muc
		ketQuaTimKiemForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());
		ketQuaTimKiemForm.setDsTinh(tinhBO.getListTinh());

		// lay dsHot --> goi y
		ketQuaTimKiemForm.setDsHot(raoBanBO.layDanhSachHot());

		// xu ly cac tham so
		String tuKhoa = StringProcess.getVaildString(ketQuaTimKiemForm.getTuKhoa());
		String sapXepThoiGian = StringProcess.notVaild(ketQuaTimKiemForm.getSapXepThoiGian())
				? Constant.DEFAULT_SAP_XEP_THOI_GIAN
				: ("0".equals(ketQuaTimKiemForm.getSapXepThoiGian()) ? "DESC" : "ASC");
		String sapXepGia = StringProcess.notVaild(ketQuaTimKiemForm.getSapXepGia()) ? Constant.DEFAULT_SAP_XEP_GIA
				: ("0".equals(ketQuaTimKiemForm.getSapXepGia()) ? "DESC" : "ASC");
		String maDanhMuc = (StringProcess.notVaild(ketQuaTimKiemForm.getMaDanhMuc()) ? "all"
				: ketQuaTimKiemForm.getMaDanhMuc());
		String maTinh = (StringProcess.notVaild(ketQuaTimKiemForm.getMaTinh()) ? "all" : ketQuaTimKiemForm.getMaTinh());

		int page;
		try {
			page = Integer.parseInt(ketQuaTimKiemForm.getPage());
		} catch (Exception e) {
			page = 1;
			ketQuaTimKiemForm.setPage("" + page);
		}

		System.out.println("Tu khoa tim kiem: -|" + tuKhoa + "|-");
		ketQuaTimKiemForm.setTuKhoa(tuKhoa);

		// Lưu từ khóa tìm kiếm vào CSDL
		// nếu từ khóa rỗng thì không lưu vào CSDL những vẫn tìm kiếm
		if (!StringProcess.notVaild(tuKhoa)) {
			raoBanBO.luuTuKhoaTimKiem(StringProcess.getVaildString((String) session.getAttribute("userID")), tuKhoa);
		}

		// -----------------
		// goi ham tim kiem
		ketQuaTimKiemForm
				.setListRaoBan(raoBanBO.layDanhSachTimKiem(tuKhoa, maTinh, maDanhMuc, sapXepGia, sapXepThoiGian, page));

		// -----------------

		if (StringProcess.notVaild((String) session.getAttribute("userName")))

			return mapping.findForward("ketQua");

		return mapping.findForward("ketQuaLogged");
	}

}
