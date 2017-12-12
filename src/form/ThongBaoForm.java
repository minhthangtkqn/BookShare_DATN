package form;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.ThongBao;

public class ThongBaoForm extends ActionForm {
	private ArrayList<ThongBao> listThongBao;

	private String maNguoiDung;
	private String noiDung;

	private String maThongBao;

	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public ArrayList<ThongBao> getListThongBao() {
		return listThongBao;
	}

	public void setListThongBao(ArrayList<ThongBao> listThongBao) {
		this.listThongBao = listThongBao;
	}

	public String getMaNguoiDung() {
		return maNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getMaThongBao() {
		return maThongBao;
	}

	public void setMaThongBao(String maThongBao) {
		this.maThongBao = maThongBao;
	}

}
