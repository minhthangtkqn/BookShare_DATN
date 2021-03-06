package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Constant;
import model.bean.DanhMuc;

public class DanhMucDAO {
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

	public ArrayList<DanhMuc> layDanhSachDanhMuc() {
		System.out.println("DANH MUC DAO layDS Danh Muc");

		connect();
		String sql = "SELECT * FROM " + Constant.TABLE_DANH_MUC;
		ArrayList<DanhMuc> list = new ArrayList<DanhMuc>();
		DanhMuc danhMuc;
		ResultSet rs = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				danhMuc = new DanhMuc();
				danhMuc.setMaDanhMuc(rs.getString("madanhmuc"));
				danhMuc.setTenDanhMuc(rs.getString("tendanhmuc"));
				danhMuc.setSoLuongDaBan(rs.getInt("SoLuongDaBan"));

				System.out.print("Ma DM: " + danhMuc.getMaDanhMuc());
				System.out.println("Ten DM: " + danhMuc.getTenDanhMuc());
				System.out.println("So luong da ban: " + danhMuc.getSoLuongDaBan());

				list.add(danhMuc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<DanhMuc> layTopDanhMucBanNhieu(int soLuong) {
		System.out.println("DANH MUC DAO lay Top 5 Danh Muc Ban Nhieu Nhat");

		connect();
		String sql = "select top " + soLuong + " madanhmuc,tendanhmuc from " + Constant.TABLE_DANH_MUC
				+ " order by SoLuongDaBan desc";
		ArrayList<DanhMuc> list = new ArrayList<DanhMuc>();
		DanhMuc danhMuc;
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				danhMuc = new DanhMuc();
				danhMuc.setMaDanhMuc(rs.getString("madanhmuc"));
				danhMuc.setTenDanhMuc(rs.getString("tendanhmuc"));

				System.out.print("Ma DM: " + danhMuc.getMaDanhMuc());
				System.out.println("  ---  Ten DM: " + danhMuc.getTenDanhMuc());

				list.add(danhMuc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean themDanhMuc(String tenDanhMuc) {
		connect();

		String sql = "EXEC " + Constant.FUNCTION_THEM_DANH_MUC + " ? ";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setNString(1, tenDanhMuc);

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean suaDanhMuc(String tenDanhMuc, String maDanhMuc) {
		connect();

		String sql = "EXEC " + Constant.FUNCTION_SUA_DANH_MUC + " ?, ? ";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setNString(1, tenDanhMuc);
			statement.setString(2, maDanhMuc);

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean xoaDanhMuc(String maDanhMuc) {
		connect();

		String sql = "DELETE FROM " + Constant.TABLE_DANH_MUC + " WHERE MaDanhMuc = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, maDanhMuc);

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public DanhMuc layThongTinDanhMuc(String maDanhMuc) {
		connect();

		String sql = "SELECT * FROM " + Constant.TABLE_DANH_MUC + " WHERE MaDanhMuc = ?";

		try {
			DanhMuc danhMuc = new DanhMuc();
			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, maDanhMuc);

			ResultSet rs = statement.executeQuery();

			if (rs.isBeforeFirst()) {
				rs.next();
				danhMuc.setMaDanhMuc(rs.getString("MaDanhMuc"));
				danhMuc.setTenDanhMuc(rs.getNString("TenDanhMuc"));
				danhMuc.setSoLuongDaBan(rs.getInt("SoLuongDaBan"));
				return danhMuc;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
