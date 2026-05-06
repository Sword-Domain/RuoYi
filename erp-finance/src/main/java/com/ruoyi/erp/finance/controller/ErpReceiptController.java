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
import com.ruoyi.erp.finance.domain.ErpReceipt;
import com.ruoyi.erp.finance.service.IErpReceiptService;

/**
 * 收款单管理
 *
 * @author ruoyi
 * @date 2024-01-01
 */
@Controller
@RequestMapping("/erp/finance/receipt")
public class ErpReceiptController extends BaseController {

    private String prefix = "/erp/finance/receipt";

    @Autowired
    private IErpReceiptService receiptService;

    @RequiresPermissions("erp:receipt:view")
    @GetMapping()
    public String receipt() {
        return prefix + "/receipt";
    }

    @RequiresPermissions("erp:receipt:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ErpReceipt receipt) {
        startPage();
        List<ErpReceipt> list = receiptService.selectList(receipt);
        return getDataTable(list);
    }

    @RequiresPermissions("erp:receipt:export")
    @Log(title = "收款单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ErpReceipt receipt) {
        List<ErpReceipt> list = receiptService.selectList(receipt);
        ExcelUtil<ErpReceipt> util = new ExcelUtil<>(ErpReceipt.class);
        return util.exportExcel(list, "收款单数据");
    }

    @RequiresPermissions("erp:receipt:detail")
    @GetMapping("/detail/{receiptId}")
    public String detail(@PathVariable("receiptId") Long receiptId, ModelMap mmap) {
        mmap.put("receipt", receiptService.selectById(receiptId));
        return prefix + "/detail";
    }

    @RequiresPermissions("erp:receipt:add")
    @Log(title = "收款单", businessType = BusinessType.INSERT)
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("erp:receipt:add")
    @Log(title = "收款单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ErpReceipt receipt) {
        return toAjax(receiptService.insert(receipt));
    }

    @RequiresPermissions("erp:receipt:edit")
    @Log(title = "收款单", businessType = BusinessType.UPDATE)
    @GetMapping("/edit/{receiptId}")
    public String edit(@PathVariable("receiptId") Long receiptId, ModelMap mmap) {
        mmap.put("receipt", receiptService.selectById(receiptId));
        return prefix + "/edit";
    }

    @RequiresPermissions("erp:receipt:edit")
    @Log(title = "收款单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ErpReceipt receipt) {
        return toAjax(receiptService.update(receipt));
    }

    @RequiresPermissions("erp:receipt:remove")
    @Log(title = "收款单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(receiptService.delete(ids));
    }

}
