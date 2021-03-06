package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.RaoBan;
import model.bean.Tinh;
import model.bean.Banner;
import model.bean.DanhMuc;

public class TrangChuForm extends ActionForm {

	private ArrayList<RaoBan> dsMoiNhat;
	private ArrayList<RaoBan> dsDanhMucBanNhieu;
	private ArrayList<RaoBan> dsGoiYMoiNguoiCungXem;

	private ArrayList<RaoBan> dsHot;

	private ArrayList<Banner> dsBanner;
	private ArrayList<DanhMuc> dsDanhMuc;
	private ArrayList<Tinh> dsTinh;

	// +++++++++++++++++++++++++++++++++++++++

	public ArrayList<Tinh> getDsTinh() {
		return dsTinh;
	}

	public ArrayList<RaoBan> getDsHot() {
		return dsHot;
	}

	public void setDsHot(ArrayList<RaoBan> dsHot) {
		this.dsHot = dsHot;
	}

	public void setDsTinh(ArrayList<Tinh> dsTinh) {
		this.dsTinh = dsTinh;
	}

	public ArrayList<RaoBan> getDsGoiYMoiNguoiCungXem() {
		return dsGoiYMoiNguoiCungXem;
	}

	public void setDsGoiYMoiNguoiCungXem(ArrayList<RaoBan> dsGoiYMoiNguoiCungXem) {
		this.dsGoiYMoiNguoiCungXem = dsGoiYMoiNguoiCungXem;
	}

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

	public ArrayList<RaoBan> getDsDanhMucBanNhieu() {
		return dsDanhMucBanNhieu;
	}

	public void setDsDanhMucBanNhieu(ArrayList<RaoBan> dsDanhMucBanNhieu) {
		this.dsDanhMucBanNhieu = dsDanhMucBanNhieu;
	}
}
