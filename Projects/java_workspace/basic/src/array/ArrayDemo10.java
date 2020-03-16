package array;

import java.util.Scanner;

public class ArrayDemo10 {

	public static void main(String[] args) {
		/* 
		 * 숫자를 10개 입력받아서 인접한 두 수의 차이가 가장 많이 나는 숫자를 각각 출력하기
		 */
		Scanner scanner = new Scanner(System.in);
		// 배열 생성하기
		int[] numbers = new int[10];
		for(int i =0; i<numbers.length; i++) {
			System.out.print("숫자를 입력하세요 : ");
			numbers[i] = scanner.nextInt();
		}
		// 출력한 값을 담는 변수 만들기
		int prev = 0;
		int next = 0;
		int gap = 0;
		int mx = 0;
		// 인접한 숫자들간의 차이를 계산해서 가장 차이가 큰 숫자와 그 차이를 구하기
		for(int i = 0; i<numbers.length-1; i++) {
			gap = Math.abs(numbers[i]-numbers[i+1]);
			if(mx<gap) {
				mx = gap;
				prev = numbers[i];
				next = numbers[i+1];
			}
		}
		System.out.print(prev+" "+next+" "+mx);
	}
}
