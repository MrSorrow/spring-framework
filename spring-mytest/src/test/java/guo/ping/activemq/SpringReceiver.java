package guo.ping.activemq;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.TextMessage;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/11/12 16:50
 * @project: spring
 */
public class SpringReceiver {

	@Test
	public void receiveMessage() {
		ApplicationContext context = new ClassPathXmlApplicationContext("activeMQ-Test.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		Destination destination = (Destination) context.getBean("destination");

		TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
		System.out.println("接收到消息：" + textMessage);
	}
}
