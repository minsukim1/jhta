package kr.co.jhta.Dao;


 
import java.util.List;

import kr.co.jhta.vo.User;

public interface UserDao {

	void insertUser(User user);

	void deleteAllUsers();

	void deleteUserById(String userId);
	
	void updateUser(User user);
	
	User getUserById(String userId);
	
	List<User> getAllUsers();

	List<User> getUserByName(String usernaem);
	
}
