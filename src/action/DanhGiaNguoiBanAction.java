package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import form.DanhGiaNguoiBanForm;
import model.bean.DanhGia;
import model.bo.DanhGiaBO;
import model.bo.NguoiDungBO;

public class DanhGiaNguoiBanAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("--- DANH GIA NGUOI BAN ACTION ---");

		HttpSession session = request.getSession();
		DanhGiaNguoiBanForm danhGiaNguoiBanForm = (DanhGiaNguoiBanForm) form;

		// Kiem tra dang nhap - only normal account
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		if (nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password")) != 1) {
			System.out.println("Chua dang nhap hoac khong phai tai khoan binh thuong");
			return mapping.findForward("trangChu");
		}

		//Kiem tra ma nguoi ban
		if(StringProcess.notVaild(danhGiaNguoiBanForm.getMaNguoiBan())){
			System.out.println("Khong co MA NGUOI BAN");
			return mapping.findForward("trangChu");
		}
		
		// kiem tra submit
		if(StringProcess.notVaild(danhGiaNguoiBanForm.getSubmit())){
			// neu KO co submit --> giao dien danh gia
			return mapping.findForward("giaoDienDanhGia");
		}
		
		ActionErrors actionErrors = new ActionErrors();
		// Kiem tra cac tham so exist
		if (StringProcess.notVaild(danhGiaNguoiBanForm.getBinhLuan())){
			actionErrors.add("binhLuanError", new ActionMessage("error.binhLuanDanhGia.trong"));
		}
		if (StringProcess.notVaild(danhGiaNguoiBanForm.getDiemDanhGia())){
			actionErrors.add("diemDanhGiaError", new ActionMessage("error.diemDanhGia.trong"));
		}
		saveErrors(request, actionErrors);
		if (actionErrors.size() > 0) {
			return mapping.findForward("thatBai");
		}
		
		//Kiem tra diem danh gia co phai tu` 1 --> 5 hay khong
		if(StringProcess.notVaildRatingPoint(danhGiaNguoiBanForm.getDiemDanhGia())){
			actionErrors.add("diemDanhGiaError", new ActionMessage("error.diemDanhGia.notValid"));
		}
		saveErrors(request, actionErrors);
		if (actionErrors.size() > 0) {
			return mapping.findForward("thatBai");
		}
		
		// tham so OK --> goi ham dang danh gia
		DanhGiaBO danhGiaBO = new DanhGiaBO();
		DanhGia danhGia = new DanhGia();
		
		danhGia.setMaNguoiDanhGia((String)session.getAttribute("userID"));
		danhGia.setMaNguoiBan(danhGiaNguoiBanForm.getMaNguoiBan());
		danhGia.setDiemDanhGia(danhGiaNguoiBanForm.getDiemDanhGia());
		danhGia.setBinhLuan(danhGiaNguoiBanForm.getBinhLuan());
		
		if(!danhGiaBO.dangDanhGiaNguoiBan(danhGia)){
			danhGiaNguoiBanForm.setError("AN ERROR HAS OCCURRED WHILE POSTING PROCESS. PLEASE TRY AGAIN LATER.");
			return mapping.findForward("thatBai");
		}
		return mapping.findForward("trangChu");
	}

}
