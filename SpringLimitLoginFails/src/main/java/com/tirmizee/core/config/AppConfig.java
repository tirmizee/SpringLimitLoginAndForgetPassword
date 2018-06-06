package com.tirmizee.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.tirmizee.core.component.MessageSourceUtils;
import com.tirmizee.core.component.MessageSourceUtilsImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.tirmizee"})
public class AppConfig {
	
	@Bean
	public MessageSourceUtils messageSource() {
		MessageSourceUtilsImpl messageSource = new MessageSourceUtilsImpl();
        messageSource.setBasename("classpath:messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
	
	@Bean
	public JavaMailSenderImpl javaMailSenderImpl(){
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("192.168.1.214");
	    mailSender.setPort(25);
        return mailSender;
	}
	
	@Bean
	public freemarker.template.Configuration freemarker(){
		freemarker.template.Configuration configuration =  new freemarker.template.Configuration(
				freemarker.template.Configuration.VERSION_2_3_28);
		configuration.setClassForTemplateLoading(AppConfig.class, "/template/");
		configuration.setDefaultEncoding("UTF-8");
		return configuration;
	}
	
}
