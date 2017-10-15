package form;

import org.apache.struts.action.ActionForm;

public class DuyetBaiDangForm extends ActionForm {
	
	private String submit;
	private String maRaoBan;
	private String maNguoiRaoBan;

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getMaRaoBan() {
		return maRaoBan;
	}

	public void setMaRaoBan(String maRaoBan) {
		this.maRaoBan = maRaoBan;
	}

	public String getMaNguoiRaoBan() {
		return maNguoiRaoBan;
	}

	public void setMaNguoiRaoBan(String maNguoiRaoBan) {
		this.maNguoiRaoBan = maNguoiRaoBan;
	}

}
