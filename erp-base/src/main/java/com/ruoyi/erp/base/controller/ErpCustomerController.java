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
import com.ruoyi.erp.base.domain.ErpCustomer;
import com.ruoyi.erp.base.service.IErpCustomerService;

@Controller
@RequestMapping("/erp/base/customer")
public class ErpCustomerController extends BaseController {

    private String prefix = "erp/base/customer";

    @Autowired
    private IErpCustomerService customerService;

    @RequiresPermissions("erp:customer:view")
    @GetMapping()
    public String customer() {
        return prefix + "/customer";
    }

    @RequiresPermissions("erp:customer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ErpCustomer customer) {
        startPage();
        List<ErpCustomer> list = customerService.selectCustomerList(customer);
        return getDataTable(list);
    }

    @RequiresPermissions("erp:customer:export")
    @Log(title = "客户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ErpCustomer customer) {
        List<ErpCustomer> list = customerService.selectCustomerList(customer);
        return AjaxResult.success();
    }

    @RequiresPermissions("erp:customer:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("erp:customer:add")
    @Log(title = "客户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated ErpCustomer customer) {
        return toAjax(customerService.insertCustomer(customer));
    }

    @RequiresPermissions("erp:customer:edit")
    @GetMapping("/edit/{customerId}")
    public String edit(@PathVariable("customerId") Long customerId, ModelMap mmap) {
        mmap.put("customer", customerService.selectCustomerById(customerId));
        return prefix + "/edit";
    }

    @RequiresPermissions("erp:customer:edit")
    @Log(title = "客户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated ErpCustomer customer) {
        return toAjax(customerService.updateCustomer(customer));
    }

    @RequiresPermissions("erp:customer:remove")
    @Log(title = "客户管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(customerService.deleteCustomerByIds(convertToLongArray(ids)));
    }

    @RequiresPermissions("erp:customer:list")
    @PostMapping("/selectCustomerList")
    @ResponseBody
    public AjaxResult selectCustomerList(ErpCustomer customer) {
        List<ErpCustomer> list = customerService.selectCustomerList(customer);
        return AjaxResult.success(list);
    }
}
