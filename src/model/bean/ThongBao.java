package model.bean;

import java.sql.Date;

public class ThongBao {
	private String maThongBao;
	private String maNguoiDung;
	private String noiDung;
	private Date thoiGian;

	public String getMaThongBao() {
		return maThongBao;
	}

	public void setMaThongBao(String maThongBao) {
		this.maThongBao = maThongBao;
	}

	public String getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

}
