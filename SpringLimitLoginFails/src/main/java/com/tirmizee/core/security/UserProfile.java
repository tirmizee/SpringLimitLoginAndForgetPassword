package com.tirmizee.core.security;

public class UserProfile extends UserDetailsImpl{
	
	private static final long serialVersionUID = 196667297093501169L;
	
	private String fistName;
	private String lastName;
	private String accessIp;
	private boolean initialLogin;
	private String initialLoginToken;
	
	public UserProfile(Builder builder) {
		super(builder);
		this.fistName = builder.fistName;
		this.lastName = builder.lastName;
		this.accessIp = builder.accessIp;
		this.initialLogin = builder.initialLogin;
		this.initialLoginToken = builder.initialLoginToken;
	}
	
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccessIp() {
		return accessIp;
	}
	public void setAccessIp(String accessIp) {
		this.accessIp = accessIp;
	}
	public boolean isInitialLogin() {
		return initialLogin;
	}
	public void setInitialLogin(boolean initialLogin) {
		this.initialLogin = initialLogin;
	}
	public String getInitialLoginToken() {
		return initialLoginToken;
	}
	public void setInitialLoginToken(String initialLoginToken) {
		this.initialLoginToken = initialLoginToken;
	}

	public static class Builder extends UserDetailsImpl.Builder<Builder>{
		
		private String fistName;
		private String lastName;
		private String accessIp;
		private boolean initialLogin;
		private String initialLoginToken;
		
		public Builder(){}
		
		public Builder fistName(String fistName){
			this.fistName = fistName;
			return this;
		}
		
		public Builder lastName(String lastName){
			this.lastName = lastName;
			return this;
		}
		
		public Builder accessIp(String accessIp){
			this.accessIp = accessIp;
			return this;
		}
		
		public Builder initialLogin(boolean initialLogin){
			this.initialLogin = initialLogin;
			return this;
		}
		
		public Builder initialLoginToken(String initialLoginToken){
			this.initialLoginToken = initialLoginToken;
			return this;
		}
		
		public UserProfile build(){
			return new  UserProfile(this);
		}

	}

}
