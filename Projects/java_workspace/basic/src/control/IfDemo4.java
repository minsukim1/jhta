package control;

import java.util.Scanner;

public class IfDemo4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		 *  고객의 등급(일반, 로얄, 플래티넘 중 하나)과 총구매금액을 입력 받는다.
		 *  고객의 등급이 플래티넘인 경우 구매금액의 10%를 할인한다.
		 *  		  로얄인 경우 구매금액의 3%를 할인한다.
		 *  		  일반인 경우 구매금액의 1%를 할인한다.
		 *  결제금액은 총구매금액에 할인된 금액만큼을 차감한 금액이다.
		 *  적립포인트는 결제금액의 3%를 적립한다.
		 *  
		 *  출력내용은
		 *  	총구매금액, 고객등급, 할인된 금액, 결제할 금액, 적립된 포인트
		 *  
		 */
		
		System.out.print("고객의 등급을 입력하세요(일반, 로얄, 플래티넘 중 하나) : ");
		String grade = scanner.next();
		System.out.print("총구매금액을 입력하세요 : ");
		int orderPrice = scanner.nextInt();
		
		int discount = 0;
		int price = 0;
		int point = 0;
		
		if(grade.equals("플래티넘")) {
			discount = (int) (orderPrice*0.1);
		} else if (grade.equals("로얄")) {
			discount = (int) (orderPrice*0.03);
		} else if (grade.equals("일반")) {
			discount = (int) (orderPrice*0.01);
		}
		price = orderPrice-discount;
		point = (int) (price*0.03);
		System.out.println("총 구매금액 : " + orderPrice);
		System.out.println("고 객 등 급 : " + grade);
		System.out.println("할인된금액 : " + discount);
		System.out.println("결제할금액 : " + price);
		System.out.println("적립된 포인트 : "+ point);
		
	}
}
