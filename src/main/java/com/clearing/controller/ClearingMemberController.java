package com.clearing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clearing.json.EquitySummary;
import com.clearing.service.ClearingMemberService;

@Controller
@RequestMapping(path = "/clearing-and-settlement")
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
}