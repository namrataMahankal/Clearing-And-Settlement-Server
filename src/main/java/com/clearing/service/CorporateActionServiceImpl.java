package com.clearing.service;

import com.clearing.entity.CorporateActionSummary;
import com.clearing.entity.EquitySummary;
import com.clearing.entity.SecuritiesEntity;
import com.clearing.repository.ClearingMemberRepository;
import com.clearing.repository.CorporateActionRepository;
import com.clearing.repository.CorporateActionSummaryRepository;
import com.clearing.repository.EquitySummaryRepository;
import com.clearing.repository.SecuritiesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.clearing.entity.ClearingMember;
import com.clearing.entity.CorporateAction;

import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

@Service
public class CorporateActionServiceImpl implements CorporateActionService {
    
    // @Autowired
	// private SecuritiesRepository securitiesRepository;

    @Autowired
    private CorporateActionRepository corporateActionRepository;

    @Autowired
    private CorporateActionSummaryRepository corporateActionSummaryRepository;

    @Autowired
    private EquitySummaryRepository equitySummaryRepository;
    
    // @Autowired
	// private ClearingMemberRepository clearingMemberRepository;

    @Override
	public ArrayList<CorporateActionSummary> applyCorporateActions() {
		List<CorporateAction> corporateActions = IterableUtils.toList(corporateActionRepository.findAll());
        ArrayList<CorporateActionSummary> corporateActionSummary = new ArrayList<CorporateActionSummary>();

        // Local Variable store
        String[] params;
        int splitRatio;
        Optional<SecuritiesEntity> securityObj;
        Optional<ClearingMember> clearingMemberObj;  
        CorporateActionSummary newAction;      

        for(CorporateAction ca: corporateActions){
            int securityId = ca.getSecurityId();
            String action = ca.getAction();
            String parameter = ca.getParameter();
            List<EquitySummary> summaries = IterableUtils.toList(equitySummaryRepository.findBySecurityId(securityId));
            // Actions = ['split','reverse-split','stock-dividend']
            switch (action) {
                case "stock-split":
                    // Parameter format "X-for-1"
                    params =  parameter.split("-",3);
                    splitRatio = Integer.parseInt(params[0]);
                    // if(params[2] !=  "1"){
                    //     throw new Error("Reference for split should be 1");
                    // }
                    
                    // // Change Stock Price
                    // securityObj = securitiesRepository.findById(securityId);
                    // if(securityObj.isPresent()){
                    //     SecuritiesEntity security = securityObj.get();
                    //     security.setMarketPrice(security.getMarketPrice()/splitRatio);
                    //     securitiesRepository.save(security);
                    // }
                    
                    // Change Number of stocks in EquitySummaries
                    for(EquitySummary eqs: summaries){
                        int numStocks = eqs.getNoOfShares() + eqs.getSettlementChange();
                        if(numStocks > 0){
                            eqs.setNoOfShares(numStocks*splitRatio);   
                            newAction = new CorporateActionSummary(eqs.getClearingMemberId(), securityId, numStocks, numStocks*splitRatio, "Stock Split",parameter);
                            corporateActionSummary.add(newAction);
                        }
                    }
                    
                    break;
                case "reverse-split":
                    // Parameter format "1-for-X"
                    params =  parameter.split("-",3);
                    splitRatio = Integer.parseInt(params[2]);
                    // if(params[0] !=  "1"){
                    //     throw new Error("Reference for reverse-split should be 1");
                    // }
                    
                    // float securityPrice;
                    // // Change Stock Price
                    // securityObj = securitiesRepository.findById(securityId);
                    // if(securityObj.isPresent()){
                    //     SecuritiesEntity security = securityObj.get();
                    //     securityPrice = security.getMarketPrice();
                    //     security.setMarketPrice(securityPrice*splitRatio);
                    //     securitiesRepository.save(security);
                    // }
                    
                    // Change Number of stocks in EquitySummaries and return non-convertible stocks to CM's funds
                    for(EquitySummary eqs: summaries){
                        int numStocks = eqs.getNoOfShares() + eqs.getSettlementChange();
                        if(numStocks > 0){
                            eqs.setNoOfShares((int)(numStocks/splitRatio));
                            // Remaining Stocks
                            // clearingMemberObj = clearingMemberRepository.findById(eqs.getClearingMemberId());
                            // if(clearingMemberObj.isPresent()){
                            //     ClearingMember cm  = clearingMemberObj.get();
                            //     /////////////////cm.set (numStocks%splitRatio)*securityPrice
                            //     // clearingmMemberRepository.save(cm)
                            // }
                            newAction = new CorporateActionSummary(eqs.getClearingMemberId(), securityId, numStocks, (int)numStocks/splitRatio, "Reverse Split",parameter);
                            corporateActionSummary.add(newAction);
                        }
                    }
                    break;
                case "stock-dividend":
                    // Parameter format "X" X% of accumulated shares
                    // params =  parameter.split("-",3);
                    int dividendPercentage = Integer.parseInt(parameter);
                    float dividendRatio = (float)1.0 + dividendPercentage/(float)100.0;
                    // Change Number of stocks in EquitySummaries
                    for(EquitySummary eqs: summaries){
                        int numStocks = eqs.getNoOfShares() + eqs.getSettlementChange();
                        if(numStocks > 0){
                            eqs.setNoOfShares((int)(numStocks*dividendRatio));
                            newAction = new CorporateActionSummary(eqs.getClearingMemberId(), securityId, numStocks, (int)(numStocks*dividendRatio), "Stock Dividend",parameter);
                            corporateActionSummary.add(newAction);
                        }
                    }

                    break;
                // case "cash-dividend":
                //     // Parameter format "5" $ per share
                //     int dividend = Integer.parseInt(parameter) 

                //     // Change Number of stocks in EquitySummaries and return non-convertible stocks to CM's funds
                //     for(EquitySummary eqs: summaries){
                //         int numStocks = eqs.getNoOfShares() + eqs.getSettlementChange();
                //         if(numStocks > 0){
                //             // Adding dividend of numStocks * Dividend
                //             clearingMemberObj = clearingMemberRepository.findById(eqs.getClearingMemberId());
                //             if(clearingMemberObj.isPresent()){
                //                 ClearingMember cm  = clearingMemberObj.get();
                //                 /////// cm.setBalance(numStocks*Dividend + cm.getBalance())
                //                 // clearingmMemberRepository.save(cm)
                //             }
                //         }
                //     }
                //     break;
                default:
                    throw new Error("Not a valid corporate action");
            }
        }
        corporateActionSummaryRepository.saveAll(corporateActionSummary);
		return corporateActionSummary;
	}
}