package collection.recruit.service;

import java.util.ArrayList;

import collection.recruit.repo.RecruitmentRepository;
import collection.recruit.vo.Career;
import collection.recruit.vo.Recruitment;
import collection.recruit.vo.Resume;

public class RecruitmentService {

	private RecruitmentRepository repo = new RecruitmentRepository();
	
	// 이력서 등록기능
	public void addNewResume(Resume resume) {
		// 구직신청객체 생성
		Recruitment recruitment = new Recruitment();
		// 구직신청객체에 전달받은 이력서 객체 저장
		recruitment.setResume(resume);
		// 레포지토리객체를 사용해서 db에 저장하고, 자신의 구직신청번호를 반환받는다.
		int recruitNo = repo.addRecuitment(recruitment);
		// 구직신청번호를 출력한다.
		System.out.println("등록이 완료되었습니다. 구직신청번호는 ["+recruitNo + "]입니다.");
		
	}
	
	// 경력사항 등록기능
	public void addCareer(int recruitmentNo, Career career) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		// 구직신청객체의 경력사항에 전달받은 경력사항객체를 추가한다.
		if(recruitment == null) {
			System.out.println("해당하는 구직신청번호가 존재하지 않습니다.");
			return;
		}
		recruitment.addCareer(career);
		System.out.println("경력사항이 성공적으로 등록되었습니다.");
	}
	
	// 구직신청 상태 조회 기능
	public void printRecruitmentDetail(int recruitmentNo) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회해서 화면에 출력한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println("해당하는 구직신청번호가 존재하지 않습니다.");
			return;
		}
		Resume resume = recruitment.getResume();
		ArrayList<Career> careers = recruitment.getCareer();
		System.out.println("구직신청번호 : "+recruitment.getNo());
		System.out.println("구 직 자 이름 : "+resume.getName());
		System.out.println("전  화  번  호 : "+resume.getTel());
		System.out.println("지  원  부  서 : "+resume.getDept());
		System.out.println("합  격  여  부 : "+recruitment.isPassed());
		for (Career career : careers) {
			System.out.println("재직했던 회사 : "+career.getCompanyName());
			System.out.println("근무했던 부서 : "+career.getDept());
			System.out.println("최종 직급 : "+career.getPosition());
			System.out.println("근무기간 (년): "+career.getYear());
		}
		
	}
	
	// 이력서 수정 기능
	public void updateResume(int recruitmentNo, Resume resume) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		// 구직신청객체의 이력서정보를 전달받은 이력서 정보로 교체한다.
		if(recruitment == null) {
			System.out.println("해당하는 구직신청번호가 존재하지 않습니다.");
			return;
		}
		recruitment.setResume(resume);
		System.out.println("이력서 수정이 완료되었습니다.");
	}
	
	// 구직신청 삭제하기
	public void deleteRecruitment(int recruitmentNo) {
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println("해당하는 구직신청번호가 존재하지 않습니다.");
			return;
		}
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 삭제한다.
		repo.deleteRecruitmentByNo(recruitmentNo);
		System.out.println("삭제가 완료되었습니다.");
	}
	
	// 전체 구직신청정보 간단 조회
	public void printAllRecruitment() {
		// 레포지토리에서 모든 구직신청 정보를 조회해서 화면에 출력한다.
		ArrayList<Recruitment>recruitments =repo.getAllRecruitments();
		for(Recruitment x : recruitments) {
			ArrayList<Career> careers = x.getCareer();
			Resume resume = x.getResume();
			System.out.println("구직신청번호 : "+x.getNo());
			System.out.println("구 직 자 이름 : "+resume.getName());
			System.out.println("전  화  번  호 : "+resume.getTel());
			System.out.println("지  원  부  서 : "+resume.getDept());
			System.out.println("합  격  여  부 : "+x.isPassed());
			for(Career career : careers) {
				System.out.println("재직했던 회사 : "+career.getCompanyName());
				System.out.println("근무했던 부서 : "+career.getDept());
				System.out.println("최종 직급 : "+career.getPosition());
				System.out.println("근무기간 (년): "+career.getYear());
			}
			System.out.println("====================================");
		}
	}
	
	// 구직신청 심사하기
	public void checkRecruitment(int recruitmentNo, boolean passed) {
		// 레포지토리에서 구직신청번호에 해당하는 구직신청객체를 조회한다.
		Recruitment recruitment = repo.getRecruitmentByNo(recruitmentNo);
		if(recruitment == null) {
			System.out.println("해당하는 구직신청번호가 존재하지 않습니다.");
			return;
		}
		// 합격/불합격여부를 결정한다.
		recruitment.setPassed(passed);
		System.out.println("완료되었습니다.");
	}
}