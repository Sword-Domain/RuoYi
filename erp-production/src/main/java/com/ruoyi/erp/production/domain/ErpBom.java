package com.ruoyi.erp.production.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import com.ruoyi.common.core.domain.BaseEntity;

public class ErpBom extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long bomId;
    private String bomCode;
    private String bomName;
    private Long materialId;
    private String materialName;
    private String materialCode;
    private String specification;
    private String unit;
    private String version;
    private String status;
    private Date effectiveDate;
    private Date obsoleteDate;
    private BigDecimal quantity;
    private BigDecimal lossRate;
    private String remark;

    private List<ErpBomItem> items;

    public Long getBomId() {
        return bomId;
    }

    public void setBomId(Long bomId) {
        this.bomId = bomId;
    }

    public String getBomCode() {
        return bomCode;
    }

    public void setBomCode(String bomCode) {
        this.bomCode = bomCode;
    }

    public String getBomName() {
        return bomName;
    }

    public void setBomName(String bomName) {
        this.bomName = bomName;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getObsoleteDate() {
        return obsoleteDate;
    }

    public void setObsoleteDate(Date obsoleteDate) {
        this.obsoleteDate = obsoleteDate;
    }

    public BigDecimal getQuantity() {
        return quantity != null ? quantity : BigDecimal.ONE;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getLossRate() {
        return lossRate != null ? lossRate : BigDecimal.ZERO;
    }

    public void setLossRate(BigDecimal lossRate) {
        this.lossRate = lossRate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ErpBomItem> getItems() {
        return items;
    }

    public void setItems(List<ErpBomItem> items) {
        this.items = items;
    }
}
