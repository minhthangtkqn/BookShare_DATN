package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TrangCaNhanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		System.out.println("TrangCaNhanAction");

		// neu chua dang nhap dua ve trang chu
		if (session.getAttribute("userID") == null) {
			return mapping.findForward("trangChu");
		}

		/**
		 * Neu da dang nhap
		 */
		int userType = (Integer) session.getAttribute("type");
		String userID = (String) session.getAttribute("userID");

		System.out.println("Phan luong` trang ca nhan");

		switch (userType) {
		case 1:
			return mapping.findForward("nguoiDung");
		case 2:
			return mapping.findForward("nguoiDung");
		case 0:
			return mapping.findForward("quanLy");
		default:
			return mapping.findForward("trangChu");
		}

	}

}
