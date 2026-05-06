package com.ruoyi.erp.production.controller;

import java.util.Date;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.erp.production.domain.ErpMrpSuggestion;
import com.ruoyi.erp.production.service.IErpMrpService;

@Controller
@RequestMapping("/erp/production/mrp")
public class ErpMrpController extends BaseController {

    @Autowired
    private IErpMrpService mrpService;

    @RequiresPermissions("erp:mrp:view")
    @GetMapping()
    public String mrp() {
        return "erp/production/mrp/mrp";
    }

    @RequiresPermissions("erp:mrp:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ErpMrpSuggestion suggestion) {
        startPage();
        List<ErpMrpSuggestion> list = mrpService.selectSuggestionList(suggestion);
        return getDataTable(list);
    }

    @RequiresPermissions("erp:mrp:run")
    @Log(title = "MRP运算", businessType = BusinessType.OTHER)
    @PostMapping("/run")
    @ResponseBody
    public AjaxResult runMrp(@RequestParam(value = "planDate", required = false) Date planDate) {
        if (planDate == null) {
            planDate = new Date();
        }
        int count = mrpService.runMrp(planDate);
        return AjaxResult.success("MRP运算完成，共生成" + count + "条建议");
    }

    @RequiresPermissions("erp:mrp:firm")
    @Log(title = "MRP建议", businessType = BusinessType.UPDATE)
    @PostMapping("/firm")
    @ResponseBody
    public AjaxResult firm(@RequestParam("ids") Long[] ids) {
        return toAjax(mrpService.firmSuggestion(ids));
    }

    @RequiresPermissions("erp:mrp:release")
    @Log(title = "MRP建议", businessType = BusinessType.UPDATE)
    @PostMapping("/release")
    @ResponseBody
    public AjaxResult release(@RequestParam("ids") Long[] ids) {
        return toAjax(mrpService.releaseSuggestion(ids));
    }

    @RequiresPermissions("erp:mrp:generatePurchase")
    @Log(title = "MRP建议-生成采购订单", businessType = BusinessType.GENCODE)
    @PostMapping("/generatePurchase")
    @ResponseBody
    public AjaxResult generatePurchase(@RequestParam("ids") Long[] ids) {
        int count = mrpService.generatePurchaseOrder(ids);
        return AjaxResult.success("成功生成" + count + "个采购订单");
    }

    @RequiresPermissions("erp:mrp:generateProduction")
    @Log(title = "MRP建议-生成生产订单", businessType = BusinessType.GENCODE)
    @PostMapping("/generateProduction")
    @ResponseBody
    public AjaxResult generateProduction(@RequestParam("ids") Long[] ids) {
        int count = mrpService.generateProductionOrder(ids);
        return AjaxResult.success("成功生成" + count + "个生产订单");
    }

    @GetMapping("/purchase")
    public String purchase() {
        return "erp/production/mrp/purchase";
    }

    @GetMapping("/production")
    public String production() {
        return "erp/production/mrp/production";
    }
}
