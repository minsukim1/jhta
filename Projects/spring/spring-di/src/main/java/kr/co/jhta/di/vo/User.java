package kr.co.jhta.di.vo;

public class User {

	private String id;
	private String name;
	private String tel;
	private String noticeType;
	
	public User() {}

	
	public User(String id, String name, String tel, String noticeType) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.noticeType = noticeType;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	
	
}
