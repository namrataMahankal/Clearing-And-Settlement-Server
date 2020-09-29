package com.clearing.json;

public class Account {

	private int clearingMemberId;
	private String clearingMemberName;
	private String userName;
	private String password;
	private String type;
	
	public Account(int id, String clearingMemberName, String password, String type, String userName){
		   this.clearingMemberId = id;
		   this.clearingMemberName = clearingMemberName;
		   this.password = password;
		   this.type = type;
		   this.userName = userName;
	}
	public Account() {}
	
	public int getClearingMemberId() {
		return clearingMemberId;
	}
	public void setClearingMemberId(int clearingMemberId) {
		this.clearingMemberId = clearingMemberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClearingMemberName() {
		return clearingMemberName;
	}
	public void setClearingMemberName(String clearingMemberName) {
		this.clearingMemberName = clearingMemberName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	
	@Override
	public String toString() {
		return "Account [clearingMemberId=" + clearingMemberId + ", password=" + password + ", type=" + type + ", clearingMemberName=" + clearingMemberName + ", userName=" + userName +"]";
	}
}
