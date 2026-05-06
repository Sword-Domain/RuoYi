package com.ruoyi.erp.inventory.service;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.erp.inventory.domain.ErpInventory;
import com.ruoyi.erp.inventory.domain.ErpInventoryTrans;

/**
 * 库存台账Service接口
 * 
 * @author ruoyi
 * @date 2024-01-01
 */
public interface IErpInventoryService
{
    /**
     * 查询库存台账列表
     * 
     * @param erpInventory 库存台账
     * @return 库存台账集合
     */
    public List<ErpInventory> selectInventoryList(ErpInventory erpInventory);

    /**
     * 查询库存台账详情
     * 
     * @param inventoryId 库存ID
     * @return 库存台账
     */
    public ErpInventory selectInventoryById(Long inventoryId);

    /**
     * 根据物料和仓库查询库存
     * 
     * @param materialId 物料ID
     * @param warehouseId 仓库ID
     * @param locationId 库位ID
     * @param batchNo 批次号
     * @return 库存台账
     */
    public ErpInventory selectInventoryByMaterialWarehouse(Long materialId, Long warehouseId, Long locationId, String batchNo);

    /**
     * 新增库存台账
     * 
     * @param erpInventory 库存台账
     * @return 结果
     */
    public int insertInventory(ErpInventory erpInventory);

    /**
     * 修改库存台账
     * 
     * @param erpInventory 库存台账
     * @return 结果
     */
    public int updateInventory(ErpInventory erpInventory);

    /**
     * 删除库存台账
     * 
     * @param inventoryId 库存ID
     * @return 结果
     */
    public int deleteInventoryById(Long inventoryId);

    /**
     * 批量删除库存台账
     * 
     * @param inventoryIds 需要删除的库存ID
     * @return 结果
     */
    public int deleteInventoryByIds(Long[] inventoryIds);

    /**
     * 调整库存数量
     * 
     * @param inventoryId 库存ID
     * @param quantity 调整数量（正数增加，负数减少）
     * @param availableQuantity 调整可用数量
     * @param allocatedQuantity 调整已分配数量
     * @param frozenQuantity 调整冻结数量
     * @param transType 异动类型
     * @param sourceType 来源类型
     * @param sourceId 来源ID
     * @param sourceNo 来源单号
     * @param operatorId 操作人ID
     * @return 结果
     */
    public int adjustInventoryQuantity(Long inventoryId, BigDecimal quantity, BigDecimal availableQuantity, 
                                       BigDecimal allocatedQuantity, BigDecimal frozenQuantity,
                                       String transType, String sourceType, Long sourceId, String sourceNo, Long operatorId);

    /**
     * 记录库存异动
     * 
     * @param transType 异动类型
     * @param sourceType 来源类型
     * @param sourceId 来源ID
     * @param sourceNo 来源单号
     * @param materialId 物料ID
     * @param warehouseId 仓库ID
     * @param locationId 库位ID
     * @param batchNo 批次号
     * @param inQuantity 入库数量
     * @param outQuantity 出库数量
     * @param beforeQuantity 异动前数量
     * @param afterQuantity 异动后数量
     * @param unitCost 单位成本
     * @param operatorId 操作人ID
     * @return 结果
     */
    public int recordInventoryTrans(String transType, String sourceType, Long sourceId, String sourceNo,
                                   Long materialId, Long warehouseId, Long locationId, String batchNo,
                                   BigDecimal inQuantity, BigDecimal outQuantity, 
                                   BigDecimal beforeQuantity, BigDecimal afterQuantity,
                                   BigDecimal unitCost, Long operatorId);

    /**
     * 查询库存异动记录列表
     * 
     * @param erpInventoryTrans 库存异动记录
     * @return 库存异动记录集合
     */
    public List<ErpInventoryTrans> selectInventoryTransList(ErpInventoryTrans erpInventoryTrans);

    /**
     * 删除库存异动记录
     * 
     * @param transId 异动ID
     * @return 结果
     */
    public int deleteInventoryTransById(Long transId);
}
