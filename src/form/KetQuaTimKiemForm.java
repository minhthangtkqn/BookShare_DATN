package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.DanhMuc;
import model.bean.RaoBan;
import model.bean.Tinh;
import model.bean.YeuCau;

public class KetQuaTimKiemForm extends ActionForm {

	private String loaiTimKiem;

	private String tuKhoa;
	private String maTinh;
	private String maDanhMuc;

	private ArrayList<Tinh> dsTinh;
	private ArrayList<DanhMuc> dsDanhMuc;
	private ArrayList<RaoBan> dsHot;

	private String page;
	private int soLuongKetQua;

	private ArrayList<YeuCau> dsYeuCau;
	private ArrayList<RaoBan> listRaoBan;

	// cao -> thap (DESC)
	// thap -> cao (ASC)
	private String sapXepGia;

	// bai` moi' truoc (DESC)
	// bai` cu~ truoc (ASC)
	private String sapXepThoiGian;

	/* ++++++++++++++++++++++++++++++ */
	/* ++++++++++++++++++++++++++++++ */
	/* ++++++++++++++++++++++++++++++ */

	public ArrayList<Tinh> getDsTinh() {
		return dsTinh;
	}

	public ArrayList<YeuCau> getDsYeuCau() {
		return dsYeuCau;
	}

	public void setDsYeuCau(ArrayList<YeuCau> dsYeuCau) {
		this.dsYeuCau = dsYeuCau;
	}

	public String getLoaiTimKiem() {
		return loaiTimKiem;
	}

	public void setLoaiTimKiem(String loaiTimKiem) {
		this.loaiTimKiem = loaiTimKiem;
	}

	public ArrayList<RaoBan> getDsHot() {
		return dsHot;
	}

	public void setDsHot(ArrayList<RaoBan> dsHot) {
		this.dsHot = dsHot;
	}

	public String getSapXepGia() {
		return sapXepGia;
	}

	public void setSapXepGia(String sapXepGia) {
		this.sapXepGia = sapXepGia;
	}

	public String getSapXepThoiGian() {
		return sapXepThoiGian;
	}

	public void setSapXepThoiGian(String sapXepThoiGian) {
		this.sapXepThoiGian = sapXepThoiGian;
	}

	public void setDsTinh(ArrayList<Tinh> dsTinh) {
		this.dsTinh = dsTinh;
	}

	public ArrayList<DanhMuc> getDsDanhMuc() {
		return dsDanhMuc;
	}

	public void setDsDanhMuc(ArrayList<DanhMuc> dsDanhMuc) {
		this.dsDanhMuc = dsDanhMuc;
	}

	public String getMaTinh() {
		return maTinh;
	}

	public void setMaTinh(String maTinh) {
		this.maTinh = maTinh;
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
