package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Constant;
import model.bean.RaoBan;

public class RaoBanDAO {
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

	/**
	 * CAC HAM LAY THONG TIN CHI TIET BAI RAO BAN
	 * 
	 * @param raoBan
	 * @return
	 */

	public boolean dangBai(RaoBan raoBan) {
		connect();
		// exec p_themraoban
		// 1'tensach',
		// 2'madanhmuc',
		// 3'tacgia',
		// 4'nxb',
		// 5namxb,
		// 6'manguoiraoban',
		// 7matinhban,
		// 8gia,
		// 9'mota',
		// 10'linkanh1',
		// 11'linkanh2',
		// 12'linkanh3',
		// 13'linkanh4',
		// 14'linkanh5'
		String sql = "exec p_themraoban ?,?,?,?,?,?,?,?,?,?,?,?,?,?";
		System.out.println("RaoBanDAO");
		try {

			// PreparedStatement pstm = connection.prepareStatement(sql);

			CallableStatement cstm = connection.prepareCall("{call p_themraoban (?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			cstm.setNString(1, raoBan.getTenSach());
			cstm.setString(2, raoBan.getMaDanhMuc());
			cstm.setNString(3, raoBan.getTacGia());
			cstm.setNString(4, raoBan.getNxb());
			cstm.setString(5, raoBan.getNamxb());
			cstm.setString(6, raoBan.getMaNguoiRaoBan());
			cstm.setInt(7, raoBan.getMaTinhBan());
			cstm.setFloat(8, raoBan.getGia());
			cstm.setNString(9, raoBan.getMoTa());
			cstm.setString(10, raoBan.getLinkAnh1());
			cstm.setString(11, raoBan.getLinkAnh2());
			cstm.setString(12, raoBan.getLinkAnh3());
			cstm.setString(13, raoBan.getLinkAnh4());
			cstm.setString(14, raoBan.getLinkAnh5());

			cstm.executeQuery();
			/*
			 * pstm.setNString(1,raoBan.getTenSach());
			 * pstm.setString(2,raoBan.getMaDanhMuc());
			 * pstm.setNString(3,raoBan.getTacGia());
			 * pstm.setNString(4,raoBan.getNxb()); pstm.setInt(5,
			 * raoBan.getNamxb()); pstm.setString(6, raoBan.getMaNguoiRaoBan());
			 * pstm.setInt(7, raoBan.getMaTinhBan());
			 * pstm.setFloat(8,raoBan.getGia());
			 * pstm.setNString(9,raoBan.getMoTa()); pstm.setString(10,
			 * raoBan.getLinkAnh1()); pstm.setString(11, raoBan.getLinkAnh2());
			 * pstm.setString(12, raoBan.getLinkAnh3()); pstm.setString(13,
			 * raoBan.getLinkAnh4()); pstm.setString(14, raoBan.getLinkAnh5());
			 * 
			 * pstm.executeUpdate(sql);
			 */

			System.out.println("Dang bai thanh cong - RaoBanDAO");

			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			System.out.println("Fail CMNR!!!");
		}
		return false;
	}

	public RaoBan layThongTinBaiDang(String maRaoBan) {

		System.out.println("Ma rao ban DAO: " + maRaoBan);

		connect();
		String sql = "select * from dbo.f_LayThongTinRaoBan(?)";
		RaoBan raoBan = null;
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, maRaoBan);
			ResultSet rs = pstm.executeQuery();
			if (!rs.isBeforeFirst()) {
				return null;
			}
			raoBan = new RaoBan();
			rs.next();

			raoBan.setMaRaoBan(rs.getString("maraoban"));
			raoBan.setMaNguoiRaoBan(rs.getString("manguoiraoban"));
			raoBan.setMaTinhBan(rs.getInt("matinhban"));
			raoBan.setTenTinhBan(rs.getString("tentinhban"));
			raoBan.setGia(rs.getFloat("gia"));
			raoBan.setMoTa(rs.getString("mota"));
			raoBan.setLinkAnh1(rs.getString("linkanh1"));
			raoBan.setLinkAnh2(rs.getString("linkanh2"));
			raoBan.setLinkAnh3(rs.getString("linkanh3"));
			raoBan.setLinkAnh4(rs.getString("linkanh4"));
			raoBan.setLinkAnh5(rs.getString("linkanh5"));
			raoBan.setNgayBan(rs.getDate("ngayban"));
			raoBan.setHoTenNguoiBan(rs.getString("hoten"));
			raoBan.setTaiKhoanNguoiBan(rs.getString("taikhoan"));
			raoBan.setAnhNguoiBan(rs.getString("anh"));

			raoBan.setNamSinhNguoiBan(rs.getInt("namsinh"));
			raoBan.setTenSach(rs.getString("tensach"));
			raoBan.setMaDanhMuc(rs.getString("madanhmuc"));
			raoBan.setTenDanhMuc(rs.getString("tendanhmuc"));
			raoBan.setNamxb(rs.getString("namxb"));
			raoBan.setNxb(rs.getString("nxb"));
			raoBan.setTacGia(rs.getString("tacgia"));
			raoBan.setTrangThaiRaoBan(rs.getInt("TrangThaiBan"));

			if ("0".equals(rs.getString("gioitinh"))) {
				raoBan.setGioiTinh("Nữ");
			} else {
				if ("1".equals(rs.getString("gioitinh"))) {
					raoBan.setGioiTinh("Nam");
				} else {
					raoBan.setGioiTinh("Chưa xác định");
				}
			}

			System.out.println("THONG TIN SACH:");
			System.out.println("ten sach: " + raoBan.getTenSach());
			System.out.println(" --- ten nguoi dang: " + raoBan.getHoTenNguoiBan());
			System.out.println(" --- nam sinh: " + raoBan.getNamSinhNguoiBan());
			System.out.println(" --- link anh 1: " + raoBan.getLinkAnh1());
			System.out.println(" --- gioi tinh: " + raoBan.getGioiTinh());
			System.out.println(" --- danh muc: " + raoBan.getTenDanhMuc());
			System.out.println(" --- nha xuat ban: " + raoBan.getNxb());

			raoBan.toString();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return raoBan;
	}

	public ArrayList<RaoBan> layDanhSachChoDuyet() {
		connect();
		String sql = "SELECT * FROM " + Constant.VIEW_DANH_SACH_CHO_DUYET;
		RaoBan raoBan = null;
		ArrayList<RaoBan> list = new ArrayList<RaoBan>();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				raoBan = new RaoBan();
				raoBan.setMaRaoBan(rs.getString("maraoban"));
				raoBan.setTenTinhBan(rs.getString("tentinh"));
				raoBan.setGia(rs.getFloat("gia"));
				raoBan.setMoTa(rs.getString("mota"));
				raoBan.setLinkAnh1(rs.getString("linkanh1"));
				raoBan.setLinkAnh2(rs.getString("linkanh2"));
				raoBan.setLinkAnh3(rs.getString("linkanh3"));
				raoBan.setLinkAnh4(rs.getString("linkanh4"));
				raoBan.setLinkAnh5(rs.getString("linkanh5"));
				raoBan.setNgayBan(rs.getDate("ngayban"));
				raoBan.setTaiKhoanNguoiBan(rs.getString("taikhoan"));
				raoBan.setAnhNguoiBan(rs.getString("anh"));
				raoBan.setTenSach(rs.getString("tensach"));
				raoBan.setMaDanhMuc(rs.getString("madanhmuc"));
				raoBan.setTenDanhMuc(rs.getString("tendanhmuc"));
				raoBan.setNamxb(rs.getString("namxb"));
				raoBan.setNxb(rs.getString("nxb"));
				raoBan.setTacGia(rs.getString("tacgia"));

				System.out.print("Ten sach: " + rs.getString("TenSach"));
				System.out.println("  --  Link anh: " + rs.getString("LinkAnh1"));
				list.add(raoBan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<RaoBan> layDanhSachChoDuyet(String maNguoiDung) {
		connect();
		String sql = "SELECT * FROM " + Constant.VIEW_DANH_SACH_CHO_DUYET + " where manguoiraoban = ?";
		RaoBan raoBan = null;
		ArrayList<RaoBan> list = new ArrayList<RaoBan>();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, maNguoiDung);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				raoBan = new RaoBan();
				raoBan.setMaRaoBan(rs.getString("maraoban"));
				raoBan.setTenTinhBan(rs.getString("tentinh"));
				raoBan.setGia(rs.getFloat("gia"));
				raoBan.setMoTa(rs.getString("mota"));
				raoBan.setLinkAnh1(rs.getString("linkanh1"));
				raoBan.setLinkAnh2(rs.getString("linkanh2"));
				raoBan.setLinkAnh3(rs.getString("linkanh3"));
				raoBan.setLinkAnh4(rs.getString("linkanh4"));
				raoBan.setLinkAnh5(rs.getString("linkanh5"));
				raoBan.setNgayBan(rs.getDate("ngayban"));
				raoBan.setTenSach(rs.getString("tensach"));
				raoBan.setMaDanhMuc(rs.getString("madanhmuc"));
				raoBan.setTenDanhMuc(rs.getString("tendanhmuc"));
				raoBan.setNamxb(rs.getString("namxb"));
				raoBan.setNxb(rs.getString("nxb"));
				raoBan.setTacGia(rs.getString("tacgia"));

				System.out.println("Ten sach: " + rs.getString("tensach"));
				System.out.println("Ma rao ban: " + rs.getString("maraoban"));
				System.out.println("+++++++++++++++++");

				list.add(raoBan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList<RaoBan> layDanhSachDangBan() {
		connect();
		String sql = "select * from " + Constant.VIEW_DANH_SACH_DANG_BAN;
		RaoBan raoBan = null;
		ArrayList<RaoBan> list = new ArrayList<RaoBan>();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				raoBan = new RaoBan();
				raoBan.setMaRaoBan(rs.getString("maraoban"));
				raoBan.setTenTinhBan(rs.getString("tentinh"));
				raoBan.setGia(rs.getFloat("gia"));
				raoBan.setMoTa(rs.getString("mota"));
				raoBan.setLinkAnh1(rs.getString("linkanh1"));
				raoBan.setLinkAnh2(rs.getString("linkanh2"));
				raoBan.setLinkAnh3(rs.getString("linkanh3"));
				raoBan.setLinkAnh4(rs.getString("linkanh4"));
				raoBan.setLinkAnh5(rs.getString("linkanh5"));
				raoBan.setNgayBan(rs.getDate("ngayban"));
				raoBan.setTaiKhoanNguoiBan(rs.getString("taikhoan"));
				raoBan.setAnhNguoiBan(rs.getString("anh"));
				raoBan.setTenSach(rs.getString("tensach"));
				raoBan.setMaDanhMuc(rs.getString("madanhmuc"));
				raoBan.setTenDanhMuc(rs.getString("tendanhmuc"));
				raoBan.setNamxb(rs.getString("namxb"));
				raoBan.setNxb(rs.getString("nxb"));
				raoBan.setTacGia(rs.getString("tacgia"));
				list.add(raoBan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<RaoBan> layDanhSachDangBan(String maNguoiDung) {
		connect();
		String sql = "select * from " + Constant.VIEW_DANH_SACH_DANG_BAN + " where MaNguoiRaoBan = ?";
		RaoBan raoBan = null;
		ArrayList<RaoBan> list = new ArrayList<RaoBan>();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, maNguoiDung);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				raoBan = new RaoBan();
				raoBan.setMaRaoBan(rs.getString("maraoban"));
				raoBan.setTenTinhBan(rs.getString("tentinh"));
				raoBan.setGia(rs.getFloat("gia"));
				raoBan.setMoTa(rs.getString("mota"));
				raoBan.setLinkAnh1(rs.getString("linkanh1"));
				raoBan.setLinkAnh2(rs.getString("linkanh2"));
				raoBan.setLinkAnh3(rs.getString("linkanh3"));
				raoBan.setLinkAnh4(rs.getString("linkanh4"));
				raoBan.setLinkAnh5(rs.getString("linkanh5"));
				raoBan.setNgayBan(rs.getDate("ngayban"));
				raoBan.setTenSach(rs.getString("tensach"));
				raoBan.setMaDanhMuc(rs.getString("madanhmuc"));
				raoBan.setTenDanhMuc(rs.getString("tendanhmuc"));
				raoBan.setNamxb(rs.getString("namxb"));
				raoBan.setNxb(rs.getString("nxb"));
				raoBan.setTacGia(rs.getString("tacgia"));
				list.add(raoBan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<RaoBan> layDanhSachDaBan() {
		connect();
		String sql = "select * from " + Constant.VIEW_DANH_SACH_DA_BAN_ADMIN;
		RaoBan raoBan = null;
		ArrayList<RaoBan> list = new ArrayList<RaoBan>();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				raoBan = new RaoBan();
				raoBan.setMaRaoBan(rs.getString("maraoban"));
				raoBan.setTenTinhBan(rs.getString("tentinh"));
				raoBan.setGia(rs.getFloat("gia"));
				raoBan.setMoTa(rs.getString("mota"));
				raoBan.setLinkAnh1(rs.getString("linkanh1"));
				raoBan.setLinkAnh2(rs.getString("linkanh2"));
				raoBan.setLinkAnh3(rs.getString("linkanh3"));
				raoBan.setLinkAnh4(rs.getString("linkanh4"));
				raoBan.setLinkAnh5(rs.getString("linkanh5"));
				raoBan.setNgayBan(rs.getDate("ngayban"));
				raoBan.setNgayDuocBan(rs.getDate("ngayduocban"));
				raoBan.setTaiKhoanNguoiBan(rs.getString("taikhoan"));
				raoBan.setAnhNguoiBan(rs.getString("anh"));
				raoBan.setTenSach(rs.getString("tensach"));
				raoBan.setMaDanhMuc(rs.getString("madanhmuc"));
				raoBan.setTenDanhMuc(rs.getString("tendanhmuc"));
				raoBan.setNamxb(rs.getString("namxb"));
				raoBan.setNxb(rs.getString("nxb"));
				raoBan.setTacGia(rs.getString("tacgia"));
				list.add(raoBan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList<RaoBan> layDanhSachDaBan(String maNguoiDung) {
		connect();
		String sql = "select * from " + Constant.VIEW_DANH_SACH_DA_BAN_ND + " where manguoiraoban = ?";
		RaoBan raoBan = null;
		ArrayList<RaoBan> list = new ArrayList<RaoBan>();
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, maNguoiDung);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				raoBan = new RaoBan();
				raoBan.setMaRaoBan(rs.getString("maraoban"));
				raoBan.setTenTinhBan(rs.getString("tentinh"));
				raoBan.setGia(rs.getFloat("gia"));
				raoBan.setMoTa(rs.getString("mota"));
				raoBan.setLinkAnh1(rs.getString("linkanh1"));
				raoBan.setLinkAnh2(rs.getString("linkanh2"));
				raoBan.setLinkAnh3(rs.getString("linkanh3"));
				raoBan.setLinkAnh4(rs.getString("linkanh4"));
				raoBan.setLinkAnh5(rs.getString("linkanh5"));
				raoBan.setNgayBan(rs.getDate("ngayban"));
				raoBan.setNgayDuocBan(rs.getDate("ngayduocban"));
				raoBan.setTenSach(rs.getString("tensach"));
				raoBan.setMaDanhMuc(rs.getString("madanhmuc"));
				raoBan.setTenDanhMuc(rs.getString("tendanhmuc"));
				raoBan.setNamxb(rs.getString("namxb"));
				raoBan.setNxb(rs.getString("nxb"));
				raoBan.setTacGia(rs.getString("tacgia"));
				list.add(raoBan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// --------------

	/**
	 * CAC HAM` LAY THONG TIN KHAI QUAT CUA BAI RAO BAN
	 */

	public ArrayList<RaoBan> layDanhSachMoiNhat() {
		System.out.println("RAOBANDAO -- layDanhSachMoiNhat");
		connect();

		String sql = "select * from v_dsMoiNhat";
		ArrayList<RaoBan> list = new ArrayList<RaoBan>();

		try {
			Statement stm = connection.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(sql);

			RaoBan baiRaoBan;
			while (rs.next()) {
				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(rs.getFloat("Gia"));
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));
				// baiRaoBan.setTenTinhBan(rs.getString("TenTinh"));

				System.out.print("Ten sach: " + rs.getString("TenSach"));
				System.out.println("  --  Link anh: " + rs.getString("LinkAnh1"));

				list.add(baiRaoBan);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<RaoBan> layDanhSachNgauNhien() {
		connect();

		String sql = "select * from v_dsNgauNhien";
		ArrayList<RaoBan> list = new ArrayList<RaoBan>();

		try {
			Statement stm = connection.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(sql);
			RaoBan baiRaoBan;
			while (rs.next()) {
				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(rs.getFloat("Gia"));
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));
				baiRaoBan.setTenTinhBan(rs.getString("TenTinh"));

				list.add(baiRaoBan);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<RaoBan> layDanhSachDanhMucBanNhieuNhat() {
		connect();

		String sql = "select * from v_dsDanhMucBanNhieuNhat";

		ArrayList<RaoBan> list = new ArrayList<RaoBan>();

		try {
			Statement stm = connection.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(sql);
			RaoBan baiRaoBan;
			while (rs.next()) {
				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(rs.getFloat("Gia"));
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));
				baiRaoBan.setTenTinhBan(rs.getString("TenTinh"));
				baiRaoBan.setTenDanhMuc(rs.getString("TenDanhMuc"));
				baiRaoBan.setMaDanhMuc(rs.getString("MaDanhMuc"));

				list.add(baiRaoBan);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<RaoBan> layDanhSachTimKiemTenSach(String tuKhoa) {
		connect();

		String sql = "SELECT TenSach, TacGia, Gia, MaRaoBan, LinkAnh1, TrangThaiBan, NgayBan FROM "
				+ Constant.TABLE_RAO_BAN + " WHERE TrangThaiBan = 1 AND TenSach LIKE N'%" + tuKhoa + "%' "
				+ " ORDER BY NgayBan DESC";

		ArrayList<RaoBan> list = new ArrayList<RaoBan>();

		System.out.println("SQL: " + sql);

		try {
			Statement pstm = connection.createStatement();

			ResultSet rs = null;

			rs = pstm.executeQuery(sql);

			RaoBan baiRaoBan;

			while (rs.next()) {
				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(rs.getFloat("Gia"));
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));
				// baiRaoBan.setTenTinhBan(rs.getString("TenTinh"));

				list.add(baiRaoBan);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<RaoBan> layDanhSachTimKiemTenTacGia(String tuKhoa) {
		connect();

		String sql = "SELECT TenSach, TacGia, Gia, MaRaoBan, LinkAnh1, TrangThaiBan, NgayBan FROM "
				+ Constant.TABLE_RAO_BAN + " WHERE TrangThaiBan = 1 AND TacGia LIKE N'%" + tuKhoa + "%' "
				+ " ORDER BY NgayBan DESC";

		ArrayList<RaoBan> list = new ArrayList<RaoBan>();

		try {
			Statement pstm = connection.createStatement();

			ResultSet rs = null;

			rs = pstm.executeQuery(sql);

			RaoBan baiRaoBan;

			while (rs.next()) {
				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(rs.getFloat("Gia"));
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));
				// baiRaoBan.setTenTinhBan(rs.getString("TenTinh"));

				list.add(baiRaoBan);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<RaoBan> layDanhSachGoiY(String userID) {

		connect();

		String sql = "select * from v_dsGoiY";
		ArrayList<RaoBan> list = new ArrayList<RaoBan>();

		try {
			Statement stm = connection.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(sql);
			RaoBan baiRaoBan;
			while (rs.next()) {
				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(rs.getFloat("Gia"));
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));
				baiRaoBan.setTenTinhBan(rs.getString("TenTinh"));

				list.add(baiRaoBan);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean luuTuKhoaTimKiem(String maNguoiDung, String tuKhoa) {
		connect();

		String sql = "INSERT INTO " + Constant.TABLE_TU_KHOA_TIM_KIEM + " VALUES(?, ?, GETDATE())";

		try {

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, maNguoiDung);
			statement.setNString(2, tuKhoa);

			statement.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean luuLichSuXemRaoBan(String maNguoiDung, String maRaoBan) {
		connect();

		String sql = "INSERT INTO " + Constant.TABLE_RAO_BAN_DA_XEM + " VALUES(?, ?, GETDATE())";

		try {

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, maNguoiDung);
			statement.setNString(2, maRaoBan);

			statement.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<RaoBan> layDanhSachGoiYMoiNguoiCungXem() {
		connect();

		String sql = "SELECT TOP 4 * FROM " + Constant.VIEW_GOI_Y_MOI_NGUOI_CUNG_XEM
				+ "	order by case when MaDanhMuc = (select TOP 1 dm.MaDanhMuc from tblDanhMuc as dm "
				+ " join tblRaoBan as rb on dm.MaDanhMuc = rb.MaDanhMuc "
				+ " join tblRaoBanDaXem as rbdx on rb.MaRaoBan = rbdx.MaRaoBan " + " group by dm.MaDanhMuc "
				+ " order by count(*) desc ) then null else MaDanhMuc end, NgayBan desc";

		ArrayList<RaoBan> list = new ArrayList<>();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			RaoBan baiRaoBan;

			while (rs.next()) {

				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(rs.getFloat("Gia"));
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));
				// baiRaoBan.setTenTinhBan(rs.getString("TenTinh"));

				list.add(baiRaoBan);

				System.out.println("Danh Muc: " + rs.getString("MaDanhMuc"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList<RaoBan> layDsMoiNhatTheoDanhMuc(String maDanhMuc) {
		connect();

		String sql = "SELECT * FROM " + Constant.TABLE_RAO_BAN
				+ " WHERE MaDanhMuc = ? AND TrangThaiBan = 1 ORDER BY NgayBan DESC";

		ArrayList<RaoBan> list = new ArrayList<>();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, maDanhMuc);

			ResultSet rs = statement.executeQuery();

			RaoBan baiRaoBan;

			while (rs.next()) {

				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(rs.getFloat("Gia"));
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));

				System.out.print("Ten sach: " + rs.getString("TenSach"));
				System.out.println(" --- Ma Rao Ban: " + rs.getString("MaRaoBan"));

				list.add(baiRaoBan);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public ArrayList<RaoBan> timKiemTrongDanhMuc(String maDanhMuc, String tuKhoa) {
		connect();

		String sql = "SELECT * FROM " + Constant.TABLE_RAO_BAN
				+ " WHERE MaDanhMuc = ? AND TrangThaiBan = 1 AND TenSach LIKE N'%" + tuKhoa + "%' "
				+ " ORDER BY NgayBan DESC";

		ArrayList<RaoBan> list = new ArrayList<>();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, maDanhMuc);

			ResultSet rs = statement.executeQuery();

			RaoBan baiRaoBan;

			while (rs.next()) {

				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(rs.getFloat("Gia"));
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));

				list.add(baiRaoBan);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public boolean suaBaiDang(RaoBan raoBan) {
		// 1 maraoban
		// 2'manguoiraoban',

		// 3'tensach',
		// 4'madanhmuc',
		// 5'tacgia',
		// 6'nxb',
		// 7 namxb,
		// 8 matinhban,
		// 9 gia,
		// 10'mota',
		// 11'linkanh1',
		// 12'linkanh2',
		// 13'linkanh3',
		// 14'linkanh4',
		// 15'linkanh5'
		connect();
		String sql = "exec " + Constant.FUNCTION_SUA_BAI_DANG + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, raoBan.getMaRaoBan());
			statement.setString(2, raoBan.getMaNguoiRaoBan());

			statement.setNString(3, raoBan.getTenSach());
			statement.setString(4, raoBan.getMaDanhMuc());
			statement.setNString(5, raoBan.getTacGia());
			statement.setNString(6, raoBan.getNxb());
			statement.setString(7, raoBan.getNamxb());
			statement.setInt(8, raoBan.getMaTinhBan());
			statement.setFloat(9, raoBan.getGia());
			statement.setNString(10, raoBan.getMoTa());
			statement.setString(11, raoBan.getLinkAnh1());
			statement.setString(12, raoBan.getLinkAnh2());
			statement.setString(13, raoBan.getLinkAnh3());
			statement.setString(14, raoBan.getLinkAnh4());
			statement.setString(15, raoBan.getLinkAnh5());

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean xoaBaiDang(String maNguoiRaoBan, String maRaoBan) {
		connect();

		String sql = "EXEC " + Constant.FUNCTION_XOA_BAI_DANG + " ?, ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, maNguoiRaoBan);
			statement.setString(2, maRaoBan);

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean banBaiDang(String maNguoiRaoBan, String maRaoBan) {
		connect();

		String sql = "EXEC " + Constant.FUNCTION_BAN_BAI_DANG + " ?, ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, maNguoiRaoBan);
			statement.setString(2, maRaoBan);

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean duyetBaiDang(String maRaoBan) {
		connect();

		String sql = "EXEC " + Constant.FUNCTION_DUYET_BAI_DANG + " ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, maRaoBan);

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}