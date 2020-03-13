package control;

import java.util.Scanner;

public class WhileDemo3 {

	public static void main(String[] args) {
		// 1~100까지 임의의 정수를 하나 생성한다.
		// 사용자가 숫자를 입력하면 정수와 비교해서 up/down을 표시한다.
		// 사용자가 입력한 숫자와 임의의 정수가 일치하면
		// 몇번만에 맞췄는지 화면에 표시한다.
		
		Scanner scanner = new Scanner(System.in);
		int secretNumber = (int)(Math.random()*100+1);
		int inputcount = 0;
		while(true) {
			System.out.print("숫자를 입력하세요 : ");
			int answer = scanner.nextInt();
			inputcount++;
			// answer 과 secretNumber를 비교해서 일치하면 반복문 탈출
			//							       그렇지 않으면 두 수를 비교해서 UP/DOWN을 출력하고,
			//							       숫자 입력한 횟수도 1 증가 시킨다.
			if(secretNumber < answer) {
				System.out.println(answer+" 보다는 작아.");
			} else if (answer < secretNumber) {
				System.out.println(answer+" 보다는 커.");
			} else {
				break;
			}
		}
		System.out.println("정답 ! "+inputcount+" 번만에 맞췄고 정답은 "+secretNumber+"였습니다.");
	}
}
