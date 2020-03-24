package oop3;

public class IphoneTester {

	void testIPhone(Iphone p) {
		p.applemusic();
		p.siri();

		if (p instanceof Iphone8) {
			// p에 전달된 객체가 Iphone8이라면 지문인식기능 실행해보기
			Iphone8 i8 = (Iphone8) p;
			i8.fingerScan();
			System.out.println("아이폰8의 지문인식기능 테스트 완료");
		} else if (p instanceof Iphone11) {
			// p에 전달된 객체가 Iphone11이라면 카메라기능 실행해보기
			((Iphone11) p).tripleCamera();
			System.out.println("아이폰11위 짱 좋은 카메라 기능 테스트 완료");

		} else if (p instanceof IphoneX) {
			// p에 전달된 객체가 IphoneX라면 얼굴인식기능 실행해보기
			((IphoneX) p).faceScan();
			System.out.println("아이폰X의 얼굴인식기능 테스트 완료");
		}
	}

	//  instanceof 연산자
	//	참조변수가 참조하는 객체의 실제 타입을 확인하는 연산자.
	//	사용법 ---> 참조변수 instanceof 클래스명     결과 ---> true:검사에 사용됐던 타입으로 형변환이 가능하다. false:검사에 사용했던 타입으로 형변환이 불가능하다.
	
	// 	p가 참조하는 객체가 Iphone 타입의 객체인가?
	//	p instanceof Iphone     -----> true
	//	p가 참조하는 객체가 Galaxy타입의 객체인가?
	//	p instanceof Galaxy     -----> false
	
	//	p instanceof SmartPhone -----> true
	//	p instanceof Phone      -----> true
	
}
