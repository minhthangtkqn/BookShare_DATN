package model.bo;

import java.util.ArrayList;

import common.StringProcess;
import model.bean.RaoBan;
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

	public ArrayList<YeuCau> layDanhSachYeuCau(String maNguoiDung) {
		return yeuCauDAO.layDanhSachYeuCau(maNguoiDung);
	}

	public ArrayList<YeuCau> layDanhSachTimKiemYeuCau(String tuKhoa) {

		String[] arrayTuKhoa = tuKhoa.split("\\s+");
		String[] arrayTuKhoaKhongDau = StringProcess.removeDiacritics(tuKhoa).split("\\s+");

		ArrayList<YeuCau> list = new ArrayList<>();

		list.addAll(yeuCauDAO.layDanhSachTimKiemYeuCau(tuKhoa));
		for (String item : arrayTuKhoa) {
			list.addAll(yeuCauDAO.layDanhSachTimKiemYeuCau(item));
		}
		list.addAll(yeuCauDAO.layDanhSachTimKiemYeuCau(StringProcess.removeDiacritics(tuKhoa)));
		for (String item : arrayTuKhoaKhongDau) {
			list.addAll(yeuCauDAO.layDanhSachTimKiemYeuCau(item));
		}

		// Lọc lại các kết quả tìm kiếm trùng nhau
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {

				if (list.get(i).getMaYeuCau().equals(list.get(j).getMaYeuCau())) {
					list.remove(j);
					j--;
				}
			}
		}
		// END Lọc lại các kết quả tìm kiếm trùng nhau
		
		System.out.println("Tong so ket qua thu duoc: " + list.size());
		
		return list;
	}
}
