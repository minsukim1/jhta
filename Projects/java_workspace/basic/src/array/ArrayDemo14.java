package array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo14 {

	public static void main(String[] args) {
		/*
		 *  숫자야구게임
		 *  숫자3개의 난수를 발생시키는 배열 만들기
		 *  숫자3개를 입력받는 배열 만들기
		 *  위치와 숫자가 모두 일치하면 -> Strike
		 *  숫자만 일치하면 -> Ball
		 *  탈출조건
		 *  	10번안에 못 맞추거나/Strike = 3이거나
		 */
		Scanner sc = new Scanner(System.in);
		int[] random = new int[3];
		for(int i =0; i<random.length; i++) {
			random[i] = (int)(Math.random()*9+1);
			for(int j=0; j<i; j++) {
				if(random[i] == random[j]) {
					i--;
				}
			}
		}
		int[] numbers = new int[3];
		int count = 0;
		while(true) {
			int strike = 0;
			int ball = 0;
			System.out.print("첫 번째 숫자를 입력하세요 : ");
			numbers[0] = sc.nextInt();
			System.out.print("두 번째 숫자를 입력하세요 : ");
			numbers[1] = sc.nextInt();
			System.out.print("세 번째 숫자를 입력하세요 : ");
			numbers[2] = sc.nextInt();
			count++;
			for (int i = 0; i < numbers.length; i++) {
				if (random[i] == numbers[i]) {
					strike+=1;
				}
				for (int j = i + 1; j < numbers.length; j++) {
					 if (random[i] == numbers[j] && numbers[i] ==random[j] ) {
						ball+=2;
					} else if (numbers[i] == random[j] || random[i] == numbers[j]) {
						ball+=1;
					}
				}
			}
			if(strike==3) {
				System.out.println("정답");
				break;
			}
			System.out.println(strike+"S "+ball+"B ");
			System.out.println(count+" 번시도");
			if(count==10) {
				System.out.println("실패 답은 : "+Arrays.toString(random));
				break;
			}	
		}
	}
}

