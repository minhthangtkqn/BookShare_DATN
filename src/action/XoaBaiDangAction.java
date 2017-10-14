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
import model.bo.RaoBanBO;

public class XoaBaiDangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		System.out.println("Xoa Bai Dang Action");
		// Các loại bài đăng có thể xóa:
		// Chờ duyệt (0)
		// Đang bán (1)
		// Đã bán (2)
		// không duyệt (3)

		// --> Đã xóa (4)
		// Nếu vẫn CHỜ DUYỆT hoặc KHÔNG DUYỆT mà XÓA ==> XÓA LUÔN
		// trong CSDL

		// 1. Kiểm tra đăng nhập
		if (StringProcess.notVaild((String) session.getAttribute("userID"))) {
			return mapping.findForward("dangNhapLai");
		}

		DangBanForm dangBanForm = (DangBanForm) form;
		RaoBanBO raoBanBO = new RaoBanBO();

		// 2.2. Kiểm tra 'maRaoBan'
		if (StringProcess.notVaild(dangBanForm.getMaRaoBan())) {

			// 2.2.1. Không có maRaoBan --> trang cá nhân
			System.out.println("Khong co Ma Rao Ban");
			return mapping.findForward("trangCaNhan");

		} else {

			// 2.2.2. Có maRaoBan --> gọi hàm xử lý
			raoBanBO.xoaBaiDang((String) session.getAttribute("userID"), dangBanForm.getMaRaoBan());
			return mapping.findForward("thanhCong");

		}

	}

}