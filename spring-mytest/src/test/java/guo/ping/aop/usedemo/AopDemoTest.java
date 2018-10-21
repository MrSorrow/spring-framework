package guo.ping.aop.usedemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 测试动态使用AOP
 * @author: guoping wang
 * @date: 2018/10/6 12:03
 * @project: spring
 */
public class AopDemoTest {

	@Test
	public void testAopDemo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopDemo-Test.xml");
		ITest testBean = (ITest) context.getBean("test");
		testBean.test();
	}
}
