package form;

import java.util.ArrayList;

import model.bean.DanhMuc;
import model.bean.Tinh;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class DangBanForm extends ActionForm {
	private ArrayList<Tinh> dsTinh;
	private ArrayList<DanhMuc> dsDanhMuc;
	private String tenSach;
	private String maDanhMuc;
	private int maTinh;
	private String tacGia;
	private String nxb;
	private String namxb;
	private Float gia;
	private String moTa;

	private FormFile linkAnh1;
	private FormFile linkAnh2;
	private FormFile linkAnh3;
	private FormFile linkAnh4;
	private FormFile linkAnh5;

	private String submit;

	private String tenSachError;
	private String tacGiaError;
	private String nxbError;
	private String namxbError;
	private Float giaError;
	private String moTaError;
	private String linkAnh1Error;
	private String linkAnh2Error;
	private String linkAnh3Error;
	private String linkAnh4Error;
	private String linkAnh5Error;

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

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public int getMaTinh() {
		return maTinh;
	}

	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNxb() {
		return nxb;
	}

	public void setNxb(String nxb) {
		this.nxb = nxb;
	}

	public String getNamxb() {
		return namxb;
	}

	public void setNamxb(String namxb) {
		this.namxb = namxb;
	}

	public Float getGia() {
		return gia;
	}

	public void setGia(Float gia) {
		this.gia = gia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public FormFile getLinkAnh1() {
		return linkAnh1;
	}

	public void setLinkAnh1(FormFile linkAnh1) {
		this.linkAnh1 = linkAnh1;
	}

	public FormFile getLinkAnh2() {
		return linkAnh2;
	}

	public void setLinkAnh2(FormFile linkAnh2) {
		this.linkAnh2 = linkAnh2;
	}

	public FormFile getLinkAnh3() {
		return linkAnh3;
	}

	public void setLinkAnh3(FormFile linkAnh3) {
		this.linkAnh3 = linkAnh3;
	}

	public FormFile getLinkAnh4() {
		return linkAnh4;
	}

	public void setLinkAnh4(FormFile linkAnh4) {
		this.linkAnh4 = linkAnh4;
	}

	public FormFile getLinkAnh5() {
		return linkAnh5;
	}

	public void setLinkAnh5(FormFile linkAnh5) {
		this.linkAnh5 = linkAnh5;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getTenSachError() {
		return tenSachError;
	}

	public void setTenSachError(String tenSachError) {
		this.tenSachError = tenSachError;
	}

	public String getTacGiaError() {
		return tacGiaError;
	}

	public void setTacGiaError(String tacGiaError) {
		this.tacGiaError = tacGiaError;
	}

	public String getNxbError() {
		return nxbError;
	}

	public void setNxbError(String nxbError) {
		this.nxbError = nxbError;
	}

	public String getNamxbError() {
		return namxbError;
	}

	public void setNamxbError(String namxbError) {
		this.namxbError = namxbError;
	}

	public Float getGiaError() {
		return giaError;
	}

	public void setGiaError(Float giaError) {
		this.giaError = giaError;
	}

	public String getMoTaError() {
		return moTaError;
	}

	public void setMoTaError(String moTaError) {
		this.moTaError = moTaError;
	}

	public String getLinkAnh1Error() {
		return linkAnh1Error;
	}

	public void setLinkAnh1Error(String linkAnh1Error) {
		this.linkAnh1Error = linkAnh1Error;
	}

	public String getLinkAnh2Error() {
		return linkAnh2Error;
	}

	public void setLinkAnh2Error(String linkAnh2Error) {
		this.linkAnh2Error = linkAnh2Error;
	}

	public String getLinkAnh3Error() {
		return linkAnh3Error;
	}

	public void setLinkAnh3Error(String linkAnh3Error) {
		this.linkAnh3Error = linkAnh3Error;
	}

	public String getLinkAnh4Error() {
		return linkAnh4Error;
	}

	public void setLinkAnh4Error(String linkAnh4Error) {
		this.linkAnh4Error = linkAnh4Error;
	}

	public String getLinkAnh5Error() {
		return linkAnh5Error;
	}

	public void setLinkAnh5Error(String linkAnh5Error) {
		this.linkAnh5Error = linkAnh5Error;
	}

}
