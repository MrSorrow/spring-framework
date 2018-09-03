package guo.ping.ioc.customtag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @description: 将组件注册到Spring容器
 * @author: guoping wang
 * @date: 2018/9/2 14:37
 * @project: spring
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {

	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
		registerBeanDefinitionParser("order", new OrderBeanDefinitionParser());
	}
}
