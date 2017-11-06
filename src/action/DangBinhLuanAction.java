package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.BinhLuanForm;
import model.bean.BinhLuan;
import model.bo.BinhLuanBO;
import model.bo.NguoiDungBO;

public class DangBinhLuanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		System.out.println("DANG BINH LUAN ACTION");
		BinhLuanForm binhLuanForm = (BinhLuanForm) form;

		// Kiem tra dang nhap - only normal account
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		if (nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password")) != 1) {
			System.out.println("Chua dang nhap hoac khong phai tai khoan binh thuong");
			return mapping.findForward("trangChu");
		}

		// kiem tra cac tham so

		// 1. kiem tra maRaoBan
		if (StringProcess.notVaild(binhLuanForm.getMaRaoBan())) {
			System.out.println("Khong co ma rao ban");
			return mapping.findForward("trangChu");
		}
		
		// 2. Kiem tra BinhLuan
		if (StringProcess.notVaild(binhLuanForm.getBinhLuan())) {
			System.out.println("Khong the de trong o binh luan");
			ActionForward forward = new ActionForward("/chi-tiet-bai-dang.do?maRaoBan=" + binhLuanForm.getMaRaoBan());
			return forward;
		}
		BinhLuan binhLuan = new BinhLuan();
		binhLuan.setMaNguoiBinhLuan((String)session.getAttribute("userID"));
		binhLuan.setMaRaoBan(binhLuanForm.getMaRaoBan());
		binhLuan.setBinhLuan(binhLuanForm.getBinhLuan());
		binhLuan.setMaBinhLuanDuocTraLoi(StringProcess.getVaildString(binhLuanForm.getMaBinhLuanDuocTraloi()));

		BinhLuanBO binhLuanBO = new BinhLuanBO();
		binhLuanBO.dangBinhLuan(binhLuan);
		
		ActionForward forward = new ActionForward("/chi-tiet-bai-dang.do?maRaoBan=" + binhLuanForm.getMaRaoBan());

		System.out.println("Forward ve trang cu~");
		return forward;
	}

}
