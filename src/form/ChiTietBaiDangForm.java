package form;

import java.util.ArrayList;
import java.util.Date;

import model.bean.RaoBan;

import org.apache.struts.action.ActionForm;

public class ChiTietBaiDangForm extends ActionForm {

	private RaoBan chiTiet;
	private ArrayList<RaoBan> dsGoiYMoiNguoiCungXem;

	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public RaoBan getChiTiet() {
		return chiTiet;
	}

	public void setChiTiet(RaoBan chiTiet) {
		this.chiTiet = chiTiet;
	}

	public ArrayList<RaoBan> getDsGoiYMoiNguoiCungXem() {
		return dsGoiYMoiNguoiCungXem;
	}

	public void setDsGoiYMoiNguoiCungXem(ArrayList<RaoBan> dsGoiYMoiNguoiCungXem) {
		this.dsGoiYMoiNguoiCungXem = dsGoiYMoiNguoiCungXem;
	}

}
