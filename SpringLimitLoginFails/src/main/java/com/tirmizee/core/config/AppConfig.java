package com.tirmizee.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.tirmizee.core.aop.LoggingSQLStatementAspect;
import com.tirmizee.core.component.MessageSourceUtils;
import com.tirmizee.core.component.MessageSourceUtilsImpl;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.tirmizee"})
@PropertySource(value = { "classpath:app.properties" })
public class AppConfig {
	
	@Autowired
	private Environment env;
	
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
		mailSender.setHost(env.getProperty("mail.host"));
	    mailSender.setPort(Integer.parseInt(env.getProperty("mail.port")));
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
	
	@Bean
	public LoggingSQLStatementAspect logSQLStatementsAOP(){
		return new LoggingSQLStatementAspect();
	}
	
}
