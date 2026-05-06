package com.ruoyi.erp.production.mapper;

import java.util.List;
import com.ruoyi.erp.production.domain.ErpMrpSuggestion;

public interface ErpMrpSuggestionMapper {

    List<ErpMrpSuggestion> selectSuggestionList(ErpMrpSuggestion suggestion);

    ErpMrpSuggestion selectSuggestionById(Long suggestionId);

    int insertSuggestion(ErpMrpSuggestion suggestion);

    int insertSuggestions(List<ErpMrpSuggestion> suggestions);

    int updateSuggestion(ErpMrpSuggestion suggestion);

    int deleteSuggestionById(Long suggestionId);

    int deleteSuggestionByIds(Long[] suggestionIds);

    int deleteSuggestionByMrpId(Long mrpId);
}
