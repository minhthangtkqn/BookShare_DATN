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
		System.out.println("Tu khoa tim kiem: -|" + tuKhoa + "|-");
		ketQuaTimKiemForm.setTuKhoa(tuKhoa);

		String sapXepThoiGian = StringProcess.notVaild(ketQuaTimKiemForm.getSapXepThoiGian())
				? Constant.DEFAULT_SAP_XEP_THOI_GIAN
				: (Constant.DEFAULT_SAP_XEP_THOI_GIAN.equals(ketQuaTimKiemForm.getSapXepThoiGian())
						? Constant.DEFAULT_SAP_XEP_THOI_GIAN : "ASC");
		ketQuaTimKiemForm.setSapXepThoiGian(sapXepThoiGian);

		String sapXepGia = StringProcess.notVaild(ketQuaTimKiemForm.getSapXepGia()) ? Constant.DEFAULT_SAP_XEP_GIA
				: (Constant.DEFAULT_SAP_XEP_GIA.equals(ketQuaTimKiemForm.getSapXepGia()) ? Constant.DEFAULT_SAP_XEP_GIA
						: "DESC");
		ketQuaTimKiemForm.setSapXepGia(sapXepGia);

		String maDanhMuc = (StringProcess.notVaild(ketQuaTimKiemForm.getMaDanhMuc()) ? "all"
				: ketQuaTimKiemForm.getMaDanhMuc());
		ketQuaTimKiemForm.setMaDanhMuc(maDanhMuc);

		String maTinh = (StringProcess.notVaild(ketQuaTimKiemForm.getMaTinh()) ? "all" : ketQuaTimKiemForm.getMaTinh());
		ketQuaTimKiemForm.setMaTinh(maTinh);

		int page;
		try {
			page = Integer.parseInt(ketQuaTimKiemForm.getPage());
		} catch (Exception e) {
			page = 1;
			ketQuaTimKiemForm.setPage("" + page);
		}
		request.setAttribute("page", page);

		// Lưu từ khóa tìm kiếm vào CSDL
		// nếu từ khóa rỗng thì không lưu vào CSDL những vẫn tìm kiếm
		if (!StringProcess.notVaild(tuKhoa)) {
			raoBanBO.luuTuKhoaTimKiem(StringProcess.getVaildString((String) session.getAttribute("userID")), tuKhoa);
		}

		// -----------------
		// goi ham tim kiem
		ArrayList<Object> ketQua = raoBanBO.layDanhSachTimKiem(tuKhoa, maTinh, maDanhMuc, sapXepGia, sapXepThoiGian,
				page);

		ketQuaTimKiemForm.setListRaoBan((ArrayList<RaoBan>) ketQua.get(1));

		request.setAttribute("soLuongKetQua", (Integer) ketQua.get(0));
		request.setAttribute("maxPage", (Integer) ketQua.get(0) / Constant.NUMBER_PRODUCT_ON_PAGE + 1);
		// -----------------

		if (StringProcess.notVaild((String) session.getAttribute("userName")))

			return mapping.findForward("ketQua");

		return mapping.findForward("ketQuaLogged");
	}

}
