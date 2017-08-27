package form;

import org.apache.struts.action.ActionForm;

/**
 * @author HCD-Fresher005
 *
 */
public class DangKyForm extends ActionForm {

	private String taiKhoan;
	private String matKhau;
	private String nhapLaiMatKhau;

	private String loiTaiKhoan;
	private String loiMatKhau;
	private String loiNhapLaiMatKhau;
	private String loiDangKy;

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

	public String getNhapLaiMatKhau() {
		return nhapLaiMatKhau;
	}

	public void setNhapLaiMatKhau(String nhapLaiMatKhau) {
		this.nhapLaiMatKhau = nhapLaiMatKhau;
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

	public String getLoiNhapLaiMatKhau() {
		return loiNhapLaiMatKhau;
	}

	public void setLoiNhapLaiMatKhau(String loiNhapLaiMatKhau) {
		this.loiNhapLaiMatKhau = loiNhapLaiMatKhau;
	}

	public String getLoiDangKy() {
		return loiDangKy;
	}

	public void setLoiDangKy(String loiDangKy) {
		this.loiDangKy = loiDangKy;
	}

}
