package com.sample.school.service;

import com.sample.school.vo.Course;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Student;
import com.sample.school.vo.Subject;

/**
 * 수강신청과 관련된 서비스를 제공하는 구현객체가 반드시 구현해야 하는 기능을 정의한 인터페이스다.<br />
 * <h3>교수관련 기능</h3>
 * <ul>
 * 	<li>교수등록</li>
 * 	<li>과목등록</li>
 * 	<li>과목조회</li>
 * 	<li>개설과정등록</li>
 * 
 * 	<li>개설과정 조회</li>
 * 
 * 	<li>과정 신청자 조회</li>
 * 	<li>성적 부여</li>
 * </ul>
 * 
 * <h3>학생관련 기능</h3>
 * 	<li>학생등록</li>
 * 	<li>과목조회</li>
 * 
 * 	<li>개설과정 조회</li>
 * 
 * 	<li>수강신청 현황 조회</li>
 * 
 * 	<li>수강신청 취소</li>
 * 	<li>성적 조회</li>
 * </ul>
 
 * @author JHTA
 *
 */
public interface SchoolService {

	void addNewProfessor(Professor professor); // 교수등록
	void addNewSubject(Subject subject); // 과목등록
	void getSubject(int professorNo); // 과목조회
	void addNewCourse(Course course); // 개설과정등록
	void getCourse(int professorNo); // 개설과정조회
	void getRegistrationByProfessor(int professorNo, int no); // 과정 신청자 조회
	void addNewCredit(int professorNo, int RegistrationNo, int credit); // 성적 부여
	void addNewStudent(Student student);
	void getRegistration(int studentNo);
	void deleteRegistration(int studentNo);
	void getRegistrationStudent(int studentNo);
	
}
