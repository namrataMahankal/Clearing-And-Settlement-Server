package com.clearing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.clearing.entity.ClearingMemberEntity;
import com.clearing.entity.CorporateActionSummaryEntity;
import com.clearing.entity.EquitySummaryEntity;
import com.clearing.entity.EquitySummaryId;
import com.clearing.entity.SecuritiesEntity;
import com.clearing.entity.TradeEntity;
import com.clearing.service.TradeService;

public class TradeServiceImplTest {

	private ArrayList<ClearingMemberEntity> cmList = new ArrayList<ClearingMemberEntity>();
	private ArrayList<SecuritiesEntity> securitiesList = new ArrayList<SecuritiesEntity>();
	private ArrayList<EquitySummaryEntity> esList = new ArrayList<EquitySummaryEntity>();
	HashMap<Integer, Float> fundHash = new HashMap<Integer, Float>();
	HashMap<Integer, HashMap<Integer, Integer>> esHash = new HashMap<Integer, HashMap<Integer, Integer>>();

	static List<TradeEntity> mockTrades;

	@Before
	public void setUp() {
		mockTrades = generateLists();
	}

	public List<TradeEntity> generateLists() {

		Set<EquitySummaryEntity> dummyES = null;
		Set<CorporateActionSummaryEntity> dummyCAS = null;

		cmList.add(new ClearingMemberEntity(1001, "Citi", 1150020, -438874, dummyES, dummyCAS, (float) 1.25, 0, 0));
		cmList.add(new ClearingMemberEntity(1002, "JP Morgan Chase", 1132370, -2322340, dummyES, dummyCAS, (float) 1.25,
				1189970, 1487470));
		cmList.add(new ClearingMemberEntity(1003, "Bank of New York Mellon", 1211790, -2180900, dummyES, dummyCAS,
				(float) 1.25, 969109, 1211390));
		cmList.add(new ClearingMemberEntity(1004, "State Street Corporation", 1161850, -145786, dummyES, dummyCAS,
				(float) 1.25, 0, 0));
		cmList.add(new ClearingMemberEntity(1005, "BNP Paribas Securities Services", 1173870, 438874, dummyES, dummyCAS,
				(float) 1.25, 0, 0));
		cmList.add(new ClearingMemberEntity(1006, "HSBC Securities Services", 1383790, 1853330, dummyES, dummyCAS,
				(float) 1.25, 0, 0));
		cmList.add(new ClearingMemberEntity(1007, "Northern Trust Corporation", 1397360, 2468130, dummyES, dummyCAS,
				(float) 1.25, 0, 0));
		cmList.add(new ClearingMemberEntity(1008, "UBS AG", 1335440, 0, dummyES, dummyCAS, (float) 1.25, 0, 0));
		cmList.add(new ClearingMemberEntity(1009, "Wells Fargo", 1485100, 0, dummyES, dummyCAS, (float) 1.25, 0, 0));
		cmList.add(new ClearingMemberEntity(10010, "Credit Suisse", 1419170, 327569, dummyES, dummyCAS, (float) 1.25, 0,
				0));

		securitiesList.add(new SecuritiesEntity(1, "Amazon", (float) 269.211, 6, dummyES));
		securitiesList.add(new SecuritiesEntity(2, "Apple", (float) 120.369, 13, dummyES));
		securitiesList.add(new SecuritiesEntity(3, "Microsoft", (float) 65.1226, 2, dummyES));
		securitiesList.add(new SecuritiesEntity(4, "UBER", (float) 64.0038, 16, dummyES));
		securitiesList.add(new SecuritiesEntity(5, "FORD Motor Company", (float) 248.97, 14, dummyES));
		securitiesList.add(new SecuritiesEntity(6, "Tesla Inc.", (float) 281.388, 2, dummyES));
		securitiesList.add(new SecuritiesEntity(7, "QUALCOMM Inc.", (float) 105.642, 9, dummyES));
		securitiesList.add(new SecuritiesEntity(8, "AT&T inc", (float) 257.714, 8, dummyES));
		securitiesList.add(new SecuritiesEntity(9, "Intercontinental Exchange", (float) 72.7932, 4, dummyES));
		securitiesList.add(new SecuritiesEntity(10, "Alphabet Inc.", (float) 137.641, 13, dummyES));
		securitiesList.add(new SecuritiesEntity(11, "Anheuser Busch Inbev NV", (float) 124.047, 7, dummyES));
		securitiesList.add(new SecuritiesEntity(12, "WALMART INC", (float) 155.119, 19, dummyES));
		securitiesList.add(new SecuritiesEntity(13, "TEXAS INSTRUMENTS INC", (float) 285.836, 14, dummyES));
		securitiesList.add(new SecuritiesEntity(14, "STARBUCKS CORP", (float) 161.821, 14, dummyES));
		securitiesList.add(new SecuritiesEntity(15, "NVIDIA Corporation", (float) 121.077, 12, dummyES));

		esList.add(new EquitySummaryEntity(new EquitySummaryId(4, 1001), 3787, 6857, 0, (float) 0, this.getSecurity(4),
				this.getCM(1001)));
		esList.add(new EquitySummaryEntity(new EquitySummaryId(1, 1002), 660, 9168, 0, (float) 0, this.getSecurity(1),
				this.getCM(1002)));
		esList.add(new EquitySummaryEntity(new EquitySummaryId(7, 1002), 9039, -1380, 0, (float) 0, this.getSecurity(7),
				this.getCM(1002)));
		esList.add(new EquitySummaryEntity(new EquitySummaryId(5, 1003), 3631, 7444, 0, (float) 0, this.getSecurity(5),
				this.getCM(1003)));
		esList.add(new EquitySummaryEntity(new EquitySummaryId(9, 1003), 4369, 4500, 0, (float) 0, this.getSecurity(9),
				this.getCM(1003)));
		esList.add(new EquitySummaryEntity(new EquitySummaryId(7, 1004), 6409, 1380, 0, (float) 0, this.getSecurity(7),
				this.getCM(1004)));
		esList.add(new EquitySummaryEntity(new EquitySummaryId(4, 1005), 4707, -6857, 2150, (float) 34400,
				this.getSecurity(4), this.getCM(1005)));
		esList.add(new EquitySummaryEntity(new EquitySummaryId(5, 1006), 3946, -7444, 3498, (float) 48972,
				this.getSecurity(5), this.getCM(1006)));
		esList.add(new EquitySummaryEntity(new EquitySummaryId(1, 1007), 3537, -9168, 5631, (float) 33786,
				this.getSecurity(1), this.getCM(1007)));
		esList.add(new EquitySummaryEntity(new EquitySummaryId(9, 10010), 3004, -4500, 1496, (float) 5984,
				this.getSecurity(9), this.getCM(10010)));

		ArrayList<TradeEntity> tradeList = new ArrayList<TradeEntity>();
		tradeList.add(new TradeEntity(1, this.getSecurity(5), 7444, (float) 248.97, this.getCM(1003), this.getCM(1006),
				1853330));
		tradeList.add(new TradeEntity(2, this.getSecurity(1), 9168, (float) 269.211, this.getCM(1002), this.getCM(1007),
				2468130));
		tradeList.add(new TradeEntity(3, this.getSecurity(4), 6857, (float) 64.0038, this.getCM(1001), this.getCM(1005),
				438874));
		tradeList.add(new TradeEntity(4, this.getSecurity(7), 1380, (float) 105.642, this.getCM(1004), this.getCM(1002),
				145786));
		tradeList.add(new TradeEntity(5, this.getSecurity(9), 4500, (float) 72.7932, this.getCM(1003),
				this.getCM(10010), 327569));

		hashTrades();
		return tradeList;
	}

	public void hashTrades() {
		for (ClearingMemberEntity cm : cmList) {
			if(cm.getAmountToPay()!=0.0) {
				fundHash.put(cm.getClearingMemberId(), cm.getAmountToPay());
			}
		}
		for (EquitySummaryEntity es : esList) {
			int currentId = es.getClearingMember().getClearingMemberId();
			HashMap<Integer, Integer> innerHash = new HashMap<Integer, Integer>();
			for (EquitySummaryEntity esinner : esList) {
				if (esinner.getClearingMember().getClearingMemberId() == currentId) {
					innerHash.put(esinner.getSecurity().getSecurityId(), esinner.getSettlementChange());
				}
			}
			esHash.put(currentId, innerHash);
		}
	}

	public ClearingMemberEntity getCM(int clearingMemberId) {
		for (ClearingMemberEntity cm : this.cmList) {
			if (cm.getClearingMemberId() == clearingMemberId)
				return cm;
		}
		return null;
	}

	public SecuritiesEntity getSecurity(int securityId) {
		for (SecuritiesEntity sec : this.securitiesList) {
			if (sec.getSecurityId() == securityId)
				return sec;
		}
		return null;
	}

	@Test
	public void testFundHash() {
		TradeService tradeService = new TradeServiceImplStub();
		System.out.println(mockTrades);
		HashMap<Integer, Float> Map0 = tradeService.hashMapifyTrades().getValue0();

		assertEquals(fundHash, Map0);
	}
	
	@Test
	public void testESHash() {
		TradeService tradeService = new TradeServiceImplStub();
		System.out.println(mockTrades);
		HashMap<Integer, HashMap<Integer, Integer>> Map1 = tradeService.hashMapifyTrades().getValue1();
		
		assertEquals(esHash, Map1);
	}

}
