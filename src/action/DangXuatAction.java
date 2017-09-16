package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DangXuatAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		try {
			session.removeAttribute("userID");
			session.removeAttribute("type");
			session.removeAttribute("userName");

			System.out.println("Dang xuat thanh cong");
			
			return mapping.findForward("dangXuatThanhCong");
		} catch (Exception e) {
			System.out.println("Dang xuat that bai");
			
			return mapping.findForward("dangXuatThatBai");
		}
	}

}
