package com.ruoyi.erp.sales.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.web.domain.BaseEntity;

public class ErpSalesOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "订单ID")
    private Long orderId;

    @Excel(name = "订单编号")
    private String orderNo;

    @Excel(name = "客户ID")
    private Long customerId;

    @Excel(name = "客户名称")
    private String customerName;

    @Excel(name = "仓库ID")
    private Long warehouseId;

    @Excel(name = "业务员ID")
    private Long salesmanId;

    @Excel(name = "订单总金额", readConverterExp = "$column.readConverterExp")
    private BigDecimal totalAmount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryDate;

    @Excel(name = "订单状态", readConverterExp = "10=草稿,20=已审核,30=已关闭,40=已取消")
    private String status;

    @Excel(name = "订单来源", readConverterExp = "1=手工创建,2=销售报价,3=销售合同")
    private String sourceType;

    @Excel(name = "联系人")
    private String contact;

    @Excel(name = "联系电话")
    private String phone;

    @Excel(name = "交货地址")
    private String deliveryAddress;

    @Excel(name = "已发货金额", readConverterExp = "$column.readConverterExp")
    private BigDecimal shippedAmount;

    @Excel(name = "已开票金额", readConverterExp = "$column.readConverterExp")
    private BigDecimal invoicedAmount;

    @Excel(name = "已收款金额", readConverterExp = "$column.readConverterExp")
    private BigDecimal receivedAmount;

    public Long getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public String getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public Long getCustomerId()
    {
        return customerId;
    }

    public void setCustomerId(Long customerId)
    {
        this.customerId = customerId;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public Long getWarehouseId()
    {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    public Long getSalesmanId()
    {
        return salesmanId;
    }

    public void setSalesmanId(Long salesmanId)
    {
        this.salesmanId = salesmanId;
    }

    public BigDecimal getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public Date getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate(Date orderDate)
    {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate()
    {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getSourceType()
    {
        return sourceType;
    }

    public void setSourceType(String sourceType)
    {
        this.sourceType = sourceType;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress)
    {
        this.deliveryAddress = deliveryAddress;
    }

    public BigDecimal getShippedAmount()
    {
        return shippedAmount;
    }

    public void setShippedAmount(BigDecimal shippedAmount)
    {
        this.shippedAmount = shippedAmount;
    }

    public BigDecimal getInvoicedAmount()
    {
        return invoicedAmount;
    }

    public void setInvoicedAmount(BigDecimal invoicedAmount)
    {
        this.invoicedAmount = invoicedAmount;
    }

    public BigDecimal getReceivedAmount()
    {
        return receivedAmount;
    }

    public void setReceivedAmount(BigDecimal receivedAmount)
    {
        this.receivedAmount = receivedAmount;
    }

    @Override
    public String toString()
    {
        return "ErpSalesOrder{" +
                "orderId=" + orderId +
                ", orderNo='" + orderNo + '\'' +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", warehouseId=" + warehouseId +
                ", salesmanId=" + salesmanId +
                ", totalAmount=" + totalAmount +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", status='" + status + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", contact='" + contact + '\'' +
                ", phone='" + phone + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", shippedAmount=" + shippedAmount +
                ", invoicedAmount=" + invoicedAmount +
                ", receivedAmount=" + receivedAmount +
                '}';
    }
}
