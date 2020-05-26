package com.bookstore.util;

import java.text.DecimalFormat;

public class NumberUtil {

	private static DecimalFormat currencyFormat = new DecimalFormat("#,###");
	
	
	/**
	 * ������ ","�� ���Ե� ��ȭǥ���� ���ڿ��� ��ȯ�ؼ� ��ȯ�Ѵ�.
	 * @param number ����
	 * @return ","�� ���Ե� ���ڿ�
	 */
	public static String numberWithComma(long number) {
		return currencyFormat.format(number);
	}
	
	public static long stringToLong(String str, long defaultNumber) {
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	
	public static long stringToLong(String str) {
		return stringToLong(str, 0);
	}
	
	public static int stringToInt(String str, int defaultNumber) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	
	/**
	 * ���ڿ��� ������ ��ȯ�ؼ� ��ȯ�Ѵ�.
	 * @param str ���ڿ�
	 * @return ����, ���ڰ� �ƴ� ���ڰ� ���Ե� ��� 0�� ��ȯ�ȴ�.
	 */
	public static int stringToInt(String str) {
		return stringToInt(str,0);
	}
	/**
	 * ���ڿ��� �Ǽ��� ��ȯ�ؼ� ��ȯ�Ѵ�.
	 * @param str ���ڿ�
	 * @param defaultNumber �⺻��
	 * @return �Ǽ�, ���ڰ� �ƴ� ���ڰ� ���Ե� ��� �⺻���� ��ȯ�ȴ�.
	 */
	public static double stringToDouble(String str, double defaultNumber) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	
	/**
	 * ���ڿ��� �Ǽ��� ��ȯ�ؼ� ��ȯ�Ѵ�.
	 * @param str ���ڿ�
	 * @return �Ǽ�, ���ڰ� �ƴ� ���ڰ� ���Ե� ��� 0.0�� ��ȯ�ȴ�.
	 */
	public static double stringToDouble(String str) {
		return stringToDouble(str,0.0);
	}
}
