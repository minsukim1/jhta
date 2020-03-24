package oop5;

import java.util.Arrays;
import java.util.Scanner;

public class OxQuiz {

	public static void main(String[] args) {
		int sum = 0;
		int count =0;
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
			for(int i=0; i<str.length; i++) {
				if(str[i].equals("O")){
					count++;
					sum +=count;
				} else if(str[i].equals("X")) {
					count = 0;
				}
			}
			if(arraySize == 0) {
				break;
			}
			System.out.println(Arrays.toString(str)+"--->"+sum);
			count = 0;
			sum = 0;
		}
	}
}
