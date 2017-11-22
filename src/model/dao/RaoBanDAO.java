package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Constant;
import common.StringProcess;
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
		String sql = "EXEC " + Constant.PROC_DANG_BAI + " ?,?,?,?,?,?,?,?,?,?,?,?,?,?";
		System.out.println("RaoBanDAO");
		try {

			PreparedStatement cstm = connection.prepareStatement(sql);

			cstm.setNString(1, raoBan.getTenSach());
			cstm.setString(2, raoBan.getMaDanhMuc());
			cstm.setNString(3, raoBan.getTacGia());
			cstm.setNString(4, raoBan.getNxb());
			cstm.setString(5, raoBan.getNamxb());
			cstm.setString(6, raoBan.getMaNguoiRaoBan());
			cstm.setInt(7, raoBan.getMaTinhBan());
			cstm.setInt(8, Integer.parseInt(raoBan.getGia()));
			cstm.setNString(9, raoBan.getMoTa());
			cstm.setString(10, raoBan.getLinkAnh1());
			cstm.setString(11, raoBan.getLinkAnh2());
			cstm.setString(12, raoBan.getLinkAnh3());
			cstm.setString(13, raoBan.getLinkAnh4());
			cstm.setString(14, raoBan.getLinkAnh5());

			cstm.executeUpdate();
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
		String sql = "SELECT * FROM " + Constant.FUNCTION_LAY_THONG_TIN_BAI_DANG + "(?)";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, maRaoBan);
			ResultSet rs = pstm.executeQuery();
			if (!rs.isBeforeFirst()) {
				return null;
			}
			RaoBan raoBan = new RaoBan();
			rs.next();

			raoBan.setMaRaoBan(rs.getString("maraoban"));
			raoBan.setMaNguoiRaoBan(rs.getString("manguoiraoban"));
			raoBan.setMaTinhBan(rs.getInt("matinhban"));
			raoBan.setTenTinhBan(rs.getString("tentinhban"));
			raoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
			raoBan.setMoTa(rs.getString("mota"));

			raoBan.setLinkAnh1(StringProcess.notVaild(rs.getString("linkanh1")) ? Constant.NO_IMAGE_DEFAULT
					: rs.getString("linkanh1"));
			raoBan.setLinkAnh2(StringProcess.notVaild(rs.getString("linkanh2")) ? Constant.NO_IMAGE_DEFAULT
					: rs.getString("linkanh2"));
			raoBan.setLinkAnh3(StringProcess.notVaild(rs.getString("linkanh3")) ? Constant.NO_IMAGE_DEFAULT
					: rs.getString("linkanh3"));
			raoBan.setLinkAnh4(StringProcess.notVaild(rs.getString("linkanh4")) ? Constant.NO_IMAGE_DEFAULT
					: rs.getString("linkanh4"));
			raoBan.setLinkAnh5(StringProcess.notVaild(rs.getString("linkanh5")) ? Constant.NO_IMAGE_DEFAULT
					: rs.getString("linkanh5"));

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
				raoBan.setGioiTinh("Female");
			} else {
				if ("1".equals(rs.getString("gioitinh"))) {
					raoBan.setGioiTinh("Male");
				} else {
					raoBan.setGioiTinh("Unidentified");
				}
			}

			raoBan.setEmailNguoiBan(StringProcess.getVaildString(rs.getString("Email")));
			raoBan.setDienThoaiNguoiBan(StringProcess.getVaildString(rs.getString("DienThoai")));

			System.out.println("THONG TIN SACH:");
			System.out.println("ten sach: " + raoBan.getTenSach());
			System.out.println(" --- ten nguoi dang: " + raoBan.getHoTenNguoiBan());
			System.out.println(" --- nam sinh: " + raoBan.getNamSinhNguoiBan());
			System.out.println(" --- link anh 1: " + raoBan.getLinkAnh1());
			System.out.println(" --- gioi tinh: " + raoBan.getGioiTinh());
			System.out.println(" --- danh muc: " + raoBan.getTenDanhMuc());
			System.out.println(" --- nha xuat ban: " + raoBan.getNxb());

			return raoBan;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
				raoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
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
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
				raoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
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
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

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
				raoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
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
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
				raoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
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
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
				raoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
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
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

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
				raoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
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
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// --------------

	/**
	 * CAC HAM` LAY THONG TIN KHAI QUAT CUA BAI RAO BAN
	 */

	public ArrayList<RaoBan> layDanhSachMoiNhat() {
		System.out.println("RAOBANDAO -- layDanhSachMoiNhat");
		connect();

		String sql = "SELECT * FROM " + Constant.VIEW_DANH_SACH_MOI_NHAT;
		ArrayList<RaoBan> list = new ArrayList<RaoBan>();

		try {
			Statement stm = connection.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(sql);

			RaoBan baiRaoBan;
			while (rs.next()) {
				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));

				System.out.print("Ten sach: " + rs.getString("TenSach"));
				System.out.println("  --  Link anh: " + rs.getString("LinkAnh1"));

				list.add(baiRaoBan);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<RaoBan> layDanhSachDanhMucBanNhieuNhat() {
		connect();

		String sql = "SELECT * FROM v_dsDanhMucBanNhieuNhat";

		ArrayList<RaoBan> list = new ArrayList<RaoBan>();

		try {
			Statement stm = connection.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(sql);
			RaoBan baiRaoBan;
			while (rs.next()) {
				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));
				baiRaoBan.setTenTinhBan(rs.getString("TenTinh"));
				baiRaoBan.setTenDanhMuc(rs.getString("TenDanhMuc"));
				baiRaoBan.setMaDanhMuc(rs.getString("MaDanhMuc"));

				list.add(baiRaoBan);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<RaoBan> layDanhSachTimKiemTenSach(String tuKhoa, String maTinh, String maDanhMuc, String sapXepGia,
			String sapXepThoiGian) {

		connect();

		String sql = "SELECT * FROM " + Constant.FUNCTION_TIM_KIEM_TEN_SACH_KHONG_DAU + "(?) WHERE TrangThaiBan = 1 ";
		if (!"all".equals(maDanhMuc)) {
			System.out.println("MaDanhMuc != all");
			sql += " AND MaDanhMuc = ? ";
		}
		if (!"all".equals(maTinh)) {
			System.out.println("MaTinh != all");
			sql += " AND MaTinh = ? ";
		}

		sql += "ORDER BY Gia " + sapXepGia + " , NgayBan " + sapXepThoiGian;

		System.out.println("SQL command: " + sql);

		ArrayList<RaoBan> list = new ArrayList<RaoBan>();

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);

			pstm.setNString(1, tuKhoa);
			if (!"all".equals(maDanhMuc) && !"all".equals(maTinh)) {
				pstm.setString(2, maDanhMuc);
				pstm.setString(3, maTinh);
			} else if (!"all".equals(maTinh)) {
				pstm.setString(2, maTinh);
			} else if (!"all".equals(maDanhMuc)) {
				pstm.setString(2, maDanhMuc);
			}

			ResultSet rs = null;
			rs = pstm.executeQuery();

			RaoBan baiRaoBan;

			while (rs.next()) {
				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));

				list.add(baiRaoBan);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<RaoBan> layDanhSachTimKiemTenTacGia(String tuKhoa, String maTinh, String maDanhMuc,
			String sapXepGia, String sapXepThoiGian) {
		connect();

		String sql = "SELECT * FROM " + Constant.FUNCTION_TIM_KIEM_TAC_GIA_KHONG_DAU + "(?) WHERE TrangThaiBan = 1 ";
		if (!"all".equals(maDanhMuc)) {
			System.out.println("MaDanhMuc != all");
			sql += " AND MaDanhMuc = ? ";
		}
		if (!"all".equals(maTinh)) {
			System.out.println("MaTinh != all");
			sql += " AND MaTinh = ? ";
		}

		sql += "ORDER BY Gia " + sapXepGia + " , NgayBan " + sapXepThoiGian;

		System.out.println("SQL command: " + sql);

		ArrayList<RaoBan> list = new ArrayList<RaoBan>();

		try {
			PreparedStatement pstm = connection.prepareStatement(sql);

			pstm.setNString(1, tuKhoa);
			if (!"all".equals(maDanhMuc) && !"all".equals(maTinh)) {
				pstm.setString(2, maDanhMuc);
				pstm.setString(3, maTinh);
			} else if (!"all".equals(maTinh)) {
				pstm.setString(2, maTinh);
			} else if (!"all".equals(maDanhMuc)) {
				pstm.setString(2, maDanhMuc);
			}

			ResultSet rs = null;
			rs = pstm.executeQuery();

			RaoBan baiRaoBan;

			while (rs.next()) {
				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));

				list.add(baiRaoBan);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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

				baiRaoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
				baiRaoBan.setTacGia(rs.getString("TacGia"));
				baiRaoBan.setTenSach(rs.getString("TenSach"));
				baiRaoBan.setMaRaoBan(rs.getString("MaRaoBan"));
				baiRaoBan.setLinkAnh1(rs.getString("LinkAnh1"));

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

				baiRaoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
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

	public ArrayList<RaoBan> timKiemTenSachTrongDanhMuc(String maDanhMuc, String tuKhoa) {
		connect();

		String sql = "SELECT * FROM " + Constant.FUNCTION_TIM_KIEM_TEN_SACH_KHONG_DAU
				+ "(?) WHERE MaDanhMuc = ? AND TrangThaiBan = 1 ORDER BY NgayBan DESC";

		ArrayList<RaoBan> list = new ArrayList<>();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setNString(1, tuKhoa);
			statement.setString(2, maDanhMuc);

			ResultSet rs = statement.executeQuery();

			RaoBan baiRaoBan;

			while (rs.next()) {

				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND" + " VND");
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

	public ArrayList<RaoBan> timKiemTacGiaTrongDanhMuc(String maDanhMuc, String tuKhoa) {
		connect();

		String sql = "SELECT * FROM " + Constant.FUNCTION_TIM_KIEM_TAC_GIA_KHONG_DAU
				+ "(?) WHERE MaDanhMuc = ? AND TrangThaiBan = 1 ORDER BY NgayBan DESC";

		ArrayList<RaoBan> list = new ArrayList<>();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setNString(1, tuKhoa);
			statement.setString(2, maDanhMuc);

			ResultSet rs = statement.executeQuery();

			RaoBan baiRaoBan;

			while (rs.next()) {

				baiRaoBan = new RaoBan();

				baiRaoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
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
		String sql = "exec " + Constant.PROC_SUA_BAI_DANG + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";

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
			statement.setInt(9, Integer.parseInt(raoBan.getGia()));
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

		String sql = "EXEC " + Constant.PROC_XOA_BAI_DANG + " ?, ?";

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

		String sql = "EXEC " + Constant.PROC_BAN_BAI_DANG + " ?, ?";

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

	public boolean khoaBaiDang(String maRaoBan, String maNguoiRaoBan) {
		connect();

		String sql = "EXEC " + Constant.PROC_KHOA_BAI_DANG + " ?, ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, maRaoBan);
			statement.setString(2, maNguoiRaoBan);

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean moKhoaBaiDang(String maRaoBan, String maNguoiRaoBan) {
		connect();

		String sql = "EXEC " + Constant.PROC_MO_KHOA_BAI_DANG + " ?, ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, maRaoBan);
			statement.setString(2, maNguoiRaoBan);

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean duyetBaiDang(String maRaoBan) {
		connect();

		String sql = "EXEC " + Constant.PROC_DUYET_BAI_DANG + " ?";

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

	public boolean khongDuyetBaiDang(String maRaoBan) {
		connect();

		String sql = "EXEC " + Constant.PROC_KHONG_DUYET_BAI_DANG + " ?";

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

	public ArrayList<RaoBan> layDanhSachHot() {
		connect();
		String sql = "SELECT * FROM " + Constant.VIEW_DANH_SACH_HOT;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			ArrayList<RaoBan> list = new ArrayList<>();
			RaoBan rb;
			while (rs.next()) {

				rb = new RaoBan();
				rb.setMaRaoBan(rs.getString("MaRaoBan"));
				rb.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
				rb.setLinkAnh1(rs.getString("linkanh1"));
				rb.setTenSach(rs.getString("tensach"));
				rb.setNamxb(rs.getString("namxb"));
				rb.setNxb(rs.getString("nxb"));
				rb.setTacGia(rs.getString("tacgia"));

				list.add(rb);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<RaoBan> layLichSuXemBaiDang(String maNguoiDung) {
		connect();

		String sql = "SELECT * FROM " + Constant.FUNCTION_LICH_SU_XEM_BAI_DANG + "(?)";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setNString(1, maNguoiDung);
			ResultSet rs = statement.executeQuery();

			ArrayList<RaoBan> list = new ArrayList<>();
			RaoBan rb;
			while (rs.next()) {
				rb = new RaoBan();

				rb.setMaRaoBan(rs.getString("MaRaoBan"));
				rb.setTenDanhMuc(rs.getNString("TenDanhMuc"));
				rb.setTenSach(rs.getString("tensach"));
				rb.setTacGia(rs.getString("tacgia"));
				rb.setNxb(rs.getString("nxb"));
				rb.setNamxb(rs.getString("namxb"));
				rb.setTrangThaiRaoBan(rs.getInt("TrangThaiBan"));
				rb.setTenTinhBan((rs.getNString("TenTinh")));
				rb.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
				rb.setMoTa(rs.getNString("MoTa"));
				rb.setLinkAnh1(rs.getString("linkanh1"));
				rb.setNgayBan(rs.getDate("NgayBan"));
				rb.setGhiChuRaoBan(rs.getNString("GhiChu"));

				list.add(rb);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public RaoBan layThongTinSuaBaiDang(String maRaoBan) {
		System.out.println("Ma rao ban DAO: " + maRaoBan);

		connect();
		String sql = "SELECT * FROM " + Constant.FUNCTION_LAY_THONG_TIN_BAI_DANG + "(?)";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setString(1, maRaoBan);
			ResultSet rs = pstm.executeQuery();
			if (!rs.isBeforeFirst()) {
				return null;
			}
			RaoBan raoBan = new RaoBan();
			rs.next();

			raoBan.setMaRaoBan(rs.getString("maraoban"));
			raoBan.setMaNguoiRaoBan(rs.getString("manguoiraoban"));
			raoBan.setMaTinhBan(rs.getInt("matinhban"));
			raoBan.setGia(rs.getString("Gia"));
			raoBan.setMoTa(rs.getString("mota"));

			raoBan.setLinkAnh1(StringProcess.notVaild(rs.getString("linkanh1")) ? Constant.NO_IMAGE_DEFAULT
					: rs.getString("linkanh1"));
			raoBan.setLinkAnh2(StringProcess.notVaild(rs.getString("linkanh2")) ? Constant.NO_IMAGE_DEFAULT
					: rs.getString("linkanh2"));
			raoBan.setLinkAnh3(StringProcess.notVaild(rs.getString("linkanh3")) ? Constant.NO_IMAGE_DEFAULT
					: rs.getString("linkanh3"));
			raoBan.setLinkAnh4(StringProcess.notVaild(rs.getString("linkanh4")) ? Constant.NO_IMAGE_DEFAULT
					: rs.getString("linkanh4"));
			raoBan.setLinkAnh5(StringProcess.notVaild(rs.getString("linkanh5")) ? Constant.NO_IMAGE_DEFAULT
					: rs.getString("linkanh5"));

			raoBan.setTenSach(rs.getString("tensach"));
			raoBan.setMaDanhMuc(rs.getString("madanhmuc"));
			raoBan.setNamxb(rs.getString("namxb"));
			raoBan.setNxb(rs.getString("nxb"));
			raoBan.setTacGia(rs.getString("tacgia"));
			raoBan.setTrangThaiRaoBan(rs.getInt("TrangThaiBan"));

			System.out.println("THONG TIN SACH:");
			System.out.println("ten sach: " + raoBan.getTenSach());
			System.out.println(" --- ten nguoi dang: " + raoBan.getHoTenNguoiBan());
			System.out.println(" --- ma rao ban: " + raoBan.getMaRaoBan());
			System.out.println(" --- Gia ban: " + raoBan.getGia());

			return raoBan;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean danhDauXemSau(String maNguoiDung, String maRaoBan) {
		connect();

		String sql = "EXEC " + Constant.PROC_THEM_XEM_SAU + " ?, ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, maNguoiDung);
			statement.setString(2, maRaoBan);

			int effectedRows = statement.executeUpdate();
			if (effectedRows > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<RaoBan> layDanhSachXemSau(String maNguoiDung) {
		connect();

		String sql = "SELECT * FROM " + Constant.FUNCTION_DANH_SACH_XEM_SAU + "(?)";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, maNguoiDung);
			ResultSet rs = statement.executeQuery();

			ArrayList<RaoBan> list = new ArrayList<>();
			RaoBan raoBan;

			while (rs.next()) {
				raoBan = new RaoBan();
				raoBan.setMaRaoBan(rs.getString("maraoban"));
				raoBan.setGia(String.format("%,8d", rs.getInt("Gia")) + " VND");
				raoBan.setLinkAnh1(rs.getString("linkanh1"));
				raoBan.setNgayBan(rs.getDate("ngayban"));
				raoBan.setTenSach(rs.getString("tensach"));
				raoBan.setMaDanhMuc(rs.getString("madanhmuc"));
				raoBan.setTenDanhMuc(rs.getString("tendanhmuc"));
				raoBan.setNamxb(rs.getString("namxb"));
				raoBan.setNxb(rs.getString("nxb"));
				raoBan.setTacGia(rs.getString("tacgia"));
				list.add(raoBan);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean boDanhDauXemSau(String maNguoiDung, String maRaoBan) {
		connect();

		String sql = "EXEC " + Constant.PROC_XOA_XEM_SAU + " ?, ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, maNguoiDung);
			statement.setString(2, maRaoBan);

			int effectedRows = statement.executeUpdate();
			if (effectedRows > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isXemSau(String maNguoiDung, String maRaoBan) {
		connect();
		String sql = "SELECT * FROM " + Constant.TABLE_XEM_SAU + " WHERE MaNguoiDung = ? AND MaRaoBan = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, maNguoiDung);
			statement.setString(2, maRaoBan);

			ResultSet rs = statement.executeQuery();

			if (rs.isBeforeFirst()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
