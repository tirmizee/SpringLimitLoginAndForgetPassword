package com.tirmizee.core.exception;

public class UrlNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String url;

	public UrlNotFoundException() {
		super();
	}

	public UrlNotFoundException(String message) {
		super(message);
	}
	
	public UrlNotFoundException(String message,String url) {
		super(message);
		this.url = url;
	}

	public UrlNotFoundException(Throwable cause) {
		super(cause);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
