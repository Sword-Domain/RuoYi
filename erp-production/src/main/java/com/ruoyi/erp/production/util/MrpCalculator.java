package com.ruoyi.erp.production.util;

import java.math.BigDecimal;
import java.util.*;
import org.springframework.stereotype.Component;
import com.ruoyi.erp.production.domain.ErpBom;
import com.ruoyi.erp.production.domain.ErpBomItem;
import com.ruoyi.erp.production.domain.ErpMrp;
import com.ruoyi.erp.production.domain.ErpMrpSuggestion;

@Component
public class MrpCalculator {

    public static class MrpResult {
        private ErpMrp mrp;
        private List<ErpMrpSuggestion> purchaseSuggestions;
        private List<ErpMrpSuggestion> productionSuggestions;

        public ErpMrp getMrp() {
            return mrp;
        }

        public void setMrp(ErpMrp mrp) {
            this.mrp = mrp;
        }

        public List<ErpMrpSuggestion> getPurchaseSuggestions() {
            return purchaseSuggestions;
        }

        public void setPurchaseSuggestions(List<ErpMrpSuggestion> purchaseSuggestions) {
            this.purchaseSuggestions = purchaseSuggestions;
        }

        public List<ErpMrpSuggestion> getProductionSuggestions() {
            return productionSuggestions;
        }

        public void setProductionSuggestions(List<ErpMrpSuggestion> productionSuggestions) {
            this.productionSuggestions = productionSuggestions;
        }
    }

    public static class MaterialRequirement {
        private Long materialId;
        private String materialCode;
        private String materialName;
        private BigDecimal grossRequirement = BigDecimal.ZERO;
        private BigDecimal scheduledReceipt = BigDecimal.ZERO;
        private BigDecimal onhandQuantity = BigDecimal.ZERO;
        private BigDecimal allocatedQuantity = BigDecimal.ZERO;
        private BigDecimal availableQuantity = BigDecimal.ZERO;
        private BigDecimal safetyStock = BigDecimal.ZERO;
        private BigDecimal netRequirement = BigDecimal.ZERO;
        private BigDecimal replenishmentQty = BigDecimal.ZERO;
        private Date requirementDate;
        private String materialType;
        private String supplyType;

        public Long getMaterialId() {
            return materialId;
        }

        public void setMaterialId(Long materialId) {
            this.materialId = materialId;
        }

        public String getMaterialCode() {
            return materialCode;
        }

        public void setMaterialCode(String materialCode) {
            this.materialCode = materialCode;
        }

        public String getMaterialName() {
            return materialName;
        }

        public void setMaterialName(String materialName) {
            this.materialName = materialName;
        }

        public BigDecimal getGrossRequirement() {
            return grossRequirement;
        }

        public void setGrossRequirement(BigDecimal grossRequirement) {
            this.grossRequirement = grossRequirement;
        }

        public BigDecimal getScheduledReceipt() {
            return scheduledReceipt;
        }

        public void setScheduledReceipt(BigDecimal scheduledReceipt) {
            this.scheduledReceipt = scheduledReceipt;
        }

        public BigDecimal getOnhandQuantity() {
            return onhandQuantity;
        }

        public void setOnhandQuantity(BigDecimal onhandQuantity) {
            this.onhandQuantity = onhandQuantity;
        }

        public BigDecimal getAllocatedQuantity() {
            return allocatedQuantity;
        }

        public void setAllocatedQuantity(BigDecimal allocatedQuantity) {
            this.allocatedQuantity = allocatedQuantity;
        }

        public BigDecimal getAvailableQuantity() {
            return availableQuantity;
        }

        public void setAvailableQuantity(BigDecimal availableQuantity) {
            this.availableQuantity = availableQuantity;
        }

        public BigDecimal getSafetyStock() {
            return safetyStock;
        }

        public void setSafetyStock(BigDecimal safetyStock) {
            this.safetyStock = safetyStock;
        }

        public BigDecimal getNetRequirement() {
            return netRequirement;
        }

        public void setNetRequirement(BigDecimal netRequirement) {
            this.netRequirement = netRequirement;
        }

        public BigDecimal getReplenishmentQty() {
            return replenishmentQty;
        }

        public void setReplenishmentQty(BigDecimal replenishmentQty) {
            this.replenishmentQty = replenishmentQty;
        }

        public Date getRequirementDate() {
            return requirementDate;
        }

        public void setRequirementDate(Date requirementDate) {
            this.requirementDate = requirementDate;
        }

        public String getMaterialType() {
            return materialType;
        }

        public void setMaterialType(String materialType) {
            this.materialType = materialType;
        }

        public String getSupplyType() {
            return supplyType;
        }

        public void setSupplyType(String supplyType) {
            this.supplyType = supplyType;
        }
    }

    public static class BomNode {
        private Long materialId;
        private String materialCode;
        private String materialName;
        private String materialType;
        private BigDecimal quantity = BigDecimal.ONE;
        private BigDecimal levelQuantity = BigDecimal.ONE;
        private int level = 0;
        private Long bomId;
        private List<BomNode> children = new ArrayList<>();

        public Long getMaterialId() {
            return materialId;
        }

        public void setMaterialId(Long materialId) {
            this.materialId = materialId;
        }

        public String getMaterialCode() {
            return materialCode;
        }

        public void setMaterialCode(String materialCode) {
            this.materialCode = materialCode;
        }

        public String getMaterialName() {
            return materialName;
        }

        public void setMaterialName(String materialName) {
            this.materialName = materialName;
        }

        public String getMaterialType() {
            return materialType;
        }

        public void setMaterialType(String materialType) {
            this.materialType = materialType;
        }

        public BigDecimal getQuantity() {
            return quantity;
        }

        public void setQuantity(BigDecimal quantity) {
            this.quantity = quantity;
        }

        public BigDecimal getLevelQuantity() {
            return levelQuantity;
        }

        public void setLevelQuantity(BigDecimal levelQuantity) {
            this.levelQuantity = levelQuantity;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public Long getBomId() {
            return bomId;
        }

        public void setBomId(Long bomId) {
            this.bomId = bomId;
        }

        public List<BomNode> getChildren() {
            return children;
        }

        public void setChildren(List<BomNode> children) {
            this.children = children;
        }

        public void addChild(BomNode child) {
            this.children.add(child);
        }
    }

    public static class ProductionRequirement {
        private Long materialId;
        private String materialCode;
        private String materialName;
        private BigDecimal requiredQuantity;
        private Date requiredDate;
        private Long mpsItemId;
        private Long bomId;
        private int priority;

        public Long getMaterialId() {
            return materialId;
        }

        public void setMaterialId(Long materialId) {
            this.materialId = materialId;
        }

        public String getMaterialCode() {
            return materialCode;
        }

        public void setMaterialCode(String materialCode) {
            this.materialCode = materialCode;
        }

        public String getMaterialName() {
            return materialName;
        }

        public void setMaterialName(String materialName) {
            this.materialName = materialName;
        }

        public BigDecimal getRequiredQuantity() {
            return requiredQuantity;
        }

        public void setRequiredQuantity(BigDecimal requiredQuantity) {
            this.requiredQuantity = requiredQuantity;
        }

        public Date getRequiredDate() {
            return requiredDate;
        }

        public void setRequiredDate(Date requiredDate) {
            this.requiredDate = requiredDate;
        }

        public Long getMpsItemId() {
            return mpsItemId;
        }

        public void setMpsItemId(Long mpsItemId) {
            this.mpsItemId = mpsItemId;
        }

        public Long getBomId() {
            return bomId;
        }

        public void setBomId(Long bomId) {
            this.bomId = bomId;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }
    }

    public MrpResult calculateMrp(
            List<ProductionRequirement> productionRequirements,
            Map<Long, BigDecimal> inventoryMap,
            Map<Long, BigDecimal> safetyStockMap,
            Map<Long, String> materialTypeMap,
            Map<Long, ErpBom> bomMap,
            Map<Long, BigDecimal> leadTimeMap) {

        MrpResult result = new MrpResult();
        List<ErpMrpSuggestion> allSuggestions = new ArrayList<>();

        Map<Long, MaterialRequirement> requirementMap = new LinkedHashMap<>();

        for (ProductionRequirement pr : productionRequirements) {
            expandBomAndCollectRequirements(
                    pr.getMaterialId(),
                    pr.getRequiredQuantity(),
                    pr.getRequiredDate(),
                    pr.getBomId(),
                    pr.getPriority(),
                    requirementMap,
                    materialTypeMap,
                    bomMap
            );
        }

        for (Map.Entry<Long, MaterialRequirement> entry : requirementMap.entrySet()) {
            MaterialRequirement mr = entry.getValue();

            BigDecimal onhand = inventoryMap.getOrDefault(mr.getMaterialId(), BigDecimal.ZERO);
            mr.setOnhandQuantity(onhand);

            BigDecimal allocated = mr.getAllocatedQuantity() != null ? mr.getAllocatedQuantity() : BigDecimal.ZERO;
            BigDecimal available = onhand.subtract(allocated);
            mr.setAvailableQuantity(available);

            BigDecimal netReq = mr.getGrossRequirement()
                    .subtract(mr.getScheduledReceipt())
                    .subtract(available);

            if (netReq.compareTo(BigDecimal.ZERO) < 0) {
                netReq = BigDecimal.ZERO;
            }

            BigDecimal safetyStock = mr.getSafetyStock() != null ? mr.getSafetyStock() : BigDecimal.ZERO;
            netReq = netReq.add(safetyStock);

            mr.setNetRequirement(netReq);
            mr.setReplenishmentQty(netReq);

            if (mr.getNetRequirement().compareTo(BigDecimal.ZERO) > 0) {
                ErpMrpSuggestion suggestion = createSuggestion(mr, leadTimeMap);
                allSuggestions.add(suggestion);
            }
        }

        result.setPurchaseSuggestions(new ArrayList<>());
        result.setProductionSuggestions(new ArrayList<>());

        for (ErpMrpSuggestion s : allSuggestions) {
            if ("purchase".equals(s.getSuggestionType())) {
                result.getPurchaseSuggestions().add(s);
            } else if ("production".equals(s.getSuggestionType())) {
                result.getProductionSuggestions().add(s);
            }
        }

        return result;
    }

    private void expandBomAndCollectRequirements(
            Long materialId,
            BigDecimal requiredQty,
            Date requiredDate,
            Long bomId,
            int priority,
            Map<Long, MaterialRequirement> requirementMap,
            Map<Long, String> materialTypeMap,
            Map<Long, ErpBom> bomMap) {

        MaterialRequirement mr = requirementMap.get(materialId);
        if (mr == null) {
            mr = new MaterialRequirement();
            mr.setMaterialId(materialId);
            mr.setMaterialCode("");
            mr.setMaterialName("");
            mr.setGrossRequirement(BigDecimal.ZERO);
            mr.setRequirementDate(requiredDate);
            mr.setMaterialType(materialTypeMap.getOrDefault(materialId, "raw"));
            requirementMap.put(materialId, mr);
        }

        mr.setGrossRequirement(mr.getGrossRequirement().add(requiredQty));

        if (requiredDate.before(mr.getRequirementDate())) {
            mr.setRequirementDate(requiredDate);
        }

        ErpBom bom = bomMap.get(materialId);
        if (bom != null && bom.getItems() != null && !bom.getItems().isEmpty()) {
            for (ErpBomItem item : bom.getItems()) {
                BigDecimal childRequiredQty = requiredQty.multiply(item.getQuantity());
                if (item.getLossRate() != null && item.getLossRate().compareTo(BigDecimal.ZERO) > 0) {
                    childRequiredQty = childRequiredQty.multiply(BigDecimal.ONE.add(item.getLossRate()));
                }

                expandBomAndCollectRequirements(
                        item.getMaterialId(),
                        childRequiredQty,
                        requiredDate,
                        bom.getBomId(),
                        priority,
                        requirementMap,
                        materialTypeMap,
                        bomMap
                );
            }
        }
    }

    private ErpMrpSuggestion createSuggestion(MaterialRequirement mr, Map<Long, BigDecimal> leadTimeMap) {
        ErpMrpSuggestion suggestion = new ErpMrpSuggestion();
        suggestion.setMaterialId(mr.getMaterialId());
        suggestion.setMaterialCode(mr.getMaterialCode());
        suggestion.setMaterialName(mr.getMaterialName());
        suggestion.setQuantity(mr.getNetRequirement());
        suggestion.setRequiredDate(mr.getRequirementDate());

        String materialType = mr.getMaterialType();
        if ("finish".equals(materialType) || "semi".equals(materialType)) {
            suggestion.setSuggestionType("production");
        } else {
            suggestion.setSuggestionType("purchase");
        }

        BigDecimal leadTime = leadTimeMap.getOrDefault(mr.getMaterialId(), BigDecimal.ZERO);
        if (leadTime == null) {
            leadTime = BigDecimal.ZERO;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(mr.getRequirementDate());
        cal.add(Calendar.DAY_OF_MONTH, -leadTime.intValue());
        suggestion.setDueDate(cal.getTime());

        suggestion.setStatus("pending");
        suggestion.setIsFirmed("0");
        suggestion.setIsGenerated("0");

        return suggestion;
    }

    public List<BomNode> expandBom(Long materialId, BigDecimal quantity, Map<Long, ErpBom> bomMap) {
        List<BomNode> result = new ArrayList<>();
        expandBomRecursive(materialId, quantity, 0, null, result, bomMap);
        return result;
    }

    private void expandBomRecursive(
            Long materialId,
            BigDecimal parentQty,
            int level,
            Long parentBomId,
            List<BomNode> result,
            Map<Long, ErpBom> bomMap) {

        BomNode node = new BomNode();
        node.setMaterialId(materialId);
        node.setQuantity(parentQty);
        node.setLevel(level);
        node.setLevelQuantity(parentQty);
        node.setBomId(parentBomId);
        result.add(node);

        ErpBom bom = bomMap.get(materialId);
        if (bom != null && bom.getItems() != null) {
            for (ErpBomItem item : bom.getItems()) {
                BigDecimal childQty = parentQty.multiply(item.getQuantity());
                if (item.getLossRate() != null && item.getLossRate().compareTo(BigDecimal.ZERO) > 0) {
                    childQty = childQty.multiply(BigDecimal.ONE.add(item.getLossRate()));
                }
                expandBomRecursive(item.getMaterialId(), childQty, level + 1, bom.getBomId(), result, bomMap);
            }
        }
    }
}
