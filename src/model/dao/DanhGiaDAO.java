package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
