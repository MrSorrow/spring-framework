package guo.ping.ioc.bean;


import guo.ping.ioc.selfbeanfactorypostprocessor.User;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @description: 测试自定义BeanFactoryPostProcessor
 * @author: guoping wang
 * @date: 2018/10/4 21:25
 * @project: spring
 */
public class MyBeanFactoryPostProcessorTest {

	@Test
	public void testMyBeanFactoryPostProcessor() {
//		ConfigurableListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("selfBeanFactoryPostProcessor-Test.xml"));
//		BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) bf.getBean("myBeanFactoryPostProcessor");
		ApplicationContext bf = new ClassPathXmlApplicationContext("selfBeanFactoryPostProcessor-Test.xml");
//		bfpp.postProcessBeanFactory(bf);
		User user = (User) bf.getBean("user");
		System.out.println(user);
	}
}
