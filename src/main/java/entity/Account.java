package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	@Id
	private int userId;
	private String password;
	private String type;

	public Account(int userId, String password,	String type) {
		this.userId = userId;
		this.password = password;
		this.type = type;
	}
	
	public Account() {
		
	}

}
