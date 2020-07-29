package kr.co.jhta.dao;

import java.util.List;

import kr.co.jhta.vo.User;

public interface UserDao {

	/**
	 * 지정된 아이디에 해당하는 사용자정보를 반환한다.
	 * @param userId 조회할 사용자 아이디
	 * @return 사용자정보가 포함된 User객체, null반환될 수 있음
	 */
	User getUserById(String userId);
	
	void insertUser(User user);

	List<User> getUsersByName(String name);
	
	void deleteUserById(String id);
	void updateUser(User user);
}
