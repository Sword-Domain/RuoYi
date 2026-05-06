package com.ruoyi.erp.finance.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;

/**
 * 付款单对象 erp_payment
 *
 * @author ruoyi
 * @date 2024-01-01
 */
public class ErpPayment extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 付款单ID */
    private Long paymentId;

    /** 付款单编号 */
    @Excel(name = "付款单编号")
    private String paymentNo;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long supplierId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 采购订单ID */
    private Long purchaseOrderId;

    /** 付款日期 */
    @Excel(name = "付款日期", dateFormat = "yyyy-MM-dd")
    private Date paymentDate;

    /** 银行账户ID */
    private Long bankAccountId;

    /** 付款金额 */
    @Excel(name = "付款金额")
    private BigDecimal totalAmount;

    /** 经办人ID */
    private Long handlerId;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
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

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(Long handlerId) {
        this.handlerId = handlerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ErpPayment{" +
                "paymentId=" + paymentId +
                ", paymentNo='" + paymentNo + '\'' +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", purchaseOrderId=" + purchaseOrderId +
                ", paymentDate=" + paymentDate +
                ", bankAccountId=" + bankAccountId +
                ", totalAmount=" + totalAmount +
                ", handlerId=" + handlerId +
                ", status='" + status + '\'' +
                '}';
    }
}
