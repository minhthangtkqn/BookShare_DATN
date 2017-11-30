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

public class XoaYeuCauAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		System.out.println("--- XOA YEU CAU ACTION ---");
		YeuCauForm yeuCauForm = (YeuCauForm) form;

		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));

		if (type == 0) {
			System.out.println("Admin");
			return mapping.findForward("trangCaNhan");
		}
		if (type == 2) {
			System.out.println("blocked account");
			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.blockedAccount.error"));
			saveErrors(request, errors);
			return mapping.findForward("errorLoggedPage");
		}
		if (type != 1) {
			return mapping.findForward("dangNhap");
		}

		// kiem tra ma yeu cau
		if (StringProcess.notVaild(yeuCauForm.getMaYeuCau())) {
			System.out.println("KHONG CO MA YEU CAU");
			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.maYeuCau.trong"));
			saveErrors(request, errors);
			return mapping.findForward("errorLoggedPage");
		}

		System.out.println("Ma yeu cau: " + yeuCauForm.getMaYeuCau());
		YeuCauBO yeuCauBO = new YeuCauBO();
		if (yeuCauBO.xoaYeuCau(yeuCauForm.getMaYeuCau())) {
			System.out.println("xoa yeu cau thanh cong");
			return mapping.findForward("trangCaNhan");
		} else {
			// khong xoa yeu cau duoc
			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.xoaYeuCau.process"));
			saveErrors(request, errors);
			return mapping.findForward("errorLoggedPage");
		}

	}

}
