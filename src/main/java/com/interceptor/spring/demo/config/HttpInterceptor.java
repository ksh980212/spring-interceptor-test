package com.interceptor.spring.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HttpInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(HttpInterceptor.class);

	@Override // 컨트롤러 실행 직전에 수행
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Object session = request.getSession().getAttribute("SESSION");
		logger.info("Session : {}", session);
		logger.info("===========");
		if (session == null) {
			logger.info("세션 없음 admin 못들어가게 해야함");

			/**
			 *  세션이 없으면 컨트롤러 실행 직전에 차단
			 */
			return false;
		}

		logger.info("세션 있음 admin 접근 OK");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// 컨트롤러 실행 직후에 수행
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// View 렌더링이 끝난 직후 수행
	}

}
