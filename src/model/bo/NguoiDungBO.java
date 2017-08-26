package model.bo;

import java.util.ArrayList;

import model.dao.NguoiDungDAO;

import model.bean.NguoiDung;

public class NguoiDungBO {

	NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();

	public ArrayList<NguoiDung> layDanhSachNguoiDung() {
		return nguoiDungDAO.layDanhSachNguoiDung();
	}

	public ArrayList<NguoiDung> layDanhSachNguoiDungBiKhoa() {
		return nguoiDungDAO.layDanhSachNguoiDungBiKhoa();
	}

	public boolean kiemTraTaiKhoanTonTai(String taiKhoan) {
		return nguoiDungDAO.kiemTraTaiKhoanTonTai(taiKhoan);
	}

	public int kiemTraDangNhap(String taiKhoan, String matKhau) {
		return nguoiDungDAO.kiemTraDangNhap(taiKhoan, matKhau);
	}

	public void khoaNguoiDung(String maNguoiDung, String ghiChu) {
		nguoiDungDAO.khoaNguoiDung(maNguoiDung, ghiChu);
	}

	public void boKhoaNguoiDung(String maNguoiDung) {
		nguoiDungDAO.boKhoaNguoiDung(maNguoiDung);
	}

	public String layMaNguoiDung(String taiKhoan, String matKhau) {
		return nguoiDungDAO.layMaNguoiDung(taiKhoan, matKhau);
	}

	public String layAnhNguoiDung(String taiKhoan, String matKhau) {
		return nguoiDungDAO.layAnhNguoiDung(taiKhoan, matKhau);
	}

	public String layLiDoKhoa(String taiKhoan, String matKhau) {
		return nguoiDungDAO.layLiDoKhoa(taiKhoan, matKhau);
	}

	public void dangKi(String taiKhoan, String matKhau) {
		nguoiDungDAO.dangKiTaiKhoan(taiKhoan, matKhau);
	}

	public NguoiDung layNguoiDung(String maNguoiDung) {
		return nguoiDungDAO.layNguoiDung(maNguoiDung);
	}

}
