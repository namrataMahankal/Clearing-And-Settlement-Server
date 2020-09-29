package com.clearing.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clearing.entity.EquitySummaryEntity;
import com.clearing.service.EquitySummaryService;

@Controller
@RequestMapping(path = "/equity-summary")
public class EquitySummaryController {

	@Autowired
	private EquitySummaryService equitySummaryService;

	@GetMapping(path = "/es-shortage")
	public @ResponseBody ArrayList<EquitySummaryEntity> calculateESShortage() {
		ArrayList<EquitySummaryEntity> equitySummaryEntity = equitySummaryService.calculateESShortage();
		return equitySummaryEntity;
	}

}