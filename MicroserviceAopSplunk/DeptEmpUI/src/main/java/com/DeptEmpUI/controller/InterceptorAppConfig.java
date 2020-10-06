package com.DeptEmpUI.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class InterceptorAppConfig implements HandlerInterceptor {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar calendar = Calendar.getInstance();
		String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
		if (dayOfWeek == 5) {
			response.getWriter().write("This website is closed on "+days[dayOfWeek-1]+" please try on some other day");
			return false;
		}

		return true;
	}
    
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptorAdapter : spring mvc called postHandle method for "
				+ request.getRequestURI().toString());
	}
    
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerInterceptorAdapter : spring mvc called afterCompletion method for "
				+ request.getRequestURI().toString());
	}

}
