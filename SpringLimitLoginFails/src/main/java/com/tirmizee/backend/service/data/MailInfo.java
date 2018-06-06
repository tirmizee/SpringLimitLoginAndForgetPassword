package com.tirmizee.backend.service.data;

import java.io.Serializable;
import java.util.Date;

public class MailInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String from;
	private String to;
	private String content;
	private String subject;
	private Date date;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
