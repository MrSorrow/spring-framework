package guo.ping.mvctest.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 测试Http缓存
 * @author: guoping wang
 * @date: 2018/11/21 11:18
 * @project: spring
 */
public class ModifyController extends AbstractController implements LastModified {

	private long lastModified;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.getWriter().write("test last modify");
		return null;
	}

	@Override
	public long getLastModified(HttpServletRequest request) {
		if (lastModified == 0L) {
			lastModified = System.currentTimeMillis();
		}
		return lastModified;
	}
}
