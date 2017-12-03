package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Constant;
import common.StringProcess;
import model.bean.NguoiDung;

public class NguoiDungDAO {
	PreparedStatement statement;
	Connection connection;
	String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShare";
	String username = "sa";
	String password = "12345678";

	void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, username, password);
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
		String sql = "SELECT * FROM " + Constant.VIEW_DANH_SACH_NGUOI_DUNG;
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
				
				nguoiDung.setNamSinh(rs.getInt("namSinh"));
				nguoiDung.setMaTinh(rs.getInt("MaTinh"));
				nguoiDung.setLoaiNguoiDung(rs.getString("LoaiNguoiDung"));

				nguoiDung.setAnh(
						StringProcess.notVaild(rs.getString("anh")) ? Constant.NO_IMAGE_DEFAULT : rs.getString("anh"));

				if ("0".equals(rs.getString("gioitinh"))) {
					nguoiDung.setGioiTinh("Nữ");
				} else {
					if ("1".equals(rs.getString("gioitinh"))) {
						nguoiDung.setGioiTinh("Nam");
					} else {
						nguoiDung.setGioiTinh("Không xác định");
					}
				}
				
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
				nguoiDung.setNamSinh(rs.getInt("namSinh"));
				
				if ("0".equals(rs.getString("gioitinh"))) {
					nguoiDung.setGioiTinh("Nữ");
				} else {
					if ("1".equals(rs.getString("gioitinh"))) {
						nguoiDung.setGioiTinh("Nam");
					} else {
						nguoiDung.setGioiTinh("Không xác định");
					}
				}
				
				list.add(nguoiDung);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
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
		
		String sql = "SELECT * FROM f_checklogin( ?, ? )";
		System.out.println("KIEM TRA DANG NHAP FUNCTION");
		System.out.println("TaiKhoan: " + taiKhoan);
		System.out.println("MatKhau: " + matKhau);
		System.out.println(sql);
		ResultSet rs = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, taiKhoan);
			stmt.setString(2, matKhau);

			rs = stmt.executeQuery();
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

		String sql = "SELECT MaNguoiDung from " + Constant.TABLE_NGUOI_DUNG + " where TaiKhoan = ? and MatKhau = ? ";

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
		String sql = "SELECT * FROM " + Constant.VIEW_DANH_SACH_NGUOI_DUNG + " where [manguoidung] = ?";
		NguoiDung nguoiDung = null;
		ResultSet rs = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, maNguoiDung);

			rs = stmt.executeQuery();

			rs.next();

			nguoiDung = new NguoiDung();

			System.out.println("tai khoan: " + rs.getString("taikhoan"));

			nguoiDung.setMaNguoiDung(rs.getString("manguoidung"));
			nguoiDung.setTaiKhoan(rs.getString("taikhoan"));
			nguoiDung.setHoTen(rs.getString("hoten"));
			nguoiDung.setTenTinh(rs.getString("tentinh"));
			nguoiDung.setDienThoai(rs.getString("dienthoai"));
			nguoiDung.setEmail(rs.getString("email"));
			nguoiDung.setAnh(rs.getString("anh"));
			
			nguoiDung.setNamSinh(rs.getInt("namSinh"));
			nguoiDung.setMaTinh(rs.getInt("matinh"));
			nguoiDung.setGhiChu((StringProcess.notVaild(rs.getString("GhiChu"))?"":rs.getString("GhiChu")));

			if ("0".equals(rs.getString("gioitinh"))) {
				nguoiDung.setGioiTinh("Nữ");
			} else {
				if ("1".equals(rs.getString("gioitinh"))) {
					nguoiDung.setGioiTinh("Nam");
				} else {
					nguoiDung.setGioiTinh("Không xác định");
				}
			}
			
			nguoiDung.setLoaiNguoiDung((rs.getInt("LoaiNguoiDung") == 1) ? Constant.NORMAL_ACCOUNT : Constant.LOCKED_ACCOUNT);

			return nguoiDung;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public NguoiDung layAdmin(String maNguoiDung) {
		connect();
		String sql = "SELECT * FROM " + Constant.VIEW_DANH_SACH_ADMIN + " where [manguoidung] = ?";
		NguoiDung nguoiDung = new NguoiDung();
		ResultSet rs = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, maNguoiDung);

			rs = stmt.executeQuery();

			rs.next();

			System.out.println("tai khoan: " + rs.getString("taikhoan"));

			nguoiDung.setMaNguoiDung(rs.getString("manguoidung"));
			nguoiDung.setTaiKhoan(rs.getString("taikhoan"));
			nguoiDung.setHoTen(rs.getString("hoten"));
			nguoiDung.setTenTinh(rs.getString("tentinh"));
			nguoiDung.setDienThoai(rs.getString("dienthoai"));
			nguoiDung.setEmail(rs.getString("email"));
			nguoiDung.setAnh(rs.getString("anh"));
			
			nguoiDung.setNamSinh(rs.getInt("namSinh"));
			nguoiDung.setMaTinh(rs.getInt("MaTinh"));
			nguoiDung.setLoaiNguoiDung(rs.getString("LoaiNguoiDung"));
			
			if ("0".equals(rs.getString("gioitinh"))) {
				nguoiDung.setGioiTinh("Nữ");
			} else {
				if ("1".equals(rs.getString("gioitinh"))) {
					nguoiDung.setGioiTinh("Nam");
				} else {
					nguoiDung.setGioiTinh("Không xác định");
				}
			}
			
			System.out.println("Ten Tinh Admin: " + rs.getString("TenTinh"));

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return nguoiDung;
	}

	public boolean suaThongTin(NguoiDung nguoiDung) {
		connect();

		String sql = "UPDATE " + Constant.TABLE_NGUOI_DUNG
				+ " SET HoTen = ?, MaTinh = ?, DienThoai = ?, Email = ?, GioiTinh = ? WHERE MaNguoiDung = ?";
		// , Anh = ?, NamSinh = ?
		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setNString(1, nguoiDung.getHoTen());
			statement.setInt(2, nguoiDung.getMaTinh());
			statement.setString(3, nguoiDung.getDienThoai());
			statement.setString(4, nguoiDung.getEmail());
			
			statement.setInt(5, Integer.parseInt(nguoiDung.getGioiTinh()));
			
			// statement.setString(6, nguoiDung.getAnh());
			// statement.setInt(7, nguoiDung.getNamSinh());
			statement.setString(6, nguoiDung.getMaNguoiDung());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean suaMatKhau(NguoiDung nguoiDung) {
		connect();

		String sql = "UPDATE " + Constant.TABLE_NGUOI_DUNG + " SET MatKhau = ? WHERE MaNguoiDung = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, nguoiDung.getMatKhau());
			statement.setString(2, nguoiDung.getMaNguoiDung());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean khoaNguoiDung(String maNguoiDung, String ghiChu) {
		connect();

		String sql = "EXEC " + Constant.FUNCTION_KHOA_NGUOI_DUNG + " ?, ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, maNguoiDung);
			statement.setNString(2, ghiChu);

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean moKhoaNguoiDung(String maNguoiDung) {
		connect();

		String sql = "EXEC " + Constant.FUNCTION_MO_KHOA_NGUOI_DUNG + " ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, maNguoiDung);

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
