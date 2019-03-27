package com.uxpsystems.assignment.service;

import java.util.Date;
import java.util.UUID;

import javax.persistence.GeneratedValue;

public class ExceptionMapper {

	private Date date;
	private String message;
	private String details;
	@GeneratedValue 
	private String transactionId;
	
	public ExceptionMapper(Date date, String message, String details, String transactionId) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
		this.transactionId =  UUID.randomUUID().toString().substring(0, 20);
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getTransactionID() {
		return transactionId;
	}
	public void setTransactionID(String transactionId) {
		this.transactionId = transactionId;
	}
}
