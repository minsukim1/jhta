package oop2;

import java.util.Scanner;

public class BankingDemo2 {
/*
 * BankingDemo2클래스를 작성하시오.
    BankingDemo2에 Banking객체를 여러 개 담는 배열을 생성하시오.
    BankingDemo2클래스에서는 Banking클래스를 이용해서
     신규계좌개설, 입금하기, 출금하기, 비번변경하기, 해지하기를 서비스하기
    BankingDemo2는 계좌정보에 대한 아래의 메뉴를 제공하시오
         =======================================================
      1.신규  2.조회  3.입금  4.출금  5.비번변경  6.해지  0.종료
      =======================================================
 */
	public static void main(String[] args) {
		Banking[] bankings = new Banking[100];
		Scanner scanner = new Scanner(System.in);
		int savePosition = 0;
		while (true) {
			System.out.println("==============================");
			System.out.println("1.신규  2.조회  3.입금  4.출금  5.비번변경  6.해지  0.종료");
			System.out.println("==============================");
			System.out.print("메뉴를선택하세요 : ");
			int menuNo = scanner.nextInt();
			if (menuNo == 1) {
				System.out.print("이름 : ");
				String name = scanner.next();
				System.out.print("계좌 : ");
				String num = scanner.next();
				System.out.print("비밀번호 : ");
				int password = scanner.nextInt();
				System.out.print("잔액 : ");
				long balance = scanner.nextLong();
				System.out.print("가입기간 : ");
				int period = scanner.nextInt();
				Banking banking = new Banking();
				banking.name = name;
				banking.no = num;
				banking.password = password;
				banking.balance = balance;
				banking.period = period;
				bankings[savePosition] = banking;
				savePosition++;
			} else if (menuNo == 2) {
				System.out.println("[계좌 조회]");
				System.out.print("계좌번호를 입력하세요 : ");
				String num = scanner.next(); 
				boolean isFound = false;
				for(int i =0; i<savePosition; i++) {
					Banking banking = bankings[i];
					if(num.equals(banking.no)) {
						banking.display();
						isFound = true;
					} 
				}
				if(!isFound) {
					System.out.println("일치하는 계좌가 없습니다.");
				}

			} else if (menuNo == 3) {
				System.out.println("[입금]");
				System.out.print("계좌번호를 입력하세요 : ");
				String num = scanner.next();
				System.out.print("입금액을 입력하세요 : ");
				long money = scanner.nextLong();
				for(int i =0; i<savePosition; i++) {
					Banking banking = bankings[i];
					if(num.equals(banking.no)) {
						banking.deposit(money);
					}
				}

			} else if (menuNo == 4) {
				System.out.println("[출금]");
				System.out.print("계좌번호 : ");
				String num = scanner.next();
				System.out.print("출금액 : ");
				long money = scanner.nextLong();
				System.out.print("비밀번호 : ");
				int password = scanner.nextInt();
				for(int i =0; i<savePosition; i++) {
					Banking banking = bankings[i];
					if (num.equals(banking.no)) {
						banking.withdraw(money, password);
					}
				}

			} else if (menuNo == 5) {
				System.out.println("[비밀번호 변경]");
				System.out.print("계좌번호 : ");
				String num = scanner.next();
				System.out.print("이전 비밀번호 : ");
				int oldPwd = scanner.nextInt();
				System.out.print("새 비밀번호 : ");
				int newPwd = scanner.nextInt();
				for(int i =0; i<savePosition; i++) {
					Banking banking = bankings[i];
					if(num.equals(banking.no)) {
						banking.changePassword(oldPwd, newPwd);
					}
				}
			} else if (menuNo == 6) {
				System.out.println("[해지]");
				System.out.print("계좌번호 : ");
				String num = scanner.next();
				System.out.print("비밀번호 : ");
				int pwd = scanner.nextInt();
				for(int i =0; i<savePosition; i++) {
					Banking banking = bankings[i];
					if(num.equals(banking.no)) {
						System.out.println("총해지금액 : "+banking.close(pwd));
					}
				}
			} else if (menuNo == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;

			}

		}
		scanner.close();
	}
}
