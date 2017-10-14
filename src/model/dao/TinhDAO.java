package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.Constant;
import model.bean.Tinh;

public class TinhDAO {
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

	public ArrayList<Tinh> layDanhSachTinh() {
		connect();
		String sql = "select MaTinh, TenTinh from tblTinh";
		ArrayList<Tinh> list = new ArrayList<Tinh>();
		Tinh tinh;
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				tinh = new Tinh();
				tinh.setMaTinh(rs.getInt("matinh"));
				tinh.setTenTinh(rs.getString("tentinh"));
				list.add(tinh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
