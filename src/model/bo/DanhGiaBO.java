package model.bo;

import model.bean.DanhGia;
import model.dao.DanhGiaDAO;

public class DanhGiaBO {
	DanhGiaDAO danhGiaDAO = new DanhGiaDAO();
	
	public boolean dangDanhGiaNguoiBan(DanhGia danhGia){
		return danhGiaDAO.dangDanhGiaNguoiBan(danhGia);
	}
}
