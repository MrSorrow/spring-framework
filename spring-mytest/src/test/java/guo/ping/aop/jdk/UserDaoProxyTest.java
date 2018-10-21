package guo.ping.aop.jdk;

import guo.ping.aop.cglib.UserDaoMethodInterceptor;
import org.junit.Test;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/10/12 11:09
 * @project: spring
 */
public class UserDaoProxyTest {

	@Test
	public void testUserDaoJDKProxy() {

		// 目标对象
		UserDao userDao = new UserDaoImpl();

		System.out.println("========普通对象调用方法========");
		userDao.getUserByName("小明");
		userDao.saveUser(new User("小花", "87654321@163.com"));

		System.out.println("========代理对象增强方法========");

		UserDaoInvocationHandler userDaoInvocationHandler = new UserDaoInvocationHandler(userDao);
		// 创建代理对象
		UserDao proxy = (UserDao) userDaoInvocationHandler.getProxy();
		proxy.getUserByName("小明");
		proxy.saveUser(new User("小花", "87654321@163.com"));
	}

	@Test
	public void testUserDaoGlibProxy() {

		// 该设置用于输出cglib动态代理产生的类
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\spring_src\\spring-framework\\spring-mytest\\src\\main\\java\\guo\\ping\\aop\\cglib");

		UserDao userDao = new UserDaoImpl();

		System.out.println("========普通对象调用方法========");
		userDao.getUserByName("小明");
		userDao.saveUser(new User("小花", "87654321@163.com"));

		System.out.println("========代理对象增强方法========");

		Enhancer enhancer = new Enhancer();
		// 继承被代理类
		enhancer.setSuperclass(UserDaoImpl.class);
		// 设置回调
		enhancer.setCallback(new UserDaoMethodInterceptor());
		// 创建代理类实例
		UserDao proxy = (UserDao) enhancer.create();

		// 创建代理对象
		proxy.getUserByName("小明");
		proxy.saveUser(new User("小花", "87654321@163.com"));
	}
}
