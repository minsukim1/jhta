package com.sample.bookstore;

import java.util.Scanner;

import com.sample.bookstore.service.BookStoreService;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.User;
import com.sample.bookstore.vo.Rental;

public class BookstoreApp {

	public static void main(String[] args) {

		BookStoreService service = new BookStoreService();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println();
			System.out.println("[도서 대여점 관리 프로그램");
			System.out.println("=========================================");
			System.out.println("1.회원관리      2.도서관리      3.대여/반납관리      0.종료");
			System.out.println("=========================================");

			System.out.print("메뉴를 선택하세요 : ");
			int menuNo = scanner.nextInt();

			if (menuNo == 1) {
				System.out.println("[회원 관리]");
				System.out.println("=========================================");
				System.out.println("1.등록   2.조회   3.변경   4.탈퇴   5.전체조회");
				System.out.println("=========================================");

				System.out.print("메뉴를 선택하세요 : ");
				int userNo = scanner.nextInt();// 숫자선택

				if (userNo == 1) {
					// 등록 service. userservice + user
					System.out.println("[신규 회원 등록]");
					System.out.print("이름을 입력하세요 : ");
					String name = scanner.next();
					System.out.print("전화번호를 입력하세요 : ");
					String tel = scanner.next();

					service.addNewUser(name, tel);
					System.out.println("###회원 등록이 완료되었습니다.");
				} else if (userNo == 2) {
					// 조회
					System.out.print("조회할 회원번호를 입력하세요 : ");
					int userNum = scanner.nextInt();
					service.retrieveUserInfo(userNum);
				} else if (userNo == 3) {
					// 변경
					System.out.print("변경할 회원의 회원번호를 입력하세요 : ");
					int cUser = scanner.nextInt();
					System.out.print("변경할 이름을 입력하세요 : ");
					String cName = scanner.next();
					System.out.print("변경할 전화번호를 입력하세요 : ");
					String cTel = scanner.next();
					System.out.print("변경할 포인트를 입력하세요 : ");
					int cPoint = scanner.nextInt();
					User cuser = new User(cUser, cName, cTel, cPoint, false);
					service.modifyUserInfo(cuser);
					System.out.println("수정되었습니다.");
				} else if (userNo == 4) {
					System.out.println("탈퇴할 회원의 회원번호를 입력하세요 : ");
					int number = scanner.nextInt();
					service.disabledUser(number);

				} else if (userNo == 5) {
					System.out.println("[전체 회원 조회]");
					service.retrieveAllUsers();
				}
			} else if (menuNo == 2) {
				System.out.println("[도서 관리]");
				System.out.println("=========================================");
				System.out.println("1.검색    2.등록    3.수정  4.전체조회");
				System.out.println("=========================================");
				System.out.print("메뉴를 선택하세요 : ");
				int bookNo = scanner.nextInt();

				if (bookNo == 1) {
					System.out.println("검색할 도서의 번호를 입력하세요  : ");
					int bookNum = scanner.nextInt();
					service.findBookByNo(bookNum);

				} else if (bookNo == 2) {
					System.out.print("등록할 도서의 제목을 입력하세요 : ");
					String title = scanner.next();
					System.out.print("등록할 도서의 저자를 입력하세요 : ");
					String writer = scanner.next();
					System.out.print("등록할 도서의 가격을 입력하세요 : ");
					int price = scanner.nextInt();

					service.insertNewBook(title, writer, price);
					System.out.println("등록 완료!");
				} else if (bookNo == 3) {
					// 수정
					System.out.print("수정할 책의 번호를 입력하세요 : ");
					int bNum = scanner.nextInt();
					System.out.print("수정할 책의 제목을 입력하세요 : ");
					String bTitle = scanner.next();
					System.out.print("수정할 책의 저자를 입력하세요 : ");
					String bWriter = scanner.next();
					System.out.print("수정할 책의 가격을 입력하세요 : ");
					int bPrice = scanner.nextInt();
					Book book = new Book(bNum, bTitle, bWriter, bPrice, 10000);
					service.modifyBook(book);
				} else if (bookNo == 4) {
					System.out.println("[전체 도서 조회]");
					service.retrieveAllBooks();
				}

			} else if (menuNo == 3) {
				System.out.println("[대여/반납 관리");
				System.out.println("=========================================");
				System.out.println("1.대여  2.반납   3.대여현황조회");
				System.out.println("=========================================");

				System.out.print("메뉴를 선택하세요 : ");
				int rentalNo = scanner.nextInt();

				if (rentalNo == 1) {
					System.out.println("[대여 시스템]");
					System.out.println("사용자 번호를 입력하세요 :");
					int sNum = scanner.nextInt();
					System.out.println("대여하실 도서번호를 입력하세요 : ");
					int dNum = scanner.nextInt();
					service.rentBook(sNum, dNum);
					System.out.println("대여 완료");
				} else if (rentalNo == 2) {
					System.out.println("[반납 시스템]");
					System.out.println("대여 번호를 입력하세요 : ");
					int renNum = scanner.nextInt();
					service.returnBook(renNum);
					System.out.println("반납 완료");
				} else if (rentalNo == 3) {
					System.out.println("[대여 현황 조회]");
					service.retrieveAllRentals();
				}
			} else if (menuNo == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
