package form;

import org.apache.struts.action.ActionForm;

public class YeuCauForm extends ActionForm {

	// tham so them yeu cau
	private String tenSach;
	private String tenSachError;

	// tham so xoa yeu cau
	private String maYeuCau;

	private String error;
	private String submit;

	public String getTenSachError() {
		return tenSachError;
	}

	public void setTenSachError(String tenSachError) {
		this.tenSachError = tenSachError;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getMaYeuCau() {
		return maYeuCau;
	}

	public void setMaYeuCau(String maYeuCau) {
		this.maYeuCau = maYeuCau;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

}
