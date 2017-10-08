package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.NguoiDung;
import model.bean.RaoBan;
import model.bean.Tinh;

public class TrangNguoiDungForm extends ActionForm {

	private ArrayList<Tinh> dsTinh;

	private NguoiDung nguoiDung;

	private ArrayList<RaoBan> dsChoDuyet;
	private ArrayList<RaoBan> dsDangBan;
	private ArrayList<RaoBan> dsDaBan;
	private ArrayList<RaoBan> dsDaMua;
	private ArrayList<RaoBan> dsGoiY;

	private String submit;
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public ArrayList<Tinh> getDsTinh() {
		return dsTinh;
	}

	public void setDsTinh(ArrayList<Tinh> dsTinh) {
		this.dsTinh = dsTinh;
	}

	public ArrayList<RaoBan> getDsChoDuyet() {
		return dsChoDuyet;
	}

	public void setDsChoDuyet(ArrayList<RaoBan> dsChoDuyet) {
		this.dsChoDuyet = dsChoDuyet;
	}

	public ArrayList<RaoBan> getDsDangBan() {
		return dsDangBan;
	}

	public void setDsDangBan(ArrayList<RaoBan> dsDangBan) {
		this.dsDangBan = dsDangBan;
	}

	public ArrayList<RaoBan> getDsDaBan() {
		return dsDaBan;
	}

	public void setDsDaBan(ArrayList<RaoBan> dsDaBan) {
		this.dsDaBan = dsDaBan;
	}

	public ArrayList<RaoBan> getDsDaMua() {
		return dsDaMua;
	}

	public void setDsDaMua(ArrayList<RaoBan> dsDaMua) {
		this.dsDaMua = dsDaMua;
	}

	public ArrayList<RaoBan> getDsGoiY() {
		return dsGoiY;
	}

	public void setDsGoiY(ArrayList<RaoBan> dsGoiY) {
		this.dsGoiY = dsGoiY;
	}

}
