package com.clearing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="account")
@Entity
public class AccountEntity {

	@Id
	private int userId;
	private String password;
	private String type;
	
	public AccountEntity(int id, String pswd, String type){
		   this.userId = id;
		   this.password = pswd;
		   this.type = type;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPswd() {
		return password;
	}
	public void setPswd(String pswd) {
		this.password = pswd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Account [userid=" + userId + ", pswd=" + password + ", type=" + type + "]";
	}
}
