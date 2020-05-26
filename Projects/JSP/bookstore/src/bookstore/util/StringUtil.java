package com.bookstore.util;

public class StringUtil {

	public static String strWithBr(String text) {
		if (text == null) {
			return "";
		}
		return text.replace(System.lineSeparator(), "<br/>");
	}
	/**
	 * ���ڿ� ���� null�̸� ������ defaultValue���� ��ȯ�Ѵ�.
	 * @param str null���� üũ�� ���ڿ�
	 * @param defaultValue null�϶� ��ȯ�� �⺻��
	 * @return
	 */
	public static String nullToValue(String str, String defaultValue) {
		if (str == null) {
			return defaultValue;
		}
		return str;
	}
	
	/**
	 * ���ڿ� ���� null�̸� ""�� ��ȯ�Ѵ�.
	 * @param str null���� üũ�� ���ڿ�
	 * @return
	 */
	public static String nullToBlank(String str) {
		return nullToValue(str,"");
	}
}
