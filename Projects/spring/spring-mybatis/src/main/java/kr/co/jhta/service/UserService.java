package kr.co.jhta.service;



import java.util.List;

import kr.co.jhta.vo.Blog;
import kr.co.jhta.vo.Comment;
import kr.co.jhta.vo.User;

public interface UserService {

	void addNewUser(User user);
	
	User login(String id, String password);
	   
   List<Blog> getMyBlogs(String userId);
   
   List<Comment> getMyComments(String userId);

   void updateUserInfo(User user);
   
   void deleteMyAccount(String userId);
}
