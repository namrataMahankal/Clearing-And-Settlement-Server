package com.clearing.util;

import java.util.ArrayList;
import java.util.List;

import com.clearing.entity.EquitySummaryEntity;
import com.clearing.json.EquitySummary;

public class EquitySummaryUtil {

	public static EquitySummary convertEquitySummaryEntityIntoEquitySummary(EquitySummaryEntity equitySummaryEntity) {
		return new EquitySummary(equitySummaryEntity.getSecurity().getSecurityName(),equitySummaryEntity.getNoOfShares());
	}

	public static List<EquitySummary> convertEquitySummaryEntityListIntoEquitySummaryList(List<EquitySummaryEntity> equitySummaryEntityList) {
		List<EquitySummary> equitySummaries = new ArrayList<EquitySummary>();
		for (EquitySummaryEntity equitySummaryEntity : equitySummaryEntityList) {
			equitySummaries.add(convertEquitySummaryEntityIntoEquitySummary(equitySummaryEntity));
		}
		return equitySummaries;
	}
}
