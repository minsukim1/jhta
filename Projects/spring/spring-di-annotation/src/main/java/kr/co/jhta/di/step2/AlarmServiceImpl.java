package kr.co.jhta.di.step2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.di.MessageSender;

@Service
public class AlarmServiceImpl implements AlarmService {

	@Resource
	private MessageSender kakao;
	
	@Override
	public void alarm(String message) {
		kakao.send("민방위본부", "전국민", "비상상태", message);
	}
}
