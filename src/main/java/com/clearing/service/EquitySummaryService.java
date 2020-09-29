package com.clearing.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.clearing.entity.EquitySummaryEntity;

public interface EquitySummaryService {
    void addChangeAfterSettlement(HashMap<Integer, HashMap<Integer, Integer>> quantityHashMap);
    ArrayList<EquitySummaryEntity> calculateESShortage();
}