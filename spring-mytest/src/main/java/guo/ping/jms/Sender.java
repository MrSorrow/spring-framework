package guo.ping.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/11/12 16:12
 * @project: spring
 */
public class Sender {

	public static void main(String[] args) throws JMSException, InterruptedException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("my-queue");

		MessageProducer producer = session.createProducer(destination);
		for (int i = 0; i < 10; i++) {
			TextMessage message = session.createTextMessage("测试发送消息");
			Thread.sleep(1000);
			producer.send(message);
		}

		session.commit();
		session.close();
		connection.close();
	}
}
