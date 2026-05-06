package com.ruoyi.erp.production.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import com.ruoyi.common.core.domain.BaseEntity;

public class ErpProductionOrder extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long orderId;
    private String orderNo;
    private String sourceType;
    private Long sourceId;
    private String sourceNo;
    private Long materialId;
    private String materialName;
    private String materialCode;
    private String specification;
    private String unit;
    private Long warehouseId;
    private String warehouseName;
    private Long routingId;
    private Long bomId;
    private BigDecimal orderQuantity;
    private BigDecimal finishedQuantity;
    private BigDecimal scrappedQuantity;
    private Date planStartDate;
    private Date planFinishDate;
    private Date actualStartDate;
    private Date actualFinishDate;
    private Integer priority;
    private String status;
    private String bomVersion;
    private String routingVersion;
    private Integer workOrderCount;
    private Integer completedWorkOrderCount;
    private String closedBy;
    private Date closedTime;
    private String closeReason;

    private List<ErpProductionOrderItem> items;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
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

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Long getRoutingId() {
        return routingId;
    }

    public void setRoutingId(Long routingId) {
        this.routingId = routingId;
    }

    public Long getBomId() {
        return bomId;
    }

    public void setBomId(Long bomId) {
        this.bomId = bomId;
    }

    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public BigDecimal getFinishedQuantity() {
        return finishedQuantity != null ? finishedQuantity : BigDecimal.ZERO;
    }

    public void setFinishedQuantity(BigDecimal finishedQuantity) {
        this.finishedQuantity = finishedQuantity;
    }

    public BigDecimal getScrappedQuantity() {
        return scrappedQuantity != null ? scrappedQuantity : BigDecimal.ZERO;
    }

    public void setScrappedQuantity(BigDecimal scrappedQuantity) {
        this.scrappedQuantity = scrappedQuantity;
    }

    public Date getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Date getPlanFinishDate() {
        return planFinishDate;
    }

    public void setPlanFinishDate(Date planFinishDate) {
        this.planFinishDate = planFinishDate;
    }

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public Date getActualFinishDate() {
        return actualFinishDate;
    }

    public void setActualFinishDate(Date actualFinishDate) {
        this.actualFinishDate = actualFinishDate;
    }

    public Integer getPriority() {
        return priority != null ? priority : 1;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBomVersion() {
        return bomVersion;
    }

    public void setBomVersion(String bomVersion) {
        this.bomVersion = bomVersion;
    }

    public String getRoutingVersion() {
        return routingVersion;
    }

    public void setRoutingVersion(String routingVersion) {
        this.routingVersion = routingVersion;
    }

    public Integer getWorkOrderCount() {
        return workOrderCount != null ? workOrderCount : 0;
    }

    public void setWorkOrderCount(Integer workOrderCount) {
        this.workOrderCount = workOrderCount;
    }

    public Integer getCompletedWorkOrderCount() {
        return completedWorkOrderCount != null ? completedWorkOrderCount : 0;
    }

    public void setCompletedWorkOrderCount(Integer completedWorkOrderCount) {
        this.completedWorkOrderCount = completedWorkOrderCount;
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

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public List<ErpProductionOrderItem> getItems() {
        return items;
    }

    public void setItems(List<ErpProductionOrderItem> items) {
        this.items = items;
    }
}
