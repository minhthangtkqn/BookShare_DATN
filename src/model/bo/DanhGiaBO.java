package model.bo;

import java.util.ArrayList;

import model.bean.DanhGia;
import model.dao.DanhGiaDAO;

public class DanhGiaBO {
	DanhGiaDAO danhGiaDAO = new DanhGiaDAO();
	
	public boolean dangDanhGiaNguoiBan(DanhGia danhGia){
		return danhGiaDAO.dangDanhGiaNguoiBan(danhGia);
	}

	public ArrayList<DanhGia> layDanhSachDanhGia(String maNguoiBan) {
		return danhGiaDAO.layDanhSachDanhGia(maNguoiBan);
	}

	public boolean isRated(String maNguoiDanhGia, String maNguoiBan) {
		return danhGiaDAO.isRated(maNguoiDanhGia, maNguoiBan);
	}
}
