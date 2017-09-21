package model.bo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public boolean dangBai(RaoBan raoBan) {
		return raoBanDAO.dangBai(raoBan);
	}

	// -----------------------

	/**
	 * LAY THONG TIN DE HIEN THI O TRANG CHU VA TIM KIEM
	 */

	public ArrayList<RaoBan> layDanhSachMoiNhat() {
		return raoBanDAO.layDanhSachMoiNhat();
	}

	public ArrayList<RaoBan> layDanhSachNgauNhien() {
		return raoBanDAO.layDanhSachNgauNhien();
	}

	public ArrayList<RaoBan> layDanhSachDanhMucBanNhieuNhat() {
		return raoBanDAO.layDanhSachDanhMucBanNhieuNhat();
	}

	public ArrayList<RaoBan> layDanhSachTimKiemTenSach(String tuKhoa) {
		return raoBanDAO.layDanhSachTimKiemTenSach(tuKhoa);
	}

	public ArrayList<RaoBan> layDanhSachTimKiemTenTacGia(String tuKhoa) {
		return raoBanDAO.layDanhSachTimKiemTenTacGia(tuKhoa);
	}

	public ArrayList<RaoBan> layDanhSachGoiY(String userID) {
		return raoBanDAO.layDanhSachGoiY(userID);
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
}
