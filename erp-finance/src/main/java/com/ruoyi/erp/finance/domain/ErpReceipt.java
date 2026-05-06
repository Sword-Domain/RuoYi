package com.ruoyi.erp.finance.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;

/**
 * 收款单对象 erp_receipt
 *
 * @author ruoyi
 * @date 2024-01-01
 */
public class ErpReceipt extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 收款单ID */
    private Long receiptId;

    /** 收款单编号 */
    @Excel(name = "收款单编号")
    private String receiptNo;

    /** 客户ID */
    @Excel(name = "客户ID")
    private Long customerId;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 销售订单ID */
    private Long salesOrderId;

    /** 收款日期 */
    @Excel(name = "收款日期", dateFormat = "yyyy-MM-dd")
    private Date receiptDate;

    /** 银行账户ID */
    private Long bankAccountId;

    /** 收款金额 */
    @Excel(name = "收款金额")
    private BigDecimal totalAmount;

    /** 经办人ID */
    private Long handlerId;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
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

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
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
        return "ErpReceipt{" +
                "receiptId=" + receiptId +
                ", receiptNo='" + receiptNo + '\'' +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", salesOrderId=" + salesOrderId +
                ", receiptDate=" + receiptDate +
                ", bankAccountId=" + bankAccountId +
                ", totalAmount=" + totalAmount +
                ", handlerId=" + handlerId +
                ", status='" + status + '\'' +
                '}';
    }
}
