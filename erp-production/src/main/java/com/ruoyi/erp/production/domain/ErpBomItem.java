package com.ruoyi.erp.production.domain;

import java.math.BigDecimal;
import com.ruoyi.common.core.domain.BaseEntity;

public class ErpBomItem extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long itemId;
    private Long bomId;
    private Long materialId;
    private String materialCode;
    private String materialName;
    private String specification;
    private String unit;
    private Long parentItemId;
    private Integer level;
    private Integer lineNo;
    private BigDecimal quantity;
    private BigDecimal lossRate;
    private BigDecimal actualQuantity;
    private Long warehouseId;
    private String stationNo;
    private String isOptional;
    private String remark;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getBomId() {
        return bomId;
    }

    public void setBomId(Long bomId) {
        this.bomId = bomId;
    }

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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(Long parentItemId) {
        this.parentItemId = parentItemId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLineNo() {
        return lineNo;
    }

    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getLossRate() {
        return lossRate != null ? lossRate : BigDecimal.ZERO;
    }

    public void setLossRate(BigDecimal lossRate) {
        this.lossRate = lossRate;
    }

    public BigDecimal getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(BigDecimal actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getStationNo() {
        return stationNo;
    }

    public void setStationNo(String stationNo) {
        this.stationNo = stationNo;
    }

    public String getIsOptional() {
        return isOptional;
    }

    public void setIsOptional(String isOptional) {
        this.isOptional = isOptional;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
