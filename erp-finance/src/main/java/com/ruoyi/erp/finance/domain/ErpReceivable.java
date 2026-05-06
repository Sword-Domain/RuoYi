package com.ruoyi.erp.finance.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;

/**
 * 应收款对象 erp_receivable
 *
 * @author ruoyi
 * @date 2024-01-01
 */
public class ErpReceivable extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 应收款ID */
    private Long receivableId;

    /** 应收款编号 */
    @Excel(name = "应收款编号")
    private String receivableNo;

    /** 客户ID */
    @Excel(name = "客户ID")
    private Long customerId;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 销售订单ID */
    private Long salesOrderId;

    /** 销售订单编号 */
    @Excel(name = "销售订单编号")
    private String salesOrderNo;

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

    /** 应收日期 */
    @Excel(name = "应收日期", dateFormat = "yyyy-MM-dd")
    private Date receivableDate;

    /** 到期日期 */
    @Excel(name = "到期日期", dateFormat = "yyyy-MM-dd")
    private Date dueDate;

    /** 应收总额 */
    @Excel(name = "应收总额")
    private BigDecimal totalAmount;

    /** 已收金额 */
    @Excel(name = "已收金额")
    private BigDecimal paidAmount;

    /** 应收余额 */
    @Excel(name = "应收余额")
    private BigDecimal balanceAmount;

    /** 逾期天数 */
    @Excel(name = "逾期天数")
    private Integer overdueDays;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public Long getReceivableId() {
        return receivableId;
    }

    public void setReceivableId(Long receivableId) {
        this.receivableId = receivableId;
    }

    public String getReceivableNo() {
        return receivableNo;
    }

    public void setReceivableNo(String receivableNo) {
        this.receivableNo = receivableNo;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getSalesOrderNo() {
        return salesOrderNo;
    }

    public void setSalesOrderNo(String salesOrderNo) {
        this.salesOrderNo = salesOrderNo;
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

    public Date getReceivableDate() {
        return receivableDate;
    }

    public void setReceivableDate(Date receivableDate) {
        this.receivableDate = receivableDate;
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
        return "ErpReceivable{" +
                "receivableId=" + receivableId +
                ", receivableNo='" + receivableNo + '\'' +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", salesOrderId=" + salesOrderId +
                ", salesOrderNo='" + salesOrderNo + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", sourceId=" + sourceId +
                ", sourceNo='" + sourceNo + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", receivableDate=" + receivableDate +
                ", dueDate=" + dueDate +
                ", totalAmount=" + totalAmount +
                ", paidAmount=" + paidAmount +
                ", balanceAmount=" + balanceAmount +
                ", overdueDays=" + overdueDays +
                ", status='" + status + '\'' +
                '}';
    }
}
