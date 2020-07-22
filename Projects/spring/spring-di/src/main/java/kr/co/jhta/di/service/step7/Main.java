package kr.co.jhta.di.service.step7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		String conf = "kr/co/jhta/di/service/step7/context-step7.xml";
		
		ApplicationContext ctx = new GenericXmlApplicationContext(conf);
		
		EventNotificationServiceImpl event = ctx.getBean("eventNotificationServiceImpl", EventNotificationServiceImpl.class);
		
		event.noticeEvent("할인", "70%");
		((ConfigurableApplicationContext) ctx).close();

	}

}
