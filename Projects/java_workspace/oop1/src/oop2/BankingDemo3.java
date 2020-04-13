package oop2;

import java.util.Scanner;

public class BankingDemo3 {

	public static void main(String[] args) {
		
		BankingService service = new BankingService();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println();
			System.out.println("[계좌관리 프로그램]");
			System.out.println("---------------------------------");
			System.out.println("1.조회  2.검색  3.신규  4.입금  5.출금  6.해지  0.종료");
			System.out.println("---------------------------------");
			
			System.out.print("메뉴를 선택하세요 : ");
			int menuNo = scanner.nextInt();

			if (menuNo == 1) {
				System.out.println("전체 계좌 조회");
				service.printAllBankings();
			} else if (menuNo == 2) {
				System.out.print("검색할 계좌번호를 입력하세요 : ");
				String no = scanner.next();
				service.printBankingByNo(no);
			} else if (menuNo == 3) {
				System.out.println("[신규 계좌개설에 필요한 정보를 입력해주세요.");
				System.out.print("고객명을 입력하세요 : ");
				String name = scanner.next();
				System.out.print("비밀번호를 입력하세요 : ");
				int pwd = scanner.nextInt();
				System.out.print("첫 입금액을 입력하세요 : ");
				long money = scanner.nextLong();
				
				service.addNewBanking(name, pwd, money);
			} else if (menuNo == 4) {
				// 계좌번호, 입금액을 전달받아서 해당계좌에 가입하는서비스
				System.out.println("[입금]");
				System.out.print("계좌번호를 입력하세요 : ");
				String no = scanner.next();
				System.out.print("입금액을 입력하세요 : ");
				long money = scanner.nextLong();
				
				service.depositToBank(no, money);
				

			} else if (menuNo == 5) {
				// 계좌번호, 비밀번호, 출금액을 전달받아서 출금액만큼 반환하는 서비스
				System.out.println("[출금]");
				System.out.print("계좌번호를 입력하세요 : ");
				String no = scanner.next();
				System.out.print("비밀번호를 입력하세요 : ");
				int pwd = scanner.nextInt();
				System.out.print("출금액을 입력하세요 : ");
				long money = scanner.nextLong();
				
				service.withdrawFromBanking(no, pwd, money);
			} else if (menuNo == 6) {
				// 계좌번호, 비밀번호를 전달받아서 계좌를 해지하고, 해지금액 전체를 반환하는 서비스
				System.out.println("[해지]");
				System.out.print("계좌번호를 입력하세요 : ");
				String no = scanner.next();
				System.out.print("비밀번호를 입력하세요 : ");
				int pwd = scanner.nextInt();
				System.out.println("해지반환금 : "+service.closeBanking(no, pwd));
			} else if (menuNo == 0) {
				System.out.println("프로그램 종료");
				break;
				
			}
		}
		scanner.close();
	}
}
