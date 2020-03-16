package array;

import java.util.Scanner;

public class ArrayDemo9 {

	public static void main(String[] args) {
		/*
		 *  숫자를 10개 입력받아서 그 중에 짝수들의 합계만 구해서 출력하기
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		int[] numbers = new int[10];
		
		for(int i =0; i<numbers.length; i++) {
			System.out.print("숫자를 입력하세요 : ");
			numbers[i] = scanner.nextInt();
		}
		int sum = 0;
		for (int x : numbers) {
			if(x%2==0) {
				sum +=x;
			}
		}
		System.out.println(sum);
	}
}
