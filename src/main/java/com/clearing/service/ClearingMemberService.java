package com.clearing.service;

import java.util.HashMap;

public interface ClearingMemberService {
    public void addChangeAfterSettlement(HashMap<Integer, Float> transactionAmountHashMap);
}
