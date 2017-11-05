package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Constant;
import model.bean.BinhLuan;

public class BinhLuanDAO {
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

	public ArrayList<BinhLuan> layDsBinhLuan(String maRaoBan) {
		connect();

		String sql = "SELECT * FROM " + Constant.VIEW_DANH_SACH_BINH_LUAN + " WHERE MaRaoBan = ?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, maRaoBan);

			ResultSet rs = statement.executeQuery();
			ArrayList<BinhLuan> listBinhLuan = new ArrayList<>();
			BinhLuan bl;
			while (rs.next()) {
				bl = new BinhLuan();
				
				bl.setTaiKhoan(rs.getString("TaiKhoan"));
				bl.setMaNguoiBinhLuan(rs.getString("MaNguoiBinhLuan"));
				bl.setMaRaoBan(rs.getString("MaRaoBan"));
				bl.setBinhLuan(rs.getNString("BinhLuan"));
				bl.setThoiGian(rs.getDate("ThoiGian"));
				bl.setLinkAnh(rs.getString("Anh"));
				bl.setMaBinhLuan(rs.getString("MaBinhLuan"));
				bl.setMaBinhLuanDuocTraLoi(rs.getString("MaBinhLuanDuocTraLoi"));
				
				listBinhLuan.add(bl);
			}
			return listBinhLuan;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
