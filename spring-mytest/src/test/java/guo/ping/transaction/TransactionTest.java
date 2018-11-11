package guo.ping.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/11/3 10:56
 * @project: spring
 */
public class TransactionTest {

	@Test
	public void testTransaction() {
		ApplicationContext context = new ClassPathXmlApplicationContext("transaction-Test.xml");
		IActorService actorService = (IActorService) context.getBean("actorService");
		Actor actor = new Actor(null, "事务", "测试", new Timestamp(System.currentTimeMillis()));
		actorService.save(actor);
	}
}
