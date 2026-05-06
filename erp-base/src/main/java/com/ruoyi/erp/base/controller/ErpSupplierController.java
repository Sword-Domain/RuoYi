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
import com.ruoyi.erp.base.domain.ErpSupplier;
import com.ruoyi.erp.base.service.IErpSupplierService;

@Controller
@RequestMapping("/erp/base/supplier")
public class ErpSupplierController extends BaseController {

    private String prefix = "erp/base/supplier";

    @Autowired
    private IErpSupplierService supplierService;

    @RequiresPermissions("erp:supplier:view")
    @GetMapping()
    public String supplier() {
        return prefix + "/supplier";
    }

    @RequiresPermissions("erp:supplier:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ErpSupplier supplier) {
        startPage();
        List<ErpSupplier> list = supplierService.selectSupplierList(supplier);
        return getDataTable(list);
    }

    @RequiresPermissions("erp:supplier:export")
    @Log(title = "供应商管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ErpSupplier supplier) {
        List<ErpSupplier> list = supplierService.selectSupplierList(supplier);
        return AjaxResult.success();
    }

    @RequiresPermissions("erp:supplier:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("erp:supplier:add")
    @Log(title = "供应商管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated ErpSupplier supplier) {
        return toAjax(supplierService.insertSupplier(supplier));
    }

    @RequiresPermissions("erp:supplier:edit")
    @GetMapping("/edit/{supplierId}")
    public String edit(@PathVariable("supplierId") Long supplierId, ModelMap mmap) {
        mmap.put("supplier", supplierService.selectSupplierById(supplierId));
        return prefix + "/edit";
    }

    @RequiresPermissions("erp:supplier:edit")
    @Log(title = "供应商管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated ErpSupplier supplier) {
        return toAjax(supplierService.updateSupplier(supplier));
    }

    @RequiresPermissions("erp:supplier:remove")
    @Log(title = "供应商管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(supplierService.deleteSupplierByIds(convertToLongArray(ids)));
    }

    @RequiresPermissions("erp:supplier:list")
    @PostMapping("/selectSupplierList")
    @ResponseBody
    public AjaxResult selectSupplierList(ErpSupplier supplier) {
        List<ErpSupplier> list = supplierService.selectSupplierList(supplier);
        return AjaxResult.success(list);
    }
}
