package guo.ping.aop.usedemo;

import org.springframework.aop.framework.AopContext;

/**
 * @description: Aop demo
 * @author: guoping wang
 * @date: 2018/10/6 11:00
 * @project: spring
 */
public class TestBean implements ITest{

	private String testStr = "testStr";

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	@Override
	public void test() {
		System.out.println("test");
		ITest proxy = (ITest) AopContext.currentProxy();
		proxy.subTest();
	}

	@Override
	public void subTest() {
		System.out.println("subTest");
	}

}
