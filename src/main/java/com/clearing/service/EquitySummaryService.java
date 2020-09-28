package com.clearing.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.clearing.entity.CorporateActionSummaryEntity;

public interface EquitySummaryService {
    void addChangeAfterSettlement(HashMap<Integer, HashMap<Integer, Integer>> quantityHashMap);
}