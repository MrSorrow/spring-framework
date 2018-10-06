package guo.ping.ioc.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @description: 测试MessageSource
 * @author: guoping wang
 * @date: 2018/10/5 20:10
 * @project: spring
 */
public class MessageSourceTest {

	@Test
	public void testMessageSource() {
		ApplicationContext context = new ClassPathXmlApplicationContext("messageSource-Test.xml");
		Object[] params = {"Wgp", new GregorianCalendar().getTime()};

		String str1 = context.getMessage("test", params, Locale.US);
		String str2 = context.getMessage("test", params, Locale.CHINA);

		System.out.println(str1);
		System.out.println(str2);
	}
}
