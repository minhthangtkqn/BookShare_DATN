package model.bo;

import java.util.ArrayList;

import common.Constant;
import common.StringProcess;
import model.bean.RaoBan;
import model.dao.RaoBanDAO;

public class RaoBanBO {
	RaoBanDAO raoBanDAO = new RaoBanDAO();

	/**
	 * LAY THONG TIN CHI TIET DE HIEN THI LIST
	 * 
	 * @param
	 * @return
	 */
	public RaoBan layThongTinBaiDang(String maRaoBan) {
		return raoBanDAO.layThongTinBaiDang(maRaoBan);
	}

	public ArrayList<RaoBan> layDanhSachChoDuyet() {
		return raoBanDAO.layDanhSachChoDuyet();
	}

	public ArrayList<RaoBan> layDanhSachChoDuyet(String maNguoiDung) {
		return raoBanDAO.layDanhSachChoDuyet(maNguoiDung);
	}

	public ArrayList<RaoBan> layDanhSachDangBan() {
		return raoBanDAO.layDanhSachDangBan();
	}

	public ArrayList<RaoBan> layDanhSachDangBan(String maNguoiDung) {
		return raoBanDAO.layDanhSachDangBan(maNguoiDung);
	}

	public ArrayList<RaoBan> layDanhSachDaBan() {
		return raoBanDAO.layDanhSachDaBan();
	}

	public ArrayList<RaoBan> layDanhSachDaBan(String maNguoiDung) {
		return raoBanDAO.layDanhSachDaBan(maNguoiDung);
	}

	public ArrayList<RaoBan> layDanhSachBaiDangBiKhoa() {
		return raoBanDAO.layDanhSachBaiDangBiKhoa();
	}

	public boolean dangBai(RaoBan raoBan) {
		return raoBanDAO.dangBai(raoBan);
	}

	// -----------------------

	/**
	 * LAY THONG TIN DE HIEN THI O TRANG CHU VA TIM KIEM
	 */

	public ArrayList<RaoBan> layDanhSachHot() {
		return raoBanDAO.layDanhSachHot();
	}

	public ArrayList<RaoBan> layDanhSachMoiNhat() {
		return raoBanDAO.layDanhSachMoiNhat();
	}

	public ArrayList<RaoBan> layDanhSachDanhMucBanNhieuNhat() {
		return raoBanDAO.layDanhSachDanhMucBanNhieuNhat();
	}

	public ArrayList<Object> layDanhSachTimKiem(String tuKhoa, String maTinh, String maDanhMuc, String sapXepGia,
			String sapXepThoiGian, int page) {

		String[] arrayTuKhoa = tuKhoa.split("\\s+");
		String[] arrayTuKhoaKhongDau = StringProcess.removeDiacritics(tuKhoa).split("\\s+");

		ArrayList<RaoBan> list = new ArrayList<>();

		// tim kiem theo ten sach
		list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(tuKhoa, maTinh, maDanhMuc, sapXepGia, sapXepThoiGian));
		for (String item : arrayTuKhoa) {
			list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(item, maTinh, maDanhMuc, sapXepGia, sapXepThoiGian));
		}
		// list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(StringProcess.removeDiacritics(tuKhoa),
		// maTinh, maDanhMuc,
		// sapXepGia, sapXepThoiGian));
		// for (String item : arrayTuKhoaKhongDau) {
		// list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(item, maTinh,
		// maDanhMuc, sapXepGia, sapXepThoiGian));
		// }

		// tim kiem theo ten tac gia
		list.addAll(raoBanDAO.layDanhSachTimKiemTenTacGia(tuKhoa, maTinh, maDanhMuc, sapXepGia, sapXepThoiGian));
		for (String item : arrayTuKhoa) {
			list.addAll(raoBanDAO.layDanhSachTimKiemTenTacGia(item, maTinh, maDanhMuc, sapXepGia, sapXepThoiGian));
		}
		// list.addAll(raoBanDAO.layDanhSachTimKiemTenTacGia(StringProcess.removeDiacritics(tuKhoa),
		// maTinh, maDanhMuc,
		// sapXepGia, sapXepThoiGian));
		// for (String item : arrayTuKhoaKhongDau) {
		// list.addAll(raoBanDAO.layDanhSachTimKiemTenTacGia(item, maTinh,
		// maDanhMuc, sapXepGia, sapXepThoiGian));
		// }

		// Lọc lại các kết quả tìm kiếm trùng nhau
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {

				if (list.get(i).getMaRaoBan().equals(list.get(j).getMaRaoBan())) {
					list.remove(j);
					j--;
				}
			}
		}
		// END Lọc lại các kết quả tìm kiếm trùng nhau

		System.out.println("RaoBanBO -- Tong so luong ket qua thu duoc: " + list.size());
		ArrayList<Object> returnList = new ArrayList<>();
		returnList.add(list.size());

		// code loc so luong ket qua theo trang HERE
		// remove elements after segment
		while (page * Constant.NUMBER_PRODUCT_ON_PAGE - 1 < list.size() - 1) {
			list.remove(list.size() - 1);
		}
		// remove elements before segment
		try {
			for (int i = 1; i <= (page - 1) * Constant.NUMBER_PRODUCT_ON_PAGE; i++) {
				list.remove(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		returnList.add(list);
		return returnList;
	}

	// public ArrayList<RaoBan> layDanhSachTimKiemTenTacGia(String tuKhoa,
	// String maTinh, String maDanhMuc,
	// String sapXepGia, String sapXepThoiGian) {
	// return raoBanDAO.layDanhSachTimKiemTenTacGia(tuKhoa, maTinh, maDanhMuc,
	// sapXepGia, sapXepThoiGian);
	// }

	public ArrayList<RaoBan> layDanhSachGoiYMoiNguoiCungXem() {
		return raoBanDAO.layDanhSachGoiYMoiNguoiCungXem();
	}

	public ArrayList<RaoBan> layDsMoiNhatTheoDanhMuc(String maDanhMuc) {
		return raoBanDAO.layDsMoiNhatTheoDanhMuc(maDanhMuc);
	}

	public ArrayList<RaoBan> timKiemTenSachTrongDanhMuc(String maDanhMuc, String tuKhoa) {
		return raoBanDAO.timKiemTenSachTrongDanhMuc(maDanhMuc, tuKhoa);
	}

	public ArrayList<RaoBan> timKiemTacGiaTrongDanhMuc(String maDanhMuc, String tuKhoa) {
		return raoBanDAO.timKiemTacGiaTrongDanhMuc(maDanhMuc, tuKhoa);
	}

	/**
	 * Luu tu khoa vao CSDL khi tim kiem
	 */
	public boolean luuTuKhoaTimKiem(String maNguoiDung, String tuKhoa) {
		return raoBanDAO.luuTuKhoaTimKiem(maNguoiDung, tuKhoa);
	}

	/**
	 * Luu lich su xem rao ban vao CSDL
	 */
	public boolean luuLichSuXemRaoBan(String maNguoiDung, String maRaoBan) {
		return raoBanDAO.luuLichSuXemRaoBan(maNguoiDung, maRaoBan);
	}

	public boolean suaBaiDang(RaoBan raoBan) {
		return raoBanDAO.suaBaiDang(raoBan);
	}

	public boolean xoaBaiDang(String maNguoiRaoBan, String maRaoBan) {
		return raoBanDAO.xoaBaiDang(maNguoiRaoBan, maRaoBan);
	}

	public boolean xoaBaiDangAdmin(String maRaoBan) {
		return raoBanDAO.xoaBaiDangAdmin(maRaoBan);
	}

	public boolean banBaiDang(String maNguoiRaoBan, String maRaoBan) {
		return raoBanDAO.banBaiDang(maNguoiRaoBan, maRaoBan);
	}

	public boolean duyetBaiDang(String maRaoBan) {
		return raoBanDAO.duyetBaiDang(maRaoBan);
	}

	public boolean khoaBaiDang(String maRaoBan, String maNguoiRaoBan) {
		return raoBanDAO.khoaBaiDang(maRaoBan, maNguoiRaoBan);
	}

	public boolean moKhoaBaiDang(String maRaoBan, String maNguoiRaoBan) {
		return raoBanDAO.moKhoaBaiDang(maRaoBan, maNguoiRaoBan);
	}

	public boolean khongDuyetBaiDang(String maRaoBan) {
		return raoBanDAO.khongDuyetBaiDang(maRaoBan);
	}

	public ArrayList<RaoBan> layLichSuXemBaiDang(String maNguoiDung) {
		return raoBanDAO.layLichSuXemBaiDang(maNguoiDung);
	}

	public RaoBan layThongTinSuaBaiDang(String maRaoBan) {
		return raoBanDAO.layThongTinSuaBaiDang(maRaoBan);
	}

	public boolean danhDauXemSau(String maNguoiDung, String maRaoBan) {
		return raoBanDAO.danhDauXemSau(maNguoiDung, maRaoBan);
	}

	public ArrayList<RaoBan> layDanhSachXemSau(String maNguoiDung) {
		return raoBanDAO.layDanhSachXemSau(maNguoiDung);
	}

	public boolean boDanhDauXemSau(String maNguoiDung, String maRaoBan) {
		return raoBanDAO.boDanhDauXemSau(maNguoiDung, maRaoBan);
	}

	public boolean isXemSau(String maNguoiDung, String maRaoBan) {
		return raoBanDAO.isXemSau(maNguoiDung, maRaoBan);
	}

	public ArrayList<RaoBan> layDanhSachLienQuan(String maRaoBan) {
		RaoBan raoBan = raoBanDAO.layThongTinBaiDang(maRaoBan);

		String tuKhoa = raoBan.getTenSach();
		String tacGia = raoBan.getTacGia();

		String[] arrayTuKhoa = tuKhoa.split("\\s+");
		// String[] arrayTuKhoaKhongDau =
		// StringProcess.removeDiacritics(tuKhoa).split("\\s+");

		// Tim sach cung ten
		ArrayList<RaoBan> list = new ArrayList<>();
		list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(tuKhoa, "all", "all", Constant.DEFAULT_SAP_XEP_GIA_TANG_DAN,
				Constant.DEFAULT_SAP_XEP_THOI_GIAN));

		/*
		 * list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(StringProcess.
		 * removeDiacritics(tuKhoa), "all", "all", Constant.DEFAULT_SAP_XEP_GIA,
		 * Constant.DEFAULT_SAP_XEP_THOI_GIAN));
		 */

		// code cat duoi - tim sach co' ten cung` chuoi~ ky' tu
		for (int i = arrayTuKhoa.length; i >= 2; i--) {
			String item = arrayTuKhoa[0];
			for (int j = 1; j <= i - 1; j++) {
				item += " " + arrayTuKhoa[j];
			}
			list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(item, "all", "all", Constant.DEFAULT_SAP_XEP_GIA_TANG_DAN,
					Constant.DEFAULT_SAP_XEP_THOI_GIAN));
		}
		/*
		 * for (int i = arrayTuKhoaKhongDau.length; i >= 2; i--) { String item =
		 * arrayTuKhoaKhongDau[0]; for (int j = 1; j <= i - 1; j++) { item +=
		 * " " + arrayTuKhoaKhongDau[j]; }
		 * list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(item, "all", "all",
		 * Constant.DEFAULT_SAP_XEP_GIA, Constant.DEFAULT_SAP_XEP_THOI_GIAN)); }
		 */

		// Tim sach cung tac gia
		list.addAll(raoBanDAO.layDanhSachTimKiemTenTacGia(tacGia, "all", "all", Constant.DEFAULT_SAP_XEP_GIA_TANG_DAN,
				Constant.DEFAULT_SAP_XEP_THOI_GIAN));

		// Tim sach co ten chua string tuong tu
		for (String item : arrayTuKhoa) {
			list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(item, "all", "all", Constant.DEFAULT_SAP_XEP_GIA_TANG_DAN,
					Constant.DEFAULT_SAP_XEP_THOI_GIAN));
		}

		/*
		 * for (String item : arrayTuKhoaKhongDau) {
		 * list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(item, "all", "all",
		 * Constant.DEFAULT_SAP_XEP_GIA, Constant.DEFAULT_SAP_XEP_THOI_GIAN)); }
		 */

		// thêm một số kết quả mới nhất, phòng trường họp không tìm
		// được bài đăng liên quan
		list.addAll(raoBanDAO.layDanhSachHot());

		// Lọc lại các kết quả tìm kiếm trùng nhau
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {

				if (list.get(i).getMaRaoBan().equals(list.get(j).getMaRaoBan())) {
					list.remove(j);
					j--;
				}
			}
		}
		// END Lọc lại các kết quả tìm kiếm trùng nhau

		// Lọc các record bài đăng trùng với bài đăng gốc
		for (int i = 0; i < list.size(); i++) {
			if (maRaoBan.equals(list.get(i).getMaRaoBan())) {
				list.remove(i);
			}
		}
		// END Lọc các record bài đăng trùng với bài đăng gốc

		// lay cac ket qua dau tien
		while (list.size() > Constant.NUMBER_RELATED_PRODUCTS) {
			list.remove(list.size() - 1);
		}

		return list;
	}

}
