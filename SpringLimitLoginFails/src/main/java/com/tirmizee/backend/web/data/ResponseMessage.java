package com.tirmizee.backend.web.data;

import java.io.Serializable;

public class ResponseMessage implements Serializable {

	private static final long serialVersionUID = -2967755031412275165L;
	
	private String message;
	private String messageDescription;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageDescription() {
		return messageDescription;
	}
	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}
	
}
