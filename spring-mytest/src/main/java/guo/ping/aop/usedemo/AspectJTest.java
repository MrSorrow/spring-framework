package guo.ping.aop.usedemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/6 11:06
 * @project: spring
 */
@Aspect
public class AspectJTest {

	@Pointcut("execution(* guo.ping.aop.usedemo.TestBean.test(..))")
	public void test() {

	}

	@Pointcut("execution(* guo.ping.aop.usedemo.TestBean.subTest(..))")
	public void subTest() {

	}

	@Before("test()")
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@After("test()")
	public void afterTest() {
		System.out.println("afterTest");
	}

	@Around("subTest()")
	public Object aroundTest(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("=========beforeSubTest==========");
		Object o = null;
		try {
			o = proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		System.out.println("=========afterSubTest==========");
		return o;
	}
}
