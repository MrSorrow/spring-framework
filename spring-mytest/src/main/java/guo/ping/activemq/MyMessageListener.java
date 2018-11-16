package guo.ping.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/11/12 22:59
 * @project: spring
 */
public class MyMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		TextMessage msg = (TextMessage) message;
		try {
			System.out.println("接收消息: " + msg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
