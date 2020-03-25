package com.sample.bookstore.service;

import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Rental;
import com.sample.bookstore.vo.User;

public class BookStoreService {

	BookService bookService = new BookService();
	UserService userService = new UserService();
	RentalService rentalService = new RentalService();

	// 회원등록
	public void addNewUser(String name, String tel) {
		User user = new User();
		user.name = name;
		user.tel = tel;
		user.point = 100;
		user.isDisabled = false;

		userService.insertUser(user);
	}
	// 회원조회
	public void retrieveUserInfo(int userNo) {

		User user = userService.findUserByNo(userNo);
		System.out.println("회원번호 : " + user.no);
		System.out.println("이름 : " + user.name);
		System.out.println("전화번호 : " + user.tel);
		System.out.println("포인트 : " + user.point);
		System.out.println("탈퇴 여부 : "+ user.isDisabled);
	}
	// 회원변경 서비스
	public void modifyUserInfo(User user) {

		userService.updateUser(user);

	}
	// 회원탈퇴 서비스
	// - RentalService의 반납기능을 실행해서 해당 회원이 대여중인 모든 책을 반납처리한다.
	public void disabledUser(int userNo) {
		User user = userService.findUserByNo(userNo);
		user.isDisabled = true;
		rentalService.returnAllRentalByUserNo(userNo);
		

	}
	// 전체 회원조회 서비스
	public void retrieveAllUsers() {
		User db[] = userService.getAllUsers();
		for (int i = 0; i < db.length; i++) {
			if (db[i] == null) {
				break;
			}
			System.out.println("회원번호 : " + db[i].no);
			System.out.println("이름 : " + db[i].name);
			System.out.println("전화번호 : " + db[i].tel);
			System.out.println("포인트 : " + db[i].point);
			System.out.println("탈퇴 여부 : "+ db[i].isDisabled);
			System.out.println();
		}

	}
	// 도서등록 서비스
	public void insertNewBook(String title, String writer, int price) {

		Book book = new Book();
		book.title = title;
		book.writer = writer;
		book.price = price;
		book.stock = 10000;
		bookService.insertBook(book);

	}

	// 도서 검색 서비스
	public void findBookByNo(int bookNo) {
		Book book = bookService.findBookByNo(bookNo);
		System.out.println("책 번호 : " + book.no);
		System.out.println("책 제목 : " + book.title);
		System.out.println("저자 : " + book.writer);
		System.out.println("가격 : " + book.price);
		System.out.println("재고 : " + book.stock);

	}

	// 도서 정보 수정 서비스
	public void modifyBook(Book book) {
		bookService.updateBook(book);
	}

	// 전체 도서조회 서비스
	public void retrieveAllBooks() {
		Book db[] = bookService.getAllBooks();
		for (int i = 0; i < db.length; i++) {
			if (db[i] == null) {
				break;
			}
			System.out.println("도서번호 : " + db[i].no);
			System.out.println("도서제목 : " + db[i].title);
			System.out.println("저자 : " + db[i].writer);
			System.out.println("가격 : " + db[i].price);
			System.out.println("재고 : " + db[i].stock);
			System.out.println();
		}
	}
	// 대여 서비스
	// 사용자번호와 책번호를 전달받아서 대여 서비스를 처리한다.
	// - Rental객체를 생성해서 사용자번호, 책번호를 저장한다.
	// - 대여여부는 대여중으로 설정한다.
	// - 책재고 변경하기
	// - BookService에서 책번호에 해당하는 책정보 조회기능 실행
	// - 조회된 책의 재고를 1감소시킨다.
	public void rentBook(int userNo, int bookNo) {
		Rental rental = new Rental();
		rental.userNo = userNo;
		rental.bookNo = bookNo;
		rental.isRent = true;
		Book book = bookService.findBookByNo(bookNo);
		User user = userService.findUserByNo(userNo);
		book.stock--;
		rentalService.insertRental(rental);
		

	}

	// 반납 서비스
	public void returnBook(int no) {
		Rental rental = rentalService.findRentalByNo(no);
		rental.isRent = false;
		User user = userService.findUserByNo(rental.userNo);
		Book book = bookService.findBookByNo(rental.bookNo);
		user.point += (int)(book.price*0.01);
		book.stock++;
	}

	// 대여현황 조회 서비스
	// 모든 대여정보를 조회하는 서비스를 처리한다.
	// - RentalService의 전체 대여정보조회 기능을 실행한다.
	// - 조회된 대여정보를 화면에 출력한다. (null체크)
	public void retrieveAllRentals() {
		Rental db[] = rentalService.getAllRentals();
		for (int i = 0; i < db.length; i++) {
			if (db[i] == null) {
				break;
			}
			System.out.println("대여번호 : " + db[i].no);
			System.out.println("회원번호 : " + db[i].userNo);
			System.out.println("도서번호 : " + db[i].bookNo);
			System.out.println("대여중인지 : " + db[i].isRent);
			System.out.println();
		}

	}
}
