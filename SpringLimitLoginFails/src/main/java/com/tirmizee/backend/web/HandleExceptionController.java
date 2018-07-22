package com.tirmizee.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.tirmizee.backend.web.data.ErrorMessage;
import com.tirmizee.core.component.MessageSourceUtils;
import com.tirmizee.core.exception.BussinesException;

@ControllerAdvice
public class HandleExceptionController {
	
	@Autowired 
	private MessageSourceUtils messageSource;
	
	@ExceptionHandler(BussinesException.class)
	public ResponseEntity<ErrorMessage> handleBussinesException(BussinesException ex){
		String errorDesc = messageSource.getMessage(ex.getCode(),ex.getArgs());
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(ex.getCode());
		errorMessage.setErrorDescription(errorDesc);
		return new ResponseEntity<>(errorMessage,ex.getStatus());
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNotFoundException(NoHandlerFoundException ex){
		return new ModelAndView("redirect:/NotFound" , "RequestURL" , ex.getRequestURL());
	}
	
}