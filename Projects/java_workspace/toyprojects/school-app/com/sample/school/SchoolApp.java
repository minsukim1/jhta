package com.sample.school;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sample.school.service.SchoolService;
import com.sample.school.service.SchoolServiceImple;
import com.sample.school.vo.Course;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Subject;


public class SchoolApp {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	private static int nextInt() {
		try {
			String text = in.readLine();
			return Integer.parseInt(text);
		} catch (IOException e) {
			return 0;
		}
	}
	
	private static String next() {
		try {
			return in.readLine();
		} catch (IOException e) {
			return "";
		}
	}
	
	public static void main(String[] args) {
		SchoolService service = new SchoolServiceImple();
		
		while (true) {
			System.out.println("[수강신청 관리 프로그램]");
			System.out.println("---------------------------------------");
			System.out.println("1.교수관련		2.학생관련		0.종료");
			System.out.println("---------------------------------------");
			System.out.print("메뉴를 선택하세요 : ");
			int menuNo = nextInt();
			if(menuNo == 1) {
				System.out.println("[교수관련 기능]");
				System.out.println("--------------------------------------------");
				System.out.println("1.교수등록 2.과목등록 3.과목조회 4.개설과정등록 5.개설과정조회 6.과정 신청자 조회 7.성적부여");
				System.out.println("--------------------------------------------");
				System.out.print("메뉴를 선택하세요 : ");
				int professorMenuNo = nextInt();
				if(professorMenuNo == 1) {
					System.out.println("[신규교수등록]");
					/*
					 * 	신규교수 등록
						이름, 이메일, 학과, 직위, 급여를 입력받아서 등록한다.
						이메일이 동일한 교수정보는 등록될 수 없다.
					 */
					System.out.print("교수의 이름을 입력하세요 : ");
					String professorName = next();
					System.out.print("교수의 이메일을 입력하세요 : ");
					String professorEmail = next();
					System.out.print("교수의 학과를 입력하세요 : ");
					String professorDept = next();
					System.out.print("교수의 직위를 입력하세요 : ");
					String professorPosition = next();
					System.out.print("교수의 급여를 입력하세요 : ");
					int professorSalary = nextInt();
					
					Professor professor = new Professor(professorName,professorEmail,professorDept,
														professorPosition,professorSalary);
					service.addNewProfessor(professor);
					
				}else if(professorMenuNo==2) {
					System.out.println("[신규과목 등록]");
					System.out.print("과목명을 입력하세요 : ");
					String subjectName = next();
					System.out.println("학과를 입력하세요 : ");
					String dept = next();
					System.out.println("학점을 입력하세요 : ");
					int grade = nextInt();
					
					Subject subject = new Subject(subjectName,dept,grade);
					service.addNewSubject(subject);
				}else if(professorMenuNo==3) {
					System.out.println("[과목 조회]");
					System.out.print("교수번호를 입력하세요 : ");
					int professorNo = nextInt();
					
					service.getSubject(professorNo);
				}else if(professorMenuNo==4) {
					System.out.println("[신규 개설과정 등록]");
					System.out.print("과정명을 입력하세요 : ");
					String courseName = next();
					System.out.print("과목번호를 입력하세요 : ");
					int subjectNo = nextInt();
					System.out.print("교수번호를 입력하세요 : ");
					int professorNo = nextInt();
					System.out.print("정원을 입력하세요 : ");
					int quota = nextInt();
					
					Course course = new Course(courseName, subjectNo, professorNo, quota);
					service.addNewCourse(course);
					
				}else if(professorMenuNo==5) {
					System.out.print("[개설 과정 조회]");
					System.out.println("조회할 개설과정의 교수번호를 입력하세요 : ");
					int professorNo = nextInt();
					
					service.getCourse(professorNo);
				}else if(professorMenuNo==6) {
					
				}else if(professorMenuNo==7) {
					
				}
			}else if (menuNo ==2) {
				System.out.println("[학생관련 기능]");
				System.out.println("--------------------------------------------");
				System.out.println("1.학생등록 2.과목조회 3.개설과정조회 4.수강신청현황조회 5.수강신청취소 6.성적조회");
				System.out.println("--------------------------------------------");
				System.out.print("메뉴를 선택하세요 : ");
				int studentMenuNo = nextInt();
				if(studentMenuNo==1) {
					
				}else if(studentMenuNo==2) {
					
				}else if(studentMenuNo==3) {
					
				}else if(studentMenuNo==4) {
					
				}else if(studentMenuNo==5) {
					
				}else if(studentMenuNo==6) {
					
				}
			}else if (menuNo ==0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		}
		
	}
	
}
