package control;

import java.util.Scanner;

public class ForDemo3 {

	public static void main(String[] args) {
		// 정수 2개를 입력받아서 두 정수 사이의 숫자를 더한 값을 구하기
		// 예) 	10 13
		// 		10 + 11 + 12 + 13 --->
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫 번째 숫자를 입력하세요 : ");
		int firstNumber = scanner.nextInt();
		System.out.println("두 번째 숫자를 입력하세요 : ");
		int secondNumber = scanner.nextInt();
		
		int sum = 0;
		if(firstNumber<secondNumber) {
			for(int i =firstNumber; i<=secondNumber; i++) {
				sum += i;
			}
			System.out.println(firstNumber+" 와 "+secondNumber+"를 포함한 두정수 사이의 숫자를 더한 값은 : "+sum+"입니다.");
		} else if (firstNumber>secondNumber) {
			for(int i =secondNumber; i<=firstNumber; i++) {
				sum += i;
			}
			System.out.println(firstNumber+" 와 "+secondNumber+"를 포함한 두정수 사이의 숫자를 더한 값은 : "+sum+"입니다.");
		} else {
			sum = firstNumber + secondNumber;
			System.out.println("두 숫자가 같습니다. 더한 값은"+sum+"입니다.");
		}
	}
}
