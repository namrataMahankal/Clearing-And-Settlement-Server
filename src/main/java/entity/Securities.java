package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security")
public class Security {
	
	@Id
	@GeneratedValue
	private int securityId;
	private String securityName;
	private float marketPrice;
	private float interestRate;	
	

	public Security(int securityId, String securityName, float marketPrice, float interestRate) {
		this.securityId = securityId;
		this.securityName = securityName;
		this.marketPrice = marketPrice;
		this.interestRate = interestRate;
	}


	public Security() {
		// TODO Auto-generated constructor stub
	}

}
