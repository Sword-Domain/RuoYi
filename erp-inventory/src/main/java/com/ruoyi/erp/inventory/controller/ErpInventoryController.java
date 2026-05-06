package com.ruoyi.erp.inventory.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.erp.inventory.domain.ErpInventory;
import com.ruoyi.erp.inventory.domain.ErpInventoryTrans;
import com.ruoyi.erp.inventory.service.IErpInventoryService;

/**
 * 库存台账Controller
 * 
 * @author ruoyi
 * @date 2024-01-01
 */
@RestController
@RequestMapping("/erp/inventory")
public class ErpInventoryController extends BaseController
{
    @Autowired
    private IErpInventoryService erpInventoryService;

    @PreAuthorize("@ss.hasPermi('erp:inventory:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpInventory erpInventory)
    {
        startPage();
        List<ErpInventory> list = erpInventoryService.selectInventoryList(erpInventory);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('erp:inventory:export')")
    @Log(title = "库存台账", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpInventory erpInventory)
    {
        List<ErpInventory> list = erpInventoryService.selectInventoryList(erpInventory);
        ExcelUtil<ErpInventory> util = new ExcelUtil<ErpInventory>(ErpInventory.class);
        return util.exportExcel(list, "库存台账数据");
    }

    @PreAuthorize("@ss.hasPermi('erp:inventory:query')")
    @GetMapping(value = "/{inventoryId}")
    public AjaxResult getInfo(@PathVariable("inventoryId") Long inventoryId)
    {
        return success(erpInventoryService.selectInventoryById(inventoryId));
    }

    @PreAuthorize("@ss.hasPermi('erp:inventory:add')")
    @Log(title = "库存台账", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpInventory erpInventory)
    {
        return toAjax(erpInventoryService.insertInventory(erpInventory));
    }

    @PreAuthorize("@ss.hasPermi('erp:inventory:edit')")
    @Log(title = "库存台账", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpInventory erpInventory)
    {
        return toAjax(erpInventoryService.updateInventory(erpInventory));
    }

    @PreAuthorize("@ss.hasPermi('erp:inventory:remove')")
    @Log(title = "库存台账", businessType = BusinessType.DELETE)
    @DeleteMapping("/{inventoryIds}")
    public AjaxResult remove(@PathVariable Long[] inventoryIds)
    {
        return toAjax(erpInventoryService.deleteInventoryByIds(inventoryIds));
    }

    @PreAuthorize("@ss.hasPermi('erp:inventory:adjust')")
    @Log(title = "库存调整", businessType = BusinessType.UPDATE)
    @PutMapping("/adjust")
    public AjaxResult adjust(@RequestBody ErpInventory erpInventory)
    {
        return toAjax(erpInventoryService.adjustInventoryQuantity(
                erpInventory.getInventoryId(),
                erpInventory.getQuantity(),
                erpInventory.getAvailableQuantity(),
                erpInventory.getAllocatedQuantity(),
                erpInventory.getFrozenQuantity(),
                erpInventory.getStatus(),
                erpInventory.getSourceType(),
                erpInventory.getSourceId(),
                erpInventory.getSourceNo(),
                erpInventory.getOperatorId()));
    }

    @PreAuthorize("@ss.hasPermi('erp:inventory:list')")
    @GetMapping("/trans/list")
    public TableDataInfo transList(ErpInventoryTrans erpInventoryTrans)
    {
        startPage();
        List<ErpInventoryTrans> list = erpInventoryService.selectInventoryTransList(erpInventoryTrans);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('erp:inventory:query')")
    @GetMapping("/trans/{transId}")
    public AjaxResult getTransInfo(@PathVariable("transId") Long transId)
    {
        ErpInventoryTrans trans = new ErpInventoryTrans();
        trans.setTransId(transId);
        List<ErpInventoryTrans> list = erpInventoryService.selectInventoryTransList(trans);
        if (list != null && !list.isEmpty())
        {
            return success(list.get(0));
        }
        return AjaxResult.error("异动记录不存在");
    }

    @PreAuthorize("@ss.hasPermi('erp:inventory:remove')")
    @Log(title = "库存异动记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/trans/{transId}")
    public AjaxResult removeTrans(@PathVariable("transId") Long transId)
    {
        return toAjax(erpInventoryService.deleteInventoryTransById(transId));
    }

    @PreAuthorize("@ss.hasPermi('erp:inventory:query')")
    @GetMapping("/detail/{materialId}/{warehouseId}")
    public AjaxResult getInventoryDetail(
            @PathVariable("materialId") Long materialId,
            @PathVariable("warehouseId") Long warehouseId,
            @RequestParam(value = "locationId", required = false) Long locationId,
            @RequestParam(value = "batchNo", required = false) String batchNo)
    {
        ErpInventory inventory = erpInventoryService.selectInventoryByMaterialWarehouse(
                materialId, warehouseId, locationId, batchNo);
        if (inventory != null)
        {
            return success(inventory);
        }
        return AjaxResult.error("库存记录不存在");
    }
}
