package operator;

import java.util.Scanner;

public class ScannerDemo2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		 *  학생이름, 국어점수, 영어점수, 수학점수를 입력받는다.
		 *  출력내용
		 *  	학생이름, 국어점수, 영어점수, 수학점수, 총점, 평균, 합격여부, 장학금지급여부
		 *  	* 합격여부는 평균이 60점 이상인 경우만 "예"로 출력 그 외는 "아니오" 출력
		 *  	* 장학금지급여부는 평균이 96점 이상인 경우만 "예"로 출력, 그 외는 "아니오" 출력
		 */
		
		System.out.print("학생이름을 입력하세요 : ");
		String name = scanner.next();
		
		System.out.print("국어점수를 입력하세요 : ");
		int kor = scanner.nextInt();
		
		System.out.print("영어점수를 입력하세요 : ");
		int eng = scanner.nextInt();
		
		System.out.print("수학점수를 입력하세요 : ");
		int math = scanner.nextInt();
		
		int totalScore = (kor+eng+math);
		int count = 3;
		int avg = totalScore/count;
		String cong = avg>=60 ? "예" : "아니오";
		String jang = avg>=96 ? "예" : "아니오";
		
		System.out.println("학생이름 : " + name);
		System.out.println("국어점수 : " + kor);
		System.out.println("영어점수 : " + eng);
		System.out.println("수학점수 : " + math);
		System.out.println("총    점 : " + totalScore);
		System.out.println("평    균 : " + avg);
		System.out.println("합격여부 : " + cong);
		System.out.println("장 학 금 : " + jang);
	}
}
