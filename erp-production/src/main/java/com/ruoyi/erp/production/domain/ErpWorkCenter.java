package com.ruoyi.erp.production.domain;

import java.math.BigDecimal;
import com.ruoyi.common.core.domain.BaseEntity;

public class ErpWorkCenter extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long centerId;
    private String centerCode;
    private String centerName;
    private String centerType;
    private Long departmentId;
    private String departmentName;
    private String capacityType;
    private BigDecimal capacityPerDay;
    private String status;

    public Long getCenterId() {
        return centerId;
    }

    public void setCenterId(Long centerId) {
        this.centerId = centerId;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterType() {
        return centerType;
    }

    public void setCenterType(String centerType) {
        this.centerType = centerType;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCapacityType() {
        return capacityType;
    }

    public void setCapacityType(String capacityType) {
        this.capacityType = capacityType;
    }

    public BigDecimal getCapacityPerDay() {
        return capacityPerDay;
    }

    public void setCapacityPerDay(BigDecimal capacityPerDay) {
        this.capacityPerDay = capacityPerDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
