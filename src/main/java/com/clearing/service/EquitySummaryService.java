package com.clearing.service;

import java.util.HashMap;

public interface EquitySummaryService {
    void addChangeAfterSettlement(HashMap<Integer, HashMap<Integer, Integer>> quantityHashMap);
    void calculateESShortage();
}