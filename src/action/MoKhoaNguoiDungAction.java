package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.NguoiDungForm;
import model.bo.NguoiDungBO;

public class MoKhoaNguoiDungAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("--- MO KHOA NGUOI DUNG ACTION ---");
		HttpSession session = request.getSession();

		// kiem tra dang nhap
		if (StringProcess.notVaild((String) session.getAttribute("userID"))) {
			System.out.println("chua dang nhap");
			return mapping.findForward("dangNhap");
		}

		NguoiDungForm nguoiDungForm = (NguoiDungForm) form;

		// kiem tra ma nguoi dung co hay khong
		if (StringProcess.notVaild(nguoiDungForm.getMaNguoiDung())) {
			System.out.println("Khong co MA NGUOI DUNG");
			return mapping.findForward("thatBai");
		}

		// kiem tra Submit
		if (!StringProcess.notVaild(nguoiDungForm.getSubmit())) {
			(new NguoiDungBO()).moKhoaNguoiDung(nguoiDungForm.getMaNguoiDung());
			return mapping.findForward("thanhCong");
		}

		System.out.println("Khong co submit !");
		return mapping.findForward("thatBai");
	}

}
