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
import com.ruoyi.erp.finance.domain.ErpReceivable;
import com.ruoyi.erp.finance.service.IErpReceivableService;

/**
 * 应收款管理
 *
 * @author ruoyi
 * @date 2024-01-01
 */
@Controller
@RequestMapping("/erp/finance/receivable")
public class ErpReceivableController extends BaseController {

    private String prefix = "/erp/finance/receivable";

    @Autowired
    private IErpReceivableService receivableService;

    @RequiresPermissions("erp:receivable:view")
    @GetMapping()
    public String receivable() {
        return prefix + "/receivable";
    }

    @RequiresPermissions("erp:receivable:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ErpReceivable receivable) {
        startPage();
        List<ErpReceivable> list = receivableService.selectList(receivable);
        return getDataTable(list);
    }

    @RequiresPermissions("erp:receivable:export")
    @Log(title = "应收款", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ErpReceivable receivable) {
        List<ErpReceivable> list = receivableService.selectList(receivable);
        ExcelUtil<ErpReceivable> util = new ExcelUtil<>(ErpReceivable.class);
        return util.exportExcel(list, "应收款数据");
    }

    @RequiresPermissions("erp:receivable:detail")
    @GetMapping("/detail/{receivableId}")
    public String detail(@PathVariable("receivableId") Long receivableId, ModelMap mmap) {
        mmap.put("receivable", receivableService.selectById(receivableId));
        return prefix + "/detail";
    }

    @RequiresPermissions("erp:receivable:add")
    @Log(title = "应收款", businessType = BusinessType.INSERT)
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("erp:receivable:add")
    @Log(title = "应收款", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ErpReceivable receivable) {
        return toAjax(receivableService.insert(receivable));
    }

    @RequiresPermissions("erp:receivable:edit")
    @Log(title = "应收款", businessType = BusinessType.UPDATE)
    @GetMapping("/edit/{receivableId}")
    public String edit(@PathVariable("receivableId") Long receivableId, ModelMap mmap) {
        mmap.put("receivable", receivableService.selectById(receivableId));
        return prefix + "/edit";
    }

    @RequiresPermissions("erp:receivable:edit")
    @Log(title = "应收款", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ErpReceivable receivable) {
        return toAjax(receivableService.update(receivable));
    }

    @RequiresPermissions("erp:receivable:remove")
    @Log(title = "应收款", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(receivableService.delete(ids));
    }

}
