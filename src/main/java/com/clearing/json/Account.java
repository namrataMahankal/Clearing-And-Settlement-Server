package com.clearing.json;

public class Account {

	private long userId;
	private String pswd;
	private String type;
	private String token;
	
	public Account(){}
	public Account(long id, String pswd, String type, String token){
		   this.userId = id;
		   this.pswd = pswd;
		   this.type = type;
		   this.token = token;
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
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return "Account [userid=" + userId + ", pswd=" + pswd + ", type=" + type + ", token=" + token + "]";
	}
}
