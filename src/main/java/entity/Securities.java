package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "securities")
public class Securities {
	
	@Id
	private int securityId;
	private float interestRate;
	private float marketPrice;
	private String securityName;
	

	public Securities(int securityId, String securityName, float marketPrice, float interestRate) {
		this.securityId = securityId;
		this.securityName = securityName;
		this.marketPrice = marketPrice;
		this.interestRate = interestRate;
	}


	public Securities() {
		// TODO Auto-generated constructor stub
	}

}
