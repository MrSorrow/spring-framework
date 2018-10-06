package guo.ping.ioc.bean;

import guo.ping.ioc.eventlistener.TestEvent;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/5 21:13
 * @project: spring
 */
public class EventListenerTest {

	@Test
	public void testEventListener() {
		ApplicationContext context = new ClassPathXmlApplicationContext("eventListener-Test.xml");
		TestEvent event = new TestEvent("hello", "msg");
		context.publishEvent(event);
	}
}
