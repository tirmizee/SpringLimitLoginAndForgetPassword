package com.tirmizee.backend.api.password.data;

import java.io.Serializable;

public class ForgetPasswordDTO implements Serializable{

	private static final long serialVersionUID = -5548488072234522565L;

	private String email;
	private String errorCode;
	private String errorMsg;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
