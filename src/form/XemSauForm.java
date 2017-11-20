package form;

import org.apache.struts.action.ActionForm;

public class XemSauForm extends ActionForm {

	private String maNguoiDung;
	private String maRaoBan;

	private String submit;
	private String error;

	public String getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getMaRaoBan() {
		return maRaoBan;
	}

	public void setMaRaoBan(String maRaoBan) {
		this.maRaoBan = maRaoBan;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
