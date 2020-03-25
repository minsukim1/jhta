package com.sample.bookstore.service;

import com.sample.bookstore.vo.Rental;
import com.sample.bookstore.vo.User;

public class RentalService {
	private Rental[] db = new Rental[100];
	private int position = 0;
	private int rentalSequence = 50001;

	// 대여정보 저장 기능
	// 전달받은 대여정보를 db에 저장한다.
	public void insertRental(Rental rental) {
		rental.no = rentalSequence;
		db[position] = rental;
		position++;
		rentalSequence++;
	}
	
	// 대여정보 조회기능
	// 대여번호에 해당하는 대여정보를 반환한다.
	public Rental findRentalByNo(int rentalNo) {
		Rental result = null;
		for(int i =0; i<position; i++) {
			if(rentalNo==db[i].no) {
				result = db[i];
			}
		}
		return result;
	}
	
	// 반납처리 기능
	// 사용자번호를 전달받아서 그 사용자의 모든 대여도서를 반납처리하는 기능
	public void returnAllRentalByUserNo(int userNo) {
		for(int i =0; i<position; i++) {
			if(db[i].userNo==userNo) {
				db[i].isRent = true;
			}
			
		}
	}
	
	// 대여현황조회기능
	// 모든 대여정보를 반환한다.
	public Rental[] getAllRentals() {
		return db;
	}
}
