package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import common.StringProcess;
import form.DanhGiaNguoiBanForm;
import model.bean.NguoiDung;
import model.bo.DanhGiaBO;
import model.bo.NguoiDungBO;

public class LichSuDanhGiaAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("--- LICH SU DANH GIA ACTION ---");

		HttpSession session = request.getSession();
		DanhGiaNguoiBanForm danhGiaNguoiBanForm = (DanhGiaNguoiBanForm) form;

		// Kiem tra ma nguoi ban exist
		if (StringProcess.notVaild(danhGiaNguoiBanForm.getMaNguoiBan())) {
			System.out.println("Khong co MA NGUOI BAN");
			return mapping.findForward("trangChu");
		}

		// kiem tra nguoi ban co ton tai hay khong
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		NguoiDung nguoiDung = nguoiDungBO.layNguoiDung(danhGiaNguoiBanForm.getMaNguoiBan());
		if (nguoiDung == null) {
			System.out.println("NGUOI BAN KHONG TON TAI");
			return mapping.findForward("trangChu");
		}
		danhGiaNguoiBanForm.setNguoiBan(nguoiDung);
		
		DanhGiaBO danhGiaBO = new DanhGiaBO();
		danhGiaNguoiBanForm.setListDanhGia(danhGiaBO.layDanhSachDanhGia(danhGiaNguoiBanForm.getMaNguoiBan()));

		// kiem tra dang nhap phan luong hien thi 
		int userType = nguoiDungBO.kiemTraDangNhap((String)session.getAttribute("userName"), (String)session.getAttribute("password"));
		if(userType != 0 && userType != 1 && userType != 2){
			return mapping.findForward("lichSuDanhGia");
		}
		return mapping.findForward("lichSuDanhGiaLogged");
	}

}
