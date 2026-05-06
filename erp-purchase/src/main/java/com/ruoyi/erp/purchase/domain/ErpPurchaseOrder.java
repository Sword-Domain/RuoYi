package com.ruoyi.erp.purchase.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class ErpPurchaseOrder extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Excel(name = "订单ID")
    private Long orderId;

    @Excel(name = "订单编号")
    private String orderNo;

    @Excel(name = "供应商ID")
    private Long supplierId;

    @Excel(name = "供应商名称")
    private String supplierName;

    @Excel(name = "仓库ID")
    private Long warehouseId;

    @Excel(name = "采购员ID")
    private Long buyerId;

    @Excel(name = "订单总额")
    private Double totalAmount;

    @Excel(name = "订单日期", dateFormat = "yyyy-MM-dd")
    private String orderDate;

    @Excel(name = "预计到货日期", dateFormat = "yyyy-MM-dd")
    private String expectedDate;

    @Excel(name = "订单状态")
    private String status;

    @Excel(name = "来源类型")
    private String sourceType;

    @Excel(name = "来源ID")
    private Long sourceId;

    @Excel(name = "来源单号")
    private String sourceNo;

    @Excel(name = "联系人")
    private String contact;

    @Excel(name = "联系电话")
    private String phone;

    @Excel(name = "交货地址")
    private String deliveryAddress;

    private String delFlag;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
