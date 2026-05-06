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
import com.ruoyi.erp.finance.domain.ErpPayment;
import com.ruoyi.erp.finance.service.IErpPaymentService;

/**
 * 付款单管理
 *
 * @author ruoyi
 * @date 2024-01-01
 */
@Controller
@RequestMapping("/erp/finance/payment")
public class ErpPaymentController extends BaseController {

    private String prefix = "/erp/finance/payment";

    @Autowired
    private IErpPaymentService paymentService;

    @RequiresPermissions("erp:payment:view")
    @GetMapping()
    public String payment() {
        return prefix + "/payment";
    }

    @RequiresPermissions("erp:payment:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ErpPayment payment) {
        startPage();
        List<ErpPayment> list = paymentService.selectList(payment);
        return getDataTable(list);
    }

    @RequiresPermissions("erp:payment:export")
    @Log(title = "付款单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ErpPayment payment) {
        List<ErpPayment> list = paymentService.selectList(payment);
        ExcelUtil<ErpPayment> util = new ExcelUtil<>(ErpPayment.class);
        return util.exportExcel(list, "付款单数据");
    }

    @RequiresPermissions("erp:payment:detail")
    @GetMapping("/detail/{paymentId}")
    public String detail(@PathVariable("paymentId") Long paymentId, ModelMap mmap) {
        mmap.put("payment", paymentService.selectById(paymentId));
        return prefix + "/detail";
    }

    @RequiresPermissions("erp:payment:add")
    @Log(title = "付款单", businessType = BusinessType.INSERT)
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("erp:payment:add")
    @Log(title = "付款单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ErpPayment payment) {
        return toAjax(paymentService.insert(payment));
    }

    @RequiresPermissions("erp:payment:edit")
    @Log(title = "付款单", businessType = BusinessType.UPDATE)
    @GetMapping("/edit/{paymentId}")
    public String edit(@PathVariable("paymentId") Long paymentId, ModelMap mmap) {
        mmap.put("payment", paymentService.selectById(paymentId));
        return prefix + "/edit";
    }

    @RequiresPermissions("erp:payment:edit")
    @Log(title = "付款单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ErpPayment payment) {
        return toAjax(paymentService.update(payment));
    }

    @RequiresPermissions("erp:payment:remove")
    @Log(title = "付款单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(paymentService.delete(ids));
    }

}
