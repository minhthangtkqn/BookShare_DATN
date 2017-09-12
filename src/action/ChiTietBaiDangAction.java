package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.RaoBan;
import model.bo.RaoBanBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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
		chiTietBaiDangForm.setChiTiet(raoBan);

		if (raoBan.getGioiTinh().equals("0"))
			chiTietBaiDangForm.getChiTiet().setGioiTinh("Nữ");
		else if (raoBan.getGioiTinh().equals("1"))
			chiTietBaiDangForm.getChiTiet().setGioiTinh("Nam");
		else
			chiTietBaiDangForm.getChiTiet().setGioiTinh("Chưa xác định");


		// kiem tra nguoi dung de phan luong hien thi
		if (session.getAttribute("userID") == null)
			return mapping.findForward("xemCheDoKhach"); // neu chua dang nhap
															// xem che do khach

		// Neu da dang nhap
		int userType = (Integer) session.getAttribute("type");
		String userID = (String) session.getAttribute("userID");

		// Nguoi dung bi chan
		if (userType == 2)
			return mapping.findForward("trangBiChan");

		if (userType == 1) {
			// Kiem tra chua mua
			return mapping.findForward("xemCheDoNguoiDung");
			// Kiem tra da mua
			// return mapping.findForward("xemchedodamua");
		}

		if (userType == 0)
			return mapping.findForward("xemCheDoQuanLy");
		return null;

	}
}
