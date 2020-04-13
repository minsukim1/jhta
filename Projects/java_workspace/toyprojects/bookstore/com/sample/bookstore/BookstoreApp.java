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
				System.out.println("1.등록   2.조회   3.변경   4.탈퇴   5.전체조회 6.대여 현황 조회");
				System.out.println("=========================================");

				System.out.print("메뉴를 선택하세요 : ");
				int userMenuNo = scanner.nextInt();// 숫자선택

				if (userMenuNo == 1) {
					// 등록 service. userservice + user
					System.out.println("[신규 회원 등록]");
					System.out.print("이름을 입력하세요 : ");
					String name = scanner.next();
					System.out.print("전화번호를 입력하세요 : ");
					String tel = scanner.next();

					service.addNewUser(name, tel);
					System.out.println("###회원 등록이 완료되었습니다.");
				} else if (userMenuNo == 2) {
					// 조회
					System.out.print("조회할 회원번호를 입력하세요 : ");
					int userNum = scanner.nextInt();

					service.retrieveUserInfo(userNum);

				} else if (userMenuNo == 3) {
					// 변경
					System.out.print("변경할 회원의 회원번호를 입력하세요 : ");
					int userNo = scanner.nextInt();
					System.out.print("변경할 이름을 입력하세요 : ");
					String userName = scanner.next();
					System.out.print("변경할 전화번호를 입력하세요 : ");
					String userTel = scanner.next();

					User user = new User();
					user.no = userNo;
					user.name = userName;
					user.tel = userTel;

					service.modifyUserInfo(user);
					System.out.println("수정되었습니다.");
				} else if (userMenuNo == 4) {
					System.out.println("탈퇴할 회원의 회원번호를 입력하세요 : ");
					int userNo = scanner.nextInt();

					service.disabledUser(userNo);

				} else if (userMenuNo == 5) {
					System.out.println("[전체 회원 조회]");

					service.retrieveAllUsers();
				} else if (userMenuNo == 6) {
					System.out.println("[대여 현황 조회]");
					System.out.print("조회할 회원의 이름을 입력하세요 : ");
					String userName = scanner.next();

					service.retrieveAllUserRentals(userName);

				}
			} else if (menuNo == 2) {
				System.out.println("[도서 관리]");
				System.out.println("==================================================");
				System.out.println("1.검색    2.등록    3.수정  4.전체조회  5.책대여회원조회 6.책 제목찾기");
				System.out.println("==================================================");
				System.out.print("메뉴를 선택하세요 : ");
				int bookMenuNo = scanner.nextInt();

				if (bookMenuNo == 1) {
					System.out.println("검색할 도서의 번호를 입력하세요  : ");
					int bookNum = scanner.nextInt();

					service.findBookByNo(bookNum);
				} else if (bookMenuNo == 2) {
					System.out.print("등록할 도서의 제목을 입력하세요 : ");
					String title = scanner.next();
					System.out.print("등록할 도서의 저자를 입력하세요 : ");
					String writer = scanner.next();
					System.out.print("등록할 도서의 가격을 입력하세요 : ");
					int price = scanner.nextInt();

					service.insertNewBook(title, writer, price);
					System.out.println("등록 완료!");
				} else if (bookMenuNo == 3) {
					// 수정
					System.out.print("수정할 책의 번호를 입력하세요 : ");
					int bookNo = scanner.nextInt();
					System.out.print("수정할 책의 제목을 입력하세요 : ");
					String bookTitle = scanner.next();
					System.out.print("수정할 책의 저자를 입력하세요 : ");
					String bookWriter = scanner.next();
					System.out.print("수정할 책의 가격을 입력하세요 : ");
					int bookPrice = scanner.nextInt();

					Book book = new Book(bookNo, bookTitle, bookWriter, bookPrice, 10000);
					service.modifyBook(book);
				} else if (bookMenuNo == 4) {
					System.out.println("[전체 도서 조회]");

					service.retrieveAllBooks();
				} else if (bookMenuNo == 5) {
					System.out.println("[책 대여 회원 조회]");
					System.out.print("도서번호를 입력하세요 : ");
					int bookNo = scanner.nextInt();

					service.retrieveUserByBookNo(bookNo);
				} else if (bookMenuNo == 6) {
					System.out.println("[책 제목으로 찾기]");
					System.out.print("책 제목을 입력하세요 : ");
					String bookTitle = scanner.next();
					
					service.searchBooks(bookTitle);
				}

			} else if (menuNo == 3) {
				System.out.println("[대여/반납 관리");
				System.out.println("=========================================");
				System.out.println("1.대여  2.반납   3.대여현황조회 4.일괄반납처리");
				System.out.println("=========================================");

				System.out.print("메뉴를 선택하세요 : ");
				int rentalMenuNo = scanner.nextInt();

				if (rentalMenuNo == 1) {
					System.out.println("[대여 시스템]");
					System.out.println("사용자 번호를 입력하세요 :");
					int userNo = scanner.nextInt();
					System.out.println("대여하실 도서번호를 입력하세요 : ");
					int bookNo = scanner.nextInt();

					service.rentBook(userNo, bookNo);
					System.out.println("대여 완료");
				} else if (rentalMenuNo == 2) {
					System.out.println("[반납 시스템]");
					System.out.println("대여 번호를 입력하세요 : ");
					int renNum = scanner.nextInt();

					service.returnBook(renNum);
					System.out.println("반납 완료");
				} else if (rentalMenuNo == 3) {
					System.out.println("[대여 현황 조회]");

					service.retrieveAllRentals();
				} else if (rentalMenuNo == 4) {
					System.out.println("[일괄 반납 처리]");
					System.out.print("반납처리할 회원의 회원번호를 입력하세요 : ");
					int rentalUser = scanner.nextInt();

					service.retrieveAllUserNo(rentalUser);

				}
			} else if (menuNo == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
