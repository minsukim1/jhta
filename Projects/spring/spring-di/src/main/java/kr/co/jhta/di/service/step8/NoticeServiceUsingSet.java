package kr.co.jhta.di.service.step8;

import java.util.List;
import java.util.Set;

import kr.co.jhta.di.service.MessageSender;
import kr.co.jhta.di.service.step7.userService;
import kr.co.jhta.di.vo.User;

/**
 * 사용가능한 모든 MessageSender류 객체를 이용해서 공지사항을 전달하는 기능
 * @author JHTA
 *
 */
public class NoticeServiceUsingSet implements NoticeService {

	private Set<MessageSender> messageSenders;
	private userService userservice;
	public void setMessageSenders(Set<MessageSender> messageSenders) {
		this.messageSenders = messageSenders;
	}
	
	public void setUserservice(userService userservice) {
		this.userservice = userservice;
	}
	
	@Override
	public void notice(String dept, String subject, String content) {
		List<User> users = userservice.getAllUser();
		for(MessageSender messageSender : messageSenders) {
			System.out.println("사용중인 MessageSender 구현객체 : "+messageSender.getClass().getName());
			for(User user : users) {
				messageSender.send(dept, user.getTel(), subject, content);
			}
		}
	}
}
