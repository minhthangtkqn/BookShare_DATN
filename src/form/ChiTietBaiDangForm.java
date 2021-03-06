package form;

import java.util.ArrayList;
import java.util.Date;

import model.bean.BinhLuan;
import model.bean.ListBinhLuan;
import model.bean.RaoBan;

import org.apache.struts.action.ActionForm;

public class ChiTietBaiDangForm extends ActionForm {

	private String maRaoBan;
	private boolean xemSau;

	private RaoBan chiTiet;
	private ArrayList<RaoBan> dsGoiYMoiNguoiCungXem;

	private float uyTinNguoiBan;

	private ArrayList<ListBinhLuan> dsBinhLuan;

	private String submit;
	private String error;

	public boolean isXemSau() {
		return xemSau;
	}

	public void setXemSau(boolean xemSau) {
		this.xemSau = xemSau;
	}

	public float getUyTinNguoiBan() {
		return uyTinNguoiBan;
	}

	public void setUyTinNguoiBan(float uyTinNguoiBan) {
		this.uyTinNguoiBan = uyTinNguoiBan;
	}

	public ArrayList<ListBinhLuan> getDsBinhLuan() {
		return dsBinhLuan;
	}

	public void setDsBinhLuan(ArrayList<ListBinhLuan> dsBinhLuan) {
		this.dsBinhLuan = dsBinhLuan;
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
