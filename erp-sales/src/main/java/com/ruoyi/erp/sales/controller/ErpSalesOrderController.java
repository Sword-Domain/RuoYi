package com.ruoyi.erp.sales.controller;

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
import com.ruoyi.erp.sales.domain.ErpSalesOrder;
import com.ruoyi.erp.sales.service.IErpSalesOrderService;

@RestController
@RequestMapping("/erp/sales/order")
public class ErpSalesOrderController extends BaseController
{
    @Autowired
    private IErpSalesOrderService erpSalesOrderService;

    @PreAuthorize("@ss.hasPermi('erp:salesOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpSalesOrder erpSalesOrder)
    {
        startPage();
        List<ErpSalesOrder> list = erpSalesOrderService.selectSalesOrderList(erpSalesOrder);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('erp:salesOrder:export')")
    @Log(title = "销售订单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpSalesOrder erpSalesOrder)
    {
        List<ErpSalesOrder> list = erpSalesOrderService.selectSalesOrderList(erpSalesOrder);
        ExcelUtil<ErpSalesOrder> util = new ExcelUtil<ErpSalesOrder>(ErpSalesOrder.class);
        return util.exportExcel(list, "销售订单数据");
    }

    @PreAuthorize("@ss.hasPermi('erp:salesOrder:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return AjaxResult.success(erpSalesOrderService.selectSalesOrderById(orderId));
    }

    @PreAuthorize("@ss.hasPermi('erp:salesOrder:add')")
    @Log(title = "销售订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpSalesOrder erpSalesOrder)
    {
        return toAjax(erpSalesOrderService.insertSalesOrder(erpSalesOrder));
    }

    @PreAuthorize("@ss.hasPermi('erp:salesOrder:edit')")
    @Log(title = "销售订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpSalesOrder erpSalesOrder)
    {
        return toAjax(erpSalesOrderService.updateSalesOrder(erpSalesOrder));
    }

    @PreAuthorize("@ss.hasPermi('erp:salesOrder:remove')")
    @Log(title = "销售订单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(erpSalesOrderService.deleteSalesOrderByIds(orderIds));
    }

    @PreAuthorize("@ss.hasPermi('erp:salesOrder:edit')")
    @Log(title = "销售订单-审核", businessType = BusinessType.UPDATE)
    @PutMapping("/release/{orderId}")
    public AjaxResult release(@PathVariable Long orderId)
    {
        return toAjax(erpSalesOrderService.release(orderId));
    }

    @PreAuthorize("@ss.hasPermi('erp:salesOrder:edit')")
    @Log(title = "销售订单-关闭", businessType = BusinessType.UPDATE)
    @PutMapping("/close/{orderId}")
    public AjaxResult close(@PathVariable Long orderId)
    {
        return toAjax(erpSalesOrderService.close(orderId));
    }

    @PreAuthorize("@ss.hasPermi('erp:salesOrder:edit')")
    @Log(title = "销售订单-取消", businessType = BusinessType.UPDATE)
    @PutMapping("/cancel/{orderId}")
    public AjaxResult cancel(@PathVariable Long orderId)
    {
        return toAjax(erpSalesOrderService.cancel(orderId));
    }
}
