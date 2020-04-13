package oop4;

public class ProductService {

	Product[] db = new Product[20];
	int position = 0;
	
	
	// 배열에 저장된 모든 상품정보를 출력한다.
	void printAllProducts() {
		System.out.println("=======================================");
		System.out.println("상품이름	제조회사	카테고리	판매가격	할인비율	재고여부	절판여부");
		System.out.println("=======================================");
		for(int i =0; i<position; i++) {
			Product product = db[i];
			System.out.print(product.name+"\t");
			System.out.print(product.maker+"\t");
			System.out.print(product.category+"\t");
			System.out.print(product.price+"\t");
			System.out.print(product.discountRate+"\t");
			System.out.print(product.stock+"\t");
			System.out.println(product.isSoldOut);
		}
	}	
	// 상품객체(새 상품, 이월상품)을 전달받아서 배열에 저장한다.
	void insertProduct(Product product) {
		db[position] = product;
		position++;
	}
	// 상품명과 입고량을 전달받아서 이미 배열에 저장된 상품의 재고량을 증가시킨다.
	void addProductStock(String name, int amount) {
		Product foundStock = null;
		for(int i =0; i<position; i++) {
			Product product = db[i];
			if(name.equals(product.name)) {
				if(product.stock == 0) {
					product.isSoldOut = false;
					product.stock += amount;
					foundStock= product;
				} else {
					product.stock += amount;
					foundStock= product;
				}
			} 	
		}
		if(foundStock!=null) {
			System.out.println("재고가 증가됐습니다 :" + foundStock.stock);
		} else {
			System.out.println("그런이름의 상품명은 없습니다.");
		}
}
	// 상품명과 출고량을 전달받아서 배열에서 해당 상품을 찾아서 재고량을 감소시킨다.
	// 단, 재고량보다 출고량이 많은 경우 오류 메세지를 표시한다.
	// 단, 재고량이 0이 되면 해당상품의 절판여부를 true로 설정한다.
	void exportProduct(String name, int amount) {
		Product foundStock = null;
		for(int i =0; i<position; i++) {
			Product product = db[i];
			if(name.equals(product.name)) {
				if(product.stock>amount) {
					product.stock -=amount;
					foundStock = product;
				} else if (product.stock == amount) {
					product.stock = 0;
					product.isSoldOut = true;
					foundStock = product;
				} else if (product.stock<amount) {
					System.out.println("재고량 보다 더 많습니다!");
					foundStock = product;
				}
			}
		}
		if(foundStock==null) {
			System.out.println("그런 이름의 상품명은 없습니다.");
		}
	}
	// 상품명을 전달받아서 배열에서 상품명이 일치하는 상품정보를 출략한다.
	void printProductsByName(String name) {
		for(int i =0; i<position; i++) {
			Product product = db[i];
			if(name.equals(product.name)) {
				product.display();
			}
		}
	}
	// 제조사명을 전달받아서 배열에서 제조사명이 일치하는 상품정보를 출력한다
	void printProductsByMaker(String maker) {
		for(int i=0; i<position; i++) {
			Product product = db[i];
			if(maker.equals(product.maker)) {
				product.display();
			}
		}
	}
	// 카테고리명을 전달받아서 배열에서 카테고리명이 일치하는 상품정보를 출력한다.
	void printProductsByCategory(String category) {
		for(int i=0; i<position; i++) {
			Product product = db[i];
			if(category.equals(product.category)) {
				product.display();
			}
		}
	}
	// 최저가격과 최고가격을 전달받아서 배열에서 해당 가격범위에 속하는 상품정보를 출력한다.
	void printProductsByPrice(int minPrice, int maxPrice) {
		for(int i =0; i<position; i++) {
			Product product = db[i];
			if(minPrice<=product.price && maxPrice>=product.price) {
				product.display();
			}
			
		}
		
	}
}
