package form;

import java.util.ArrayList;

import model.bean.DanhMuc;
import model.bean.Tinh;

import org.apache.struts.action.ActionForm;

public class DangBanForm extends ActionForm {
	private ArrayList<Tinh> dsTinh;
	private ArrayList<DanhMuc> dsDanhMuc;
	private String tenSach;
	private String maDanhMuc;
	private int maTinh;
	private String tacGia;
	private String nxb;
	private int namxb;
	private Float gia;
	private String moTa;
	private String linkAnh1;
	private String linkAnh2;
	private String linkAnh3;
	private String linkAnh4;
	private String linkAnh5;
	private String submit;
	private Float giaError;
	private String tenSachError;
	private String tacGiaError;
	private int namxbError;
	private String nxbError;
	private String moTaError;
	private String linkAnh1Error;
	private String linkAnh2Error;
	private String linkAnh3Error;
	private String linkAnh4Error;
	private String linkAnh5Error;

	public int getMaTinh() {
		return maTinh;
	}

	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public ArrayList<Tinh> getDsTinh() {
		return dsTinh;
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

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTenSachError() {
		return tenSachError;
	}

	public void setTenSachError(String tenSachError) {
		this.tenSachError = tenSachError;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getTacGiaError() {
		return tacGiaError;
	}

	public void setTacGiaError(String tacGiaError) {
		this.tacGiaError = tacGiaError;
	}

	public String getNxb() {
		return nxb;
	}

	public void setNxb(String nxb) {
		this.nxb = nxb;
	}

	public String getNxbError() {
		return nxbError;
	}

	public void setNxbError(String nxbError) {
		this.nxbError = nxbError;
	}

	public int getNamxb() {
		return namxb;
	}

	public void setNamxb(int namxb) {
		this.namxb = namxb;
	}

	public int getNamxbError() {
		return namxbError;
	}

	public void setNamxbError(int namxbError) {
		this.namxbError = namxbError;
	}

	public Float getGia() {
		return gia;
	}

	public void setGia(Float gia) {
		this.gia = gia;
	}

	public Float getGiaError() {
		return giaError;
	}

	public void setGiaError(Float giaError) {
		this.giaError = giaError;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getMoTaError() {
		return moTaError;
	}

	public void setMoTaError(String moTaError) {
		this.moTaError = moTaError;
	}

	public String getLinkAnh1() {
		return linkAnh1;
	}

	public void setLinkAnh1(String linkAnh1) {
		this.linkAnh1 = linkAnh1;
	}

	public String getLinkAnh1Error() {
		return linkAnh1Error;
	}

	public void setLinkAnh1Error(String linkAnh1Error) {
		this.linkAnh1Error = linkAnh1Error;
	}

	public String getLinkAnh2() {
		return linkAnh2;
	}

	public void setLinkAnh2(String linkAnh2) {
		this.linkAnh2 = linkAnh2;
	}

	public String getLinkAnh2Error() {
		return linkAnh2Error;
	}

	public void setLinkAnh2Error(String linkAnh2Error) {
		this.linkAnh2Error = linkAnh2Error;
	}

	public String getLinkAnh3() {
		return linkAnh3;
	}

	public void setLinkAnh3(String linkAnh3) {
		this.linkAnh3 = linkAnh3;
	}

	public String getLinkAnh3Error() {
		return linkAnh3Error;
	}

	public void setLinkAnh3Error(String linkAnh3Error) {
		this.linkAnh3Error = linkAnh3Error;
	}

	public String getLinkAnh4() {
		return linkAnh4;
	}

	public void setLinkAnh4(String linkAnh4) {
		this.linkAnh4 = linkAnh4;
	}

	public String getLinkAnh4Error() {
		return linkAnh4Error;
	}

	public void setLinkAnh4Error(String linkAnh4Error) {
		this.linkAnh4Error = linkAnh4Error;
	}

	public String getLinkAnh5() {
		return linkAnh5;
	}

	public void setLinkAnh5(String linkAnh5) {
		this.linkAnh5 = linkAnh5;
	}

	public String getLinkAnh5Error() {
		return linkAnh5Error;
	}

	public void setLinkAnh5Error(String linkAnh5Error) {
		this.linkAnh5Error = linkAnh5Error;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getSubmit() {
		return submit;
	}

}
