package com.ruoyi.erp.production.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.ruoyi.common.core.domain.BaseEntity;

public class ErpMrpSuggestion extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long suggestionId;
    private Long mrpId;
    private Long mrpItemId;
    private String suggestionType;
    private Long materialId;
    private String materialName;
    private String materialCode;
    private Long supplierId;
    private String supplierName;
    private Long warehouseId;
    private String warehouseName;
    private BigDecimal quantity;
    private Date requiredDate;
    private Date dueDate;
    private String supplySource;
    private String isFirmed;
    private String isGenerated;
    private String generatedOrderType;
    private Long generatedOrderId;
    private String status;
    private String remark;

    public Long getSuggestionId() {
        return suggestionId;
    }

    public void setSuggestionId(Long suggestionId) {
        this.suggestionId = suggestionId;
    }

    public Long getMrpId() {
        return mrpId;
    }

    public void setMrpId(Long mrpId) {
        this.mrpId = mrpId;
    }

    public Long getMrpItemId() {
        return mrpItemId;
    }

    public void setMrpItemId(Long mrpItemId) {
        this.mrpItemId = mrpItemId;
    }

    public String getSuggestionType() {
        return suggestionType;
    }

    public void setSuggestionType(String suggestionType) {
        this.suggestionType = suggestionType;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getSupplySource() {
        return supplySource;
    }

    public void setSupplySource(String supplySource) {
        this.supplySource = supplySource;
    }

    public String getIsFirmed() {
        return isFirmed;
    }

    public void setIsFirmed(String isFirmed) {
        this.isFirmed = isFirmed;
    }

    public String getIsGenerated() {
        return isGenerated;
    }

    public void setIsGenerated(String isGenerated) {
        this.isGenerated = isGenerated;
    }

    public String getGeneratedOrderType() {
        return generatedOrderType;
    }

    public void setGeneratedOrderType(String generatedOrderType) {
        this.generatedOrderType = generatedOrderType;
    }

    public Long getGeneratedOrderId() {
        return generatedOrderId;
    }

    public void setGeneratedOrderId(Long generatedOrderId) {
        this.generatedOrderId = generatedOrderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
