package oop5;

import java.util.Arrays;
import java.util.Scanner;

public class OxQuiz {

	public static void main(String[] args) {

		OxQuizService Ox1 = new OxQuizService();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("배열의 크기를 결정하세요. 0을누르면 종료됩니다 : ");
			int arraySize = scanner.nextInt();
			String[] str = new String[arraySize];
			for(int i=0; i<str.length; i++) {
				System.out.print("배열str["+i+"]값을 정하세요(O, X) : ");
				String num = scanner.next();
				str[i] = num;
			}
			if(arraySize == 0) {
				break;
			}
			
			Ox1.calcu(str);
		}
	}
}
