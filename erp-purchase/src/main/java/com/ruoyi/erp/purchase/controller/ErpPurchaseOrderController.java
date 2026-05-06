package com.ruoyi.erp.purchase.controller;

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
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.erp.purchase.domain.ErpPurchaseOrder;
import com.ruoyi.erp.purchase.service.IErpPurchaseOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "采购订单管理")
@Controller
@RequestMapping("/erp/purchase/order")
public class ErpPurchaseOrderController extends BaseController {

    private String prefix = "erp/purchase/order";

    @Autowired
    private IErpPurchaseOrderService purchaseOrderService;

    @RequiresPermissions("erp:purchaseOrder:view")
    @GetMapping()
    public String order() {
        return prefix + "/order";
    }

    @Operation(summary = "获取采购订单列表")
    @RequiresPermissions("erp:purchaseOrder:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ErpPurchaseOrder purchaseOrder) {
        startPage();
        List<ErpPurchaseOrder> list = purchaseOrderService.selectPurchaseOrderList(purchaseOrder);
        return getDataTable(list);
    }

    @Operation(summary = "导出采购订单列表")
    @RequiresPermissions("erp:purchaseOrder:export")
    @Log(title = "采购订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ErpPurchaseOrder purchaseOrder) {
        List<ErpPurchaseOrder> list = purchaseOrderService.selectPurchaseOrderList(purchaseOrder);
        return AjaxResult.success();
    }

    @Operation(summary = "新增采购订单")
    @RequiresPermissions("erp:purchaseOrder:add")
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        return prefix + "/add";
    }

    @Operation(summary = "新增保存采购订单")
    @RequiresPermissions("erp:purchaseOrder:add")
    @Log(title = "采购订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated ErpPurchaseOrder purchaseOrder) {
        purchaseOrder.setBuyerId(ShiroUtils.getSysUser().getUserId());
        return toAjax(purchaseOrderService.insertPurchaseOrder(purchaseOrder));
    }

    @Operation(summary = "修改采购订单")
    @RequiresPermissions("erp:purchaseOrder:edit")
    @GetMapping("/edit/{orderId}")
    public String edit(@PathVariable("orderId") Long orderId, ModelMap mmap) {
        mmap.put("purchaseOrder", purchaseOrderService.selectPurchaseOrderById(orderId));
        return prefix + "/edit";
    }

    @Operation(summary = "修改保存采购订单")
    @RequiresPermissions("erp:purchaseOrder:edit")
    @Log(title = "采购订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated ErpPurchaseOrder purchaseOrder) {
        return toAjax(purchaseOrderService.updatePurchaseOrder(purchaseOrder));
    }

    @Operation(summary = "删除采购订单")
    @RequiresPermissions("erp:purchaseOrder:remove")
    @Log(title = "采购订单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(purchaseOrderService.deletePurchaseOrderByIds(convertToLongArray(ids)));
    }

    @Operation(summary = "发布采购订单")
    @Parameter(name = "orderId", description = "订单ID", required = true)
    @RequiresPermissions("erp:purchaseOrder:release")
    @Log(title = "采购订单", businessType = BusinessType.UPDATE)
    @PostMapping("/release/{orderId}")
    @ResponseBody
    public AjaxResult release(@PathVariable("orderId") Long orderId) {
        return toAjax(purchaseOrderService.release(orderId));
    }

    @Operation(summary = "关闭采购订单")
    @Parameter(name = "orderId", description = "订单ID", required = true)
    @RequiresPermissions("erp:purchaseOrder:close")
    @Log(title = "采购订单", businessType = BusinessType.UPDATE)
    @PostMapping("/close/{orderId}")
    @ResponseBody
    public AjaxResult close(@PathVariable("orderId") Long orderId) {
        return toAjax(purchaseOrderService.close(orderId));
    }

    @Operation(summary = "取消采购订单")
    @Parameter(name = "orderId", description = "订单ID", required = true)
    @RequiresPermissions("erp:purchaseOrder:cancel")
    @Log(title = "采购订单", businessType = BusinessType.UPDATE)
    @PostMapping("/cancel/{orderId}")
    @ResponseBody
    public AjaxResult cancel(@PathVariable("orderId") Long orderId) {
        return toAjax(purchaseOrderService.cancel(orderId));
    }
}
