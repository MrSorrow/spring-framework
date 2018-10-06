package guo.ping.ioc.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/5 16:52
 * @project: spring
 */
public class SelfBeanPostProcessorTest {

	@Test
	public void testSelfBeanPostProcessor() {
		ApplicationContext context = new ClassPathXmlApplicationContext("selfBeanPostProcessor-Test.xml");
	}
}
