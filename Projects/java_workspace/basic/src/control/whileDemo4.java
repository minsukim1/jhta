package control;

import java.util.Scanner;

public class whileDemo4 {
	public static void main(String[] args) {
	
		// 10000 ~ 99999 사이의 임의의 정수를 입력하세요.
		// 예 ) 입력값 : 12132 ---> 출력값 1 + 2 + 1 + 3 + 2 --> 9
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("임의의 5자리숫자를 입력하세요(10000 ~ 99999) : ");
		int inputNumber = scanner.nextInt();
		int sum = 0;
		while(inputNumber !=0) {
			sum += inputNumber%10;
			inputNumber /=10;
		}
		System.out.println("합계 : "+ sum);
	}
}
