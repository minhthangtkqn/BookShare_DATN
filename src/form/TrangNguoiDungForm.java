package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.NguoiDung;
import model.bean.RaoBan;
import model.bean.Tinh;

public class TrangNguoiDungForm extends ActionForm {

	private NguoiDung nguoiDung;

	private ArrayList<RaoBan> dsChoDuyet;
	private ArrayList<RaoBan> dsDangBan;
	private ArrayList<RaoBan> dsDaBan;
	private ArrayList<RaoBan> dsXemSau;

	private int soLuongChoDuyet;
	private int soLuongDangBan;
	private int soLuongDaBan;
	private int soLuongXemSau;

	private ArrayList<RaoBan> dsDaMua;
	private ArrayList<RaoBan> dsGoiY;

	public ArrayList<RaoBan> getDsXemSau() {
		return dsXemSau;
	}

	public void setDsXemSau(ArrayList<RaoBan> dsXemSau) {
		this.dsXemSau = dsXemSau;
	}

	public int getSoLuongXemSau() {
		return soLuongXemSau;
	}

	public void setSoLuongXemSau(int soLuongXemSau) {
		this.soLuongXemSau = soLuongXemSau;
	}

	public int getSoLuongChoDuyet() {
		return soLuongChoDuyet;
	}

	public void setSoLuongChoDuyet(int soLuongChoDuyet) {
		this.soLuongChoDuyet = soLuongChoDuyet;
	}

	public int getSoLuongDangBan() {
		return soLuongDangBan;
	}

	public void setSoLuongDangBan(int soLuongDangBan) {
		this.soLuongDangBan = soLuongDangBan;
	}

	public int getSoLuongDaBan() {
		return soLuongDaBan;
	}

	public void setSoLuongDaBan(int soLuongDaBan) {
		this.soLuongDaBan = soLuongDaBan;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public ArrayList<RaoBan> getDsChoDuyet() {
		return dsChoDuyet;
	}

	public void setDsChoDuyet(ArrayList<RaoBan> dsChoDuyet) {
		this.dsChoDuyet = dsChoDuyet;
	}

	public ArrayList<RaoBan> getDsDangBan() {
		return dsDangBan;
	}

	public void setDsDangBan(ArrayList<RaoBan> dsDangBan) {
		this.dsDangBan = dsDangBan;
	}

	public ArrayList<RaoBan> getDsDaBan() {
		return dsDaBan;
	}

	public void setDsDaBan(ArrayList<RaoBan> dsDaBan) {
		this.dsDaBan = dsDaBan;
	}

	public ArrayList<RaoBan> getDsDaMua() {
		return dsDaMua;
	}

	public void setDsDaMua(ArrayList<RaoBan> dsDaMua) {
		this.dsDaMua = dsDaMua;
	}

	public ArrayList<RaoBan> getDsGoiY() {
		return dsGoiY;
	}

	public void setDsGoiY(ArrayList<RaoBan> dsGoiY) {
		this.dsGoiY = dsGoiY;
	}

}
