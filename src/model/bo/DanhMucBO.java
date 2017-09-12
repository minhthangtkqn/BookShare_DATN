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
	
}
