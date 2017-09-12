package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.RaoBan;

public class KetQuaTimKiemForm extends ActionForm {

	private String tuKhoa;
	private String page;
	private ArrayList<RaoBan> listRaoBan;
	private int soLuongKetQua;

	public String getTuKhoa() {
		return tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public ArrayList<RaoBan> getListRaoBan() {
		return listRaoBan;
	}

	public void setListRaoBan(ArrayList<RaoBan> listRaoBan) {
		this.listRaoBan = listRaoBan;
	}

	public int getSoLuongKetQua() {
		return soLuongKetQua;
	}

	public void setSoLuongKetQua(int soLuongKetQua) {
		this.soLuongKetQua = soLuongKetQua;
	}

}
