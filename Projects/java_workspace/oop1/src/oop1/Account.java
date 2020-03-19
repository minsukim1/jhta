package oop1;

public class Account {

	// 클래스 변수 - 상수 
	// 대문자로 적는것 -> 클래스명 , 상수(all대문자, 두단어합쳐질때 _(언더바))
	static final double RATE_OF_INTEREST = 0.021;
	
	// 인스턴스 변수
	String owner;		// 예금주
	String no;			// 계좌번호
	String password;	// 비밀번호
	int balance;		// 잔액
	int period;			// 예금기간(개월단위)
}
