package common;

public class Constant {

	// INFORMATION FOR CONNECTION
	public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=LineBook";
	public static final String DATABASE_USERNAME = "sa";
	public static final String DATABASE_PASSWORD = "12345678";
	// Default image for no image case
	public static final String NO_IMAGE_DEFAULT = "images/No-image.jpg";

	// Link upload image files
	public static final String LINK_IMAGE_STORAGE = "E:/WorkSpace/WorkSpaceJavaEclipse/BookShare_DATN/WebContent/images/raoban/";
	public static final String LINK_IMAGE_DATABASE = "images/raoban/";

	// TABLE NAME
	public static final String TABLE_TINH = "[tblTinh]";
	public static final String TABLE_BANNER = "[tblBanner]";
	public static final String TABLE_RAO_BAN = "[tblRaoBan]";
	public static final String TABLE_DANH_MUC = "[tblDanhMuc]";
	public static final String TABLE_NGUOI_DUNG = "[tblNguoiDung]";
	public static final String TABLE_RAO_BAN_DA_XEM = "[tblRaoBanDaXem]";
	public static final String TABLE_TU_KHOA_TIM_KIEM = "[tblTuKhoaTimKiem]";

	// Views Name
	public static final String VIEW_GOI_Y_MOI_NGUOI_CUNG_XEM = "[v_GoiYMoiNguoiRaoBan]";
	public static final String VIEW_DANH_SACH_CHO_DUYET = "[v_dsChoDuyet]";
	public static final String VIEW_DANH_SACH_DANG_BAN = "[v_dsDangBan]";
	public static final String VIEW_DANH_SACH_DA_BAN_ADMIN = "[v_dsDaBanAD]";
	public static final String VIEW_DANH_SACH_DA_BAN_ND = "[v_dsDaBanND]";
	public static final String VIEW_DANH_SACH_NGUOI_DUNG = "[v_danhsachnguoidung]";
	public static final String VIEW_DANH_SACH_ADMIN = "[v_danhSachAdmin]";

	// Functions Name
	public static final String FUNCTION_XOA_BAI_DANG = "p_xoaRaoBan";
	public static final String FUNCTION_SUA_BAI_DANG = "p_suaRaoBan";
	public static final String FUNCTION_BAN_BAI_DANG = "p_baiDangDaBan";
	public static final String FUNCTION_DUYET_BAI_DANG = "p_duyetRaoBan";
	public static final String FUNCTION_KHOA_BAI_DANG = "p_khoaBaiDang";
	public static final String FUNCTION_MO_KHOA_BAI_DANG = "p_moKhoaBaiDang";
	
	public static final String FUNCTION_KHOA_NGUOI_DUNG = "p_khoaNguoiDung";
	public static final String FUNCTION_MO_KHOA_NGUOI_DUNG = "p_moKhoaNguoiDung";
	

	// POST STATUS
	public static final int TRANG_THAI_CHO_DUYET = 0;
	public static final int TRANG_THAI_DANG_BAN = 1;
	public static final int TRANG_THAI_DA_BAN = 2;
	public static final int TRANG_THAI_DA_BAN_VA_DA_XOA = 3;

}
