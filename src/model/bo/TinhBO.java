package model.bo;

import java.util.ArrayList;

import model.bean.Tinh;
import model.dao.TinhDAO;


public class TinhBO {
	TinhDAO tinhDAO = new TinhDAO();

	public ArrayList<Tinh> getListTinh(){
		return tinhDAO.layDanhSachTinh();
	}
	

	
}
