package kr.co.jhta.di.service.step7;

import java.util.ArrayList;
import java.util.List;

import kr.co.jhta.di.vo.User;

public class UserServiceImpl implements userService {

	@Override
	public List<User> getAllUser() {
		List<User> users = new ArrayList<>();
		users.add(new User("hong","홍길동","010-1111-1111","sms"));
		users.add(new User("kim","김유신","010-2222-1111","kakao"));
		users.add(new User("kang","강감찬","010-3333-1111","sms"));
		users.add(new User("lee","이순신","010-4444-1111","sms"));
		users.add(new User("ryu","류관순","010-5555-1111","kakao"));
			
		return users;
	}
}
