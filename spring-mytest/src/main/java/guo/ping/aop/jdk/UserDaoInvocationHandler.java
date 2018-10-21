package guo.ping.aop.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 实现InvocationHandler接口
 * @author: guoping wang
 * @date: 2018/10/12 11:19
 * @project: spring
 */
public class UserDaoInvocationHandler implements InvocationHandler {

	private Object raw;

	public UserDaoInvocationHandler(Object raw) {
		this.raw = raw;
	}

	/**
	 * @param proxy  动态生成的代理类的实例，就是UserDaoImpl$$EnhancerByCGLIB$$d820d840的实例
	 * @param method 对应的method方法
	 * @param args method需要的参数
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		// 保存动态生成的字节码文件
		byte[] b = ProxyGenerator.generateProxyClass(proxy.getClass().getSimpleName(), proxy.getClass().getInterfaces());
		String currentUrl = "E:\\spring_src\\spring-framework\\spring-mytest\\src\\main\\java\\guo\\ping\\aop\\jdk\\";
		FileOutputStream out = new FileOutputStream(currentUrl + proxy.getClass().getSimpleName() + ".class");
		out.write(b);
		out.flush();
		out.close();

		System.out.println("》》》》开启事务《《《《");
		System.out.println(proxy.getClass());
		Object proxyObject = method.invoke(raw, args);
		System.out.println("》》》》关闭事务《《《《");
		return proxyObject;
	}

	/**
	 * 获取代理对象，利用Proxy的newProxyInstance方法
	 * @return
	 */
	public Object getProxy() {
		return Proxy.newProxyInstance(raw.getClass().getClassLoader(), raw.getClass().getInterfaces(), this);
	}
}
