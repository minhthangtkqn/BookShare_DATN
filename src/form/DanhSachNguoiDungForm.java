package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.NguoiDung;
import model.bean.Tinh;

public class DanhSachNguoiDungForm extends ActionForm {
	private ArrayList<NguoiDung> dsNguoiDung;
	private ArrayList<Tinh> dsTinh;

	private String submit;
	private String error;

	public ArrayList<NguoiDung> getDsNguoiDung() {
		return dsNguoiDung;
	}

	public void setDsNguoiDung(ArrayList<NguoiDung> dsNguoiDung) {
		this.dsNguoiDung = dsNguoiDung;
	}

	public ArrayList<Tinh> getDsTinh() {
		return dsTinh;
	}

	public void setDsTinh(ArrayList<Tinh> dsTinh) {
		this.dsTinh = dsTinh;
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
