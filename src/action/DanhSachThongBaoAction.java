package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BinhLuanForm;
import form.ThongBaoForm;
import model.bo.NguoiDungBO;
import model.bo.ThongBaoBO;

public class DanhSachThongBaoAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		System.out.println("--- DANH SACH THONG BAO ACTION ---");
		ThongBaoForm thongBaoForm = (ThongBaoForm) form;

		// kiem tra dang nhap
		NguoiDungBO nguoiDungBO = new NguoiDungBO();

		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));

		if (type == 1 || type == 2 || type == 0) {
			ThongBaoBO thongBaoBO = new ThongBaoBO();
			thongBaoForm.setListThongBao(thongBaoBO.layDanhSachThongBao((String) session.getAttribute("userID")));
			return mapping.findForward("danhSachThongBao");
		}

		return mapping.findForward("trangChu");
	}

}
