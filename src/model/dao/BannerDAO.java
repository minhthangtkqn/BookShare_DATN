package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Banner;

public class BannerDAO {

	String url = "jdbc:sqlserver://localhost:1433;databaseName=LineBook";
	String userName = "sa";
	String password = "12345678";
	Connection connection;
	PreparedStatement statement;	
	
	//Ket Noi Co So Du Lieu
	void connect(){
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
