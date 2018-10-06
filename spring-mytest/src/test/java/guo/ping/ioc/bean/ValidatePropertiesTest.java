package guo.ping.ioc.bean;

import guo.ping.ioc.customtag.User;
import guo.ping.ioc.validateproperties.MyClassPathXmlAppllicationContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 * @description: 测试验证属性
 * @author: guoping wang
 * @date: 2018/10/3 13:15
 * @project: spring
 */
public class ValidatePropertiesTest {

	@Test
	public void testValidateProperties() {
		ApplicationContext context = new MyClassPathXmlAppllicationContext("customTag-Test.xml");
		User user = (User) context.getBean("testUserBean");
	}
}
