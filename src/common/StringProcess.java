package common;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringProcess {
	public static String removeDiacritics(String str) {
		try {
			String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
			Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			return pattern.matcher(temp).replaceAll("").toLowerCase()/*.replaceAll(" ", "-")*/.replaceAll("đ", "d");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
}
