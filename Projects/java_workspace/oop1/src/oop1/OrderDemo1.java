package oop1;

import java.util.Scanner;

public class OrderDemo1 {
	public static void main(String[] args) {
		/*
		 * 상품권 관리 프로그램 1. 메뉴 구성 1.조회 2.검색 3.입력 4.종료 2. 
		 * 입력내용 고객명 고객등급 총구매금액 고객등급은클래식,베스트,에이스,프리미어 중 하나를 입력한다. 
		 * 적립포인트는 고객등급별로 차등 적립된다. 프리미어: 총구매금액의 5% 에이스 :총구매금액의 3%
		 *  베스트 : 총구매금액의 2% 클래식 : 총구매금액의 1% 
		 *  사은품은 구매금액에 따라서 차등 지급된다. 
		 *  500만원 이상 :숙박권 100만원 이상 : 상품권 50 만원 이상 : 할인권 그 외 : 주차권
		 *   3. 조회에서 출력하는 내용 
		 *   고객명 	고객등급	 총구매금액	적립포인트	 사은품
		 *    =================================================
		 *   홍길동 	 에이스 	100000	3000 	주차권
		 *    김유신 프리미어	   7000000 350000	 숙박권 
		 *   강감찬  베스트  2000000 		 40000     상품권
		 *   4. 검색에서 입력하는내용 
		 * 검색조건을 입력하세요(N,G): * N은 이름, G는 등급
		 * 키워드를 입력하세요: 검색조건에 N을 입력하고 키워드에 이름을 입력해서 조회할 수 있다.
		 *  고객명이 입력한 이름과 일치하는 정보를 찾아서 출력한다. 
		 * 검색조건에 G를 입력하고 키워드에 등급을 입력해서 조회할 수있다. 
		 * 사은품이 입력한 내용과 일치하는 정보를 찾아서 출력한다.
		 * 
		 */
		
		Scanner scanner = new Scanner(System.in);
		Order[] orders = new Order[100];
		int savePosition = 0;
		
		while(true) {
			System.out.println("================================");
			System.out.println("1.조회   2.검색   3.입력   4.종료");
			System.out.println("================================");
			System.out.print("번호를 입력하세요 : ");
			int menuNo = scanner.nextInt();
			if(menuNo == 1) {
				System.out.println("[고객 조회]");
				System.out.println("고객명	고객등급	총구매금액	적립포인트	사은품");
				System.out.println("======================================");
				for(int i=0; i<savePosition; i++) {
					Order order = orders[i];
					System.out.print(order.name+"\t");
					System.out.print(order.grade+"\t");
					System.out.print(order.price+"\t");
					System.out.print(order.point+"\t");
					System.out.println(order.gift);
				}
			}else if(menuNo ==2) {
				System.out.println("[고객 검색]");
				System.out.print("검색조건을 입력하세요(N,G) : ");
				String search = scanner.next();
				Order foundOrder = null;
				if(search.equals("N")) {
					System.out.print("키워드를 입력하세요 : ");
					String name = scanner.next();
					for(int i=0; i<savePosition; i++) {
						Order order = orders[i];
						if(name.equals(order.name)) {
							foundOrder = order;
							break;
						}
					}
				}else if(search.equals("G")) {
					System.out.print("키워드를 입력하세요 : ");
					String grade = scanner.next();
					for(int i=0; i<savePosition; i++) {
						Order order = orders[i];
						if(grade.equals(order.grade)) {
							foundOrder = order;
							break;
						}
					}
				}
				if(foundOrder!=null) {
					System.out.println("=========출력 결과==========");
					System.out.println("고   객   명 : "+foundOrder.name);
					System.out.println("고 객 등 급 : "+foundOrder.grade);
					System.out.println("총구매금액 : "+foundOrder.price);
					System.out.println("적립포인트 : "+foundOrder.point);
					System.out.println("사   은   품 : "+foundOrder.gift);
					System.out.println("=========================");
				}else {
					System.out.println("일치하는 정보를 찾을수 없습니다.");
				}
			}else if(menuNo ==3) {
				System.out.print("고객명을 입력하세요 : ");
				String name = scanner.next();
				System.out.print("고객등급을 입력하세요 : ");
				String grade = scanner.next();
				System.out.print("총 구매금액을 입력하세요 : ");
				int totalPrice = scanner.nextInt();
				Order order = new Order();
				order.name = name;
				order.grade = grade;
				order.price = totalPrice;
				if(grade.equals("프리미어")) {
					order.point = (int)(totalPrice*0.05);
				} else if(grade.equals("에이스")) {
					order.point = (int)(totalPrice*0.03);
				} else if(grade.equals("베스트")) {
					order.point = (int)(totalPrice*0.02);
				} else if(grade.equals("클래식")) {
					order.point = (int)(totalPrice*0.01);
				}
				if(totalPrice >=5000000) {
					order.gift ="숙박권";
				}else if (totalPrice>=1000000) {
					order.gift = "상품권";
				}else if (totalPrice>=500000) {
					order.gift = "할인권";
				}else {
					order.gift = "주차권";
				}
				orders[savePosition] = order;
				savePosition++;
			}else if(menuNo ==4) {
				System.out.println("프로그램이 종료됩니다.");
				break;
			}
		}
	}
	
}
