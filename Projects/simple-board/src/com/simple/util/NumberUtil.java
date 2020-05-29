package com.simple.util;

import java.text.DecimalFormat;

public class NumberUtil {

	private static DecimalFormat currencyFormat = new DecimalFormat("#,###");
	
	/**
	 * ?��?���? ","�? ?��?��?�� 문자?���? �??��?��?�� 반환?��?��.
	 * @param number ?��?��
	 * @return ","�? ?��?��?�� 문자?��
	 */
	public static String numberWithComma(long number) {
		return currencyFormat.format(number);
	}
	
	/**
	 * 문자?��?�� ?��?���? �??��?��?�� 반환?��?��.
	 * @param str 문자?��
	 * @param defaultNumber 기본�?
	 * @return ?��?��, ?��?���? ?��?�� 문자�? ?��?��?�� 경우 기본값을 반환?��?��.
	 */
	public static long stringToLong(String str, long defaultNumber) {
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	
	/**
	 * 문자?��?�� ?��?���? �??��?��?�� 반환?��?��.
	 * @param str 문자?��
	 * @return ?��?��, ?��?���? ?��?�� 문자�? ?��?��?�� 경우 0?�� 반환?��?��.
	 */
	public static long stringToLong(String str) {
		return stringToLong(str, 0);
	}
	
	/**
	 * 문자?��?�� ?��?���? �??��?��?�� 반환?��?��.
	 * @param str 문자?��
	 * @param defaultNumber 기본�?
	 * @return ?��?��, ?��?���? ?��?�� 문자�? ?��?��?�� 경우 기본값이 반환?��?��.
	 */
	public static int stringToInt(String str, int defaultNumber) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	
	/**
	 * 문자?��?�� ?��?���? �??��?��?�� 반환?��?��.
	 * @param str 문자?��
	 * @return ?��?��, ?��?���? ?��?�� 문자�? ?��?��?�� 경우 0?�� 반환?��?��.
	 */
	public static int stringToInt(String str) {
		return stringToInt(str, 0);
	}
	
	/**
	 * 문자?��?�� ?��?���? �??��?��?�� 반환?��?��.
	 * @param str 문자?��
	 * @param defaultNumber 기본�?
	 * @return ?��?��, ?��?���? ?��?�� 문자�? ?��?��?�� 경우 기본값이 반환?��?��.
	 */
	public static double stringToDouble(String str, double defaultNumber) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	
	/**
	 * 문자?��?�� ?��?���? �??��?��?�� 반환?��?��.
	 * @param str 문자?��
	 * @return ?��?��, ?��?���? ?��?�� 문자�? ?��?��?�� 경우 0.0?�� 반환?��?��.
	 */
	public static double stringToDouble(String str) {
		return stringToDouble(str, 0.0);
	}
}









