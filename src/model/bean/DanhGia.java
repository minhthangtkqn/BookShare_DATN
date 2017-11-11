package model.bean;

import java.sql.Date;

public class DanhGia {
	// thong tin danh gia
	private String diemDanhGia;
	private String binhLuan;
	private String maNguoiBan;
	private String maDanhGia;
	private Date thoiGian;

	// thong tin nguoi danh gia
	private String maNguoiDanhGia;
	private String anhNguoiDanhGia;
	private String taiKhoanNguoiDanhGia;

	public String getAnhNguoiDanhGia() {
		return anhNguoiDanhGia;
	}

	public void setAnhNguoiDanhGia(String anhNguoiDanhGia) {
		this.anhNguoiDanhGia = anhNguoiDanhGia;
	}

	public String getTaiKhoanNguoiDanhGia() {
		return taiKhoanNguoiDanhGia;
	}

	public void setTaiKhoanNguoiDanhGia(String taiKhoanNguoiDanhGia) {
		this.taiKhoanNguoiDanhGia = taiKhoanNguoiDanhGia;
	}

	public String getDiemDanhGia() {
		return diemDanhGia;
	}

	public void setDiemDanhGia(String diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}

	public String getBinhLuan() {
		return binhLuan;
	}

	public void setBinhLuan(String binhLuan) {
		this.binhLuan = binhLuan;
	}

	public String getMaNguoiDanhGia() {
		return maNguoiDanhGia;
	}

	public void setMaNguoiDanhGia(String maNguoiDanhGia) {
		this.maNguoiDanhGia = maNguoiDanhGia;
	}

	public String getMaNguoiBan() {
		return maNguoiBan;
	}

	public void setMaNguoiBan(String maNguoiBan) {
		this.maNguoiBan = maNguoiBan;
	}

	public String getMaDanhGia() {
		return maDanhGia;
	}

	public void setMaDanhGia(String maDanhGia) {
		this.maDanhGia = maDanhGia;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

}
