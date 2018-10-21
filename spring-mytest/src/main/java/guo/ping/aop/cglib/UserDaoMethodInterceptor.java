package guo.ping.aop.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: 利用CGlib动态生成字节码文件
 * @author: guoping wang
 * @date: 2018/10/12 16:48
 * @project: spring
 */
public class UserDaoMethodInterceptor implements MethodInterceptor {

	/**
	 *
	 * @param o 动态生成的代理类的实例，就是UserDaoImpl$$EnhancerByCGLIB$$d820d840的实例
	 * @param method 对应的method方法
	 * @param args method需要的参数
	 * @param methodProxy 增强的代理对象
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println(">>>>>>开启事务<<<<<<");
		Object proxyObject = methodProxy.invokeSuper(o, args);
		System.out.println(">>>>>>关闭事务<<<<<<");
		return proxyObject;
	}
}
