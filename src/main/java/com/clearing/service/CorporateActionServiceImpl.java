package com.clearing.service;

import com.clearing.entity.CorporateActionSummaryEntity;
import com.clearing.entity.CorporateActionSummaryId;
import com.clearing.entity.EquitySummaryEntity;

import com.clearing.entity.SecuritiesEntity;
import com.clearing.json.CorporateActionCMList;
import com.clearing.json.CorporateActionSummary;
import com.clearing.json.CorporateActionSummarySecurity;
import com.clearing.repository.ClearingMemberRepository;
import com.clearing.repository.CorporateActionRepository;
import com.clearing.repository.CorporateActionSummaryRepository;
import com.clearing.repository.EquitySummaryRepository;
import com.clearing.repository.SecuritiesRepository;
import com.clearing.util.CorporateActionSummaryUtil;

import java.util.ArrayList;
import java.util.List;
	
import com.clearing.entity.ClearingMemberEntity;
import com.clearing.entity.CorporateActionEntity;

import org.apache.commons.collections4.IterableUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class CorporateActionServiceImpl implements CorporateActionService {

	@Autowired
	private SecuritiesRepository securitiesRepository;

	@Autowired
	private CorporateActionRepository corporateActionRepository;

	@Autowired
	private CorporateActionSummaryRepository corporateActionSummaryRepository;

	@Autowired
	private EquitySummaryRepository equitySummaryRepository;

	@Autowired
	private ClearingMemberRepository clearingMemberRepository;

	@Override
	public List<CorporateActionEntity> showCorporateActions() {
		List<CorporateActionEntity> corporateActions = corporateActionRepository.findAll();
		return corporateActions;
	}

	@Override
	public List<CorporateActionSummaryEntity> showCorporateActionsSummary() {
		List<CorporateActionSummaryEntity> summary = corporateActionSummaryRepository.findAll();
		return summary;
	}

	@Override
	public CorporateActionSummary getCorporateActionSummary(int id, String name) {
		return CorporateActionSummaryUtil
				.convertEntityToSummary(corporateActionSummaryRepository.findByIdClearingMemberId(id), name);
	}

	@Override
	public ArrayList<CorporateActionSummaryEntity> applyCorporateActions() {
		corporateActionSummaryRepository.deleteAll();
		List<CorporateActionEntity> corporateActions = IterableUtils.toList(corporateActionRepository.findAll());
		ArrayList<CorporateActionSummaryEntity> corporateActionSummary = new ArrayList<CorporateActionSummaryEntity>();

		// Local Variable store
		String[] params;
		int splitRatio;

		CorporateActionSummaryEntity newAction;

		for (CorporateActionEntity ca : corporateActions) {
			int securityId = ca.getSecurityId();
			String action = ca.getAction();
			String parameter = ca.getParameter();
			List<EquitySummaryEntity> summaries = IterableUtils
					.toList(equitySummaryRepository.findByIdSecurityId(securityId));

			switch (action) {
			case "stock-split":
				// Parameter format "X-for-1"
				params = parameter.split("-", 3);
				splitRatio = Integer.parseInt(params[0]);

				// Change Number of stocks in EquitySummaries
				for (EquitySummaryEntity eqs : summaries) {
					int numStocks = eqs.getNoOfShares() + eqs.getSettlementChange();
					if (numStocks > 0) {
						newAction = new CorporateActionSummaryEntity(
								new CorporateActionSummaryId(eqs.getClearingMember().getClearingMemberId(),
										eqs.getSecurity().getSecurityId()),
								eqs.getClearingMember(), eqs.getSecurity(), numStocks, numStocks * splitRatio,
								"Stock Split", parameter);
						corporateActionSummary.add(newAction);
					}
				}

				break;
			case "reverse-split":
				// Parameter format "1-for-X"
				params = parameter.split("-", 3);
				splitRatio = Integer.parseInt(params[2]);

				// Change Number of stocks in EquitySummaries and return non-convertible stocks
				// to CM's funds
				for (EquitySummaryEntity eqs : summaries) {
					int numStocks = eqs.getNoOfShares() + eqs.getSettlementChange();
					if (numStocks > 0) {
						// Unconverted Stocks
						ClearingMemberEntity cm = eqs.getClearingMember();
						cm.setCorporateActionChange(cm.getCorporateActionChange()
								+ (numStocks % splitRatio) * eqs.getSecurity().getMarketPrice());
						clearingMemberRepository.save(cm);
						newAction = new CorporateActionSummaryEntity(
								new CorporateActionSummaryId(eqs.getClearingMember().getClearingMemberId(),
										eqs.getSecurity().getSecurityId()),
								eqs.getClearingMember(), eqs.getSecurity(), numStocks, (int) numStocks / splitRatio,
								"Reverse Split", parameter);
						corporateActionSummary.add(newAction);
					}
				}
				break;
			case "stock-dividend":
				// Parameter format "X%" X% of accumulated shares
				parameter = parameter.replace("%", "");
				double dividendPercentage = Double.parseDouble(parameter);
				double dividendRatio = (double) 1.0 + dividendPercentage / (double) 100.0;
				// Change Number of stocks in EquitySummaries
				for (EquitySummaryEntity eqs : summaries) {
					int numStocks = eqs.getNoOfShares() + eqs.getSettlementChange();
					if (numStocks > 0) {
						newAction = new CorporateActionSummaryEntity(
								new CorporateActionSummaryId(eqs.getClearingMember().getClearingMemberId(),
										eqs.getSecurity().getSecurityId()),
								eqs.getClearingMember(), eqs.getSecurity(), numStocks,
								(int) (numStocks * dividendRatio), "Stock Dividend", parameter);
						corporateActionSummary.add(newAction);
					}
				}

				break;
			case "cash-dividend":
				// Parameter format "5$" $ per share
				parameter = parameter.replace("$", "");
				double dividend = Double.parseDouble(parameter);

				// Change Number of stocks in EquitySummaries and return non-convertible stocks to CM's funds
				for (EquitySummaryEntity eqs : summaries) {
					int numStocks = eqs.getNoOfShares() + eqs.getSettlementChange();
					if (numStocks > 0) {
						// Adding dividend of numStocks * Dividend
						ClearingMemberEntity cm = eqs.getClearingMember();
						cm.setCorporateActionChange(cm.getCorporateActionChange() + (double) numStocks * dividend);
						clearingMemberRepository.save(cm);
					}
				}
				break;
			default:
				throw new Error("Not a valid corporate action");
			}
		}
		corporateActionSummaryRepository.saveAll(corporateActionSummary);
		return corporateActionSummary;
	}

	@Override
	public List<CorporateActionSummarySecurity> getCorporateActionSummarySecurity() {

		List<CorporateActionSummarySecurity> corporateActionSummaryCH = new ArrayList<CorporateActionSummarySecurity>();
		List<SecuritiesEntity> allSecurities = securitiesRepository.findAll();
		for (SecuritiesEntity security : allSecurities) {
			List<CorporateActionSummaryEntity> actions = corporateActionSummaryRepository
					.findByIdSecurityId(security.getSecurityId());
			if (actions.size() > 0) {
				List<CorporateActionCMList> cMs = new ArrayList<CorporateActionCMList>();
				for (CorporateActionSummaryEntity action : actions) {
					cMs.add(new CorporateActionCMList(action.getClearingMember().getClearingMemberName(),
							action.getInitialShareBalance(), action.getFinalShareBalance()));
				}
				CorporateActionSummaryEntity action = actions.get(0);
				corporateActionSummaryCH.add(new CorporateActionSummarySecurity(security.getSecurityName(),
						action.getAction(), action.getParameter(), cMs));
			}

		}
		return corporateActionSummaryCH;
	}

}
