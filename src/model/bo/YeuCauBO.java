package model.bo;

import java.util.ArrayList;

import model.bean.YeuCau;
import model.dao.YeuCauDAO;

public class YeuCauBO {
	YeuCauDAO yeuCauDAO = new YeuCauDAO();

	public boolean themYeuCau(String tenSach, String maNguoiYeuCau) {
		return yeuCauDAO.themYeuCau(tenSach, maNguoiYeuCau);
	}
	
	public boolean xoaYeuCau(String maYeuCau) {
		return yeuCauDAO.xoaYeuCau(maYeuCau);
	}
	
	public ArrayList<YeuCau> layDanhSachYeuCau(String maNguoiDung){
		return yeuCauDAO.layDanhSachYeuCau(maNguoiDung);
	}
}
