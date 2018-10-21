package guo.ping.aop.ltw;

/**
 * @description: Aop demo
 * @author: guoping wang
 * @date: 2018/10/6 11:00
 * @project: spring
 */
public class TestLTWBean {

	private String testStr = "testStr";

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	public void test() {
		System.out.println("test");
	}
}
