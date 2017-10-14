package action;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import model.bean.RaoBan;
import model.bo.DanhMucBO;
import model.bo.RaoBanBO;
import model.bo.TinhBO;

public class SuaBaiDangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		System.out.println("Sua Bai Dang Action");
		// neu chua dang nhap --> den trang dang Nhap
		if (session.getAttribute("userID") == null) {
			return mapping.findForward("dangNhapLai");
		}

		// Neu da dang nhap
		DangBanForm dangBanForm = (DangBanForm) form;
		TinhBO tinhBo = new TinhBO();
		DanhMucBO danhMucBO = new DanhMucBO();
		RaoBanBO raoBanBO = new RaoBanBO();

		// lấy DANH MỤC SÁCH và danh sách TỈNH
		dangBanForm.setDsDanhMuc(danhMucBO.layDanhSachDanhMuc());
		dangBanForm.setDsTinh(tinhBo.getListTinh());

		FileOutputStream outputStream = null;
		FormFile anh1 = null;
		FormFile anh2 = null;
		FormFile anh3 = null;
		FormFile anh4 = null;
		FormFile anh5 = null;

		// Kiem tra nhan button Xac nhan o trang sua bai dang
		if ("submit".equals(dangBanForm.getSubmit())) {

			// validate du lieu nhap vao
			ActionErrors actionErrors = new ActionErrors();

			anh1 = dangBanForm.getAnh1();
			anh2 = dangBanForm.getAnh2();
			anh3 = dangBanForm.getAnh3();
			anh4 = dangBanForm.getAnh4();
			anh5 = dangBanForm.getAnh5();

			System.out.println("VALIDATE DU LIEU");

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
				System.out.println("Du lieu co loi");
				return mapping.findForward("thatBai");
			}
		}

		// Nếu dữ liệu OK --> Nạp dữ liệu
		if ("submit".equals(dangBanForm.getSubmit())) {
			System.out.println("Bat dau nap du lieu");
			RaoBan raoBan = new RaoBan();
			raoBan.setMaRaoBan(dangBanForm.getMaRaoBan());
			raoBan.setMaNguoiRaoBan((String) session.getAttribute("userID"));

			raoBan.setTenSach(dangBanForm.getTenSach());
			raoBan.setMaDanhMuc(dangBanForm.getMaDanhMuc());
			raoBan.setTacGia(dangBanForm.getTacGia());
			raoBan.setNxb(dangBanForm.getNxb());
			raoBan.setNamxb(dangBanForm.getNamxb());
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

			String storageLink = "";
			String databaseLink = "";

			if (StringProcess.notVaild(anh1.getFileName())) {
				raoBan.setLinkAnh1(dangBanForm.getLinkAnh1());
			} else {
				storageLink = prefixStorageLink + "(1)" + StringProcess.getSuffix(anh1);
				databaseLink = prefixDatabaseLink + "(1)" + StringProcess.getSuffix(anh1);
				outputStream = new FileOutputStream(new File(storageLink));
				outputStream.write(anh1.getFileData());
				raoBan.setLinkAnh2(databaseLink);
			}

			if (StringProcess.notVaild(anh2.getFileName())) {
				if (dangBanForm.getLinkAnh2().equals(Constant.NO_IMAGE_DEFAULT)) {
					raoBan.setLinkAnh2("");
				} else {
					raoBan.setLinkAnh2(dangBanForm.getLinkAnh2());
				}
			} else {
				storageLink = prefixStorageLink + "(2)" + StringProcess.getSuffix(anh2);
				databaseLink = prefixDatabaseLink + "(2)" + StringProcess.getSuffix(anh2);
				outputStream = new FileOutputStream(new File(storageLink));
				outputStream.write(anh2.getFileData());
				raoBan.setLinkAnh2(databaseLink);
			}

			if (StringProcess.notVaild(anh3.getFileName())) {
				if (dangBanForm.getLinkAnh3().equals(Constant.NO_IMAGE_DEFAULT)) {
					raoBan.setLinkAnh3("");
				} else {
					raoBan.setLinkAnh3(dangBanForm.getLinkAnh3());
				}
			} else {
				storageLink = prefixStorageLink + "(3)" + StringProcess.getSuffix(anh3);
				databaseLink = prefixDatabaseLink + "(3)" + StringProcess.getSuffix(anh3);
				outputStream = new FileOutputStream(new File(storageLink));
				outputStream.write(anh3.getFileData());
				raoBan.setLinkAnh3(databaseLink);
			}

			if (StringProcess.notVaild(anh4.getFileName())) {
				if (dangBanForm.getLinkAnh4().equals(Constant.NO_IMAGE_DEFAULT)) {
					raoBan.setLinkAnh4("");
				} else {
					raoBan.setLinkAnh4(dangBanForm.getLinkAnh4());
				}
			} else {
				storageLink = prefixStorageLink + "(4)" + StringProcess.getSuffix(anh4);
				databaseLink = prefixDatabaseLink + "(4)" + StringProcess.getSuffix(anh4);
				outputStream = new FileOutputStream(new File(storageLink));
				outputStream.write(anh4.getFileData());
				raoBan.setLinkAnh4(databaseLink);
			}

			if (StringProcess.notVaild(anh5.getFileName())) {
				if (dangBanForm.getLinkAnh4().equals(Constant.NO_IMAGE_DEFAULT)) {
					raoBan.setLinkAnh4("");
				} else {
					raoBan.setLinkAnh4(dangBanForm.getLinkAnh4());
				}
			} else {
				storageLink = prefixStorageLink + "(5)" + StringProcess.getSuffix(anh5);
				databaseLink = prefixDatabaseLink + "(5)" + StringProcess.getSuffix(anh5);
				outputStream = new FileOutputStream(new File(storageLink));
				outputStream.write(anh5.getFileData());
				raoBan.setLinkAnh5(databaseLink);
			}
			if (outputStream != null) {
				outputStream.close();
			}

			// chạy hàm sửa bài đăng
			System.out.println("Goi ham` sua bai");
			if (raoBanBO.suaBaiDang(raoBan)) {
				System.out.println("Sua bai dang thanh cong !!! - SuaBaiDangAction");
				return mapping.findForward("thanhCong");
			}
			return mapping.findForward("thatBai");
		}

		// Nếu không bấm button submit
		// Nạp dữ liệu cũ và hiển thị form sửa
		System.out.println("SUBMIT: " + dangBanForm.getSubmit());

		if (StringProcess.notVaild(dangBanForm.getMaRaoBan())) {
			System.out.println("Khong co ma rao ban --> Tra ve trang chu");
			return mapping.findForward("trangChu");
		}
		RaoBan raoBan = raoBanBO.layThongTinBaiDang(dangBanForm.getMaRaoBan());

		// Trước tiên kiểm tra trạng thái rao bán CHỜ DUYỆT (0) và ĐANG BÁN (1)
		// mới có thể sửa
		System.out.println("TRANG THAI BAI DANG: " + raoBan.getTrangThaiRaoBan());
		if (Constant.TRANG_THAI_CHO_DUYET == raoBan.getTrangThaiRaoBan()
				|| Constant.TRANG_THAI_DANG_BAN == raoBan.getTrangThaiRaoBan()) {

			dangBanForm.setMaRaoBan(raoBan.getMaRaoBan());

			dangBanForm.setTenSach(raoBan.getTenSach());
			dangBanForm.setMaDanhMuc(raoBan.getMaDanhMuc());
			dangBanForm.setTacGia(raoBan.getTacGia());
			dangBanForm.setNxb(raoBan.getNxb());
			dangBanForm.setNamxb(raoBan.getNamxb());
			dangBanForm.setMaTinh(raoBan.getMaTinhBan());
			dangBanForm.setGia(raoBan.getGia());
			dangBanForm.setMoTa(raoBan.getMoTa());

			dangBanForm.setLinkAnh1(
					StringProcess.notVaild(raoBan.getLinkAnh1()) ? Constant.NO_IMAGE_DEFAULT : raoBan.getLinkAnh1());
			dangBanForm.setLinkAnh2(
					StringProcess.notVaild(raoBan.getLinkAnh2()) ? Constant.NO_IMAGE_DEFAULT : raoBan.getLinkAnh2());
			dangBanForm.setLinkAnh3(
					StringProcess.notVaild(raoBan.getLinkAnh3()) ? Constant.NO_IMAGE_DEFAULT : raoBan.getLinkAnh3());
			dangBanForm.setLinkAnh4(
					StringProcess.notVaild(raoBan.getLinkAnh4()) ? Constant.NO_IMAGE_DEFAULT : raoBan.getLinkAnh4());
			dangBanForm.setLinkAnh5(
					StringProcess.notVaild(raoBan.getLinkAnh5()) ? Constant.NO_IMAGE_DEFAULT : raoBan.getLinkAnh5());

			System.out.println("Forward den giao dien sua bai dang");
			return mapping.findForward("suaBaiDang");
		} else {
			System.out.println("Ban chi co the sua bai dang chua ban hoac dang ban");
			ActionErrors errors = new ActionErrors();
			errors.add("error", new ActionMessage("error.suaBaiDang.notValid"));
			saveErrors(request, errors);
			return mapping.findForward("khongTheSuaLogged");
		}
	}

}
