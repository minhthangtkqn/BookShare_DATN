package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Constant;
import model.bean.NguoiDung;

public class NguoiDungDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShare";
	String userName = "sa";
	String password = "12345678";
	Connection connection;

	PreparedStatement statement;

	// Ket Noi Co So Du Lieu
	void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		}
	}

	// Danh Sach Nguoi Dung Cho Admin
	public ArrayList<NguoiDung> layDanhSachNguoiDung() {
		connect();
		String sql = "select * from v_danhsachnguoidung";
		ResultSet rs = null;
		ArrayList<NguoiDung> list = new ArrayList<NguoiDung>();
		NguoiDung nguoiDung;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				nguoiDung = new NguoiDung();
				nguoiDung.setMaNguoiDung(rs.getString("manguoidung"));
				nguoiDung.setTaiKhoan(rs.getString("taikhoan"));
				nguoiDung.setHoTen(rs.getString("hoten"));
				nguoiDung.setTenTinh(rs.getString("tentinh"));
				nguoiDung.setDienThoai(rs.getString("dienthoai"));
				nguoiDung.setEmail(rs.getString("email"));
				nguoiDung.setAnh(rs.getString("anh"));
				nguoiDung.setGioiTinh(rs.getInt("gioitinh"));
				nguoiDung.setNamSinh(rs.getInt("namSinh"));
				list.add(nguoiDung);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// Danh Sach NguoiDungBiChan
	public ArrayList<NguoiDung> layDanhSachNguoiDungBiKhoa() {
		connect();
		String sql = "select * from [v_danhsachblock]";
		ArrayList<NguoiDung> list = new ArrayList<NguoiDung>();
		NguoiDung nguoiDung;
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				nguoiDung = new NguoiDung();
				nguoiDung.setMaNguoiDung(rs.getString("manguoidung"));
				nguoiDung.setTaiKhoan(rs.getString("taikhoan"));
				nguoiDung.setHoTen(rs.getString("hoten"));
				nguoiDung.setTenTinh(rs.getString("tentinh"));
				nguoiDung.setDienThoai(rs.getString("dienthoai"));
				nguoiDung.setEmail(rs.getString("email"));
				nguoiDung.setAnh(rs.getString("anh"));
				nguoiDung.setGioiTinh(rs.getInt("gioitinh"));
				nguoiDung.setNamSinh(rs.getInt("namSinh"));
				list.add(nguoiDung);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// Chan Nguoi Dung
	public void khoaNguoiDung(String maNguoiDung, String ghiChu) {
		connect();
		String sql = String.format("update tblnguoidung set loainguoidung=2,ghichu=N'%s' where manguoidung='%s'",
				maNguoiDung, ghiChu);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Bo Chan Nguoi Dung
	public void boKhoaNguoiDung(String maNguoiDung) {
		connect();
		String sql = String.format("update tblnguoidung set loainguoidung=1,ghichu='' where manguoidung='%s'",
				maNguoiDung);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Xoa Nguoi Dung ---Chua Su Dung Phai Dung Procedure
	public void xoaNguoiDung(String maNguoiDung) {
		connect();
		String sql = String.format("delete tblnguoidung where manguoidung='%s'", maNguoiDung);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Kiem Tra Xem Tai Khoan Da Ton Tai Hay Chua
	public boolean kiemTraTaiKhoanTonTai(String taikhoan) {
		connect();
		String sql = String.format("select * from dbo.f_checkaccount('%s')", taikhoan);
		try {
			ResultSet rs = null;
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			int key = rs.getInt(1);
			if (key == 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	// Kiem Tra Dang Nhap
	// 0 admin
	// 1 nguoi dung
	// 2 nguoi dung bi khoa
	// 3 sai mat khau
	// 4 sai tai khoan
	public int kiemTraDangNhap(String taiKhoan, String matKhau) {
		connect();
		String sql = String.format("select * from dbo.f_checklogin('%s','%s')", taiKhoan, matKhau);
		System.out.println(sql);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			int key = rs.getInt(1);
			return key;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// Lay li do khoa
	public String layLiDoKhoa(String taiKhoan, String matKhau) {
		connect();
		String sql = String.format("select ghichu from tblnguoidung where taikhoan='%s' and matkhau='%s'", taiKhoan,
				matKhau);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			String reason = rs.getString(1);
			return reason;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// Lay ma nguoi dung
	public String layMaNguoiDung(String taiKhoan, String matKhau) {
		connect();

		/*
		 * String sql = String .format(
		 * "select manguoidung from tblnguoidung where taikhoan='%s' and matkhau='%s'"
		 * , taiKhoan, matKhau);
		 */

		String sql = "select MaNguoiDung from " + Constant.TABLE_NGUOI_DUNG + " where TaiKhoan = ? and MatKhau = ? ";

		ResultSet rs = null;

		try {
			statement = connection.prepareStatement(sql);

			statement.setString(1, taiKhoan);
			statement.setString(2, matKhau);

			rs = statement.executeQuery();

			rs.next();

			String maNguoiDung = rs.getString("MaNguoiDung");

			return maNguoiDung;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String layAnhNguoiDung(String taiKhoan, String matKhau) {
		connect();
		String sql = "SELECT Anh FROM " + Constant.TABLE_NGUOI_DUNG + " WHERE TaiKhoan = ? and MatKhau = ?";
		ResultSet rs = null;
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, taiKhoan);
			statement.setString(2, matKhau);
			
			rs = statement.executeQuery();
			
			rs.next();

			String linkAnhNguoiDung = rs.getString("Anh");
			
			return linkAnhNguoiDung;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// Dang Ki Tai Khoan
	public boolean dangKiTaiKhoan(String taiKhoan, String matKhau) {
		connect();
		String sql = "exec p_dangki ?, ?";
		try {
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, taiKhoan);
			statement.setString(2, matKhau);
			
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public NguoiDung layNguoiDung(String maNguoiDung) {
		connect();
		String sql = "select * from [v_danhsachnguoidung] where [manguoidung] = ?";
		NguoiDung nguoiDung = new NguoiDung();
		ResultSet rs = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, maNguoiDung);

			rs = stmt.executeQuery();

			nguoiDung = new NguoiDung();

			rs.next();

			System.out.println("tai khoan: " + rs.getString("taikhoan"));

			nguoiDung.setMaNguoiDung(rs.getString("manguoidung"));
			nguoiDung.setTaiKhoan(rs.getString("taikhoan"));
			nguoiDung.setHoTen(rs.getString("hoten"));
			nguoiDung.setTenTinh(rs.getString("tentinh"));
			nguoiDung.setDienThoai(rs.getString("dienthoai"));
			nguoiDung.setEmail(rs.getString("email"));
			nguoiDung.setAnh(rs.getString("anh"));
			nguoiDung.setGioiTinh(rs.getInt("gioitinh"));
			nguoiDung.setNamSinh(rs.getInt("namSinh"));

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return nguoiDung;
	}

}
