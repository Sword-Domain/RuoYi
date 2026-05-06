package com.ruoyi.erp.production.service;

import java.util.Date;
import java.util.List;
import com.ruoyi.erp.production.domain.ErpMrpSuggestion;

public interface IErpMrpService {

    List<ErpMrpSuggestion> selectSuggestionList(ErpMrpSuggestion suggestion);

    List<ErpMrpSuggestion> selectPurchaseSuggestions(Long mrpId);

    List<ErpMrpSuggestion> selectProductionSuggestions(Long mrpId);

    ErpMrpSuggestion selectSuggestionById(Long suggestionId);

    int runMrp(Date planDate);

    int firmSuggestion(Long[] suggestionIds);

    int releaseSuggestion(Long[] suggestionIds);

    int generatePurchaseOrder(Long[] suggestionIds);

    int generateProductionOrder(Long[] suggestionIds);
}
