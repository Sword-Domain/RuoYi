package com.ruoyi.erp.sales.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.web.domain.BaseEntity;

public class ErpSalesOrderItem extends BaseEntity
{
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

    @Excel(name = "数量", readConverterExp = "$column.readConverterExp")
    private BigDecimal quantity;

    @Excel(name = "单价", readConverterExp = "$column.readConverterExp")
    private BigDecimal unitPrice;

    @Excel(name = "税率(%)")
    private BigDecimal taxRate;

    @Excel(name = "税额", readConverterExp = "$column.readConverterExp")
    private BigDecimal taxAmount;

    @Excel(name = "金额", readConverterExp = "$column.readConverterExp")
    private BigDecimal amount;

    @Excel(name = "已交货数量", readConverterExp = "$column.readConverterExp")
    private BigDecimal deliveredQuantity;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "交货日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryDate;

    @Excel(name = "明细状态", readConverterExp = "10=正常,20=已关闭,30=已取消")
    private String status;

    public Long getItemId()
    {
        return itemId;
    }

    public void setItemId(Long itemId)
    {
        this.itemId = itemId;
    }

    public Long getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }

    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public String getMaterialName()
    {
        return materialName;
    }

    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }

    public String getMaterialCode()
    {
        return materialCode;
    }

    public void setMaterialCode(String materialCode)
    {
        this.materialCode = materialCode;
    }

    public String getSpecification()
    {
        return specification;
    }

    public void setSpecification(String specification)
    {
        this.specification = specification;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public BigDecimal getQuantity()
    {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTaxRate()
    {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate)
    {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxAmount()
    {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount)
    {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getDeliveredQuantity()
    {
        return deliveredQuantity;
    }

    public void setDeliveredQuantity(BigDecimal deliveredQuantity)
    {
        this.deliveredQuantity = deliveredQuantity;
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

    @Override
    public String toString()
    {
        return "ErpSalesOrderItem{" +
                "itemId=" + itemId +
                ", orderId=" + orderId +
                ", materialId=" + materialId +
                ", materialName='" + materialName + '\'' +
                ", materialCode='" + materialCode + '\'' +
                ", specification='" + specification + '\'' +
                ", unit='" + unit + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", taxRate=" + taxRate +
                ", taxAmount=" + taxAmount +
                ", amount=" + amount +
                ", deliveredQuantity=" + deliveredQuantity +
                ", deliveryDate=" + deliveryDate +
                ", status='" + status + '\'' +
                '}';
    }
}
