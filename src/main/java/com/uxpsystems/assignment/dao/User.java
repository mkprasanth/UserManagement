package com.uxpsystems.assignment.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="User details")
public class User {
	
	@Id
	@GeneratedValue()
	private long id;
	@Column(unique=true, nullable=false, length=32)
	@Size(min=2, max=30)
	@NotNull
	@ApiModelProperty(notes="username cannot be null.")
	private String username;	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@Column(length = 32, columnDefinition = "varchar(32) default 'ACTIVATED'")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	protected User() {}
	
	public User(String username, String password, Status status) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
	}

	public User(long id,String username, String password, Status status) {
		super();
		this.id=id;
		this.username = username;
		this.password = password;
		this.status = status;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", status=" + status + "]";
	}
	

}
