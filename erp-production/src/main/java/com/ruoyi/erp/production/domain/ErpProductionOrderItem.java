package com.ruoyi.erp.production.domain;

import java.math.BigDecimal;
import com.ruoyi.common.core.domain.BaseEntity;

public class ErpProductionOrderItem extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long itemId;
    private Long orderId;
    private Long materialId;
    private String materialName;
    private String materialCode;
    private String specification;
    private String unit;
    private Long warehouseId;
    private BigDecimal bomQuantity;
    private BigDecimal orderQuantity;
    private BigDecimal issuedQuantity;
    private BigDecimal returnedQuantity;
    private BigDecimal usedQuantity;
    private String status;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public BigDecimal getBomQuantity() {
        return bomQuantity;
    }

    public void setBomQuantity(BigDecimal bomQuantity) {
        this.bomQuantity = bomQuantity;
    }

    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public BigDecimal getIssuedQuantity() {
        return issuedQuantity != null ? issuedQuantity : BigDecimal.ZERO;
    }

    public void setIssuedQuantity(BigDecimal issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public BigDecimal getReturnedQuantity() {
        return returnedQuantity != null ? returnedQuantity : BigDecimal.ZERO;
    }

    public void setReturnedQuantity(BigDecimal returnedQuantity) {
        this.returnedQuantity = returnedQuantity;
    }

    public BigDecimal getUsedQuantity() {
        return usedQuantity != null ? usedQuantity : BigDecimal.ZERO;
    }

    public void setUsedQuantity(BigDecimal usedQuantity) {
        this.usedQuantity = usedQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
