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
import model.bo.NguoiDungBO;
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
 * 
 * DangBanAction
 * 
 * @author hoangminhthang
 *
 */

public class DangBanAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("DangBanAction");

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		DangBanForm dangBanForm = (DangBanForm) form;

		// Kiem tra user dang nhap
		NguoiDungBO nguoiDungBO = new NguoiDungBO();
		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));
		
		if(type == 0){
			System.out.println("ADMIN KHÔNG THỂ ĐĂNG BÁN");
			return mapping.findForward("trangChu");
		}
		
		if (type == 2) {
			System.out.println("CHỈ CÓ TÀI KHOẢN NGƯỜI DÙNG KHÔNG BỊ KHÓA MỚI CÓ THỂ ĐĂNG BÁN");
			return mapping.findForward("dangNhapDO");
		}
		if(type != 1){
			System.out.println("CHƯA ĐĂNG NHẬP THÀNH CÔNG");
			return mapping.findForward("dangnhaplai");
		}

		FileOutputStream outputStream = null;
		FormFile anh1 = null;
		FormFile anh2 = null;
		FormFile anh3 = null;
		FormFile anh4 = null;
		FormFile anh5 = null;
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

			anh1 = dangBanForm.getAnh1();
			anh2 = dangBanForm.getAnh2();
			anh3 = dangBanForm.getAnh3();
			anh4 = dangBanForm.getAnh4();
			anh5 = dangBanForm.getAnh5();

			System.out.println("VALIDATE DU LIEU");

			if (StringProcess.notVaild(anh1.getFileName())) {
				actionErrors.add("linkAnh1Error", new ActionMessage("error.linkAnh1.trong"));
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
		}

		// dang tin rao ban neu du lieu OK
		if ("submit".equals(dangBanForm.getSubmit())) {

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

			String storageLink = prefixStorageLink + "(1)" + StringProcess.getSuffix(anh1);
			String databaseLink = prefixDatabaseLink + "(1)" + StringProcess.getSuffix(anh1);
			outputStream = new FileOutputStream(new File(storageLink));
			outputStream.write(anh1.getFileData());
			raoBan.setLinkAnh1(databaseLink);

			if (StringProcess.notVaild(anh2.getFileName())) {
				raoBan.setLinkAnh2("");
			} else {
				storageLink = prefixStorageLink + "(2)" + StringProcess.getSuffix(anh2);
				databaseLink = prefixDatabaseLink + "(2)" + StringProcess.getSuffix(anh2);
				outputStream = new FileOutputStream(new File(storageLink));
				outputStream.write(anh2.getFileData());
				raoBan.setLinkAnh2(databaseLink);
			}

			if (StringProcess.notVaild(anh3.getFileName())) {
				raoBan.setLinkAnh3("");
			} else {
				storageLink = prefixStorageLink + "(3)" + StringProcess.getSuffix(anh3);
				databaseLink = prefixDatabaseLink + "(3)" + StringProcess.getSuffix(anh3);
				outputStream = new FileOutputStream(new File(storageLink));
				outputStream.write(anh3.getFileData());
				raoBan.setLinkAnh3(databaseLink);
			}

			if (StringProcess.notVaild(anh4.getFileName())) {
				raoBan.setLinkAnh4("");
			} else {
				storageLink = prefixStorageLink + "(4)" + StringProcess.getSuffix(anh4);
				databaseLink = prefixDatabaseLink + "(4)" + StringProcess.getSuffix(anh4);
				outputStream = new FileOutputStream(new File(storageLink));
				outputStream.write(anh4.getFileData());
				raoBan.setLinkAnh4(databaseLink);
			}

			if (StringProcess.notVaild(anh5.getFileName())) {
				raoBan.setLinkAnh5("");
			} else {
				storageLink = prefixStorageLink + "(5)" + StringProcess.getSuffix(anh5);
				databaseLink = prefixDatabaseLink + "(5)" + StringProcess.getSuffix(anh5);
				outputStream = new FileOutputStream(new File(storageLink));
				outputStream.write(anh5.getFileData());
				raoBan.setLinkAnh5(databaseLink);
			}

			outputStream.close();

			System.out.println("Goi ham dang bai");

			if (raoBanBO.dangBai(raoBan)) {
				System.out.println("Dang bai thanh cong !!! - DangBanAction");
				return mapping.findForward("trangCaNhan");
			}
			return mapping.findForward("thatbai");
		}

		System.out.println("SUBMIT: " + dangBanForm.getSubmit());
		return mapping.findForward("dangban");
	}

}
