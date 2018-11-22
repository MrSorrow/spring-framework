package guo.ping.mvctest.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @description:
 * @author: guoping wang
 * @date: 2018/11/19 10:36
 * @project: spring
 */
public class MyContextListener implements ServletContextListener {

	private ServletContext servletContext;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		servletContext = sce.getServletContext();
		servletContext.setAttribute("name", "=========wgp========");
		System.out.println("web application is starting...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("servlet context is going to shut down...");
		System.out.println(servletContext.getAttribute("name"));
	}
}
