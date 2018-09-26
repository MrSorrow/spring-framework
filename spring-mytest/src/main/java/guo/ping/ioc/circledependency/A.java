package guo.ping.ioc.circledependency;

/**
 * @description: A实体
 * @author: guoping wang
 * @date: 2018/9/17 23:02
 * @project: spring
 */
public class A {
	private B b;

	public A(B b) {
		this.b = b;
	}
}
