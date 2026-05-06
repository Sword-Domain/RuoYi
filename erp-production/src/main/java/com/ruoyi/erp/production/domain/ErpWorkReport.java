package com.ruoyi.erp.production.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.ruoyi.common.core.domain.BaseEntity;

public class ErpWorkReport extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long reportId;
    private String reportNo;
    private Long workOrderId;
    private String workOrderNo;
    private Long productionOrderId;
    private String productionOrderNo;
    private Long processId;
    private String processName;
    private Long workCenterId;
    private Long reporterId;
    private String reporterName;
    private String reportType;
    private BigDecimal quantity;
    private BigDecimal qualifiedQuantity;
    private BigDecimal scrappedQuantity;
    private BigDecimal workHours;
    private Date reportTime;
    private String qcStatus;
    private Long qcOrderId;
    private String status;
    private String confirmedBy;
    private Date confirmedTime;

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getWorkOrderNo() {
        return workOrderNo;
    }

    public void setWorkOrderNo(String workOrderNo) {
        this.workOrderNo = workOrderNo;
    }

    public Long getProductionOrderId() {
        return productionOrderId;
    }

    public void setProductionOrderId(Long productionOrderId) {
        this.productionOrderId = productionOrderId;
    }

    public String getProductionOrderNo() {
        return productionOrderNo;
    }

    public void setProductionOrderNo(String productionOrderNo) {
        this.productionOrderNo = productionOrderNo;
    }

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Long getWorkCenterId() {
        return workCenterId;
    }

    public void setWorkCenterId(Long workCenterId) {
        this.workCenterId = workCenterId;
    }

    public Long getReporterId() {
        return reporterId;
    }

    public void setReporterId(Long reporterId) {
        this.reporterId = reporterId;
    }

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getQualifiedQuantity() {
        return qualifiedQuantity;
    }

    public void setQualifiedQuantity(BigDecimal qualifiedQuantity) {
        this.qualifiedQuantity = qualifiedQuantity;
    }

    public BigDecimal getScrappedQuantity() {
        return scrappedQuantity;
    }

    public void setScrappedQuantity(BigDecimal scrappedQuantity) {
        this.scrappedQuantity = scrappedQuantity;
    }

    public BigDecimal getWorkHours() {
        return workHours;
    }

    public void setWorkHours(BigDecimal workHours) {
        this.workHours = workHours;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getQcStatus() {
        return qcStatus;
    }

    public void setQcStatus(String qcStatus) {
        this.qcStatus = qcStatus;
    }

    public Long getQcOrderId() {
        return qcOrderId;
    }

    public void setQcOrderId(Long qcOrderId) {
        this.qcOrderId = qcOrderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConfirmedBy() {
        return confirmedBy;
    }

    public void setConfirmedBy(String confirmedBy) {
        this.confirmedBy = confirmedBy;
    }

    public Date getConfirmedTime() {
        return confirmedTime;
    }

    public void setConfirmedTime(Date confirmedTime) {
        this.confirmedTime = confirmedTime;
    }
}
