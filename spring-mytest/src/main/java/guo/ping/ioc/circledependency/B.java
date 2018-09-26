package guo.ping.ioc.circledependency;

/**
 * @description: B
 * @author: guoping wang
 * @date: 2018/9/17 23:02
 * @project: spring
 */
public class B {
	private C c;

	public B(C c) {
		this.c = c;
	}
}
