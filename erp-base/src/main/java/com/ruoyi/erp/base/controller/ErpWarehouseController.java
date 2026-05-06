package com.ruoyi.erp.base.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.erp.base.domain.ErpWarehouse;
import com.ruoyi.erp.base.service.IErpWarehouseService;

@Controller
@RequestMapping("/erp/base/warehouse")
public class ErpWarehouseController extends BaseController {

    private String prefix = "erp/base/warehouse";

    @Autowired
    private IErpWarehouseService warehouseService;

    @RequiresPermissions("erp:warehouse:view")
    @GetMapping()
    public String warehouse() {
        return prefix + "/warehouse";
    }

    @RequiresPermissions("erp:warehouse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ErpWarehouse warehouse) {
        startPage();
        List<ErpWarehouse> list = warehouseService.selectWarehouseList(warehouse);
        return getDataTable(list);
    }

    @RequiresPermissions("erp:warehouse:export")
    @Log(title = "仓库管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ErpWarehouse warehouse) {
        List<ErpWarehouse> list = warehouseService.selectWarehouseList(warehouse);
        return AjaxResult.success();
    }

    @RequiresPermissions("erp:warehouse:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("erp:warehouse:add")
    @Log(title = "仓库管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated ErpWarehouse warehouse) {
        return toAjax(warehouseService.insertWarehouse(warehouse));
    }

    @RequiresPermissions("erp:warehouse:edit")
    @GetMapping("/edit/{warehouseId}")
    public String edit(@PathVariable("warehouseId") Long warehouseId, ModelMap mmap) {
        mmap.put("warehouse", warehouseService.selectWarehouseById(warehouseId));
        return prefix + "/edit";
    }

    @RequiresPermissions("erp:warehouse:edit")
    @Log(title = "仓库管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated ErpWarehouse warehouse) {
        return toAjax(warehouseService.updateWarehouse(warehouse));
    }

    @RequiresPermissions("erp:warehouse:remove")
    @Log(title = "仓库管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(warehouseService.deleteWarehouseByIds(convertToLongArray(ids)));
    }

    @RequiresPermissions("erp:warehouse:list")
    @PostMapping("/selectWarehouseList")
    @ResponseBody
    public AjaxResult selectWarehouseList(ErpWarehouse warehouse) {
        List<ErpWarehouse> list = warehouseService.selectWarehouseList(warehouse);
        return AjaxResult.success(list);
    }
}
