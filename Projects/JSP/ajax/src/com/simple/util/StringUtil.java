package com.simple.util;

public class StringUtil {

	/**
	 * 문자?��?�� 줄바꿈문?���? &lt;br&gt;�? �??��?��?�� 반환?��?��.
	 * @param text ?��?��?��
	 * @return &lt;br&gt;?��그�? ?��?��?�� ?��?��?��
	 */
	public static String strWithBr(String text) {
		if (text == null) {
			return "";
		}
		return text.replace(System.lineSeparator(), "<br/>");
	}
	
	/**
	 * 문자?�� 값이 null?���? �??��?�� defaultValue값을 반환?��?��.
	 * @param str null?���? 체크?�� 문자?��
	 * @param defaultValue null?��?�� 반환?�� 기본�?
	 * @return
	 */
	public static String nullToValue(String str, String defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		return str;
	}
	/**
	 * 문자?�� 값이 null?���? ""?�� 반환?��?��.
	 * @param str null?���? 체크?�� 문자?��
	 * @return
	 */
	public static String nullToBlank(String str) {
		return nullToValue(str, "");
	}
}
