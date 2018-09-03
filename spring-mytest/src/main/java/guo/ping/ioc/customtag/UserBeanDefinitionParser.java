package guo.ping.ioc.customtag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @description: 自定义User的BeanDefinition解析类
 * @author: guoping wang
 * @date: 2018/9/2 14:09
 * @project: spring
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	// Element 对应的类
	protected Class<?> getBeanClass(Element element) {
		return User.class;
	}

	// 从 element 中解析并提取对应的元素
	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String userName = element.getAttribute("userName");
		String email = element.getAttribute("email");
		// 将提取的数据放入到BeanDefinitionBuilder中，待到完成所有的bean的解析后统一注册到beanFactory中
		if (StringUtils.hasText(userName)) {
			builder.addPropertyValue("userName", userName);
		}
		if (StringUtils.hasText(email)) {
			builder.addPropertyValue("email", email);
		}
	}
}
