package oop2;

import java.util.Scanner;

public class StudentDemo {
/*
 * StudentDemo 클래스를 정의하고 아래의 내용을 구현하시오
  학생정보를 여러 개 저장할 수 있는 배열을 생성하시오.
  학생정보를 조회, 검색, 입력, 종료하는 메뉴를 제공하시오.
  조회메뉴를 선택하면
    학생이름  반  번호  국어점수  영어점수  수학점수  총점  평균 을 화면에 출력하시오
 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Student[] students = new Student[100];
		int savePosition = 0;
		while(true) {
			System.out.println("");
			System.out.println("====================");
			System.out.println("학생정보 조회 프로그램");
			System.out.println("1.조회  2.검색  3.입력  4.종료  ");
			System.out.println("====================");
			System.out.print("메뉴 선택 : ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[학생정보 조회]");
				System.out.println("========================");
				System.out.println("학생이름	반	번호	국어점수	영어점수	수학점수	총점	평균");
				System.out.println("========================");
				for(int i=0; i<savePosition; i++) {
					Student stu = students[i];
					stu.display();
				}
			} else if (menuNo == 2) {
				System.out.println("[학생정보 검색]");
				System.out.print("학생의 이름을 입력하세요 : ");
				String name = scanner.next();
				for (int i = 0; i < savePosition; i++) {
					Student stu = students[i];
					boolean isFound = false;
					if (name.equals(stu.name)) {
						isFound = true;
					}
					if (isFound) {
						stu.display();
					}
				}
				
			} else if (menuNo == 3) {
				System.out.print("학생 이름을 입력하세요 : ");
				String name = scanner.next();
				System.out.print("반을 입력하세요 : ");
				int studentClass = scanner.nextInt();
				System.out.print("번호를 입력하세요 : ");
				int number = scanner.nextInt();
				System.out.print("국어점수를 입력하세요 : ");
				int kor = scanner.nextInt();
				System.out.print("영어점수를 입력하세요 : ");
				int eng = scanner.nextInt();
				System.out.print("수학점수를 입력하세요 : ");
				int math = scanner.nextInt();
				
				Student stu = new Student();
				stu.name = name;
				stu.studentClass = studentClass;
				stu.number = number;
				stu.kor = kor;
				stu.eng = eng;
				stu.math = math;
				stu.total();
				stu.avg();
				students[savePosition] = stu;
				savePosition++;
			} else if (menuNo == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
