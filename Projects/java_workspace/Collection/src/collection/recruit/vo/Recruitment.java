package collection.recruit.vo;

import java.util.ArrayList;

/**
 * 구직정보를 담는 객체용 설계도
 * @author JHTA
 *
 */
public class Recruitment {

	private int no;				// 구직신청번호, Repository에서 자동증가
	private Resume resume;		// 이력서정보
	private ArrayList<Career> career = new ArrayList<Career>();	// 경력사항
	private boolean isPassed;	// 합격여부
	
	public Recruitment() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public ArrayList<Career> getCareer() {
		return career;
	}

	/**
	 * 경력사항 추가
	 * @param career
	 */
	public void addCareer(Career career) {
		this.career.add(career);
	}
	
	public void setCareer(ArrayList<Career> career) {
		this.career = career;
	}

	public boolean isPassed() {
		return isPassed;
	}

	public void setPassed(boolean isPassed) {
		this.isPassed = isPassed;
	}
	
	
}
