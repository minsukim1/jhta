package com.simple.util;

public class StringUtil {

	/**
	 * λ¬Έμ?΄? μ€λ°κΏλ¬Έ?λ₯? &lt;br&gt;λ‘? λ³???΄? λ°ν??€.
	 * @param text ??€?Έ
	 * @return &lt;br&gt;?κ·Έκ? ?¬?¨? ??€?Έ
	 */
	public static String strWithBr(String text) {
		if (text == null) {
			return "";
		}
		return text.replace(System.lineSeparator(), "<br/>");
	}
	
	/**
	 * λ¬Έμ?΄ κ°μ΄ null?΄λ©? μ§?? ? defaultValueκ°μ λ°ν??€.
	 * @param str null?Έμ§? μ²΄ν¬?  λ¬Έμ?΄
	 * @param defaultValue null?Ό? λ°ν?  κΈ°λ³Έκ°?
	 * @return
	 */
	public static String nullToValue(String str, String defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		return str;
	}
	/**
	 * λ¬Έμ?΄ κ°μ΄ null?΄λ©? ""? λ°ν??€.
	 * @param str null?Έμ§? μ²΄ν¬?  λ¬Έμ?΄
	 * @return
	 */
	public static String nullToBlank(String str) {
		return nullToValue(str, "");
	}
}
