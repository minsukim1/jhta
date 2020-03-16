package array;

import java.util.Scanner;

public class ArrayDemo12 {

	public static void main(String[] args) {
		/*
		 *  상품명, 가격, 구매수량을 입력받아서 총 구매가격을 출력하는 프로그램 
		 */
		Scanner scanner = new Scanner(System.in);
		
		String[] names = new String[3];
		int[] prices = new int[3];
		int[] amounts = new int[3];
		int totalOrderPrice = 0;
		// 상품명, 가격, 구매수량을 입력받는다.
		for(int i =0; i<prices.length; i++) {
			System.out.print("상품명을 입력하세요 : ");
			names[i] = scanner.next();
			System.out.print("가격을 입력하세요 : ");
			prices[i] = scanner.nextInt();
			System.out.print("구매수량을 입력하세요 : ");
			amounts[i] = scanner.nextInt();
		}
		// 구매정보 출력하기
		System.out.println("순번	상품명	가격	수량	구매가격");
		System.out.println("======================================");
		for(int i =0; i<prices.length; i++) {
			System.out.print(i+1+"\t"+names[i]+"\t"+prices[i]+"\t"+amounts[i]+"\t"+(prices[i]*amounts[i]));
			System.out.println();
			totalOrderPrice +=(prices[i]*amounts[i]);
		}
		System.out.println("======================================");
		System.out.print("\t\t\t\t"+totalOrderPrice);
	}
}
