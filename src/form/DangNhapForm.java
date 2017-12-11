package form;

import org.apache.struts.action.ActionForm;

public class DangNhapForm extends ActionForm {
	private String taiKhoan;
	private String matKhau;
	private String loiTaiKhoan;
	private String loiMatKhau;
	private boolean nhoDangNhap;
	private String thongBao = "";

	private String prevTask;

	private String error;
	private String submit;

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getPrevTask() {
		return prevTask;
	}

	public void setPrevTask(String prevTask) {
		this.prevTask = prevTask;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

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
