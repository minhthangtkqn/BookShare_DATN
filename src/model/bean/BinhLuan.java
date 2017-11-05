package model.bean;

import java.sql.Date;

import net.sourceforge.jtds.jdbc.DateTime;

public class BinhLuan {
	private String taiKhoan;
	private String maNguoiBinhLuan;
	private String linkAnh;

	private String binhLuan;
	private String maRaoBan;
	private Date thoiGian;

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getLinkAnh() {
		return linkAnh;
	}

	public void setLinkAnh(String linkAnh) {
		this.linkAnh = linkAnh;
	}

	public String getMaNguoiBinhLuan() {
		return maNguoiBinhLuan;
	}

	public void setMaNguoiBinhLuan(String maNguoiBinhLuan) {
		this.maNguoiBinhLuan = maNguoiBinhLuan;
	}

	public String getMaRaoBan() {
		return maRaoBan;
	}

	public void setMaRaoBan(String maRaoBan) {
		this.maRaoBan = maRaoBan;
	}

	public String getBinhLuan() {
		return binhLuan;
	}

	public void setBinhLuan(String binhLuan) {
		this.binhLuan = binhLuan;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

}
