package guo.ping.ioc.bean;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/7/23 21:01
 * @project: spring
 */
@SuppressWarnings("deprecation")
public class BeanFactoryTest {

	@Test
	public void testSimpleLoad() {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
		MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");
		System.out.println(myTestBean.getTestStr());
	}
}
