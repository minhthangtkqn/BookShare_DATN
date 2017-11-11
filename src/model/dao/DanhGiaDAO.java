package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Constant;
import model.bean.DanhGia;

public class DanhGiaDAO {
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

	public boolean dangDanhGiaNguoiBan(DanhGia danhGia) {
		System.out.println("*** DANHGIADAO");
		System.out.println("Ma nguoi danh gia: " + danhGia.getMaNguoiDanhGia());
		System.out.println("Ma nguoi ban: " + danhGia.getMaNguoiBan());
		System.out.println("Diem danh gia: " + danhGia.getDiemDanhGia());
		System.out.println("Binh luan: " + danhGia.getBinhLuan());

		connect();
		String sql = "EXEC " + Constant.PROC_THEM_DANH_GIA + " ?, ?, ?, ?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setString(1, danhGia.getMaNguoiDanhGia());
			statement.setString(2, danhGia.getMaNguoiBan());
			statement.setInt(3, Integer.parseInt(danhGia.getDiemDanhGia()));
			statement.setNString(4, danhGia.getBinhLuan());

			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<DanhGia> layDanhSachDanhGia(String maNguoiBan) {
		connect();

		String sql = "SELECT * FROM " + Constant.VIEW_DANH_SACH_DANH_GIA + " WHERE MaNguoiBan = ?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setString(1, maNguoiBan);

			ResultSet rs = statement.executeQuery();
			DanhGia danhGia;
			ArrayList<DanhGia> list = new ArrayList<>();
			while (rs.next()) {
				danhGia = new DanhGia();

				danhGia.setMaDanhGia(rs.getString("MaDanhGia"));
				danhGia.setMaNguoiBan(maNguoiBan);
				danhGia.setDiemDanhGia(rs.getString("DiemDanhGia"));
				danhGia.setBinhLuan(rs.getNString("BinhLuan"));
				danhGia.setThoiGian(rs.getDate("ThoiGian"));
				
				danhGia.setMaNguoiDanhGia(rs.getString("MaNguoiDanhGia"));
				danhGia.setTaiKhoanNguoiDanhGia(rs.getString("TaiKhoan"));
				danhGia.setAnhNguoiDanhGia(rs.getString("Anh"));

				list.add(danhGia);
			}
			return list;
		} catch (Exception e) {
			System.out.println("CO LOI XAY RA TRONG QUA TRINH LAY DANH SACH DANH GIA");
			e.printStackTrace();
		}
		return null;
	}
}
