package guo.ping.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/11/12 16:24
 * @project: spring
 */
public class Receiver {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

		Connection connection = connectionFactory.createConnection();
		connection.start();

		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue("my-queue");

		MessageConsumer consumer = session.createConsumer(destination);

		int i = 0;
		while (i < 10) {
			i++;
			TextMessage message = (TextMessage) consumer.receive();
			session.commit();
			System.out.println("接收到消息内容为：" + message.getText());
		}

		session.close();
		connection.close();
	}
}
