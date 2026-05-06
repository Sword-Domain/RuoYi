package com.ruoyi.erp.production.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.ruoyi.common.core.domain.BaseEntity;

public class ErpMrp extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long mrpId;
    private String mrpCode;
    private Date planDate;
    private String status;
    private BigDecimal totalPurchaseQty;
    private BigDecimal totalProductionQty;

    public Long getMrpId() {
        return mrpId;
    }

    public void setMrpId(Long mrpId) {
        this.mrpId = mrpId;
    }

    public String getMrpCode() {
        return mrpCode;
    }

    public void setMrpCode(String mrpCode) {
        this.mrpCode = mrpCode;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalPurchaseQty() {
        return totalPurchaseQty;
    }

    public void setTotalPurchaseQty(BigDecimal totalPurchaseQty) {
        this.totalPurchaseQty = totalPurchaseQty;
    }

    public BigDecimal getTotalProductionQty() {
        return totalProductionQty;
    }

    public void setTotalProductionQty(BigDecimal totalProductionQty) {
        this.totalProductionQty = totalProductionQty;
    }
}
