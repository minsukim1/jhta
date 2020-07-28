package kr.co.jhta;

import java.util.List;
import java.util.Scanner;

import kr.co.jhta.dao.BlogDao;
import kr.co.jhta.dao.CommentDao;
import kr.co.jhta.dao.UserDao;
import kr.co.jhta.dto.BlogDto;
import kr.co.jhta.vo.Blog;
import kr.co.jhta.vo.Comment;
import kr.co.jhta.vo.User;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		BlogDao blogDao = new BlogDao();
		UserDao userDao = new UserDao();
		CommentDao commentDao = new CommentDao();
		
		// 아이디에 해당하는 사용자 정보 조회하기
//		System.out.println("아이디에 해당하는 사용자 정보를 조회해보기");	
//		System.out.println("아이디를 입력하세요 : ");
//		String userId = scanner.next();
//		User user = userDao.getUserById(userId);
//		if(user != null) {
//			System.out.println(user.getId());
//			System.out.println(user.getName());
//			System.out.println(user.getPassword());
//			System.out.println(user.getEmail());
//			System.out.println(user.getCreatedDate());
//		} else {
//			System.out.println("아이디에 해당하는 사용자가 없습니다.");
//		}
		// 신규 게시물 등록하기
//		System.out.println("신규 게시글 등록해보기");
//		
//		System.out.println("제목을 입력하세요 : ");
//		String title = scanner.next();
//		System.out.println("아이디를 입력하세요 : ");
//		String id = scanner.next();
//		System.out.println("내용을 입력하세요 : ");
//		String content = scanner.next();
//
//		Blog blog = new Blog();
//		blog.setTitle(title);
//		blog.setWriter(id);
//		blog.setContent(content);
//		blogDao.insertBlog(blog);
//		
//		System.out.println("신규 게시글 등록이 완료되었습니다.");

		// 모든 게시물 조회하기	
//		System.out.println("모든 게시물 조회하기");
//		List<BlogDto> dtos = blogDao.getAllBlogs();
//		for(BlogDto dto : dtos) {
//			System.out.println(dto.getUserName());
//		}
//		System.out.println("모든 게시물 조회 완료");
		// 게시글 상세 조회하기
//		System.out.println("게시글 상세 조회하기");
//		System.out.println("조회할 게시글의 번호를 입력하세요 : ");
//		int blogNo = scanner.nextInt();
//		BlogDto dto = blogDao.getBlogByNo(blogNo);
//		if(dto != null) {
//			System.out.println("조회한 게시글");
//			System.out.println("글 번호 : "+dto.getNo());
//			System.out.println("글 제목 : "+dto.getTitle());
//			System.out.println("글 내용 : "+dto.getContent());
//			System.out.println("작성자 명 : "+dto.getUserName());
//			System.out.println("작성자 아이디 : "+dto.getWriter());
//			System.out.println("작성날짜 : "+dto.getCreatedDate());
//			System.out.println("댓글수 : "+dto.getCommentCounts());
//			System.out.println("좋아요 : "+dto.getLikes());
//		} else {
//			System.out.println("해당하는 번호의 게시글이 없습니다.");
//		}
		
		while(true) {
			System.out.println("댓글 등록하기");
			System.out.println("작성자 아이디를 입력하세요  : ");
			String userId = scanner.next();
			User user = userDao.getUserById(userId);
			if(user == null) {
				System.out.println("작성자 아이디에 해당하는 사용자가 없습니다.");
				break;
			}
			System.out.println("댓글 내용을 입력하세요 :");
			String content = scanner.next();
			System.out.println("댓글을 작성할 블로그 번호 : ");
			int blogNo = scanner.nextInt();
			BlogDto blogDto = blogDao.getBlogByNo(blogNo);
			if(blogDto == null) {
				System.out.println("블로그 번호에 해당하는 게시글이 없습니다.");
				break;
			}
			Comment comment = new Comment();
			comment.setBlogNo(blogNo);
			comment.setContent(content);
			comment.setWriter(userId);
			commentDao.insertComment(comment);
			
			Blog blog = new Blog();
			blog.setNo(blogNo);
			blog.setCommentCounts(blogDto.getCommentCounts()+1);
			blogDao.updateBlog(blog);
			
			System.out.println("완료되었습니다.");
			break;
			
		}
	}

}
