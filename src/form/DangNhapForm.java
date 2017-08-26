package form;

import org.apache.struts.action.ActionForm;

public class DangNhapForm extends ActionForm {
	private String taiKhoan;
	private String matKhau;
	private String loiTaiKhoan;
	private String loiMatKhau;
	private boolean nhoDangNhap;
	private String thongBao="";
	
	
	
	public String getThongBao() {
		return thongBao;
	}
	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getLoiTaiKhoan() {
		return loiTaiKhoan;
	}
	public void setLoiTaiKhoan(String loiTaiKhoan) {
		this.loiTaiKhoan = loiTaiKhoan;
	}
	public String getLoiMatKhau() {
		return loiMatKhau;
	}
	public void setLoiMatKhau(String loiMatKhau) {
		this.loiMatKhau = loiMatKhau;
	}
	public boolean isNhoDangNhap() {
		return nhoDangNhap;
	}
	public void setNhoDangNhap(boolean nhoDangNhap) {
		this.nhoDangNhap = nhoDangNhap;
	}
	
	
	
	
	
}
