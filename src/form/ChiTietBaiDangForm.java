package form;

import java.util.Date;

import model.bean.RaoBan;

import org.apache.struts.action.ActionForm;

public class ChiTietBaiDangForm extends ActionForm {

	private RaoBan chiTiet;

	public RaoBan getChiTiet() {
		return chiTiet;
	}

	public void setChiTiet(RaoBan chiTiet) {
		this.chiTiet = chiTiet;
	}

}
