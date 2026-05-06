package com.ruoyi.erp.production.domain;

import java.math.BigDecimal;
import com.ruoyi.common.core.domain.BaseEntity;

public class ErpProcess extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long processId;
    private String processCode;
    private String processName;
    private String processType;
    private Long workCenterId;
    private String workCenterName;
    private BigDecimal workTime;
    private String workTimeUnit;
    private BigDecimal setupTime;
    private BigDecimal waitTime;
    private BigDecimal transferTime;
    private String isQcRequired;
    private BigDecimal qcRate;
    private String status;

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public Long getWorkCenterId() {
        return workCenterId;
    }

    public void setWorkCenterId(Long workCenterId) {
        this.workCenterId = workCenterId;
    }

    public String getWorkCenterName() {
        return workCenterName;
    }

    public void setWorkCenterName(String workCenterName) {
        this.workCenterName = workCenterName;
    }

    public BigDecimal getWorkTime() {
        return workTime != null ? workTime : BigDecimal.ZERO;
    }

    public void setWorkTime(BigDecimal workTime) {
        this.workTime = workTime;
    }

    public String getWorkTimeUnit() {
        return workTimeUnit;
    }

    public void setWorkTimeUnit(String workTimeUnit) {
        this.workTimeUnit = workTimeUnit;
    }

    public BigDecimal getSetupTime() {
        return setupTime != null ? setupTime : BigDecimal.ZERO;
    }

    public void setSetupTime(BigDecimal setupTime) {
        this.setupTime = setupTime;
    }

    public BigDecimal getWaitTime() {
        return waitTime != null ? waitTime : BigDecimal.ZERO;
    }

    public void setWaitTime(BigDecimal waitTime) {
        this.waitTime = waitTime;
    }

    public BigDecimal getTransferTime() {
        return transferTime != null ? transferTime : BigDecimal.ZERO;
    }

    public void setTransferTime(BigDecimal transferTime) {
        this.transferTime = transferTime;
    }

    public String getIsQcRequired() {
        return isQcRequired;
    }

    public void setIsQcRequired(String isQcRequired) {
        this.isQcRequired = isQcRequired;
    }

    public BigDecimal getQcRate() {
        return qcRate != null ? qcRate : BigDecimal.valueOf(100);
    }

    public void setQcRate(BigDecimal qcRate) {
        this.qcRate = qcRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
