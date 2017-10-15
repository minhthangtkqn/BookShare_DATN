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

public class KhoaBaiDangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("--- KHOA BAI DANG ACTION ---");

		HttpSession session = request.getSession();

		// kiem tra dang nhap ADMIN
		if (StringProcess.notVaild((String) session.getAttribute("userID"))) {
			System.out.println("Chua dang nhap");
			return mapping.findForward("dangNhap");
		}
		
		DangBanForm dangBanForm = (DangBanForm) form;
		RaoBanBO raoBanBO = new RaoBanBO();
		
		if (StringProcess.notVaild(dangBanForm.getMaRaoBan())) {
			// neu ko co Ma Rao Ban --> trang ca nhan
			System.out.println("Khong co MA RAO BAN");
			return mapping.findForward("thatBai");
		}
		
		if (StringProcess.notVaild(dangBanForm.getMaNguoiRaoBan())) {
			// neu ko co Ma Nguoi Rao Ban --> trang ca nhan
			System.out.println("Khong co MA Nguoi RAO BAN");
			return mapping.findForward("thatBai");
		}
		
		// kiem tra submit
		if (!StringProcess.notVaild(dangBanForm.getSubmit())) {
			// Neu co submit --> goi ham` khoa bai dang
			System.out.println("Submit tu` trang ");
			raoBanBO.khoaBaiDang(dangBanForm.getMaRaoBan(), maNguoiRaoBan);
			return mapping.findForward("thanhCong");
		}
		return mapping.findForward("thatBai");
	}

}
