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
import model.bo.NguoiDungBO;
import model.bo.RaoBanBO;

public class ThemDanhMucAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		System.out.println("--- THEM DANH MUC ACTION ---");

		// kiem tra admin dang nhap
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		if (nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password")) != 0) {
			System.out.println("chua dang nhap hoac khong phai admin");
			return mapping.findForward("trangChu");
		}

		DanhMucForm danhMucForm = (DanhMucForm) form;
		DanhMucBO danhMucBO = new DanhMucBO();

		// Check submit
		if (!StringProcess.notVaild(danhMucForm.getSubmit())) {
			// Neu co submit --> check TenDanhMuc
			if (StringProcess.notVaild(danhMucForm.getTenDanhMuc().trim())) {
				danhMucForm.setTenDanhMucError("TÊN DANH MỤC KHÔNG ĐƯỢC ĐỂ TRỐNG");
				danhMucForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());
				return mapping.findForward("thatBai");
			}
			if (danhMucBO.themDanhMuc(danhMucForm.getTenDanhMuc().trim())){
				danhMucForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());
				danhMucForm.setTenDanhMucError("THÊM DANH MỤC THÀNH CÔNG !!!");
				return mapping.findForward("thanhCong");
			}
			danhMucForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());
			return mapping.findForward("thatBai");
		} else {
			// KHONG CO submit
			danhMucForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());
			return mapping.findForward("thatBai");
		}
	}

}
