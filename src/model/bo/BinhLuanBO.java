package model.bo;

import java.util.ArrayList;

import model.bean.BinhLuan;
import model.dao.BinhLuanDAO;

public class BinhLuanBO {
	BinhLuanDAO binhLuanDAO = new BinhLuanDAO();
	
	public ArrayList<BinhLuan> layDsBinhLuan(String maRaoBan){
		return binhLuanDAO.layDsBinhLuan(maRaoBan);
	}
}
