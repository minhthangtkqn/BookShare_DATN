package form;

import java.util.ArrayList;

import model.bean.NguoiDung;
import model.bean.RaoBan;
import org.apache.struts.action.ActionForm;

public class TrangQuanLyForm extends ActionForm {

	private NguoiDung admin;

	// private ArrayList<NguoiDung> dsNguoiDung;
	// private ArrayList<NguoiDung> dsNguoiDungBiKhoa;

	private ArrayList<RaoBan> dsChoDuyet;
	private ArrayList<RaoBan> dsDangBan;
	private ArrayList<RaoBan> dsDaBan;

	private int soLuongChoDuyet;
	private int soLuongDangBan;
	private int soLuongDaBan;

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

	public NguoiDung getAdmin() {
		return admin;
	}

	public void setAdmin(NguoiDung admin) {
		this.admin = admin;
	}

}
