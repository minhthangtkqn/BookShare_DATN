package model.bo;

import java.util.ArrayList;

import common.StringProcess;
import model.bean.BinhLuan;
import model.bean.ListBinhLuan;
import model.dao.BinhLuanDAO;

public class BinhLuanBO {
	BinhLuanDAO binhLuanDAO = new BinhLuanDAO();

	public ArrayList<ListBinhLuan> layDsBinhLuan(String maRaoBan) {

		// lay tat ca cac binh luan trong bai dang
		ArrayList<BinhLuan> listTatCaBinhLuan = binhLuanDAO.layDsBinhLuan(maRaoBan);
		System.out.println("Tong so binh luan: " + listTatCaBinhLuan.size());

		// loc ra cac cau hoi?
		ArrayList<BinhLuan> listCauHoi = new ArrayList<>();
		for (int i = 0; i < listTatCaBinhLuan.size(); i++) {
			if (StringProcess.notVaild(listTatCaBinhLuan.get(i).getMaBinhLuanDuocTraLoi())) {
				listCauHoi.add(listTatCaBinhLuan.get(i));
			}
		}
		if (listCauHoi.size() == 0) {
			return new ArrayList<ListBinhLuan>();
		}
		// loc ra cac cau tra loi tuong ung voi cau hoi
		ArrayList<ListBinhLuan> listNhomBinhLuan = new ArrayList<ListBinhLuan>();
		for (int i = 0; i < listCauHoi.size(); i++) {
			listNhomBinhLuan.add(new ListBinhLuan());
			listNhomBinhLuan.get(i).setNhomBinhLuan(new ArrayList<BinhLuan>());
			
			listNhomBinhLuan.get(i).getNhomBinhLuan().add(listCauHoi.get(i));
			System.out.println("Cau hoi: " + listCauHoi.get(i).getBinhLuan());

			for (int j = 0; j < listTatCaBinhLuan.size(); j++) {
				if (listCauHoi.get(i).getMaBinhLuan().equals(listTatCaBinhLuan.get(j).getMaBinhLuanDuocTraLoi())) {
					listNhomBinhLuan.get(i).getNhomBinhLuan().add(listTatCaBinhLuan.get(j));
					System.out.println("Cau tra loi: " + listTatCaBinhLuan.get(j).getBinhLuan());
				}
			}
			System.out.println("----------------");
		}

		return listNhomBinhLuan;
	}

}
