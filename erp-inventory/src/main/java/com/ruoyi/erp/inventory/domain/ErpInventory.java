package com.ruoyi.erp.inventory.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存台账对象 erp_inventory
 * 
 * @author ruoyi
 * @date 2024-01-01
 */
public class ErpInventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存ID */
    private Long inventoryId;

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

    /** 库存数量 */
    @Excel(name = "库存数量")
    private BigDecimal quantity;

    /** 可用数量 */
    @Excel(name = "可用数量")
    private BigDecimal availableQuantity;

    /** 已分配数量 */
    @Excel(name = "已分配数量")
    private BigDecimal allocatedQuantity;

    /** 冻结数量 */
    @Excel(name = "冻结数量")
    private BigDecimal frozenQuantity;

    /** 单位成本 */
    @Excel(name = "单位成本")
    private BigDecimal unitCost;

    /** 总金额 */
    @Excel(name = "总金额")
    private BigDecimal totalAmount;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", dateFormat = "yyyy-MM-dd")
    private Date mfgDate;

    /** 失效日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "失效日期", dateFormat = "yyyy-MM-dd")
    private Date expDate;

    /** 状态（0正常 1冻结 2锁定） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=冻结,2=锁定")
    private String status;

    public void setInventoryId(Long inventoryId)
    {
        this.inventoryId = inventoryId;
    }

    public Long getInventoryId()
    {
        return inventoryId;
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
    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    public BigDecimal getQuantity()
    {
        return quantity;
    }
    public void setAvailableQuantity(BigDecimal availableQuantity)
    {
        this.availableQuantity = availableQuantity;
    }

    public BigDecimal getAvailableQuantity()
    {
        return availableQuantity;
    }
    public void setAllocatedQuantity(BigDecimal allocatedQuantity)
    {
        this.allocatedQuantity = allocatedQuantity;
    }

    public BigDecimal getAllocatedQuantity()
    {
        return allocatedQuantity;
    }
    public void setFrozenQuantity(BigDecimal frozenQuantity)
    {
        this.frozenQuantity = frozenQuantity;
    }

    public BigDecimal getFrozenQuantity()
    {
        return frozenQuantity;
    }
    public void setUnitCost(BigDecimal unitCost)
    {
        this.unitCost = unitCost;
    }

    public BigDecimal getUnitCost()
    {
        return unitCost;
    }
    public void setTotalAmount(BigDecimal totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount()
    {
        return totalAmount;
    }
    public void setMfgDate(Date mfgDate)
    {
        this.mfgDate = mfgDate;
    }

    public Date getMfgDate()
    {
        return mfgDate;
    }
    public void setExpDate(Date expDate)
    {
        this.expDate = expDate;
    }

    public Date getExpDate()
    {
        return expDate;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return "ErpInventory{" +
                "inventoryId=" + inventoryId +
                ", materialId=" + materialId +
                ", warehouseId=" + warehouseId +
                ", locationId=" + locationId +
                ", batchNo='" + batchNo + '\'' +
                ", quantity=" + quantity +
                ", availableQuantity=" + availableQuantity +
                ", allocatedQuantity=" + allocatedQuantity +
                ", frozenQuantity=" + frozenQuantity +
                ", unitCost=" + unitCost +
                ", totalAmount=" + totalAmount +
                ", mfgDate=" + mfgDate +
                ", expDate=" + expDate +
                ", status='" + status + '\'' +
                '}';
    }
}
