package com.clearing.json;

public class Account {

	private int userId;
	private String pswd;
	private String type;
	private String token = "invalid user";
	
	public Account(){}
	public Account(int id, String pswd, String type, String token){
		   this.userId = id;
		   this.pswd = pswd;
		   this.type = type;
		   this.token = token;
		}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
