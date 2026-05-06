package com.ruoyi.erp.inventory.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存异动记录对象 erp_inventory_trans
 * 
 * @author ruoyi
 * @date 2024-01-01
 */
public class ErpInventoryTrans extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 异动ID */
    private Long transId;

    /** 异动单号 */
    @Excel(name = "异动单号")
    private String transNo;

    /** 异动类型 */
    @Excel(name = "异动类型")
    private String transType;

    /** 来源类型 */
    @Excel(name = "来源类型")
    private String sourceType;

    /** 来源ID */
    @Excel(name = "来源ID")
    private Long sourceId;

    /** 来源单号 */
    @Excel(name = "来源单号")
    private String sourceNo;

    /** 物料ID */
    @Excel(name = "物料ID")
    private Long materialId;

    /** 仓库ID */
    @Excel(name = "仓库ID")
    private Long warehouseId;

    /** 库位ID */
    @Excel(name = "库位ID")
    private Long locationId;

    /** 批次号 */
    @Excel(name = "批次号")
    private String batchNo;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private BigDecimal inQuantity;

    /** 出库数量 */
    @Excel(name = "出库数量")
    private BigDecimal outQuantity;

    /** 异动前数量 */
    @Excel(name = "异动前数量")
    private BigDecimal beforeQuantity;

    /** 异动后数量 */
    @Excel(name = "异动后数量")
    private BigDecimal afterQuantity;

    /** 单位成本 */
    @Excel(name = "单位成本")
    private BigDecimal unitCost;

    /** 异动金额 */
    @Excel(name = "异动金额")
    private BigDecimal amount;

    /** 异动日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "异动日期", dateFormat = "yyyy-MM-dd")
    private Date transDate;

    /** 异动时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "异动时间", dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date transTime;

    /** 操作人ID */
    @Excel(name = "操作人ID")
    private Long operatorId;

    public void setTransId(Long transId)
    {
        this.transId = transId;
    }

    public Long getTransId()
    {
        return transId;
    }
    public void setTransNo(String transNo)
    {
        this.transNo = transNo;
    }

    public String getTransNo()
    {
        return transNo;
    }
    public void setTransType(String transType)
    {
        this.transType = transType;
    }

    public String getTransType()
    {
        return transType;
    }
    public void setSourceType(String sourceType)
    {
        this.sourceType = sourceType;
    }

    public String getSourceType()
    {
        return sourceType;
    }
    public void setSourceId(Long sourceId)
    {
        this.sourceId = sourceId;
    }

    public Long getSourceId()
    {
        return sourceId;
    }
    public void setSourceNo(String sourceNo)
    {
        this.sourceNo = sourceNo;
    }

    public String getSourceNo()
    {
        return sourceNo;
    }
    public void setMaterialId(Long materialId)
    {
        this.materialId = materialId;
    }

    public Long getMaterialId()
    {
        return materialId;
    }
    public void setWarehouseId(Long warehouseId)
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId()
    {
        return warehouseId;
    }
    public void setLocationId(Long locationId)
    {
        this.locationId = locationId;
    }

    public Long getLocationId()
    {
        return locationId;
    }
    public void setBatchNo(String batchNo)
    {
        this.batchNo = batchNo;
    }

    public String getBatchNo()
    {
        return batchNo;
    }
    public void setInQuantity(BigDecimal inQuantity)
    {
        this.inQuantity = inQuantity;
    }

    public BigDecimal getInQuantity()
    {
        return inQuantity;
    }
    public void setOutQuantity(BigDecimal outQuantity)
    {
        this.outQuantity = outQuantity;
    }

    public BigDecimal getOutQuantity()
    {
        return outQuantity;
    }
    public void setBeforeQuantity(BigDecimal beforeQuantity)
    {
        this.beforeQuantity = beforeQuantity;
    }

    public BigDecimal getBeforeQuantity()
    {
        return beforeQuantity;
    }
    public void setAfterQuantity(BigDecimal afterQuantity)
    {
        this.afterQuantity = afterQuantity;
    }

    public BigDecimal getAfterQuantity()
    {
        return afterQuantity;
    }
    public void setUnitCost(BigDecimal unitCost)
    {
        this.unitCost = unitCost;
    }

    public BigDecimal getUnitCost()
    {
        return unitCost;
    }
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }
    public void setTransDate(Date transDate)
    {
        this.transDate = transDate;
    }

    public Date getTransDate()
    {
        return transDate;
    }
    public void setTransTime(Date transTime)
    {
        this.transTime = transTime;
    }

    public Date getTransTime()
    {
        return transTime;
    }
    public void setOperatorId(Long operatorId)
    {
        this.operatorId = operatorId;
    }

    public Long getOperatorId()
    {
        return operatorId;
    }

    @Override
    public String toString() {
        return "ErpInventoryTrans{" +
                "transId=" + transId +
                ", transNo='" + transNo + '\'' +
                ", transType='" + transType + '\'' +
                ", sourceType='" + sourceType + '\'' +
                ", sourceId=" + sourceId +
                ", sourceNo='" + sourceNo + '\'' +
                ", materialId=" + materialId +
                ", warehouseId=" + warehouseId +
                ", locationId=" + locationId +
                ", batchNo='" + batchNo + '\'' +
                ", inQuantity=" + inQuantity +
                ", outQuantity=" + outQuantity +
                ", beforeQuantity=" + beforeQuantity +
                ", afterQuantity=" + afterQuantity +
                ", unitCost=" + unitCost +
                ", amount=" + amount +
                ", transDate=" + transDate +
                ", transTime=" + transTime +
                ", operatorId=" + operatorId +
                '}';
    }
}
