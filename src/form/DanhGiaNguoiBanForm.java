package form;

import org.apache.struts.action.ActionForm;

public class DanhGiaNguoiBanForm extends ActionForm {
	private String diemDanhGia;
	private String binhLuan;
	private String maNguoiBan;

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

	public String getMaNguoiBan() {
		return maNguoiBan;
	}

	public void setMaNguoiBan(String maNguoiBan) {
		this.maNguoiBan = maNguoiBan;
	}

}
