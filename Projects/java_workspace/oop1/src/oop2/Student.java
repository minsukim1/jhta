package oop2;

public class Student {
/*
 * 다음과 같은 멤버변수와 멤버메소드를 갖는 Student 클래스를 정의하시오
  멤버변수 - 학생이름, 반, 번호, 국어점수, 영어점수, 수학점수
  멤버메소드 - 객체의 국어, 영어, 수학점수를 모두 더해서 총점을 반환하는 메소드
              총점을 과목수로 나눈 평균을 반환하는 메소드
              학생이름, 반, 번호, 국어점수, 영어점수, 수학점수, 총점, 평균을 화면에 출력하는 메소드
 */
	String name;
	int studentClass;
	int number;
	int kor;
	int eng;
	int math;
	
	
	int total() {
		return kor + eng + math;
	}
	int avg() {
		return total()/3;
	}
	void display() {
		System.out.println("학생이름 : " + name);
		System.out.println("반 : " + studentClass);
		System.out.println("번호 : " + number);
		System.out.println("국어점수 : " + kor);
		System.out.println("영어점수 : " + eng);
		System.out.println("수학점수 : " + math);
		System.out.println("총점 : " + total());
		System.out.println("평균 : " + avg());
	}
}
