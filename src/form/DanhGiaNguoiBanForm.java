package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.DanhGia;
import model.bean.NguoiDung;

public class DanhGiaNguoiBanForm extends ActionForm {

	private String diemDanhGia;
	private String binhLuan;
	private String maNguoiBan;
	private NguoiDung nguoiBan;

	private String diemDanhGiaError;
	private String binhLuanError;

	private ArrayList<DanhGia> listDanhGia;

	private String submit;
	private String error;

	public ArrayList<DanhGia> getListDanhGia() {
		return listDanhGia;
	}

	public void setListDanhGia(ArrayList<DanhGia> listDanhGia) {
		this.listDanhGia = listDanhGia;
	}

	public NguoiDung getNguoiBan() {
		return nguoiBan;
	}

	public void setNguoiBan(NguoiDung nguoiBan) {
		this.nguoiBan = nguoiBan;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getDiemDanhGiaError() {
		return diemDanhGiaError;
	}

	public void setDiemDanhGiaError(String diemDanhGiaError) {
		this.diemDanhGiaError = diemDanhGiaError;
	}

	public String getBinhLuanError() {
		return binhLuanError;
	}

	public void setBinhLuanError(String binhLuanError) {
		this.binhLuanError = binhLuanError;
	}

	public String getDiemDanhGia() {
		return diemDanhGia;
	}

	public void setDiemDanhGia(String diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}

	public String getBinhLuan() {
		return binhLuan;
	}

	public void setBinhLuan(String binhLuan) {
		this.binhLuan = binhLuan;
	}

	public String getMaNguoiBan() {
		return maNguoiBan;
	}

	public void setMaNguoiBan(String maNguoiBan) {
		this.maNguoiBan = maNguoiBan;
	}

}
