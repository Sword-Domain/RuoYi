package com.ruoyi.erp.production.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.erp.production.domain.ErpBom;
import com.ruoyi.erp.production.domain.ErpBomItem;
import com.ruoyi.erp.production.domain.ErpMaterial;
import com.ruoyi.erp.production.mapper.ErpBomMapper;
import com.ruoyi.erp.production.service.IErpBomService;
import com.ruoyi.erp.production.service.IErpMaterialService;
import com.ruoyi.erp.production.util.MrpCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErpBomServiceImpl implements IErpBomService {

    @Autowired
    private ErpBomMapper bomMapper;

    @Autowired
    private IErpMaterialService materialService;

    @Override
    public List<ErpBom> selectBomList(ErpBom bom) {
        return bomMapper.selectBomList(bom);
    }

    @Override
    public ErpBom selectBomById(Long bomId) {
        return bomMapper.selectBomById(bomId);
    }

    @Override
    public ErpBom selectBomByMaterialId(Long materialId) {
        return bomMapper.selectBomByMaterialId(materialId);
    }

    @Override
    public ErpBom selectActiveBomByMaterialId(Long materialId) {
        return bomMapper.selectActiveBomByMaterialId(materialId);
    }

    @Override
    public int insertBom(ErpBom bom) {
        if (StringUtils.isNotNull(bom.getBomCode())) {
            ErpBom exist = bomMapper.selectBomByMaterialId(bom.getMaterialId());
            if (exist != null) {
                throw new ServiceException("该物料已存在BOM");
            }
        } else {
            bom.setBomCode(generateBomCode());
        }
        bom.setStatus("draft");
        int rows = bomMapper.insertBom(bom);

        if (bom.getItems() != null && !bom.getItems().isEmpty()) {
            for (ErpBomItem item : bom.getItems()) {
                item.setBomId(bom.getBomId());
            }
        }
        return rows;
    }

    @Override
    public int updateBom(ErpBom bom) {
        return bomMapper.updateBom(bom);
    }

    @Override
    public int deleteBomById(Long bomId) {
        return bomMapper.deleteBomById(bomId);
    }

    @Override
    public int deleteBomByIds(Long[] bomIds) {
        return bomMapper.deleteBomByIds(bomIds);
    }

    @Override
    public String generateBomCode() {
        String maxCode = bomMapper.selectMaxBomCode();
        if (StringUtils.isNull(maxCode)) {
            return "BOM001";
        }
        int num = Integer.parseInt(maxCode.substring(3));
        return String.format("BOM%03d", num + 1);
    }

    @Override
    public List<MrpCalculator.BomNode> expandBom(Long materialId, Long bomId) {
        Map<Long, ErpBom> bomMap = new HashMap<>();
        ErpBom bom = bomId != null ? bomMapper.selectBomById(bomId) : bomMapper.selectActiveBomByMaterialId(materialId);
        if (bom != null) {
            bomMap.put(bom.getMaterialId(), bom);
        }
        MrpCalculator calculator = new MrpCalculator();
        return calculator.expandBom(materialId, java.math.BigDecimal.ONE, bomMap);
    }

    @Override
    public List<MrpCalculator.BomNode> expandBomByMaterial(Long materialId) {
        Map<Long, ErpBom> bomMap = new HashMap<>();
        ErpBom bom = bomMapper.selectActiveBomByMaterialId(materialId);
        if (bom != null) {
            bomMap.put(bom.getMaterialId(), bom);
        }
        MrpCalculator calculator = new MrpCalculator();
        return calculator.expandBom(materialId, java.math.BigDecimal.ONE, bomMap);
    }
}
