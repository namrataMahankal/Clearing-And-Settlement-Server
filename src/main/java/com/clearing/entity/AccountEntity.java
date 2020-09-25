package com.clearing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="account")
@Entity
public class AccountEntity {

	@Id
	@Column(name="User_Id")
	private long userId;
	
	@Column(name="password")
	private String pswd;
	
	@Column(name="type")
	private String type;
	
	@Column(name="Auth_Token")
	private String auth_token;
	
	public AccountEntity(){}
	public AccountEntity(long id, String pswd, String type, String token){
		   this.userId = id;
		   this.pswd = pswd;
		   this.type = type;
		   this.auth_token = token;
		}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getToken() {
		return auth_token;
	}
	public void setToken(String token) {
		this.auth_token = token;
	}
	
	@Override
	public String toString() {
		return "Account [userid=" + userId + ", pswd=" + pswd + ", type=" + type + ", token=" + auth_token + "]";
	}
}
