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
import form.DangBanForm;
import model.bo.NguoiDungBO;
import model.bo.RaoBanBO;

public class BanBaiDangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		System.out.println("Da Ban Bai Dang Action");
		DangBanForm dangBanForm = (DangBanForm) form;
		
		// Chỉ có bài đăng đang bán mới có thể chuyển sang trạng thái đã bán

		// Kiem tra user dang nhap
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
			System.out.println("chua dang nhap hoac khong phai tai khoan nguoi dung binh thuong");
			return mapping.findForward("dangNhapLai");
		}

		RaoBanBO raoBanBO = new RaoBanBO();

		// 2.2. Kiểm tra 'maRaoBan'
		if (StringProcess.notVaild(dangBanForm.getMaRaoBan())) {

			// 2.2.1. Không có maRaoBan --> trang cá nhân
			System.out.println("Khong co Ma Rao Ban");
			return mapping.findForward("trangCaNhan");

		} else {

			// 2.2.2. Có maRaoBan --> gọi hàm xử lý
			raoBanBO.banBaiDang((String) session.getAttribute("userID"), dangBanForm.getMaRaoBan());
			return mapping.findForward("thanhCong");

		}
	}

}
