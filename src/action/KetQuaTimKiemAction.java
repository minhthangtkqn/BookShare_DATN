package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.KetQuaTimKiemForm;
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

		ketQuaTimKiemForm.setListRaoBan(raoBanBO.layDanhSachTimKiemTenSach(tuKhoa));

		if (session.getAttribute("userID") == null)

			return mapping.findForward("ketQua");

		return mapping.findForward("ketQuaLogged");
	}

}
