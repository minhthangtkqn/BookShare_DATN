package model.bean;

public class DanhMuc {
	private String maDanhMuc;
	private String tenDanhMuc;
	private int soLuongDaBan;

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public void setSoLuongDaBan(int soLuongDaBan) {
		this.soLuongDaBan = soLuongDaBan;
	}

	public int getSoLuongDaBan() {
		return soLuongDaBan;
	}

}
