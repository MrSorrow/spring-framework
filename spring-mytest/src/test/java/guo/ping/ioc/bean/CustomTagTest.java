package guo.ping.ioc.bean;

import guo.ping.ioc.customtag.Order;
import guo.ping.ioc.customtag.User;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/9/2 14:50
 * @project: spring
 */
public class CustomTagTest {

	@Test
	public void testCustomTag() {
//		XmlBeanFactory context = new XmlBeanFactory(new ClassPathResource("customTag-Test.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("${config}");
		User user = (User) context.getBean("testUserBean");
		Order order = (Order) context.getBean("testOrderBean");
		System.out.println(user);
		System.out.println(order);
	}
}
