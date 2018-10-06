package guo.ping.ioc.bean;

import guo.ping.ioc.propertieseditor.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 测试自定义Converter
 * @author: guoping wang
 * @date: 2018/10/6 8:51
 * @project: spring
 */
public class ConverterTest {

	@Test
	public void testConverter() {
		ApplicationContext context = new ClassPathXmlApplicationContext("converter-Test.xml");
		User user = (User) context.getBean("user");
		System.out.println(user);
	}
}
