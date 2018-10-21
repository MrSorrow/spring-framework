package guo.ping.aop.ltw;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 测试静态使用AOP
 * @author: guoping wang
 * @date: 2018/10/6 12:03
 * @project: spring
 */
public class AopLTWDemoTest {

	@Test
	public void testAopLTWDemo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopDemoStatic-Test.xml");
		TestLTWBean testBean = (TestLTWBean) context.getBean("test");
		testBean.test();
	}
}
