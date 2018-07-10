package com.tirmizee.core.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.tirmizee.core.interceptor.ILocaleChangeInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	public static final String PREFIX = "/WEB-INF/views/";
	
	public static final String SUFFIX = ".jsp";
	
	@Bean
	public LocaleResolver localeResolver()  {
	    CookieLocaleResolver resolver = new CookieLocaleResolver();
	    resolver.setDefaultLocale(Locale.ENGLISH);
	    resolver.setCookieName("Language");
	    resolver.setCookieMaxAge(30*60);
	    return resolver;
    }
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.enableContentNegotiation(true);
        registry.jsp()
        		.prefix(PREFIX)
                .suffix(SUFFIX);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeInterceptor = new ILocaleChangeInterceptor();
        localeInterceptor.setParamName("language");
        registry.addInterceptor(localeInterceptor);
	}
	
}
