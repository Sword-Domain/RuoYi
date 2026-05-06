package com.ruoyi.erp.inventory.service.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.erp.inventory.mapper.ErpInventoryMapper;
import com.ruoyi.erp.inventory.domain.ErpInventory;
import com.ruoyi.erp.inventory.domain.ErpInventoryTrans;
import com.ruoyi.erp.inventory.service.IErpInventoryService;

/**
 * 库存台账Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-01
 */
@Service
public class ErpInventoryServiceImpl implements IErpInventoryService
{
    @Autowired
    private ErpInventoryMapper erpInventoryMapper;

    @Override
    public List<ErpInventory> selectInventoryList(ErpInventory erpInventory)
    {
        return erpInventoryMapper.selectInventoryList(erpInventory);
    }

    @Override
    public ErpInventory selectInventoryById(Long inventoryId)
    {
        return erpInventoryMapper.selectInventoryById(inventoryId);
    }

    @Override
    public ErpInventory selectInventoryByMaterialWarehouse(Long materialId, Long warehouseId, Long locationId, String batchNo)
    {
        return erpInventoryMapper.selectInventoryByMaterialWarehouse(materialId, warehouseId, locationId, batchNo);
    }

    @Override
    @Transactional
    public int insertInventory(ErpInventory erpInventory)
    {
        return erpInventoryMapper.insertInventory(erpInventory);
    }

    @Override
    @Transactional
    public int updateInventory(ErpInventory erpInventory)
    {
        return erpInventoryMapper.updateInventory(erpInventory);
    }

    @Override
    @Transactional
    public int deleteInventoryById(Long inventoryId)
    {
        return erpInventoryMapper.deleteInventoryById(inventoryId);
    }

    @Override
    @Transactional
    public int deleteInventoryByIds(Long[] inventoryIds)
    {
        return erpInventoryMapper.deleteInventoryByIds(inventoryIds);
    }

    @Override
    @Transactional
    public int adjustInventoryQuantity(Long inventoryId, BigDecimal quantity, BigDecimal availableQuantity,
                                      BigDecimal allocatedQuantity, BigDecimal frozenQuantity,
                                      String transType, String sourceType, Long sourceId, String sourceNo, Long operatorId)
    {
        ErpInventory inventory = erpInventoryMapper.selectInventoryById(inventoryId);
        if (inventory == null)
        {
            return 0;
        }

        BigDecimal beforeQuantity = inventory.getQuantity();
        BigDecimal beforeAvailable = inventory.getAvailableQuantity();
        
        BigDecimal newQuantity = inventory.getQuantity().add(quantity);
        BigDecimal newAvailableQuantity = inventory.getAvailableQuantity().add(availableQuantity);
        BigDecimal newAllocatedQuantity = inventory.getAllocatedQuantity().add(allocatedQuantity);
        BigDecimal newFrozenQuantity = inventory.getFrozenQuantity().add(frozenQuantity);
        
        BigDecimal totalAmount = newQuantity.multiply(inventory.getUnitCost());
        
        int result = erpInventoryMapper.updateInventoryQuantity(inventoryId, newQuantity, newAvailableQuantity,
                newAllocatedQuantity, newFrozenQuantity, inventory.getUnitCost(), totalAmount);
        
        if (result > 0)
        {
            BigDecimal inQty = quantity.compareTo(BigDecimal.ZERO) > 0 ? quantity : BigDecimal.ZERO;
            BigDecimal outQty = quantity.compareTo(BigDecimal.ZERO) < 0 ? quantity.abs() : BigDecimal.ZERO;
            BigDecimal amount = inQty.compareTo(BigDecimal.ZERO) > 0 ? 
                    inQty.multiply(inventory.getUnitCost()) : outQty.multiply(inventory.getUnitCost());
            
            recordInventoryTrans(transType, sourceType, sourceId, sourceNo,
                    inventory.getMaterialId(), inventory.getWarehouseId(), inventory.getLocationId(),
                    inventory.getBatchNo(), inQty, outQty, beforeQuantity, newQuantity,
                    inventory.getUnitCost(), operatorId);
        }
        
        return result;
    }

    @Override
    @Transactional
    public int recordInventoryTrans(String transType, String sourceType, Long sourceId, String sourceNo,
                                   Long materialId, Long warehouseId, Long locationId, String batchNo,
                                   BigDecimal inQuantity, BigDecimal outQuantity,
                                   BigDecimal beforeQuantity, BigDecimal afterQuantity,
                                   BigDecimal unitCost, Long operatorId)
    {
        ErpInventoryTrans trans = new ErpInventoryTrans();
        trans.setTransNo(generateTransNo());
        trans.setTransType(transType);
        trans.setSourceType(sourceType);
        trans.setSourceId(sourceId);
        trans.setSourceNo(sourceNo);
        trans.setMaterialId(materialId);
        trans.setWarehouseId(warehouseId);
        trans.setLocationId(locationId);
        trans.setBatchNo(batchNo);
        trans.setInQuantity(inQuantity);
        trans.setOutQuantity(outQuantity);
        trans.setBeforeQuantity(beforeQuantity);
        trans.setAfterQuantity(afterQuantity);
        trans.setUnitCost(unitCost);
        if (inQuantity != null && inQuantity.compareTo(BigDecimal.ZERO) > 0)
        {
            trans.setAmount(inQuantity.multiply(unitCost));
        }
        else if (outQuantity != null && outQuantity.compareTo(BigDecimal.ZERO) > 0)
        {
            trans.setAmount(outQuantity.multiply(unitCost));
        }
        trans.setTransDate(new Date());
        trans.setTransTime(new Date());
        trans.setOperatorId(operatorId);
        
        return erpInventoryMapper.insertInventoryTrans(trans);
    }

    @Override
    public List<ErpInventoryTrans> selectInventoryTransList(ErpInventoryTrans erpInventoryTrans)
    {
        return erpInventoryMapper.selectInventoryTransList(erpInventoryTrans);
    }

    @Override
    @Transactional
    public int deleteInventoryTransById(Long transId)
    {
        return erpInventoryMapper.deleteInventoryTransById(transId);
    }

    private String generateTransNo()
    {
        return "TR" + System.currentTimeMillis();
    }
}
