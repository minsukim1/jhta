package com.simple.util;

public class StringUtil {

	/**
	 * ë¬¸ì?—´?˜ ì¤„ë°”ê¿ˆë¬¸?ë¥? &lt;br&gt;ë¡? ë³??™˜?•´?„œ ë°˜í™˜?•œ?‹¤.
	 * @param text ?…?Š¤?Š¸
	 * @return &lt;br&gt;?ƒœê·¸ê? ?¬?•¨?œ ?…?Š¤?Š¸
	 */
	public static String strWithBr(String text) {
		if (text == null) {
			return "";
		}
		return text.replace(System.lineSeparator(), "<br/>");
	}
	
	/**
	 * ë¬¸ì?—´ ê°’ì´ null?´ë©? ì§?? •?œ defaultValueê°’ì„ ë°˜í™˜?•œ?‹¤.
	 * @param str null?¸ì§? ì²´í¬?•  ë¬¸ì?—´
	 * @param defaultValue null?¼?•Œ ë°˜í™˜?•  ê¸°ë³¸ê°?
	 * @return
	 */
	public static String nullToValue(String str, String defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		return str;
	}
	/**
	 * ë¬¸ì?—´ ê°’ì´ null?´ë©? ""?„ ë°˜í™˜?•œ?‹¤.
	 * @param str null?¸ì§? ì²´í¬?•  ë¬¸ì?—´
	 * @return
	 */
	public static String nullToBlank(String str) {
		return nullToValue(str, "");
	}
}
