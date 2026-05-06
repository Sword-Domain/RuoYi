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
import com.ruoyi.erp.base.domain.ErpMaterial;
import com.ruoyi.erp.base.service.IErpMaterialService;

@Controller
@RequestMapping("/erp/base/material")
public class ErpMaterialController extends BaseController {

    private String prefix = "erp/base/material";

    @Autowired
    private IErpMaterialService materialService;

    @RequiresPermissions("erp:material:view")
    @GetMapping()
    public String material() {
        return prefix + "/material";
    }

    @RequiresPermissions("erp:material:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ErpMaterial material) {
        startPage();
        List<ErpMaterial> list = materialService.selectMaterialList(material);
        return getDataTable(list);
    }

    @RequiresPermissions("erp:material:export")
    @Log(title = "物料管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ErpMaterial material) {
        List<ErpMaterial> list = materialService.selectMaterialList(material);
        return AjaxResult.success();
    }

    @RequiresPermissions("erp:material:add")
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    @RequiresPermissions("erp:material:add")
    @Log(title = "物料管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated ErpMaterial material) {
        return toAjax(materialService.insertMaterial(material));
    }

    @RequiresPermissions("erp:material:edit")
    @GetMapping("/edit/{materialId}")
    public String edit(@PathVariable("materialId") Long materialId, ModelMap mmap) {
        mmap.put("material", materialService.selectMaterialById(materialId));
        return prefix + "/edit";
    }

    @RequiresPermissions("erp:material:edit")
    @Log(title = "物料管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated ErpMaterial material) {
        return toAjax(materialService.updateMaterial(material));
    }

    @RequiresPermissions("erp:material:remove")
    @Log(title = "物料管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(materialService.deleteMaterialByIds(convertToLongArray(ids)));
    }

    @RequiresPermissions("erp:material:list")
    @PostMapping("/selectMaterialList")
    @ResponseBody
    public AjaxResult selectMaterialList(ErpMaterial material) {
        List<ErpMaterial> list = materialService.selectMaterialList(material);
        return AjaxResult.success(list);
    }

    @PostMapping("/checkMaterialCodeUnique")
    @ResponseBody
    public String checkMaterialCodeUnique(ErpMaterial material) {
        ErpMaterial exist = materialService.selectMaterialByCode(material.getMaterialCode());
        if (exist != null && !exist.getMaterialId().equals(material.getMaterialId())) {
            return "1";
        }
        return "0";
    }
}
