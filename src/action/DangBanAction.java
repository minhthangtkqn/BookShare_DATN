package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.RaoBan;
import model.bo.DanhMucBO;
import model.bo.RaoBanBO;
import model.bo.TinhBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.DangBanForm;

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

public class DangBanAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		System.out.println("DangBanAction");
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		if (session.getAttribute("userID") == null)
			// neu chua dang nhap --> den trang dang Nhap
			return mapping.findForward("dangnhaplai"); 

		System.out.println("Pass Session");

		// Neu da dang nhap
		DangBanForm dangBanForm = (DangBanForm) form;
		TinhBO tinhBo = new TinhBO();
		DanhMucBO danhMucBO = new DanhMucBO();
		RaoBanBO raoBanBO = new RaoBanBO();

		// validate du lieu
		/*
		 * if("submit".equals(dangBanForm.getSubmit())){
		 * 
		 * }
		 */

		if ("submit".equals(dangBanForm.getSubmit())) { // nhan nut Xac nhan o
														// trang dang ban
			System.out.println("Dang ban");
			RaoBan raoBan = new RaoBan();

			raoBan.setMaNguoiRaoBan((String) session.getAttribute("userID"));
			System.out.println((String) session.getAttribute("userID"));
			raoBan.setTenSach(dangBanForm.getTenSach());
			raoBan.setMaDanhMuc(dangBanForm.getMaDanhMuc());
			raoBan.setTacGia(dangBanForm.getTacGia());
			raoBan.setNamxb(dangBanForm.getNamxb());
			raoBan.setNxb(dangBanForm.getNxb());
			raoBan.setGia(dangBanForm.getGia());
			raoBan.setMaTinhBan(dangBanForm.getMaTinh());
			raoBan.setMoTa(dangBanForm.getMoTa());

			/**
			 * chua xu ly upload anh
			 */
			raoBan.setLinkAnh1(dangBanForm.getLinkAnh1());
			raoBan.setLinkAnh2(dangBanForm.getLinkAnh2());
			raoBan.setLinkAnh3(dangBanForm.getLinkAnh3());
			raoBan.setLinkAnh4(dangBanForm.getLinkAnh4());
			raoBan.setLinkAnh5(dangBanForm.getLinkAnh5());

			System.out.println("Dang bai");

			raoBanBO.dangBai(raoBan);
			return mapping.findForward("thanhcong");

		}
		
		dangBanForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());
		dangBanForm.setDsTinh(tinhBo.getListTinh());
		System.out.println("SUBMIT: " + dangBanForm.getSubmit());
		return mapping.findForward("dangban");
	}

}
