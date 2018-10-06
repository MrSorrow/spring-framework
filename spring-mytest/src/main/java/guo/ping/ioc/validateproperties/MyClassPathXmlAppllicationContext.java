package guo.ping.ioc.validateproperties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 自定义扩展ClassPathXmlApplicationContext
 * @author: guoping wang
 * @date: 2018/10/3 12:34
 * @project: spring
 */
public class MyClassPathXmlAppllicationContext extends ClassPathXmlApplicationContext {

	public MyClassPathXmlAppllicationContext(String... configLocations) throws BeansException {
		super(configLocations);
	}

	/**
	 * 重写方法添加需要验证的Properties
	 */
	@Override
	protected void initPropertySources() {
//		getEnvironment().setRequiredProperties("VAR");
	}

	/**
	 * 设置允许覆盖和依赖
	 * @param beanFactory the newly created bean factory for this context
	 */
	@Override
	protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
		setAllowBeanDefinitionOverriding(true);
		setAllowCircularReferences(true);
		super.customizeBeanFactory(beanFactory);
	}

	@Override
	protected void initBeanDefinitionReader(XmlBeanDefinitionReader reader) {
		super.initBeanDefinitionReader(reader);
	}
}
