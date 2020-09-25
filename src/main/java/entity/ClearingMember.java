package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clearing_member")
public class ClearingMember {
	
	@Id
	private int clearingMemberId;
	private float amountToPay;
	private float clearingMemberFundBalance;
	private String clearingMemberName;

	public ClearingMember(int clearingMemberId, String clearingMemberName, float clearingMemberFundBalance,
			float amountToPay) {
		this.clearingMemberId = clearingMemberId;
		this.clearingMemberName = clearingMemberName;
		this.clearingMemberFundBalance = clearingMemberFundBalance;
		this.amountToPay = amountToPay;
	}



	public ClearingMember() {
		// TODO Auto-generated constructor stub
	}

}
