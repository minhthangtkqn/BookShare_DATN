package form;

import org.apache.struts.action.ActionForm;

public class BinhLuanForm extends ActionForm {

	// cac tham so de dang binh luan
	private String binhLuan;
	private String maRaoBan;
	private String maBinhLuanDuocTraloi;

	// cac tham so de xoa binh luan
	private String maBinhLuan;

	private String submit;
	private String error;

	public String getBinhLuan() {
		return binhLuan;
	}

	public void setBinhLuan(String binhLuan) {
		this.binhLuan = binhLuan;
	}

	public String getMaRaoBan() {
		return maRaoBan;
	}

	public void setMaRaoBan(String maRaoBan) {
		this.maRaoBan = maRaoBan;
	}

	public String getMaBinhLuanDuocTraloi() {
		return maBinhLuanDuocTraloi;
	}

	public void setMaBinhLuanDuocTraloi(String maBinhLuanDuocTraloi) {
		this.maBinhLuanDuocTraloi = maBinhLuanDuocTraloi;
	}

	public String getMaBinhLuan() {
		return maBinhLuan;
	}

	public void setMaBinhLuan(String maBinhLuan) {
		this.maBinhLuan = maBinhLuan;
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
