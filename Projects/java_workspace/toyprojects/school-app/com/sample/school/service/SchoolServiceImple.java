package com.sample.school.service;

import com.sample.school.repository.CourseRepository;
import com.sample.school.repository.ProfessorRepository;
import com.sample.school.repository.RegistrationRepository;
import com.sample.school.repository.StudentRepository;
import com.sample.school.repository.SubjectRepository;
import com.sample.school.vo.Course;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Registration;
import com.sample.school.vo.Student;
import com.sample.school.vo.Subject;

public class SchoolServiceImple implements SchoolService {

	private CourseRepository courseRepo = new CourseRepository();
	private ProfessorRepository professorRepo = new ProfessorRepository();
	private RegistrationRepository registrationRepo = new RegistrationRepository();
	private SubjectRepository subjectRepo = new SubjectRepository();
	private StudentRepository studentRepo = new StudentRepository();

	/*
	 * 	신규교수 등록
		이름, 이메일, 학과, 직위, 급여를 입력받아서 등록한다.
		이메일이 동일한 교수정보는 등록될 수 없다.
	 */
	@Override
	public void addNewProfessor(Professor professor) {
		Professor[] profe = professorRepo.getAllProfessor();
		for(int i=0; i<profe.length; i++) {
			if(profe[i].getEmail().equals(professor.getEmail())) {
				System.out.println("동일한 이메일이 존재합니다.");
				return;
			}
		}
		professorRepo.insertProfessor(professor);		
		System.out.println("등록이 완료되었습니다.");
	}
	/*
	 * 	신규과목 등록
		과목명, 학과, 학점을 입력받아서 등록한다.
		과목명이 동일한 과목정보는 등록될 수 없다.
	 */
	@Override
	public void addNewSubject(Subject subject) {
		Subject[] subjects = subjectRepo.getAllSubject();
		for(int i=0; i<subjects.length; i++) {
			if(subjects[i].getTitle().equals(subject.getTitle())) {
				System.out.println("동일한 과목명이 존재합니다.");
				return;
			}
		}
		subjectRepo.insertSubject(subject);
		System.out.println("등록이 완료되었습니다.");
	}
	/*
	 * 	과목조회
		교수번호를 입력받는다.
		그 교수가 소속된 학과의 과목만 화면에 출력한다.
	 */
	@Override
	public void getSubject(int professorNo) {
		Professor pro = professorRepo.getProfessorByNo(professorNo);
		if(pro==null) {
			System.out.println("교수번호가 일치하지 않습니다.");
			return;
		}
		Subject[] subs = subjectRepo.getSubjectByDept(pro.getDept());
		if(subs.length==0) {
			System.out.println("일치하는 과목정보가 없습니다.");
			return;
		}
		for(int i=0; i<subs.length; i++) {
			System.out.println(subs[i].getTitle());
		}

	}
	/*
	 * 	신규 개설과정 등록
		과정명, 과목번호, 담당교수번호, 정원을 입력받아서 등록한다.
		그 교수가 소속된 학과에서 개설된 과목에 대해서만 신규 과정을 등록할 수 있다.
	 */
	@Override
	public void addNewCourse(Course course) {
		Professor pro = professorRepo.getProfessorByNo(course.getProfessorNo());
		Subject sub = subjectRepo.getSubjectByNo(course.getSubjectNo());
		if(sub==null || pro == null) {
			System.out.println("교수또는 학과가일치하지않습니다.");
			return;
		}
		if(pro.getDept().equals(sub.getDept())) {
			courseRepo.insertCourse(course);
			System.out.println("과정이 등록되었습니다!");
		} else {
			
			System.out.println("과정을 등록할수 없습니다!");
		}
	}
	/*
	 * 	개설과정 조회 
		교수번호를 입력받는다.
		그 교수가 개설한 과정만 화면에 출력한다.
	 */
	@Override
	public void getCourse(int professorNo) {
		Professor professor = professorRepo.getProfessorByNo(professorNo);
		if(professor ==null) {
			System.out.println("교수번호가 올바르지 않습니다.");
			return;
		}
		Course[] courses = courseRepo.getAllCourse();
		for(int i =0; i<courses.length; i++) {
			if(courses[i].getProfessorNo()==professor.getNo()) {
				System.out.println("개설과정 번호 : "+courses[i].getNo());
				System.out.println("과정명 : "+courses[i].getName());
				System.out.println("과목명 : "+professor.getDept());
			}
		}
	}
	/*
	 * 	개설과정 신청자 조회
		교수번호와 개설과정번호를 입력받는다.
		개설과정의 담당교수와 입력한 교수번호가 일치하는 경우만 해당 과정 신청자를 조회해서 화면에 출력한다.
	 */
	@Override
	public void getRegistrationByProfessor(int professorNo, int no) {
		Course course = courseRepo.getCourseByNo(no);
		if(course.getProfessorNo()==professorNo) {
			
		}
	}
	/*
	 * 	성적입력
		교수번호, 수강신청번호, 성적을 입력받는다.
		수강신청 정보의 과정번호로 조회된 과정정보의 교수번호와 입력한 교수번호가 일치할 때만 성적이 입력되게 한다.
	 */
	@Override
	public void addNewCredit(int professorNo, int RegistrationNo, int score) {
		Registration reg = registrationRepo.getRegistrationByNo(RegistrationNo);
		Course cog = courseRepo.getCourseByNo(professorNo);
		if(reg.getCourseNo() == cog.getNo()) {
			reg.setScore(score);
		}
	}
	@Override
	public void addNewStudent(Student student) {
		
		
	}
	@Override
	public void deleteRegistration(int studentNo) {
	
	}
	@Override
	public void getRegistration(int studentNo) {
	
		
	}
	@Override
	public void getRegistrationStudent(int studentNo) {
		
		
	}
}
