package kr.co.jhta.dto;

import java.util.Date;

public class BlogDto {
	private int no;
	private String title;
	private String writer;
	private String content;
	private int likes;
	private int commentCounts;
	private Date createdDate;
	private String userName;
	
	public BlogDto() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getCommentCounts() {
		return commentCounts;
	}

	public void setCommentCounts(int commentCounts) {
		this.commentCounts = commentCounts;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
