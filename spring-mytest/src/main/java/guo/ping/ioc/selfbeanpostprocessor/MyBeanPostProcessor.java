package guo.ping.ioc.selfbeanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @description: 自定义BeanPostProcessor
 * @author: guoping wang
 * @date: 2018/10/5 16:41
 * @project: spring
 */
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("user")) {
			System.out.println("初始化前：指定对user bean进行处理");
		}
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("user")) {
			System.out.println("初始化后：处理完毕");
		}
		return null;
	}
}
