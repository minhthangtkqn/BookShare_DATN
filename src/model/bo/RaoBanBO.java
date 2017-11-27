package model.bo;

import java.util.ArrayList;

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

	public ArrayList<RaoBan> layDanhSachTimKiem(String tuKhoa, String maTinh, String maDanhMuc, String sapXepGia,
			String sapXepThoiGian, int page) {

		String[] arrayTuKhoa = tuKhoa.split("\\s+");
		String[] arrayTuKhoaKhongDau = StringProcess.removeDiacritics(tuKhoa).split("\\s+");

		ArrayList<RaoBan> list = new ArrayList<>();

		// tim kiem theo ten sach
		list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(tuKhoa, maTinh, maDanhMuc, sapXepGia, sapXepThoiGian));
		for (String item : arrayTuKhoa) {
			list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(item, maTinh, maDanhMuc, sapXepGia, sapXepThoiGian));
		}
		list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(StringProcess.removeDiacritics(tuKhoa), maTinh, maDanhMuc,
				sapXepGia, sapXepThoiGian));
		for (String item : arrayTuKhoaKhongDau) {
			list.addAll(raoBanDAO.layDanhSachTimKiemTenSach(item, maTinh, maDanhMuc, sapXepGia, sapXepThoiGian));
		}

		// tim kiem theo ten tac gia
		list.addAll(raoBanDAO.layDanhSachTimKiemTenTacGia(tuKhoa, maTinh, maDanhMuc, sapXepGia, sapXepThoiGian));
		for (String item : arrayTuKhoa) {
			list.addAll(raoBanDAO.layDanhSachTimKiemTenTacGia(item, maTinh, maDanhMuc, sapXepGia, sapXepThoiGian));
		}
		list.addAll(raoBanDAO.layDanhSachTimKiemTenTacGia(StringProcess.removeDiacritics(tuKhoa), maTinh, maDanhMuc,
				sapXepGia, sapXepThoiGian));
		for (String item : arrayTuKhoaKhongDau) {
			list.addAll(raoBanDAO.layDanhSachTimKiemTenTacGia(item, maTinh, maDanhMuc, sapXepGia, sapXepThoiGian));
		}

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

		// code loc so luong ket qua theo trang HERE
		// remove elements after segment
		while (page * 16 - 1 < list.size() - 1) {
			list.remove(list.size() - 1);
		}
		// remove elements before segment
		for (int i = 1; i <= (page - 1) * 16; i++) {
			list.remove(0);
		}

		return list;
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

}
