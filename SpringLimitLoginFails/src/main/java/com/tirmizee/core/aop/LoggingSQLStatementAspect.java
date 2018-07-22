package com.tirmizee.core.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingSQLStatementAspect {
	
	public static final Logger LOGGER = Logger.getLogger(LoggingSQLStatementAspect.class); 
	
	@Before("execution(* org.springframework.jdbc.core..*JdbcOperations.*(String, ..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("logBefore() is running!");
	}

}
