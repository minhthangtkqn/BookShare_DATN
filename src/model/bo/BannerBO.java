package model.bo;

import java.util.ArrayList;

import model.bean.Banner;
import model.dao.BannerDAO;

public class BannerBO {
	BannerDAO bannerDAO = new BannerDAO();
	
	public ArrayList<Banner> layDSBanner() {
		return bannerDAO.layDSBanner();
	}
}
