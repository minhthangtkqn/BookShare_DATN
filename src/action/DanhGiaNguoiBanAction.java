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
import model.bean.NguoiDung;
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

		DanhGiaBO danhGiaBO = new DanhGiaBO();
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		
		// Kiem tra dang nhap - only normal account
		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));
		if (type == 0) {
			System.out.println("Admin khong the danh gia");
			return mapping.findForward("trangChu");
		}
		if (type == 2) {
			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.blockedAccount.error"));
			saveErrors(request, errors);
			return mapping.findForward("errorLoggedPage");
		}
		if(type != 1){
			System.out.println("Dang nhap khong thanh cong --> Den trang dangNhap.jsp");
			return mapping.findForward("dangNhap");
		}

		// Kiem tra ma nguoi ban exist
		if (StringProcess.notVaild(danhGiaNguoiBanForm.getMaNguoiBan())) {
			System.out.println("Khong co MA NGUOI BAN");
			return mapping.findForward("trangChu");
		}

		// kiem tra Ma Nguoi Ban --> do not allow user rate owner account
		if (danhGiaNguoiBanForm.getMaNguoiBan().equals((String) session.getAttribute("userID"))) {
			System.out.println("You cannot rate yourself !");
			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.MaNguoiBan.same"));
			saveErrors(request, errors);
			return mapping.findForward("errorLoggedPage");
		}

		// kiem tra nguoi ban co ton tai hay khong
		NguoiDung nguoiDung = nguoiDungBO.layNguoiDung(danhGiaNguoiBanForm.getMaNguoiBan());
		if (nguoiDung == null) {
			System.out.println("NGUOI BAN KHONG TON TAI");
			return mapping.findForward("trangChu");
		}
		danhGiaNguoiBanForm.setNguoiBan(nguoiDung);

		// kiem tra chi danh gia 1 lan
		if(danhGiaBO.isRated((String)session.getAttribute("userID"), danhGiaNguoiBanForm.getMaNguoiBan())){
			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.danhGia.already"));
			saveErrors(request, errors);
			return mapping.findForward("errorLoggedPage");
		}
		
		// kiem tra submit
		if (StringProcess.notVaild(danhGiaNguoiBanForm.getSubmit())) {
			// neu KO co submit --> giao dien danh gia
			System.out.println("submit: " + danhGiaNguoiBanForm.getSubmit());
			return mapping.findForward("giaoDienDanhGia");
		}

		ActionErrors actionErrors = new ActionErrors();
		// Kiem tra cac tham so exist
		if (StringProcess.notVaild(danhGiaNguoiBanForm.getBinhLuan())) {
			actionErrors.add("binhLuanError", new ActionMessage("error.binhLuanDanhGia.trong"));
		}
		if (StringProcess.notVaild(danhGiaNguoiBanForm.getDiemDanhGia())) {
			actionErrors.add("diemDanhGiaError", new ActionMessage("error.diemDanhGia.trong"));
		}
		saveErrors(request, actionErrors);
		if (actionErrors.size() > 0) {
			return mapping.findForward("thatBai");
		}

		// Kiem tra diem danh gia co phai tu` 1 --> 5 hay khong
		if (StringProcess.notVaildRatingPoint(danhGiaNguoiBanForm.getDiemDanhGia())) {
			System.out.println("Rating point must be 1 to 5");
			actionErrors.add("diemDanhGiaError", new ActionMessage("error.diemDanhGia.notValid"));
		}
		saveErrors(request, actionErrors);
		if (actionErrors.size() > 0) {
			return mapping.findForward("thatBai");
		}

		// tham so OK --> goi ham dang danh gia
		System.out.println("Tham so OK --> Goi ham dang danh gia");
		DanhGia danhGia = new DanhGia();

		danhGia.setMaNguoiDanhGia((String) session.getAttribute("userID"));
		danhGia.setMaNguoiBan(danhGiaNguoiBanForm.getMaNguoiBan());
		danhGia.setDiemDanhGia(danhGiaNguoiBanForm.getDiemDanhGia());
		danhGia.setBinhLuan(danhGiaNguoiBanForm.getBinhLuan());

		if (!danhGiaBO.dangDanhGiaNguoiBan(danhGia)) {
			System.out.println("Co loi xay ra trong qua trinh dang danh gia");
			danhGiaNguoiBanForm.setError("AN ERROR HAS OCCURRED WHILE POSTING PROCESS. PLEASE TRY AGAIN LATER.");
			return mapping.findForward("thatBai");
		}
		return mapping.findForward("trangChu");
	}

}
