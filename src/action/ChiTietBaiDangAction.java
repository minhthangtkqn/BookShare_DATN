package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.RaoBan;
import model.bo.RaoBanBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import form.ChiTietBaiDangForm;

/**
 * SinhVienAction.java
 * 
 * Version 1.0
 * 
 * Date: Jan 21, 2015
 * 
 * Copyright
 * 
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * ----------------------------------------------------------------------- Jan
 * 21, 2015 DaiLV2 Create
 */

public class ChiTietBaiDangAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("ChiTietBaiDangAction");

		HttpSession session = request.getSession();

		System.out.println("Ma rao ban: " + request.getParameter("maRaoBan"));

		// lay du lieu hien thi
		RaoBanBO raoBanBO = new RaoBanBO();
		ChiTietBaiDangForm chiTietBaiDangForm = (ChiTietBaiDangForm) form;

		RaoBan raoBan = raoBanBO.layThongTinBaiDang(request.getParameter("maRaoBan"));
		// Kiem tra bai rao ban co ton tai hay khong
		if (raoBan == null) {
			System.out.println("Bai dang khong ton tai");
			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.baiDang.null"));
			saveErrors(request, errors);
			
			if (StringProcess.notVaild((String) session.getAttribute("userID"))) {
				return mapping.findForward("baiDangKhongTonTai");
			}
			return mapping.findForward("baiDangKhongTonTaiLogged");
		}

		chiTietBaiDangForm.setChiTiet(raoBan);

		if (raoBan.getGioiTinh().equals("0"))
			chiTietBaiDangForm.getChiTiet().setGioiTinh("Nữ");
		else if (raoBan.getGioiTinh().equals("1"))
			chiTietBaiDangForm.getChiTiet().setGioiTinh("Nam");
		else
			chiTietBaiDangForm.getChiTiet().setGioiTinh("Chưa xác định");

		// lay thong tin goi y cho moi nguoi
		chiTietBaiDangForm.setDsGoiYMoiNguoiCungXem(raoBanBO.layDanhSachGoiYMoiNguoiCungXem());

		/**
		 * Kiem tra nguoi dung de phan luong hien thi
		 */
		String userID;
		int userType;

		// kiem tra da dang nhap hay chua
		if (StringProcess.notVaild((String) session.getAttribute("userID"))) {
			userID = "";
			userType = -1;
		} else {
			userType = (Integer) session.getAttribute("type");
			userID = (String) session.getAttribute("userID");
		}
		
		// luu lich su xem vao` CSDL
		if (raoBanBO.luuLichSuXemRaoBan(userID, chiTietBaiDangForm.getChiTiet().getMaRaoBan())) {
			System.out.println("Da~ luu vao CSDL:");
			System.out.println(
					"Ma Nguoi Dung: " + userID + "  ---  Ma Rao Ban: " + chiTietBaiDangForm.getChiTiet().getMaRaoBan());
		} else {
			System.out.println("Luu vao` CSDL that bai");
		}

		switch (userType) {
		case 0:
			// admin
			return mapping.findForward("xemCheDoQuanLy");
		case 1:
			// nguoi dung binh thuong
			return mapping.findForward("xemCheDoNguoiDung");
		case 2:
			// Nguoi dung bi chan
			return mapping.findForward("nguoiDungBiChan");
		default:
			// chua dang nhap
			return mapping.findForward("xemCheDoKhach");
		}

	}
}
