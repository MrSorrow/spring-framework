package guo.ping.activemq;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/11/12 16:46
 * @project: spring
 */
public class SpringSender {

	@Test
	public void sendMessage() {
		ApplicationContext context = new ClassPathXmlApplicationContext("activeMQ-Test.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		Destination destination = (Destination) context.getBean("destination");

		for (int i = 0; i < 10; i++) {
			jmsTemplate.send(destination, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage("发送一个消息");
				}
			});
		}
	}
}
