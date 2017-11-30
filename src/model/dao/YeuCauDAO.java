package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import common.Constant;
import model.bean.Tinh;
import model.bean.YeuCau;

public class YeuCauDAO {
	Connection connection;
	PreparedStatement statement;

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

	public boolean themYeuCau(String tenSach, String maNguoiYeuCau) {

		connect();

		String sql = "EXEC " + Constant.PROC_THEM_YEU_CAU + " ?, ?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setNString(1, tenSach);
			statement.setString(2, maNguoiYeuCau);

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean xoaYeuCau(String maYeuCau) {

		connect();

		String sql = "EXEC " + Constant.PROC_XOA_YEU_CAU + " ?";

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, maYeuCau);

			if (statement.executeUpdate() > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<YeuCau> layDanhSachYeuCau(String maNguoiDung) {

		connect();

		String sql = "SELECT * FROM " + Constant.TABLE_YEU_CAU_SACH + " WHERE [MaNguoiYeuCau] = ?";

		ArrayList<YeuCau> list = new ArrayList<>();
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, maNguoiDung);

			ResultSet rs = statement.executeQuery();
			YeuCau yeuCau;

			while (rs.next()) {
				yeuCau = new YeuCau();

				yeuCau.setMaYeuCau(rs.getString("MaYeuCau"));
				yeuCau.setMaNguoiYeuCau(rs.getString("MaNguoiYeuCau"));
				yeuCau.setTenSach(rs.getNString("TenSach"));

				list.add(yeuCau);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<YeuCau> layDanhSachTimKiemYeuCau(String tuKhoa) {
		connect();
		String sql = "SELECT * FROM " + Constant.FUNCTION_TIM_KIEM_YEU_CAU + "(?)";

		ArrayList<YeuCau> list = new ArrayList<>();

		try {
			statement = connection.prepareStatement(sql);
			statement.setNString(1, tuKhoa);

			ResultSet rs = statement.executeQuery();
			YeuCau yeuCau;
			while (rs.next()) {
				yeuCau = new YeuCau();

				yeuCau.setMaYeuCau(rs.getString("MaYeuCau"));
				yeuCau.setTenSach(rs.getNString("TenSach"));
				yeuCau.setMaNguoiYeuCau(rs.getString("MaNguoiYeuCau"));
				yeuCau.setDienThoai(rs.getString("DienThoai"));
				yeuCau.setEmail(rs.getString("Email"));
				yeuCau.setTenNguoiYeuCau(rs.getNString("HoTen"));

				list.add(yeuCau);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
