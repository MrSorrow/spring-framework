package guo.ping.ioc.circledependency;

/**
 * @description: C
 * @author: guoping wang
 * @date: 2018/9/17 23:02
 * @project: spring
 */
public class C {

	private A a;

	public C() {
	}

	public C(A a) {
		this.a = a;
	}
}
