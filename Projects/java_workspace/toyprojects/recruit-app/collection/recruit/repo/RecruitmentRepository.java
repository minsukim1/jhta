package collection.recruit.repo;

import java.util.ArrayList;

import collection.recruit.vo.Recruitment;

public class RecruitmentRepository {

	private ArrayList<Recruitment> db = new ArrayList<Recruitment>();
	private int sequence = 100;
	
	// 구직신청 등록하고, 구직신청 번호를 반환한다.
	public int addRecuitment(Recruitment recruitment) {
		recruitment.setNo(sequence++);
		db.add(recruitment);
		return sequence - 1;
	}
	
	// 나의 구직신청 현황 조회하기
	public Recruitment getRecruitmentByNo(int recruitmentNo) {
		Recruitment result = null;
		for(Recruitment x : db) {
			if(x.getNo() == recruitmentNo) {
				result = x;
			}
		}
		return result;
	}
	
	// 나의 구직신청 삭제하기
	public void deleteRecruitmentByNo(int recruitmentNo) {
		for(int i =0; i<db.size(); i++) {
			Recruitment x = db.get(i);
			if(x.getNo()==recruitmentNo) {
				db.remove(i);
			}
		}
	}
	
	// 전체 구직현황 조회하기
	public ArrayList<Recruitment> getAllRecruitments() {
		return db;
	}
}