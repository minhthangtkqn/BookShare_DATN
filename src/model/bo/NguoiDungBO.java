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

	public boolean khoaNguoiDung(String maNguoiDung, String ghiChu) {
		return nguoiDungDAO.khoaNguoiDung(maNguoiDung, ghiChu);
	}

	public boolean moKhoaNguoiDung(String maNguoiDung) {
		return nguoiDungDAO.moKhoaNguoiDung(maNguoiDung);
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

	public boolean dangKi(String taiKhoan, String matKhau) {
		return nguoiDungDAO.dangKiTaiKhoan(taiKhoan, matKhau);
	}

	public NguoiDung layNguoiDung(String maNguoiDung) {
		System.out.println("Lay ND - Ma ND: " + maNguoiDung);
		return nguoiDungDAO.layNguoiDung(maNguoiDung);
	}

	public NguoiDung layAdmin(String maNguoiDung) {
		return nguoiDungDAO.layAdmin(maNguoiDung);
	}

	public boolean suaThongTin(NguoiDung nguoiDung) {
		return nguoiDungDAO.suaThongTin(nguoiDung);
	}

	public boolean suaMatKhau(NguoiDung nguoiDung) {
		return nguoiDungDAO.suaMatKhau(nguoiDung);
	}

}
