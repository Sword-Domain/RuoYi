package com.ruoyi.erp.production.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.ruoyi.common.core.domain.BaseEntity;

public class ErpMps extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long mpsId;
    private String mpsCode;
    private Integer planYear;
    private Integer planMonth;
    private String planType;
    private String status;
    private BigDecimal totalQuantity;
    private String closedBy;
    private Date closedTime;

    public Long getMpsId() {
        return mpsId;
    }

    public void setMpsId(Long mpsId) {
        this.mpsId = mpsId;
    }

    public String getMpsCode() {
        return mpsCode;
    }

    public void setMpsCode(String mpsCode) {
        this.mpsCode = mpsCode;
    }

    public Integer getPlanYear() {
        return planYear;
    }

    public void setPlanYear(Integer planYear) {
        this.planYear = planYear;
    }

    public Integer getPlanMonth() {
        return planMonth;
    }

    public void setPlanMonth(Integer planMonth) {
        this.planMonth = planMonth;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(BigDecimal totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(String closedBy) {
        this.closedBy = closedBy;
    }

    public Date getClosedTime() {
        return closedTime;
    }

    public void setClosedTime(Date closedTime) {
        this.closedTime = closedTime;
    }
}
