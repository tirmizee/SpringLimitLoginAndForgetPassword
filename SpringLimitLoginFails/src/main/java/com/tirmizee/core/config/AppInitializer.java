package com.tirmizee.core.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.tirmizee.core.filter.RequestLoggingFilter;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{
			AppConfig.class,
			SecurityConfig.class,
			DozerMapperConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{
			WebMvcConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{ "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[]{
			new RequestLoggingFilter()
		};
	}
	
}
