package com.ruoyi.erp.finance.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;

/**
 * 应付款对象 erp_payable
 *
 * @author ruoyi
 * @date 2024-01-01
 */
public class ErpPayable extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 应付款ID */
    private Long payableId;

    /** 应付款编号 */
    @Excel(name = "应付款编号")
    private String payableNo;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long supplierId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 采购订单ID */
    private Long purchaseOrderId;

    /** 采购订单编号 */
    @Excel(name = "采购订单编号")
    private String purchaseOrderNo;

    /** 来源类型 */
    @Excel(name = "来源类型")
    private String sourceType;

    /** 来源ID */
    private Long sourceId;

    /** 来源编号 */
    @Excel(name = "来源编号")
    private String sourceNo;

    /** 发票编号 */
    @Excel(name = "发票编号")
    private String invoiceNo;

    /** 应付日期 */
    @Excel(name = "应付日期", dateFormat = "yyyy-MM-dd")
    private Date payableDate;

    /** 到期日期 */
    @Excel(name = "到期日期", dateFormat = "yyyy-MM-dd")
    private Date dueDate;

    /** 应付总额 */
    @Excel(name = "应付总额")
    private BigDecimal totalAmount;

    /** 已付金额 */
    @Excel(name = "已付金额")
    private BigDecimal paidAmount;

    /** 应付余额 */
    @Excel(name = "应付余额")
    private BigDecimal balanceAmount;

    /** 逾期天数 */
    @Excel(name = "逾期天数")
    private Integer overdueDays;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public Long getPayableId() {
        return payableId;
    }

    public void setPayableId(Long payableId) {
        this.payableId = payableId;
    }

    public String getPayableNo() {
        return payableNo;
    }

    public void setPayableNo(String payableNo) {
        this.payableNo = payableNo;
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

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
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

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Date getPayableDate() {
        return payableDate;
    }

    public void setPayableDate(Date payableDate) {
        this.payableDate = payableDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ErpPayable{" +
                "payableId=" + payableId +
                ", payableNo='" + payableNo + '\'' +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", purchaseOrderId=" + purchaseOrderId +
                ", purchaseOrderNo='" + purchaseOrderNo + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", sourceId=" + sourceId +
                ", sourceNo='" + sourceNo + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", payableDate=" + payableDate +
                ", dueDate=" + dueDate +
                ", totalAmount=" + totalAmount +
                ", paidAmount=" + paidAmount +
                ", balanceAmount=" + balanceAmount +
                ", overdueDays=" + overdueDays +
                ", status='" + status + '\'' +
                '}';
    }
}
