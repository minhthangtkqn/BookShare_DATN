package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.DangBanForm;
import form.XemSauForm;
import model.bo.NguoiDungBO;
import model.bo.RaoBanBO;

public class DanhDauXemSauAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("DanhDauXemSauAction");

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		XemSauForm xemSauForm = (XemSauForm) form;

		// Kiem tra user dang nhap
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));

		if (type == 0) {
			System.out.println("ADMIN KHÔNG THỂ ĐÁNH DẤU XEM SAU");
			return mapping.findForward("trangChu");
		}

		if (type == 2) {
			System.out.println("TÀI KHOẢN NÀY HIỆN ĐANG BỊ KHÓA");
			return mapping.findForward("dangNhapDO");
		}
		if (type != 1) {
			System.out.println("CHƯA ĐĂNG NHẬP THÀNH CÔNG");
			return mapping.findForward("dangnhaplai");
		}

		// check maRaoBan
		if (StringProcess.notVaild(xemSauForm.getMaRaoBan())) {
			System.out.println("postID is not exists.");
			return mapping.findForward("trangChu");
		}

		RaoBanBO raoBanBO = new RaoBanBO();
		
		if (raoBanBO.danhDauXemSau((String) session.getAttribute("userID"), xemSauForm.getMaRaoBan())) {
			System.out.println("Post is saved to watch later list.");
		}else{
			xemSauForm.setError("There are some problems! Please try again later!");
			return mapping.findForward("errorLoggedPage");
		}
		
		ActionForward forward = new ActionForward("/chi-tiet-bai-dang.do?maRaoBan=" + xemSauForm.getMaRaoBan());
		return forward;
	}

}
