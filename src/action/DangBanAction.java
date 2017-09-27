package action;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
import org.apache.struts.upload.FormFile;

import common.Constant;
import common.StringProcess;
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
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("DangBanAction");

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		FileOutputStream outputStream = null;
		FormFile linkAnh1 = null;
		FormFile linkAnh2 = null;
		FormFile linkAnh3 = null;
		FormFile linkAnh4 = null;
		FormFile linkAnh5 = null;

		// neu chua dang nhap --> den trang dang Nhap
		if (session.getAttribute("userID") == null) {
			return mapping.findForward("dangnhaplai");
		}

		// Neu da dang nhap
		DangBanForm dangBanForm = (DangBanForm) form;
		TinhBO tinhBo = new TinhBO();
		DanhMucBO danhMucBO = new DanhMucBO();
		RaoBanBO raoBanBO = new RaoBanBO();

		// lấy DANH MỤC SÁCH và danh sách TỈNH
		dangBanForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());
		dangBanForm.setDsTinh(tinhBo.getListTinh());

		// nhan nut Xac nhan o trang dang ban
		if ("submit".equals(dangBanForm.getSubmit())) {

			// validate du lieu nhap vao
			ActionErrors actionErrors = new ActionErrors();

			linkAnh1 = dangBanForm.getLinkAnh1();
			linkAnh2 = dangBanForm.getLinkAnh2();
			linkAnh3 = dangBanForm.getLinkAnh3();
			linkAnh4 = dangBanForm.getLinkAnh4();
			linkAnh5 = dangBanForm.getLinkAnh5();

			System.out.println("VALIDATE DU LIEU");

			if (StringProcess.notVaild(linkAnh1.getFileName())) {
				actionErrors.add("linkAnh4Error", new ActionMessage("error.linkAnh1.trong"));
			}
			if (StringProcess.notVaild(dangBanForm.getTenSach())) {
				actionErrors.add("tenSachError", new ActionMessage("error.tenSach.trong"));
			}
			if (StringProcess.notVaild(dangBanForm.getTacGia())) {
				actionErrors.add("tacGiaError", new ActionMessage("error.tacGia.trong"));
			}
			if (StringProcess.notVaild(dangBanForm.getTacGia())) {
				actionErrors.add("giaError", new ActionMessage("error.gia.trong"));
			}
			if (StringProcess.notVaild(dangBanForm.getNxb())) {
				actionErrors.add("nxbError", new ActionMessage("error.nxb.trong"));
			}
			if (StringProcess.notVaild(dangBanForm.getNamxb())) {
				actionErrors.add("namxbError", new ActionMessage("error.namxb.trong"));
			} else {
				if (StringProcess.notVaildNumber(dangBanForm.getNamxb())) {
					actionErrors.add("namxbError", new ActionMessage("error.namxb.so"));
				}
			}

			saveErrors(request, actionErrors);
			if (actionErrors.size() > 0) {
				return mapping.findForward("thatbai");
			}

			// -------------

			if ("submit".equals(dangBanForm.getSubmit())) {

				// dang tin rao ban neu du lieu OK
				System.out.println("Bat dau nap du lieu");
				RaoBan raoBan = new RaoBan();

				raoBan.setTenSach(dangBanForm.getTenSach());
				raoBan.setMaDanhMuc(dangBanForm.getMaDanhMuc());
				raoBan.setTacGia(dangBanForm.getTacGia());
				raoBan.setNxb(dangBanForm.getNxb());
				raoBan.setNamxb(dangBanForm.getNamxb());
				raoBan.setMaNguoiRaoBan((String) session.getAttribute("userID"));
				raoBan.setMaTinhBan(dangBanForm.getMaTinh());
				raoBan.setGia(dangBanForm.getGia());
				raoBan.setMoTa(StringProcess.getVaildString(dangBanForm.getMoTa()));

				/**
				 * upload anh
				 */
				String prefixStorageLink = Constant.LINK_IMAGE_STORAGE + session.getAttribute("userID") + "_"
						+ new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
				String prefixDatabaseLink = Constant.LINK_IMAGE_DATABASE + session.getAttribute("userID") + "_"
						+ new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());

				String storageLink = prefixStorageLink + "(1)" + getSuffix(linkAnh1);
				String databaseLink = prefixDatabaseLink + "(1)" + getSuffix(linkAnh1);
				outputStream = new FileOutputStream(new File(storageLink));
				outputStream.write(linkAnh1.getFileData());
				raoBan.setLinkAnh1(databaseLink);

				if (StringProcess.notVaild(linkAnh2.getFileName())) {
					raoBan.setLinkAnh2("");
				} else {
					storageLink = prefixStorageLink + "(2)" + getSuffix(linkAnh2);
					databaseLink = prefixDatabaseLink + "(2)" + getSuffix(linkAnh2);
					outputStream = new FileOutputStream(new File(storageLink));
					outputStream.write(linkAnh2.getFileData());
					raoBan.setLinkAnh2(databaseLink);
				}

				if (StringProcess.notVaild(linkAnh3.getFileName())) {
					raoBan.setLinkAnh3("");
				} else {
					storageLink = prefixStorageLink + "(3)" + getSuffix(linkAnh3);
					databaseLink = prefixDatabaseLink + "(3)" + getSuffix(linkAnh3);
					outputStream = new FileOutputStream(new File(storageLink));
					outputStream.write(linkAnh3.getFileData());
					raoBan.setLinkAnh3(databaseLink);
				}

				if (StringProcess.notVaild(linkAnh4.getFileName())) {
					raoBan.setLinkAnh4("");
				} else {
					storageLink = prefixStorageLink + "(4)" + getSuffix(linkAnh4);
					databaseLink = prefixDatabaseLink + "(4)" + getSuffix(linkAnh4);
					outputStream = new FileOutputStream(new File(storageLink));
					outputStream.write(linkAnh4.getFileData());
					raoBan.setLinkAnh4(databaseLink);
				}

				if (StringProcess.notVaild(linkAnh5.getFileName())) {
					raoBan.setLinkAnh5("");
				} else {
					storageLink = prefixStorageLink + "(5)" + getSuffix(linkAnh5);
					databaseLink = prefixDatabaseLink + "(5)" + getSuffix(linkAnh5);
					outputStream = new FileOutputStream(new File(storageLink));
					outputStream.write(linkAnh5.getFileData());
					raoBan.setLinkAnh5(databaseLink);
				}

				outputStream.close();

				System.out.println("Goi ham dang bai");

				if (raoBanBO.dangBai(raoBan)) {
					System.out.println("Dang bai thanh cong !!! - DangBanAction");
				}
				return mapping.findForward("thanhcong");
			}
		}

		System.out.println("SUBMIT: " + dangBanForm.getSubmit());
		return mapping.findForward("dangban");
	}

	public String getSuffix(FormFile file) {
		return "." + file.getFileName().split("\\.")[file.getFileName().split("\\.").length - 1];
	}

}
