package com.clearing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clearing.json.CostOfSettlement;
import com.clearing.json.CostOfSettlementFund;
import com.clearing.json.CostOfSettlementShares;
import com.clearing.json.EquitySummary;
import com.clearing.service.ClearingMemberService;

@Controller
@RequestMapping(path = "/clearing-and-settlement")
@CrossOrigin(origins="http://localhost:4200")

public class ClearingMemberController {

	@Autowired
	private ClearingMemberService clearingMemberService;

	@GetMapping(path = "/clearing-member/{cMName}/opening-fund-balance")
	public @ResponseBody float getCMOpeningFundBalance(@PathVariable("cMName") String cMName) {
		return clearingMemberService.getCMOpeningFundBalance(cMName);
	}

	@GetMapping(path = "/clearing-member/{cMName}/opening-share-balance")
	public @ResponseBody List<EquitySummary> getCMOpeningShareBalance(@PathVariable("cMName") String cMName) {
		return clearingMemberService.getCMOpeningShareBalance(cMName);
	}
	
	@GetMapping(path = "/clearing-member/{cMName}/cost-of-settlement/funds")
	public @ResponseBody CostOfSettlementFund getCostOfSettlementFunds(@PathVariable("cMName") String cMName) {
		return clearingMemberService.getCostOfSettlementFund(cMName);
	}
	
	@GetMapping(path = "/clearing-member/{cMName}/cost-of-settlement/shares")
	public @ResponseBody List<CostOfSettlementShares> getCostOfSettlementShares(@PathVariable("cMName") String cMName) {
		return clearingMemberService.getCostOfSettlementShares(cMName);
	}
	
	
	@GetMapping(path = "/cost-of-settlement")
	public @ResponseBody List<CostOfSettlement> getCostOfSettlement() {
		
		return clearingMemberService.getCostOfSettlement();
	}
}