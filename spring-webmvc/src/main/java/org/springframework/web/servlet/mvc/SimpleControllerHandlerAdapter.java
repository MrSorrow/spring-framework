/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

/**
 * Adapter to use the plain {@link Controller} workflow interface with
 * the generic {@link org.springframework.web.servlet.DispatcherServlet}.
 * Supports handlers that implement the {@link LastModified} interface.
 *
 * <p>This is an SPI class, not used directly by application code.
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @see org.springframework.web.servlet.DispatcherServlet
 * @see Controller
 * @see LastModified
 * @see HttpRequestHandlerAdapter
 */
public class SimpleControllerHandlerAdapter implements HandlerAdapter {

	/**
	 * 判断该处理器适配器是否适合该请求，标准是handler是Controller即可
	 * @param handler handler object to check
	 * @return
	 */
	@Override
	public boolean supports(Object handler) {
		return (handler instanceof Controller);
	}

	/**
	 * 处理请求，返回视图
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @param handler handler to use. This object must have previously been passed
	 * to the {@code supports} method of this interface, which must have
	 * returned {@code true}.
	 * @return
	 * @throws Exception
	 */
	@Override
	@Nullable
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 委托具体的Controller的handleRequest方法
		return ((Controller) handler).handleRequest(request, response);
	}

	/**
	 * 获取上一次服务器端内容更新时间
	 * @param request current HTTP request
	 * @param handler handler to use
	 * @return
	 */
	@Override
	public long getLastModified(HttpServletRequest request, Object handler) {
		// 所以需要实现LastModified接口，因为这一步会判断
		if (handler instanceof LastModified) {
			return ((LastModified) handler).getLastModified(request);
		}
		return -1L;
	}

}
