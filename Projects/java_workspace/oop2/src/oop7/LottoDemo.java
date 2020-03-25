package oop7;

import java.util.Arrays;

public class LottoDemo {

	public static void main(String[] args) {
		
		Lotto lotto = new Lotto();
		int[] number1 = lotto.generateNumbers();
		System.out.println(Arrays.toString(number1));
	}
}
