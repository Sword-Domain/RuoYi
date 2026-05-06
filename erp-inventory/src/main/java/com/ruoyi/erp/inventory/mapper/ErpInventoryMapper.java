package com.ruoyi.erp.inventory.mapper;

import java.util.List;
import com.ruoyi.erp.inventory.domain.ErpInventory;
import com.ruoyi.erp.inventory.domain.ErpInventoryTrans;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 库存台账Mapper接口
 * 
 * @author ruoyi
 * @date 2024-01-01
 */
@Mapper
public interface ErpInventoryMapper
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
    public ErpInventory selectInventoryById(@Param("inventoryId") Long inventoryId);

    /**
     * 根据物料和仓库查询库存
     * 
     * @param materialId 物料ID
     * @param warehouseId 仓库ID
     * @param locationId 库位ID
     * @param batchNo 批次号
     * @return 库存台账
     */
    public ErpInventory selectInventoryByMaterialWarehouse(
            @Param("materialId") Long materialId,
            @Param("warehouseId") Long warehouseId,
            @Param("locationId") Long locationId,
            @Param("batchNo") String batchNo);

    /**
     * 修改库存数量
     * 
     * @param inventoryId 库存ID
     * @param quantity 库存数量
     * @param availableQuantity 可用数量
     * @param allocatedQuantity 已分配数量
     * @param frozenQuantity 冻结数量
     * @param unitCost 单位成本
     * @param totalAmount 总金额
     * @return 结果
     */
    public int updateInventoryQuantity(
            @Param("inventoryId") Long inventoryId,
            @Param("quantity") java.math.BigDecimal quantity,
            @Param("availableQuantity") java.math.BigDecimal availableQuantity,
            @Param("allocatedQuantity") java.math.BigDecimal allocatedQuantity,
            @Param("frozenQuantity") java.math.BigDecimal frozenQuantity,
            @Param("unitCost") java.math.BigDecimal unitCost,
            @Param("totalAmount") java.math.BigDecimal totalAmount);

    /**
     * 新增库存异动记录
     * 
     * @param erpInventoryTrans 库存异动记录
     * @return 结果
     */
    public int insertInventoryTrans(ErpInventoryTrans erpInventoryTrans);

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
    public int deleteInventoryTransById(@Param("transId") Long transId);
}
