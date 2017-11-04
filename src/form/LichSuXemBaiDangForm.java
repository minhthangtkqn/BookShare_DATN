package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.RaoBan;

public class LichSuXemBaiDangForm extends ActionForm {
	private ArrayList<RaoBan> listBaiDangDaXem;
	private ArrayList<RaoBan> dsHot;

	public ArrayList<RaoBan> getListBaiDangDaXem() {
		return listBaiDangDaXem;
	}

	public void setListBaiDangDaXem(ArrayList<RaoBan> listBaiDangDaXem) {
		this.listBaiDangDaXem = listBaiDangDaXem;
	}

	public ArrayList<RaoBan> getDsHot() {
		return dsHot;
	}

	public void setDsHot(ArrayList<RaoBan> dsHot) {
		this.dsHot = dsHot;
	}

}
