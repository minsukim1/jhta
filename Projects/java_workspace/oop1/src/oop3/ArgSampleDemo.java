package oop3;

public class ArgSampleDemo {

	public static void main(String[] args) {
		
		
		ArgSample sample = new ArgSample();
		
		// 기본자료형 변수가 가지고 있는 값을 메소드 호출 시 전달한 경우
		// Call By Value
		// 	메소드의 매개변수에 기본자료형 값을 전달해서 메소드를 실행하는 것
		//	호출된 메소드에서 전달받은 값을 변경해도 원래 값은 변경되지 않는다.
		int num = 100;
		
		System.out.println("main()에서 changeValue() 수행 전 num --->"+num);
		sample.changeValue(num); // <---- num 변수가 가지고 있는 값을 전달
		System.out.println("main()에서 changeValue() 수행 후 num --->"+num);
		
		// 참조형 변수가 가지고 있는 주소값을 메소드 호출시 전달한 경우
		// Call By Reference
		//	메소드의 매개변수에 객체의 참조값(주소값을) 전달해서 메소드를 실행하는 것
		//	호출된 메소드에서도 원본 객체를 같이 참조하게 된다.
		//	호출된 메소드에서 전달받은 주소값으로 참조되는 객체의 속성을 변경하는 것은
		//	원본 객체의 속성을 변경하는 것이 된다.
		
		Data data = new Data();
		data.num = 200;
		
		System.out.println("main()에서 changeDataValue() 수행 전 data.num ---> " + data.num);
		sample.changeDataValue(data); // <==== data 변수가 가지고 있는 주소값을 전달
		System.out.println("main()에서 changeDataValue() 수행 후 data.num ---> " + data.num);
	}
}
