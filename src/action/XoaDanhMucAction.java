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

public class XoaDanhMucAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		System.out.println("--- XOA DANH MUC ACTION ---");

		// kiem tra admin dang nhap
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		if (nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password")) != 0) {
			System.out.println("chua dang nhap hoac khong phai admin");
			return mapping.findForward("trangChu");
		}

		DanhMucForm danhMucForm = (DanhMucForm) form;
		DanhMucBO danhMucBO = new DanhMucBO();

		// check maDanhMuc
		if (StringProcess.notVaild(danhMucForm.getMaDanhMuc())) {
			System.out.println("KHONG CO MA DANH MUC");
			return mapping.findForward("listDanhMuc");
		}
		
		if (!StringProcess.notVaild(danhMucForm.getAction())) {
			// có ACTION
			if(danhMucBO.xoaDanhMuc(danhMucForm.getMaDanhMuc())){
				danhMucForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());
				danhMucForm.setTenDanhMucError("XÓA DANH MỤC THÀNH CÔNG !!!");
				return mapping.findForward("thanhCong");
			}
			danhMucForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());
			danhMucForm.setTenDanhMucError("XÓA DANH MỤC THẤT BẠI !!!");
			return mapping.findForward("thatBai");
		}
		System.out.println("KHÔNG CÓ ACTION");
		return mapping.findForward("listDanhMuc");
	}

}
