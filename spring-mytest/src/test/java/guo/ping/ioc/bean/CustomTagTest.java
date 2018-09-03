package guo.ping.ioc.bean;

import guo.ping.ioc.customtag.Order;
import guo.ping.ioc.customtag.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/9/2 14:50
 * @project: spring
 */
public class CustomTagTest {

	@Test
	public void testCustomTag() {
		ApplicationContext context = new ClassPathXmlApplicationContext("customTag-Test.xml");
		User user = (User) context.getBean("testUserBean");
		Order order = (Order) context.getBean("testOrderBean");
		System.out.println(user);
		System.out.println(order);
	}
}
