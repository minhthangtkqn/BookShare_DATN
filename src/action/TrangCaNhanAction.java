package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import model.bo.NguoiDungBO;

public class TrangCaNhanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		System.out.println("TrangCaNhanAction");

		// neu chua dang nhap dua ve trang chu
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));
		if (type != 0 && type != 1 && type != 2) {
			return mapping.findForward("trangChu");
		}

		/**
		 * Neu da dang nhap
		 */
		System.out.println("Phan luong` trang ca nhan");

		switch (type) {
		case 0:
			return mapping.findForward("quanLy");
		case 1:
			return mapping.findForward("nguoiDung");
		case 2:
			return mapping.findForward("nguoiDung");
		default:
			return mapping.findForward("trangChu");
		}

	}

}
