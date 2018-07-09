package com.tirmizee.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.core.component.MessageSourceUtils;
import com.tirmizee.core.exception.BussinesException;
import com.tirmizee.core.exception.ErrorMessage;
import com.tirmizee.core.exception.UrlNotFoundException;

@ControllerAdvice
public class HandleExceptionController {
	
	@Autowired 
	MessageSourceUtils messageSource;
	
	@ExceptionHandler(BussinesException.class)
	public ResponseEntity<ErrorMessage> handleBussinesException(BussinesException ex){
		String errorDesc = messageSource.getMessage(ex.getCode(),ex.getArgs());
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(ex.getCode());
		errorMessage.setErrorDescription(errorDesc);
		return new ResponseEntity<>(errorMessage,ex.getStatus());
	}
	
	@ExceptionHandler(UrlNotFoundException.class)
	public ModelAndView handleUrlNotFoundException(UrlNotFoundException ex){
		return new ModelAndView("error/404");
	}
	
}