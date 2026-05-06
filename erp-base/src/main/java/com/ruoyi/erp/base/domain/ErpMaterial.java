package com.ruoyi.erp.base.domain;

import java.math.BigDecimal;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class ErpMaterial extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long materialId;

    @Excel(name = "物料编码")
    private String materialCode;

    @Excel(name = "物料名称")
    private String materialName;

    @Excel(name = "物料类型", readConverterExp = "raw=原材料,semi=半成品,finish=成品,pack=包装物,tool=工具,waste=废料")
    private String materialType;

    private String specification;

    private String unit;

    private Long categoryId;

    private String categoryName;

    @Excel(name = "采购单价", type = Excel.Type.EXPORT)
    private BigDecimal purchasePrice;

    @Excel(name = "销售单价", type = Excel.Type.EXPORT)
    private BigDecimal salePrice;

    @Excel(name = "成本单价", type = Excel.Type.EXPORT)
    private BigDecimal costPrice;

    private BigDecimal safeStock;

    private BigDecimal minStock;

    private BigDecimal maxStock;

    private Integer leadTime;

    private String batchManagement;

    private Integer shelfLife;

    private BigDecimal weight;

    private BigDecimal volume;

    private String status;

    private String delFlag;

    private Long createDept;

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getSafeStock() {
        return safeStock != null ? safeStock : BigDecimal.ZERO;
    }

    public void setSafeStock(BigDecimal safeStock) {
        this.safeStock = safeStock;
    }

    public BigDecimal getMinStock() {
        return minStock != null ? minStock : BigDecimal.ZERO;
    }

    public void setMinStock(BigDecimal minStock) {
        this.minStock = minStock;
    }

    public BigDecimal getMaxStock() {
        return maxStock != null ? maxStock : BigDecimal.ZERO;
    }

    public void setMaxStock(BigDecimal maxStock) {
        this.maxStock = maxStock;
    }

    public Integer getLeadTime() {
        return leadTime != null ? leadTime : 0;
    }

    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
    }

    public String getBatchManagement() {
        return batchManagement;
    }

    public void setBatchManagement(String batchManagement) {
        this.batchManagement = batchManagement;
    }

    public Integer getShelfLife() {
        return shelfLife != null ? shelfLife : 0;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Long getCreateDept() {
        return createDept;
    }

    public void setCreateDept(Long createDept) {
        this.createDept = createDept;
    }
}
