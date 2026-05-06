package com.ruoyi.erp.base.service;

import java.util.List;
import com.ruoyi.erp.base.domain.ErpMaterial;

public interface IErpMaterialService {

    List<ErpMaterial> selectMaterialList(ErpMaterial material);

    ErpMaterial selectMaterialById(Long materialId);

    ErpMaterial selectMaterialByCode(String materialCode);

    int insertMaterial(ErpMaterial material);

    int updateMaterial(ErpMaterial material);

    int deleteMaterialById(Long materialId);

    int deleteMaterialByIds(Long[] materialIds);

    List<ErpMaterial> selectMaterialByType(String materialType);

    String generateMaterialCode();
}
