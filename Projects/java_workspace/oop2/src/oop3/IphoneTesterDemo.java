package oop3;

public class IphoneTesterDemo {

	public static void main(String[] args) {
		
		IphoneTester tester = new IphoneTester();
		
		Iphone p1 = new Iphone();
		Iphone8 p2 = new Iphone8();
		IphoneX p3 = new IphoneX();
		Iphone11 p4 = new Iphone11();
		Galaxy p5 = new Galaxy();
		
		tester.testIPhone(p1);
		tester.testIPhone(p2);
		tester.testIPhone(p3);
		tester.testIPhone(p4);
		
		System.out.println("##### Iphone 객체 테스트 실시");
		tester.testIPhone(p1);
		System.out.println("##### Iphone8 객체 테스트 실시");
		tester.testIPhone(p2);
		System.out.println("##### IphoneX 객체 테스트 실시");
		tester.testIPhone(p3);
		System.out.println("##### Iphone11 객체 테스트 실시");
		tester.testIPhone(p4);
		//tester.testIphone(p5); // 오류 Iphone타입류가 아닌것은 전달할수없다.
	}
}
