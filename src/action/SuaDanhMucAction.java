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

public class SuaDanhMucAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		System.out.println("--- SUA DANH MUC ACTION ---");

		// kiem tra admin dang nhap
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		if (nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password")) != 0) {
			System.out.println("chua dang nhap hoac khong phai admin");
			return mapping.findForward("trangChu");
		}

		DanhMucForm danhMucForm = (DanhMucForm) form;
		DanhMucBO danhMucBO = new DanhMucBO();

		//Check MaDanhMuc
		if(StringProcess.notVaild(danhMucForm.getMaDanhMuc())){
			System.out.println("KHONG CO MA DANH MUC");
			return mapping.findForward("listDanhMuc");
		}
		
		// Check submit
		if (!StringProcess.notVaild(danhMucForm.getSubmit())) {
			// Neu co submit --> check TenDanhMuc
			if (StringProcess.notVaild(danhMucForm.getTenDanhMuc().trim())) {
				danhMucForm.setTenDanhMucError("TÊN DANH MỤC KHÔNG ĐƯỢC ĐỂ TRỐNG");
				return mapping.findForward("thatBai");
			}
			if (danhMucBO.suaDanhMuc(danhMucForm.getTenDanhMuc().trim(), danhMucForm.getMaDanhMuc())) {
				danhMucForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());
				danhMucForm.setTenDanhMucError("SỬA DANH MỤC THÀNH CÔNG !!!");
				return mapping.findForward("thanhCong");
			}
			danhMucForm.setTenDanhMucError("CÓ LỖI XẢY RA TRONG QUÁ TRÌNH SỬA !!!");
			danhMucForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());
			return mapping.findForward("thatBai");
		} else {
			// KHONG CO submit --> lay thong tin cua danh muc --> trang sua danh muc
			danhMucForm.setTenDanhMuc(danhMucBO.layThongTinDanhMuc(danhMucForm.getMaDanhMuc()).getTenDanhMuc());
			return mapping.findForward("suaDanhMucPage");
		}
	}

}
