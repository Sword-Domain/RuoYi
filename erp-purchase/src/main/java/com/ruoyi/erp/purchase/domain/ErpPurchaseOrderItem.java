package com.ruoyi.erp.purchase.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class ErpPurchaseOrderItem extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Excel(name = "明细ID")
    private Long itemId;

    @Excel(name = "订单ID")
    private Long orderId;

    @Excel(name = "物料ID")
    private Long materialId;

    @Excel(name = "物料名称")
    private String materialName;

    @Excel(name = "物料编码")
    private String materialCode;

    @Excel(name = "规格型号")
    private String specification;

    @Excel(name = "单位")
    private String unit;

    @Excel(name = "采购数量")
    private Double quantity;

    @Excel(name = "单价")
    private Double unitPrice;

    @Excel(name = "税率")
    private Double taxRate;

    @Excel(name = "税额")
    private Double taxAmount;

    @Excel(name = "金额")
    private Double amount;

    @Excel(name = "已到货数量")
    private Double receivedQuantity;

    @Excel(name = "预计到货日期", dateFormat = "yyyy-MM-dd")
    private String deliveryDate;

    @Excel(name = "明细状态")
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getReceivedQuantity() {
        return receivedQuantity;
    }

    public void setReceivedQuantity(Double receivedQuantity) {
        this.receivedQuantity = receivedQuantity;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
