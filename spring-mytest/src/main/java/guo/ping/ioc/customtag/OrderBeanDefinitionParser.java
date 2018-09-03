package guo.ping.ioc.customtag;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @description: 自定义Order的BeanDefinition解析类
 * @author: guoping wang
 * @date: 2018/9/3 9:24
 * @project: spring
 */
public class OrderBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

	@Override
	protected Class<?> getBeanClass(Element element) {
		return Order.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String orderId = element.getAttribute("orderId");
		String item = element.getAttribute("item");
		// 将提取的数据放入到BeanDefinitionBuilder中，待到完成所有的bean的解析后统一注册到beanFactory中
		if (StringUtils.hasText(orderId)) {
			builder.addPropertyValue("orderId", orderId);
		}
		if (StringUtils.hasText(item)) {
			builder.addPropertyValue("item", item);
		}
	}
}
