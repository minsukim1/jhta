package com.simple.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.controller.Controller;
import com.simple.dao.ReviewDao;
import com.simple.util.NumberUtil;
import com.simple.vo.Review;
import com.simple.vo.User;

public class DeleteReviewController implements Controller {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginUser");
		// 로그인되지 않은 사용자는 로그인 폼으로 리다이렉션시킨다.
		if (user == null) {
			return"redirect:../login/form.hta?error=deny";
		}
		
		// 요청 파라미터값 조회
		int reviewNo = NumberUtil.stringToInt((req.getParameter("reviewno")));
		
		ReviewDao reviewDao = new ReviewDao();
		Review review = reviewDao.getReviewByNo(reviewNo);
		// 리뷰정보가 존재하지 않는 경우 책 목록페이지로 리다이렉션 시킨다.
		if(review == null) {
			return "redirect:list.hta";
		}
		// 로그인 사용자가 작성한 리뷰가 아닌 경우 에러메세지와 함께 책 상세페이지로 리다이렉션 시킨다.
		if(!review.getUserId().equals(user.getId())) {
			return "redirect:detail.hta?error=deny&bookno=" + review.getBookNo();
		}
		// 리뷰삭제하기
		reviewDao.deleteReview(reviewNo);
		// 책 상세페이지를 요청하는 URI를 재요청하게 하기
		return "redirect:detail.hta?bookno="+review.getBookNo();
	}
}
