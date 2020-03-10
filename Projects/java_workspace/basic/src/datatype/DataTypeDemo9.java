package datatype;

public class DataTypeDemo9 {

	public static void main(String[] args) {
		/*
		 * 홍길동 고객은
		 * 		3만원짜리 셔츠 3장
		 * 		10만원짜리 청바지 2장
		 * 		50만원짜리 구두 1켤레를 구매했다.
		 * 홍길동 고객의 총구매금액을 출력하기
		 * 해당 사이트에서는 구매금액의 3% 포인트로 적립시킨다. (포인트는 정수값만 사용한다.)
		 * 홍길동 고객이 이번 주문에서 적립한 포인트를 출력하기
		 */
		int shirtPrice = 30000;
		int shirtAmount = 3;
		int jeanPrice = 100000;
		int jeanAmount = 2;
		int shoesPrice = 500000;
		int shoesAmount = 1;
		
		int shirtOrderPrice = shirtPrice * shirtAmount;
		int jeanOrderPrice = jeanPrice * jeanAmount;
		int shoesOrderPrice = shoesPrice * shoesAmount;
		
		int totalOrderPrice = shirtOrderPrice + jeanOrderPrice + shoesOrderPrice;	
		//int depositpoint = (totalOrderPrice/100)*3;
		int depositpoint = (int) (totalOrderPrice * 0.03);
		
		System.out.println("홍길동 고객님의 총 구매 금액은 : "+ totalOrderPrice + "입니다.");
		System.out.println("홍길동 고객님이 이번 주문에서 적립된 포인트는 : "+ depositpoint+ "입니다.");
	}

}
