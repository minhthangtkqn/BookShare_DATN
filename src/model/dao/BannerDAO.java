package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.Constant;
import model.bean.Banner;

public class BannerDAO {
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

	public ArrayList<Banner> layDSBanner() {
		connect();
		String sql = "SELECT * FROM tblBanner";
		ArrayList<Banner> listBanner = new ArrayList<Banner>();

		ResultSet rs = null;

		try {
			statement = connection.prepareStatement(sql);

			rs = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Banner banner;
		try {
			while(rs.next()){
				banner = new Banner();
				
				banner.setMaBanner(rs.getString("MaBanner"));
				banner.setTieuDe(rs.getString("TieuDe"));
				banner.setLinkAnh(rs.getString("Link"));
				
				System.out.print("Banner Title: " + banner.getTieuDe());
				System.out.println(" ---  Banner IMG Link: " + banner.getLinkAnh());
				
				listBanner.add(banner);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listBanner;
	}
}
