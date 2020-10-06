package com.DeptEmpUI.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.DeptEmpUI.controller.InterceptorAppConfig;

@Configuration
public class DeptInterceptor extends WebMvcConfigurerAdapter {

	@Autowired
	private InterceptorAppConfig config;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(config);
	}

}
