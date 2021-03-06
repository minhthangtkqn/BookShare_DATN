package common;

import java.text.Normalizer;
import java.util.regex.Pattern;

import org.apache.struts.upload.FormFile;

public class StringProcess {

	/**
	 * Hàm bỏ dấu tiếng việt
	 * 
	 * @param str
	 * @return
	 */
	public static String removeDiacritics(String str) {
		try {
			String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			return pattern.matcher(temp).replaceAll("").toLowerCase()
					/* .replaceAll(" ", "-") */.replaceAll("đ", "d");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	/**
	 * Ham tra ve gioi tinh: 1=Nam, 0=Nu
	 * 
	 * @param val
	 * @return String
	 */
	public static String gioiTinh(String val) {
		if ("0".equals(val)) {
			return "Female";
		}
		return "Male";
	}

	/**
	 * Ham in ra mot xau, null in ra xau rong
	 * 
	 * @param s
	 * @return String
	 */
	public static String getVaildString(String s) {
		if (s == null)
			return "";
		return s;
	}

	/**
	 * Ham kiem tra xau rong hay khong
	 * 
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaild(String s) {
		if (s == null || s.length() == 0)
			return true;
		return false;
	}

	/**
	 * Ham kiem tra xem xau co bao gom chi chu so hay khong
	 * 
	 * @param s
	 * @return boolean
	 */
	public static boolean notVaildNumber(String s) {
		if (notVaild(s))
			return true;
		String regex = "[0-9]+";
		if (s.matches(regex))
			return false;
		return true;
	}

	/**
	 * Hàm lấy định dạng file ảnh
	 * 
	 * @param file
	 * @return
	 */
	public static String getSuffix(FormFile file) {
		return "." + file.getFileName().split("\\.")[file.getFileName().split("\\.").length - 1];
	}
	
	/**
	 * 
	 */
	public static boolean notVaildRatingPoint(String s) {
		if (notVaild(s))
			return true;
		String regex = "[1-5]";
		if (s.matches(regex))
			return false;
		return true;
	}
}
