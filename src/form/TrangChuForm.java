package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.RaoBan;
import model.bean.Banner;
import model.bean.DanhMuc;

public class TrangChuForm extends ActionForm {
	
	private ArrayList<RaoBan> dsMoiNhat;
	private ArrayList<RaoBan> dsNgauNhien;
	private ArrayList<RaoBan> dsDanhMucBanNhieu;
	private ArrayList<RaoBan> dsGoiY;
	private ArrayList<Banner> dsBanner;
	private ArrayList<DanhMuc> dsDanhMuc;

	public ArrayList<DanhMuc> getDsDanhMuc() {
		return dsDanhMuc;
	}

	public void setDsDanhMuc(ArrayList<DanhMuc> dsDanhMuc) {
		this.dsDanhMuc = dsDanhMuc;
	}

	public ArrayList<Banner> getDsBanner() {
		return dsBanner;
	}

	public void setDsBanner(ArrayList<Banner> dsBanner) {
		this.dsBanner = dsBanner;
	}

	public ArrayList<RaoBan> getDsMoiNhat() {
		return dsMoiNhat;
	}

	public void setDsMoiNhat(ArrayList<RaoBan> dsMoiNhat) {
		this.dsMoiNhat = dsMoiNhat;
	}

	public ArrayList<RaoBan> getDsNgauNhien() {
		return dsNgauNhien;
	}

	public void setDsNgauNhien(ArrayList<RaoBan> dsNgauNhien) {
		this.dsNgauNhien = dsNgauNhien;
	}

	public ArrayList<RaoBan> getDsDanhMucBanNhieu() {
		return dsDanhMucBanNhieu;
	}

	public void setDsDanhMucBanNhieu(ArrayList<RaoBan> dsDanhMucBanNhieu) {
		this.dsDanhMucBanNhieu = dsDanhMucBanNhieu;
	}

	public ArrayList<RaoBan> getDsGoiY() {
		return dsGoiY;
	}

	public void setDsGoiY(ArrayList<RaoBan> dsGoiY) {
		this.dsGoiY = dsGoiY;
	}
}
