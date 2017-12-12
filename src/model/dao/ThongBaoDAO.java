package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Constant;
import model.bean.BinhLuan;
import model.bean.ThongBao;

public class ThongBaoDAO {
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

	public ArrayList<ThongBao> layDanhSachThongBao(String maNguoiDung) {
		connect();

		String sql = "SELECT * FROM " + Constant.TABLE_THONG_BAO + " WHERE MaNguoiDung = ?";
		ArrayList<ThongBao> list = new ArrayList<>();

		try {
			statement = connection.prepareStatement(sql);

			statement.setString(1, maNguoiDung);

			ResultSet rs = statement.executeQuery();
			ThongBao thongBao = new ThongBao();

			while (rs.next()) {
				thongBao = new ThongBao();

				thongBao.setMaThongBao(rs.getString("MaThongBao"));
				thongBao.setMaNguoiDung(rs.getString("MaNguoiDung"));
				thongBao.setNoiDung(rs.getNString("NoiDung"));
				thongBao.setThoiGian(rs.getDate("ThoiGian"));

				list.add(thongBao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean taoThongBao(String maNguoiDung, String noiDung) {
		connect();
		String sql = "EXEC " + Constant.PROC_THEM_THONG_BAO + " ?, ?";

		try {
			statement = connection.prepareStatement(sql);

			statement.setString(1, maNguoiDung);
			statement.setNString(2, noiDung);

			if(statement.executeUpdate() > 0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
