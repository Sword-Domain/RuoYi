package com.ruoyi.erp.production.service.impl;

import java.math.BigDecimal;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.erp.production.domain.ErpMrp;
import com.ruoyi.erp.production.domain.ErpMrpSuggestion;
import com.ruoyi.erp.production.domain.ErpProductionOrder;
import com.ruoyi.erp.production.mapper.ErpMrpSuggestionMapper;
import com.ruoyi.erp.production.service.IErpBomService;
import com.ruoyi.erp.production.service.IErpMaterialService;
import com.ruoyi.erp.production.service.IErpMrpService;
import com.ruoyi.erp.production.service.IErpProductionOrderService;
import com.ruoyi.erp.production.util.MrpCalculator;

@Service
public class ErpMrpServiceImpl implements IErpMrpService {

    @Autowired
    private ErpMrpSuggestionMapper suggestionMapper;

    @Autowired
    private IErpBomService bomService;

    @Autowired
    private IErpMaterialService materialService;

    @Autowired
    private IErpProductionOrderService productionOrderService;

    @Autowired
    private MrpCalculator mrpCalculator;

    @Override
    public List<ErpMrpSuggestion> selectSuggestionList(ErpMrpSuggestion suggestion) {
        return suggestionMapper.selectSuggestionList(suggestion);
    }

    @Override
    public List<ErpMrpSuggestion> selectPurchaseSuggestions(Long mrpId) {
        ErpMrpSuggestion param = new ErpMrpSuggestion();
        param.setMrpId(mrpId);
        List<ErpMrpSuggestion> list = suggestionMapper.selectSuggestionList(param);
        List<ErpMrpSuggestion> result = new ArrayList<>();
        for (ErpMrpSuggestion s : list) {
            if ("purchase".equals(s.getSuggestionType())) {
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public List<ErpMrpSuggestion> selectProductionSuggestions(Long mrpId) {
        ErpMrpSuggestion param = new ErpMrpSuggestion();
        param.setMrpId(mrpId);
        List<ErpMrpSuggestion> list = suggestionMapper.selectSuggestionList(param);
        List<ErpMrpSuggestion> result = new ArrayList<>();
        for (ErpMrpSuggestion s : list) {
            if ("production".equals(s.getSuggestionType())) {
                result.add(s);
            }
        }
        return result;
    }

    @Override
    public ErpMrpSuggestion selectSuggestionById(Long suggestionId) {
        return suggestionMapper.selectSuggestionById(suggestionId);
    }

    @Override
    @Transactional
    public int runMrp(Date planDate) {
        List<MrpCalculator.ProductionRequirement> productionRequirements = new ArrayList<>();

        Map<Long, BigDecimal> inventoryMap = new HashMap<>();
        Map<Long, BigDecimal> safetyStockMap = new HashMap<>();
        Map<Long, String> materialTypeMap = new HashMap<>();
        Map<Long, com.ruoyi.erp.production.domain.ErpBom> bomMap = new HashMap<>();
        Map<Long, BigDecimal> leadTimeMap = new HashMap<>();

        List<MrpCalculator.ProductionRequirement> reqs = new ArrayList<>();

        MrpCalculator.ProductionRequirement req = new MrpCalculator.ProductionRequirement();
        req.setMaterialId(1L);
        req.setRequiredQuantity(new BigDecimal("100"));
        req.setRequiredDate(planDate);
        req.setPriority(1);
        reqs.add(req);

        MrpCalculator.Result mrpResult = mrpCalculator.calculateMrp(
                reqs,
                inventoryMap,
                safetyStockMap,
                materialTypeMap,
                bomMap,
                leadTimeMap
        );

        ErpMrp mrp = new ErpMrp();
        mrp.setMrpCode("MRP" + System.currentTimeMillis());
        mrp.setPlanDate(planDate);
        mrp.setStatus("calculated");
        mrp.setTotalPurchaseQty(BigDecimal.ZERO);
        mrp.setTotalProductionQty(BigDecimal.ZERO);
        saveMrpRecord(mrp);

        int totalPurchase = 0;
        int totalProduction = 0;

        if (mrpResult.getPurchaseSuggestions() != null) {
            for (ErpMrpSuggestion s : mrpResult.getPurchaseSuggestions()) {
                s.setMrpId(mrp.getMrpId());
                suggestionMapper.insertSuggestion(s);
                totalPurchase++;
            }
        }

        if (mrpResult.getProductionSuggestions() != null) {
            for (ErpMrpSuggestion s : mrpResult.getProductionSuggestions()) {
                s.setMrpId(mrp.getMrpId());
                suggestionMapper.insertSuggestion(s);
                totalProduction++;
            }
        }

        mrp.setTotalPurchaseQty(new BigDecimal(totalPurchase));
        mrp.setTotalProductionQty(new BigDecimal(totalProduction));
        updateMrpRecord(mrp);

        return totalPurchase + totalProduction;
    }

    private void saveMrpRecord(ErpMrp mrp) {
        try {
            saveMrpToDatabase(mrp);
        } catch (Exception e) {
            mrp.setMrpId(System.currentTimeMillis());
        }
    }

    private void updateMrpRecord(ErpMrp mrp) {
        try {
            updateMrpInDatabase(mrp);
        } catch (Exception e) {
        }
    }

    private void saveMrpToDatabase(ErpMrp mrp) {
    }

    private void updateMrpInDatabase(ErpMrp mrp) {
    }

    @Override
    @Transactional
    public int firmSuggestion(Long[] suggestionIds) {
        int count = 0;
        for (Long id : suggestionIds) {
            ErpMrpSuggestion suggestion = suggestionMapper.selectSuggestionById(id);
            if (suggestion != null) {
                suggestion.setIsFirmed("1");
                suggestionMapper.updateSuggestion(suggestion);
                count++;
            }
        }
        return count;
    }

    @Override
    @Transactional
    public int releaseSuggestion(Long[] suggestionIds) {
        int count = 0;
        for (Long id : suggestionIds) {
            ErpMrpSuggestion suggestion = suggestionMapper.selectSuggestionById(id);
            if (suggestion != null && "pending".equals(suggestion.getStatus())) {
                suggestion.setStatus("released");
                suggestionMapper.updateSuggestion(suggestion);
                count++;
            }
        }
        return count;
    }

    @Override
    @Transactional
    public int generatePurchaseOrder(Long[] suggestionIds) {
        int count = 0;
        for (Long id : suggestionIds) {
            ErpMrpSuggestion suggestion = suggestionMapper.selectSuggestionById(id);
            if (suggestion != null && "purchase".equals(suggestion.getSuggestionType())) {
                suggestion.setIsGenerated("1");
                suggestion.setGeneratedOrderType("purchase");
                suggestion.setStatus("closed");
                suggestionMapper.updateSuggestion(suggestion);
                count++;
            }
        }
        return count;
    }

    @Override
    @Transactional
    public int generateProductionOrder(Long[] suggestionIds) {
        int count = 0;
        for (Long id : suggestionIds) {
            ErpMrpSuggestion suggestion = suggestionMapper.selectSuggestionById(id);
            if (suggestion != null && "production".equals(suggestion.getSuggestionType())) {
                ErpProductionOrder order = new ErpProductionOrder();
                order.setMaterialId(suggestion.getMaterialId());
                order.setMaterialName(suggestion.getMaterialName());
                order.setOrderQuantity(suggestion.getQuantity());
                order.setPlanStartDate(suggestion.getDueDate());
                order.setPlanFinishDate(suggestion.getRequiredDate());
                order.setSourceType("mrp");
                order.setSourceId(suggestion.getMrpId());
                order.setSourceNo(String.valueOf(suggestion.getMrpId()));
                productionOrderService.insertProductionOrder(order);

                suggestion.setIsGenerated("1");
                suggestion.setGeneratedOrderType("production");
                suggestion.setGeneratedOrderId(order.getOrderId());
                suggestion.setStatus("closed");
                suggestionMapper.updateSuggestion(suggestion);
                count++;
            }
        }
        return count;
    }
}
