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
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.erp.production.domain.ErpBom;
import com.ruoyi.erp.production.service.IErpBomService;
import com.ruoyi.erp.production.util.MrpCalculator;

@Controller
@RequestMapping("/erp/production/bom")
public class ErpBomController extends BaseController {

    private String prefix = "erp/production/bom";

    @Autowired
    private IErpBomService bomService;

    @RequiresPermissions("erp:bom:view")
    @GetMapping()
    public String bom() {
        return prefix + "/bom";
    }

    @RequiresPermissions("erp:bom:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ErpBom bom) {
        startPage();
        List<ErpBom> list = bomService.selectBomList(bom);
        return getDataTable(list);
    }

    @RequiresPermissions("erp:bom:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("erp:bom:add")
    @Log(title = "BOM管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ErpBom bom) {
        return toAjax(bomService.insertBom(bom));
    }

    @RequiresPermissions("erp:bom:edit")
    @GetMapping("/edit/{bomId}")
    public String edit(@PathVariable("bomId") Long bomId, ModelMap mmap) {
        mmap.put("bom", bomService.selectBomById(bomId));
        return prefix + "/edit";
    }

    @RequiresPermissions("erp:bom:edit")
    @Log(title = "BOM管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ErpBom bom) {
        return toAjax(bomService.updateBom(bom));
    }

    @RequiresPermissions("erp:bom:remove")
    @Log(title = "BOM管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(bomService.deleteBomByIds(convertToLongArray(ids)));
    }

    @RequiresPermissions("erp:bom:list")
    @GetMapping("/expand/{materialId}")
    @ResponseBody
    public AjaxResult expandBom(@PathVariable("materialId") Long materialId) {
        List<MrpCalculator.BomNode> list = bomService.expandBomByMaterial(materialId);
        return AjaxResult.success(list);
    }

    @RequiresPermissions("erp:bom:changeStatus")
    @Log(title = "BOM管理", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(Long bomId, String status) {
        ErpBom bom = new ErpBom();
        bom.setBomId(bomId);
        bom.setStatus(status);
        return toAjax(bomService.updateBom(bom));
    }
}
