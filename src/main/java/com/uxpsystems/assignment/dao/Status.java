package com.uxpsystems.assignment.dao;

public enum Status {
	
	ACTIVATED("Activated"),
	DEACTIVATED("Deactivated");
	
	private String status;
	Status(String status){
		this.status=status;
	}
	
	public String status(){
		return this.status;
	}
}
