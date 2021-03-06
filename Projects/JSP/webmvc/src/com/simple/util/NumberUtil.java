package com.simple.util;

import java.text.DecimalFormat;

public class NumberUtil {

	private static DecimalFormat currencyFormat = new DecimalFormat("#,###");
	
	/**
	 * ? ?λ₯? ","κ°? ?¬?¨? λ¬Έμ?΄λ‘? λ³???΄? λ°ν??€.
	 * @param number ? ?
	 * @return ","κ°? ?¬?¨? λ¬Έμ?΄
	 */
	public static String numberWithComma(long number) {
		return currencyFormat.format(number);
	}
	
	/**
	 * λ¬Έμ?΄? ? ?λ‘? λ³???΄? λ°ν??€.
	 * @param str λ¬Έμ?΄
	 * @param defaultNumber κΈ°λ³Έκ°?
	 * @return ? ?, ?«?κ°? ?? λ¬Έμκ°? ?¬?¨? κ²½μ° κΈ°λ³Έκ°μ λ°ν??€.
	 */
	public static long stringToLong(String str, long defaultNumber) {
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	
	/**
	 * λ¬Έμ?΄? ? ?λ‘? λ³???΄? λ°ν??€.
	 * @param str λ¬Έμ?΄
	 * @return ? ?, ?«?κ°? ?? λ¬Έμκ°? ?¬?¨? κ²½μ° 0?΄ λ°ν??€.
	 */
	public static long stringToLong(String str) {
		return stringToLong(str, 0);
	}
	
	/**
	 * λ¬Έμ?΄? ? ?λ‘? λ³???΄? λ°ν??€.
	 * @param str λ¬Έμ?΄
	 * @param defaultNumber κΈ°λ³Έκ°?
	 * @return ? ?, ?«?κ°? ?? λ¬Έμκ°? ?¬?¨? κ²½μ° κΈ°λ³Έκ°μ΄ λ°ν??€.
	 */
	public static int stringToInt(String str, int defaultNumber) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	
	/**
	 * λ¬Έμ?΄? ? ?λ‘? λ³???΄? λ°ν??€.
	 * @param str λ¬Έμ?΄
	 * @return ? ?, ?«?κ°? ?? λ¬Έμκ°? ?¬?¨? κ²½μ° 0?΄ λ°ν??€.
	 */
	public static int stringToInt(String str) {
		return stringToInt(str, 0);
	}
	
	/**
	 * λ¬Έμ?΄? ?€?λ‘? λ³???΄? λ°ν??€.
	 * @param str λ¬Έμ?΄
	 * @param defaultNumber κΈ°λ³Έκ°?
	 * @return ?€?, ?«?κ°? ?? λ¬Έμκ°? ?¬?¨? κ²½μ° κΈ°λ³Έκ°μ΄ λ°ν??€.
	 */
	public static double stringToDouble(String str, double defaultNumber) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	
	/**
	 * λ¬Έμ?΄? ?€?λ‘? λ³???΄? λ°ν??€.
	 * @param str λ¬Έμ?΄
	 * @return ?€?, ?«?κ°? ?? λ¬Έμκ°? ?¬?¨? κ²½μ° 0.0?΄ λ°ν??€.
	 */
	public static double stringToDouble(String str) {
		return stringToDouble(str, 0.0);
	}
}









