package com.ruoyi.erp.production.service;

import java.util.List;
import com.ruoyi.erp.production.domain.ErpBom;
import com.ruoyi.erp.production.util.MrpCalculator;

public interface IErpBomService {

    List<ErpBom> selectBomList(ErpBom bom);

    ErpBom selectBomById(Long bomId);

    ErpBom selectBomByMaterialId(Long materialId);

    ErpBom selectActiveBomByMaterialId(Long materialId);

    int insertBom(ErpBom bom);

    int updateBom(ErpBom bom);

    int deleteBomById(Long bomId);

    int deleteBomByIds(Long[] bomIds);

    String generateBomCode();

    List<MrpCalculator.BomNode> expandBom(Long materialId, Long bomId);

    List<MrpCalculator.BomNode> expandBomByMaterial(Long materialId);
}
