package com.ruoyi.erp.production.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.erp.production.domain.ErpProductionOrder;
import com.ruoyi.erp.production.service.IErpProductionOrderService;

@Controller
@RequestMapping("/erp/production/order")
public class ErpProductionOrderController extends BaseController {

    private String prefix = "erp/production/order";

    @Autowired
    private IErpProductionOrderService productionOrderService;

    @RequiresPermissions("erp:productionOrder:view")
    @GetMapping()
    public String order() {
        return prefix + "/order";
    }

    @RequiresPermissions("erp:productionOrder:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ErpProductionOrder order) {
        startPage();
        List<ErpProductionOrder> list = productionOrderService.selectProductionOrderList(order);
        return getDataTable(list);
    }

    @RequiresPermissions("erp:productionOrder:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("erp:productionOrder:add")
    @Log(title = "生产订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ErpProductionOrder order) {
        return toAjax(productionOrderService.insertProductionOrder(order));
    }

    @RequiresPermissions("erp:productionOrder:edit")
    @GetMapping("/edit/{orderId}")
    public String edit(@PathVariable("orderId") Long orderId, ModelMap mmap) {
        mmap.put("order", productionOrderService.selectProductionOrderById(orderId));
        return prefix + "/edit";
    }

    @RequiresPermissions("erp:productionOrder:edit")
    @Log(title = "生产订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ErpProductionOrder order) {
        return toAjax(productionOrderService.updateProductionOrder(order));
    }

    @RequiresPermissions("erp:productionOrder:remove")
    @Log(title = "生产订单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(productionOrderService.deleteProductionOrderByIds(convertToLongArray(ids)));
    }

    @RequiresPermissions("erp:productionOrder:release")
    @Log(title = "生产订单", businessType = BusinessType.UPDATE)
    @PostMapping("/release")
    @ResponseBody
    public AjaxResult release(@RequestParam("orderId") Long orderId) {
        return toAjax(productionOrderService.releaseProductionOrder(orderId));
    }

    @RequiresPermissions("erp:productionOrder:close")
    @Log(title = "生产订单", businessType = BusinessType.UPDATE)
    @PostMapping("/close")
    @ResponseBody
    public AjaxResult close(@RequestParam("orderId") Long orderId, @RequestParam(value = "closeReason", required = false) String closeReason) {
        return toAjax(productionOrderService.closeProductionOrder(orderId, closeReason));
    }

    @RequiresPermissions("erp:productionOrder:cancel")
    @Log(title = "生产订单", businessType = BusinessType.UPDATE)
    @PostMapping("/cancel")
    @ResponseBody
    public AjaxResult cancel(@RequestParam("orderId") Long orderId) {
        return toAjax(productionOrderService.cancelProductionOrder(orderId));
    }

    @GetMapping("/detail/{orderId}")
    public String detail(@PathVariable("orderId") Long orderId, ModelMap mmap) {
        mmap.put("order", productionOrderService.selectProductionOrderById(orderId));
        return prefix + "/detail";
    }
}
