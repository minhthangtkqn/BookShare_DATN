package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.DanhMuc;
import model.bean.RaoBan;

public class DanhMucForm extends ActionForm {
	private ArrayList<DanhMuc> dsDanhMuc;
	private ArrayList<RaoBan> dsGoiYCaNhan;
	private ArrayList<RaoBan> dsGoiYMoiNguoiCungXem;
	private ArrayList<RaoBan> dsRaoBanTrongDanhMuc;

	private String maDanhMuc;
	private String tuKhoa;
	private String trang;

	// dung de them, sua, xoa danhMuc
	private String submit;
	private String tenDanhMuc;

	private String tenDanhMucError;

	public String getTenDanhMucError() {
		return tenDanhMucError;
	}

	public void setTenDanhMucError(String tenDanhMucError) {
		this.tenDanhMucError = tenDanhMucError;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public ArrayList<DanhMuc> getDsDanhMuc() {
		return dsDanhMuc;
	}

	public void setDsDanhMuc(ArrayList<DanhMuc> dsDanhMuc) {
		this.dsDanhMuc = dsDanhMuc;
	}

	public ArrayList<RaoBan> getDsGoiYCaNhan() {
		return dsGoiYCaNhan;
	}

	public void setDsGoiYCaNhan(ArrayList<RaoBan> dsGoiYCaNhan) {
		this.dsGoiYCaNhan = dsGoiYCaNhan;
	}

	public ArrayList<RaoBan> getDsGoiYMoiNguoiCungXem() {
		return dsGoiYMoiNguoiCungXem;
	}

	public void setDsGoiYMoiNguoiCungXem(ArrayList<RaoBan> dsGoiYMoiNguoiCungXem) {
		this.dsGoiYMoiNguoiCungXem = dsGoiYMoiNguoiCungXem;
	}

	public ArrayList<RaoBan> getDsRaoBanTrongDanhMuc() {
		return dsRaoBanTrongDanhMuc;
	}

	public void setDsRaoBanTrongDanhMuc(ArrayList<RaoBan> dsRaoBanTrongDanhMuc) {
		this.dsRaoBanTrongDanhMuc = dsRaoBanTrongDanhMuc;
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTuKhoa() {
		return tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}

	public String getTrang() {
		return trang;
	}

	public void setTrang(String trang) {
		this.trang = trang;
	}

}
