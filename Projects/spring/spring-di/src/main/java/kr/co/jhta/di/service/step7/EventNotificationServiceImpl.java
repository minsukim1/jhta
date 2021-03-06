package kr.co.jhta.di.service.step7;

import java.util.List;

import kr.co.jhta.di.service.MessageSender;
import kr.co.jhta.di.vo.User;

public class EventNotificationServiceImpl implements EventNotificationService {

	private MessageSender messageSender;
	private userService userservice;
	
	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}
	
	public void setUserservice(userService userservice) {
		this.userservice = userservice;
	}
	
	
	@Override
	public void noticeEvent(String eventName, String eventContent) {
		List<User> users = userservice.getAllUser();
		for(User user : users) {
			
			messageSender.send("JHTA", user.getName(), eventName, eventContent);
		}
	}
	
}
