package com.ruoyi.erp.finance.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.erp.finance.domain.ErpPayable;
import com.ruoyi.erp.finance.service.IErpPayableService;

/**
 * 应付款管理
 *
 * @author ruoyi
 * @date 2024-01-01
 */
@Controller
@RequestMapping("/erp/finance/payable")
public class ErpPayableController extends BaseController {

    private String prefix = "/erp/finance/payable";

    @Autowired
    private IErpPayableService payableService;

    @RequiresPermissions("erp:payable:view")
    @GetMapping()
    public String payable() {
        return prefix + "/payable";
    }

    @RequiresPermissions("erp:payable:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ErpPayable payable) {
        startPage();
        List<ErpPayable> list = payableService.selectList(payable);
        return getDataTable(list);
    }

    @RequiresPermissions("erp:payable:export")
    @Log(title = "应付款", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ErpPayable payable) {
        List<ErpPayable> list = payableService.selectList(payable);
        ExcelUtil<ErpPayable> util = new ExcelUtil<>(ErpPayable.class);
        return util.exportExcel(list, "应付款数据");
    }

    @RequiresPermissions("erp:payable:detail")
    @GetMapping("/detail/{payableId}")
    public String detail(@PathVariable("payableId") Long payableId, ModelMap mmap) {
        mmap.put("payable", payableService.selectById(payableId));
        return prefix + "/detail";
    }

    @RequiresPermissions("erp:payable:add")
    @Log(title = "应付款", businessType = BusinessType.INSERT)
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("erp:payable:add")
    @Log(title = "应付款", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ErpPayable payable) {
        return toAjax(payableService.insert(payable));
    }

    @RequiresPermissions("erp:payable:edit")
    @Log(title = "应付款", businessType = BusinessType.UPDATE)
    @GetMapping("/edit/{payableId}")
    public String edit(@PathVariable("payableId") Long payableId, ModelMap mmap) {
        mmap.put("payable", payableService.selectById(payableId));
        return prefix + "/edit";
    }

    @RequiresPermissions("erp:payable:edit")
    @Log(title = "应付款", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ErpPayable payable) {
        return toAjax(payableService.update(payable));
    }

    @RequiresPermissions("erp:payable:remove")
    @Log(title = "应付款", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(payableService.delete(ids));
    }

}
