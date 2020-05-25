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
}
