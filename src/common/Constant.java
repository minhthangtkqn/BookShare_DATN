package common;

public class Constant {

	// INFORMATION FOR CONNECTION
	public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=LineBook";
	public static final String DATABASE_USERNAME = "sa";
	public static final String DATABASE_PASSWORD = "12345678";

	// number of products on one search page
	public static final int NUMBER_PRODUCT_ON_PAGE = 8;
	public static final int NUMBER_RELATED_PRODUCTS = 10;

	// Default values
	public static final String NO_IMAGE_DEFAULT = "images/No-image.jpg";
	
	public static final String PREFIX_NOTIFICATION_DUYET_BAI_DANG = "Admin đã duyệt bài đăng \"";
	public static final String SUFFIX_NOTIFICATION_DUYET_BAI_DANG = "\" của bạn";
	
	public static final String PREFIX_NOTIFICATION_BO_DUYET_BAI_DANG = "Admin đã bỏ duyệt bài đăng \"";
	public static final String SUFFIX_NOTIFICATION_BO_DUYET_BAI_DANG = "\" của bạn";
	
	public static final String PREFIX_NOTIFICATION_XOA_BAI_DANG = "Admin đã xóa bài đăng \"";
	public static final String SUFFIX_NOTIFICATION_XOA_BAI_DANG = "\" của bạn";
	
	/**
	 * gia thap -> cao (ASC)
	 */
	public static final String DEFAULT_SAP_XEP_GIA_TANG_DAN = "ASC";

	/**
	 * bai` moi' truoc (DESC)
	 */
	public static final String DEFAULT_SAP_XEP_THOI_GIAN = "DESC";

	// Link upload image files
	public static final String LINK_IMAGE_STORAGE = "E:/WorkSpace/WorkSpaceJavaEclipse/BookShare_DATN/WebContent/images/raoban/";
	public static final String LINK_IMAGE_DATABASE = "images/raoban/";

	// type of search
	public static final String SELLING_SEARCH = "sell";
	public static final String REQUEST_SEARCH = "request";

	// type of user account
	public static final String NORMAL_ACCOUNT = "Bình thường";
	public static final String LOCKED_ACCOUNT = "Bị khóa";

	// TABLE NAME
	public static final String TABLE_TINH = "[tblTinh]";
	public static final String TABLE_BANNER = "[tblBanner]";
	public static final String TABLE_RAO_BAN = "[tblRaoBan]";
	public static final String TABLE_XEM_SAU = "[tblXemSau]";
	public static final String TABLE_DANH_MUC = "[tblDanhMuc]";
	public static final String TABLE_DANH_GIA = "[tblDanhGia]";
	public static final String TABLE_THONG_BAO = "[tblThongBao]";
	public static final String TABLE_BINH_LUAN = "[tblBinhLuan]";
	public static final String TABLE_YEU_CAU_SACH = "[tblYeuCau]";
	public static final String TABLE_NGUOI_DUNG = "[tblNguoiDung]";
	public static final String TABLE_RAO_BAN_DA_XEM = "[tblRaoBanDaXem]";
	public static final String TABLE_TU_KHOA_TIM_KIEM = "[tblTuKhoaTimKiem]";

	
	// Views Name
	public static final String VIEW_DANH_SACH_MOI_NHAT = "[v_dsMoiNhat]";
	public static final String VIEW_GOI_Y_MOI_NGUOI_CUNG_XEM = "[v_GoiYMoiNguoiRaoBan]";
	public static final String VIEW_DANH_SACH_CHO_DUYET = "[v_dsChoDuyet]";
	public static final String VIEW_DANH_SACH_DANG_BAN = "[v_dsDangBan]";
	public static final String VIEW_DANH_SACH_DA_BAN_ND = "[v_dsDaBanND]";
	public static final String VIEW_DANH_SACH_DA_BAN_ADMIN = "[v_dsDaBanAD]";
	public static final String VIEW_DANH_SACH_BAI_DANG_BI_KHOA = "[v_dsBaiDangBiKhoa]";

	public static final String VIEW_DANH_SACH_NGUOI_DUNG = "[v_danhSachNguoiDung]";
	public static final String VIEW_DANH_SACH_ADMIN = "[v_danhSachAdmin]";
	public static final String VIEW_DANH_SACH_HOT = "[v_dsXemNhieu1ThangGanDay]";
	public static final String VIEW_DANH_SACH_BINH_LUAN = "[v_danhSachBinhLuan]";
	public static final String VIEW_DANH_SACH_DANH_GIA = "[v_danhSachDanhGia]";

	// Post Functions
	public static final String PROC_DANG_BAI = "[p_themraoban]";
	public static final String PROC_SUA_BAI_DANG = "[p_suaRaoBan]";
	public static final String PROC_XOA_BAI_DANG = "[p_xoaRaoBan]";
	public static final String PROC_ADMIN_XOA_BAI_DANG = "[p_xoaRaoBanAdmin]";

	public static final String PROC_BAN_BAI_DANG = "[p_baiDangDaBan]";

	public static final String PROC_DUYET_BAI_DANG = "[p_duyetRaoBan]";
	public static final String PROC_KHONG_DUYET_BAI_DANG = "[p_khongDuyetRaoBan]";

	public static final String PROC_KHOA_BAI_DANG = "[p_khoaRaoBan]";
	public static final String PROC_MO_KHOA_BAI_DANG = "[p_moKhoaRaoBan]";

	public static final String PROC_THEM_BINH_LUAN = "[p_themBinhLuan]";
	public static final String PROC_THEM_DANH_GIA = "[p_themDanhGia]";

	public static final String PROC_THEM_XEM_SAU = "[p_themXemSau]";
	public static final String PROC_XOA_XEM_SAU = "[p_xoaXemSau]";

	public static final String PROC_XOA_YEU_CAU = "[p_xoaYeuCau]";
	public static final String PROC_THEM_YEU_CAU = "[p_themYeuCau]";
	public static final String PROC_DUYET_YEU_CAU = "[p_duyetYeuCau]";

	// ADMIN FUNCTION
	public static final String FUNCTION_KHOA_NGUOI_DUNG = "[p_khoaNguoiDung]";
	public static final String FUNCTION_MO_KHOA_NGUOI_DUNG = "[p_moKhoaNguoiDung]";

	public static final String FUNCTION_THEM_DANH_MUC = "[p_themDanhMuc]";
	public static final String FUNCTION_SUA_DANH_MUC = "[p_suaDanhMuc]";
	
	public static final String PROC_THEM_THONG_BAO = "[p_themThongBao]";
	public static final String PROC_XOA_THONG_BAO = "[p_xoaThongBao]";

	// Table-valued function
	public static final String FUNCTION_LAY_THONG_TIN_BAI_DANG = "f_LayThongTinRaoBan";
	public static final String FUNCTION_TIM_KIEM_TEN_SACH_KHONG_DAU = "f_TimKiemTenSachKhongDau";
	public static final String FUNCTION_TIM_KIEM_TAC_GIA_KHONG_DAU = "f_TimKiemTacGiaKhongDau";
	public static final String FUNCTION_LICH_SU_XEM_BAI_DANG = "f_lichSuXemBaiDang";
	public static final String FUNCTION_DANH_SACH_XEM_SAU = "f_DanhSachXemSau";
	public static final String FUNCTION_TIM_KIEM_YEU_CAU = "f_TimKiemYeuCau";

	// POST STATUS
	public static final int TRANG_THAI_CHO_DUYET = 0;
	public static final int TRANG_THAI_DANG_BAN = 1;
	public static final int TRANG_THAI_DA_BAN = 2;
	public static final int TRANG_THAI_DA_BAN_VA_DA_XOA = 3;

}
