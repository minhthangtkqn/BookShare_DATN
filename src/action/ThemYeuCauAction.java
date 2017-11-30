package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import form.YeuCauForm;
import model.bo.NguoiDungBO;
import model.bo.YeuCauBO;

public class ThemYeuCauAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		System.out.println("--- THEM YEU CAU ACTION ---");
		YeuCauForm yeuCauForm = (YeuCauForm) form;

		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));

		if (type == 0) {
			return mapping.findForward("trangCaNhan");
		}
		if (type == 2) {
			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.blockedAccount.error"));
			saveErrors(request, errors);
			return mapping.findForward("errorLoggedPage");
		}
		if (type != 1) {
			return mapping.findForward("dangNhap");
		}

		if (!StringProcess.notVaild(yeuCauForm.getSubmit())) {
			// neu co submit --> them yeu cau
			if (StringProcess.notVaild(yeuCauForm.getTenSach())) {
				ActionErrors errors = new ActionErrors();
				errors.add("tenSachError", new ActionMessage("error.tenSach.trong"));
				saveErrors(request, errors);
				return mapping.findForward("giaoDienYeuCau");
			}

			YeuCauBO yeuCauBO = new YeuCauBO();
			if (yeuCauBO.themYeuCau(yeuCauForm.getTenSach(), (String) session.getAttribute("userID"))) {
				return mapping.findForward("trangCaNhan");
			}else{
				// khong them yeu cau duoc
				ActionErrors errors = new ActionErrors();
				errors.add("error", new ActionMessage("error.themYeuCau.process"));
				saveErrors(request, errors);
				return mapping.findForward("errorLoggedPage");
			}

		} else {
			return mapping.findForward("giaoDienYeuCau");
		}

	}

}
