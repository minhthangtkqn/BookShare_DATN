package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Constant;
import model.bean.DanhMuc;

public class DanhMucDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShare";
	String userName = "sa";
	String password = "12345678";
	Connection connection;

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

	public ArrayList<DanhMuc> layDanhSachDanhMuc() {
		System.out.println("DANH MUC DAO layDS Danh Muc");

		connect();
		String sql = "select madanhmuc,tendanhmuc from tblDanhMuc";
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
				System.out.println("Ten DM: " + danhMuc.getTenDanhMuc());

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
}
