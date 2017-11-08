package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.RaoBan;
import model.bo.BinhLuanBO;
import model.bo.NguoiDungBO;
import model.bo.RaoBanBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import form.ChiTietBaiDangForm;

public class ChiTietBaiDangAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("ChiTietBaiDangAction");

		HttpSession session = request.getSession();
		ChiTietBaiDangForm chiTietBaiDangForm = (ChiTietBaiDangForm) form;

		// Kiem tra MA RAO BAN co hay khong
		if (StringProcess.notVaild(chiTietBaiDangForm.getMaRaoBan())) {
			System.out.println("Khong co MA RAO BAN");
			return mapping.findForward("trangChu");
		}

		RaoBanBO raoBanBO = new RaoBanBO();
		BinhLuanBO binhLuanBO = new BinhLuanBO();
		NguoiDungBO nguoiDungBO = new NguoiDungBO();

		// lay du lieu hien thi
		RaoBan raoBan = raoBanBO.layThongTinBaiDang(chiTietBaiDangForm.getMaRaoBan());

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
		chiTietBaiDangForm.setDsBinhLuan(binhLuanBO.layDsBinhLuan(chiTietBaiDangForm.getMaRaoBan()));

		/**
		 * Kiem tra nguoi dung de phan luong hien thi
		 */
		String userID;
		int userType;

		// kiem tra da dang nhap hay chua
		int type = nguoiDungBO.kiemTraDangNhap((String) session.getAttribute("userName"),
				(String) session.getAttribute("password"));

		// PHÂN LUỒNG
		if (type == 0) {
			// admin
			return mapping.findForward("xemCheDoQuanLy");
		} else {
			chiTietBaiDangForm.setDsGoiYMoiNguoiCungXem(raoBanBO.layDanhSachHot());

			// luu lich su xem vao` CSDL
			if (raoBanBO.luuLichSuXemRaoBan(StringProcess.getVaildString((String) session.getAttribute("userID")),
					chiTietBaiDangForm.getChiTiet().getMaRaoBan())) {
				System.out.println("Da~ luu vao CSDL:");
				System.out.println(
						"Ma Nguoi Dung: " + StringProcess.getVaildString((String) session.getAttribute("userID"))
								+ "  ---  Ma Rao Ban: " + chiTietBaiDangForm.getChiTiet().getMaRaoBan());
			} else {
				System.out.println("Luu vao` CSDL that bai");
			}

			switch (type) {
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
}
