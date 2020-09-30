package com.clearing.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.entity.ClearingMemberEntity;
import com.clearing.entity.EquitySummaryEntity;
import com.clearing.entity.SecuritiesEntity;
import com.clearing.json.EquityObligations;
import com.clearing.json.Obligation;
import com.clearing.json.ObligationReport;
import com.clearing.repository.ClearingMemberRepository;
import com.clearing.repository.EquityObligationRepo;
import com.clearing.repository.EquitySummaryRepository;
import com.clearing.repository.ObligationRepo;
import com.clearing.util.ObligationUtil;

@Service
public class ObligationServiceImpl implements ObligationService {

	@Autowired
	private ObligationRepo obligationRepo;

	@Autowired
	private EquityObligationRepo equityObligationRepo;

	@Autowired
	private ClearingMemberRepository clearingMemberRepository;

	@Autowired
	private EquitySummaryRepository equitySummaryRepository;

	@Override
	public Obligation getObligations(int id, String name) {

		return ObligationUtil.convertToObligation(obligationRepo.findById(id), name);

	}

	@Override
	public List<EquityObligations> getEquityObligations(int id) {

		return ObligationUtil.convertEquityEntityToObligation(equityObligationRepo.findByIdClearingMemberId(id));

	}

	@Override
	public HashMap<String, List<EquityObligations>> getAllEquityObligations() {
		return ObligationUtil.convertToObligationMatrix(equityObligationRepo.findAll());
	}

	@Override
	public List<Obligation> getAllObligations() {
		return ObligationUtil.convertToObligation(obligationRepo.findAll());
	}

	@Override
	public List<ObligationReport> getObligationReport() {
		// TODO Auto-generated method stub
		List<ObligationReport> obligationReports = new ArrayList<ObligationReport>();
		List<ClearingMemberEntity> allCMs = clearingMemberRepository.findAll();
		for (ClearingMemberEntity cm : allCMs) {
			List<EquitySummaryEntity> securities = equitySummaryRepository
					.findByIdClearingMemberId(cm.getClearingMemberId());
			if (securities.size() > 0) {
				ObligationReport cMObligationReport = new ObligationReport();
				cMObligationReport.setCMName(cm.getClearingMemberName());
				cMObligationReport.setFundsObligation(cm.getAmountToPay());
				List<EquityObligations> equityObligations = new ArrayList<EquityObligations>();
				for (EquitySummaryEntity security : securities) {
					equityObligations.add(new EquityObligations(security.getSecurity().getSecurityName(),
							security.getNoOfShares(), security.getSettlementChange()));
				}

				cMObligationReport.setShareListObligation(equityObligations);
				obligationReports.add(cMObligationReport);
			}

		}
		return obligationReports;
	}

}
