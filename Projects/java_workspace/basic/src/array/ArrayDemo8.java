package array;

import java.util.Scanner;

public class ArrayDemo8 {

	public static void main(String[] args) {
		/*
		 *  5개의 정수를 입력받아서 그 중에 가장 큰 값을 출력하시오.
		 */
		
		Scanner scanner = new Scanner(System.in);
		
		// 배열생성
		int[] numbers = new int[5];
		
		// 5번 반복해서 숫자를 입력받고 배열에 담기
		for(int i =0; i<numbers.length; i++) {
			numbers[i] = scanner.nextInt();
		}
		// 최대값 구하기
		int max = 0;
		//배열에서 가장 큰 값을 찾아서 max에 담기
		for(int x : numbers) {
			if(x>max) {
				max = x;
			}
		}
		// 최대값 출력하기
		System.out.println("최대값 : "+max);
	}
}
