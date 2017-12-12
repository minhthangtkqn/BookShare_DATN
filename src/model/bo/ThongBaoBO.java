package model.bo;

import java.util.ArrayList;

import model.bean.ThongBao;
import model.dao.ThongBaoDAO;

public class ThongBaoBO {
	ThongBaoDAO thongBaoDAO = new ThongBaoDAO();

	public ArrayList<ThongBao> layDanhSachThongBao(String maNguoiDung) {
		return thongBaoDAO.layDanhSachThongBao(maNguoiDung);
	}

	public boolean taoThongBao(String maNguoiDung, String noiDung) {
		return thongBaoDAO.taoThongBao(maNguoiDung, noiDung);
	}
}
