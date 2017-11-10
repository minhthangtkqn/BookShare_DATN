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

public class DanhMucAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("DanhMucAction");

		HttpSession session = request.getSession();
		DanhMucForm danhMucForm = (DanhMucForm) form;

		DanhMucBO danhMucBO = new DanhMucBO();
		NguoiDungBO nguoiDungBO = new NguoiDungBO();

		// lay list danh muc

		if (nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password")) == 0) {
			System.out.println("hien thi list danh muc cho admin");
			danhMucForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());
			return mapping.findForward("admin");
		}else{
			System.out.println("Chi co admin moi' duoc quan ly DANH MUC");
			return mapping.findForward("trangChu");
		}

	}

}
