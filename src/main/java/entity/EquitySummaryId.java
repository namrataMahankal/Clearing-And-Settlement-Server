package entity;

import java.io.Serializable;
import java.util.Objects;

public class EquitySummaryId implements Serializable{

	private int securityId;
	private int clearingMemberId;
	
	public EquitySummaryId() {
		// TODO Auto-generated constructor stub
	}

	public EquitySummaryId(int securityId, int clearingMemberId) {
		this.securityId = securityId;
		this.clearingMemberId = clearingMemberId;
	}
	
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquitySummaryId equitySummaryId = (EquitySummaryId) o;
        return securityId == equitySummaryId.securityId &&
        		clearingMemberId == equitySummaryId.clearingMemberId;
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(securityId, clearingMemberId);
    }
	
	

}
