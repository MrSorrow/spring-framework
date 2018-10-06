package guo.ping.ioc.bean;

import guo.ping.ioc.propertyplaceholder.HelloMessage;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/4 19:48
 * @project: spring
 */
public class PropertyPlacehloderTest {

	@Test
	public void testValidateProperties() {
		ApplicationContext context = new ClassPathXmlApplicationContext("propertyPlaceholder-Test.xml");
		HelloMessage helloMessage = (HelloMessage) context.getBean("helloMessage");
		System.out.println(helloMessage);
	}
}
