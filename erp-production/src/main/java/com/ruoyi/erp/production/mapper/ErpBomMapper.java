package com.ruoyi.erp.production.mapper;

import java.util.List;
import com.ruoyi.erp.production.domain.ErpBom;

public interface ErpBomMapper {

    List<ErpBom> selectBomList(ErpBom bom);

    ErpBom selectBomById(Long bomId);

    ErpBom selectBomByMaterialId(Long materialId);

    ErpBom selectActiveBomByMaterialId(Long materialId);

    int insertBom(ErpBom bom);

    int updateBom(ErpBom bom);

    int deleteBomById(Long bomId);

    int deleteBomByIds(Long[] bomIds);

    String selectMaxBomCode();
}
