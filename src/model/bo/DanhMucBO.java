package model.bo;

import java.util.ArrayList;

import model.bean.DanhMuc;
import model.dao.DanhMucDAO;

public class DanhMucBO {
	DanhMucDAO danhMucDAO = new DanhMucDAO();

	public ArrayList<DanhMuc> layDanhSachDanhMuc(){
		return danhMucDAO.layDanhSachDanhMuc();
	}

	public ArrayList<DanhMuc> layTopDanhMucBanNhieu(int soLuong) {
		return danhMucDAO.layTopDanhMucBanNhieu(soLuong);
	}

	public boolean themDanhMuc(String tenDanhMuc) {
		return danhMucDAO.themDanhMuc(tenDanhMuc);
	}
	
	public boolean suaDanhMuc(String tenDanhMuc, String maDanhMuc){
		return danhMucDAO.suaDanhMuc(tenDanhMuc, maDanhMuc);
	}
	public boolean xoaDanhMuc(String maDanhMuc){
		return danhMucDAO.xoaDanhMuc(maDanhMuc);
	}
	
}
