package datatype;

public class DataTypeDemo8 {

	public static void main(String[] args) {
//		반지름의 길이가 5, 10, 20인 원들이 있다.
//		각 원들의 넓이와 원의 둘레길이를 계산해서 출력하기
//		넓이는 3.14*반지름*반지름 둘레길이는 2*3.14*반지름
		int radius1 = 5;
		int radius2 = 10;
		int radius3 = 20;
		
		double circleArea1 = Math.PI * radius1 * radius1;
		double circleArea2 = Math.PI * radius2 * radius2;
		double circleArea3 = Math.PI * radius3 * radius3;
		
		double circleRound1 = 2 * Math.PI * radius1;
		double circleRound2 = 2 * Math.PI * radius2;
		double circleRound3 = 2 * Math.PI * radius3;
		
		System.out.println("첫 번째 원의 넓이 : " + circleArea1 + "둘레길이 : " + circleRound1);
		System.out.println("첫 번째 원의 넓이 : " + circleArea2 + "둘레길이 : " + circleRound2);
		System.out.println("첫 번째 원의 넓이 : " + circleArea3 + "둘레길이 : " + circleRound3);
	}

}
