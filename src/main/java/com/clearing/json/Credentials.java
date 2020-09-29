package com.clearing.json;

public class Credentials {

	private String userName;
	private String password;
	
	public Credentials(String password,String userName){
		
		   this.password = password;
		   this.userName = userName;
	}
	public Credentials() {}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "Credentials [password=" + password + ", userName=" + userName +"]";
	}
	
}
