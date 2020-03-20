package oop4;

public class Product {

	// this ---> 참조변수.
	// this() ---> 생성자메소드. 생성자에서 다른생성자를 호출할때(실행시킬때) 사용.
	String name;
	String maker;
	String category;
	int price; //가격
	double discountRate;
	int stock; //재고량
	boolean isSoldOut;
	
	Product() {}
	
	// 신제품 객체의 멤버변수 초기화에 적합한 생성자 메소드
	Product(String name, String maker, String category, int price, int stock){
		this(name,maker,category,price,0.0,stock,false);
	}
	
	// 이월 제품 객체의 멤버변수 초기화에 적합한 생성자 메소드
	Product(String name, String maker, String category, int price, double discountRate,int stock){
//		*this()메소드 사용전 코드
//		this.name = name;
//		this.maker = maker;
//		this.category = category;
//		this.price = price;
//		this.discountRate = discountRate;
//		this.isSoldOut = false;
		
		this(name, maker, category, price, discountRate, stock,false);
		
	}
	
	Product(String name, String maker, String category, 
			int price, double discountRate,int stock, boolean isSoldOut){
		this.name = name;
		this.maker = maker;
		this.category = category;
		this.price = price;
		this.discountRate = discountRate;
		this.stock = stock;
		this.isSoldOut = isSoldOut;
	}
	
	void display() {
		
		System.out.println("-------------- 상품정보 ----------------");
		System.out.println("상품이름 : "+ name);
		System.out.println("제조회사 : "+ maker);
		System.out.println("카테고리 : "+ category);
		System.out.println("판매가격 : "+ price);
		System.out.println("할인비율 : "+ discountRate);
		System.out.println("재고여부 : "+ stock);
		System.out.println("절판여부 : "+ isSoldOut);
		System.out.println("------------------------------------");
	}
}
