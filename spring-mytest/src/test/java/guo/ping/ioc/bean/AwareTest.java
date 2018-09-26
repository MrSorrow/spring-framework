package guo.ping.ioc.bean;

import guo.ping.ioc.aware.TestAware;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/9/26 13:45
 * @project: spring
 */
public class AwareTest {

	@Test
	public void sing() {
		ApplicationContext context = new ClassPathXmlApplicationContext("awareTest.xml");
		TestAware testAware = (TestAware) context.getBean("beanFactory");
		testAware.testAware();
	}
}
