package guo.ping.ioc.eventlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @description: 自定义监听器
 * @author: guoping wang
 * @date: 2018/10/5 21:06
 * @project: spring
 */
public class TestListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof TestEvent) {
			((TestEvent) event).print();
		}
	}
}
