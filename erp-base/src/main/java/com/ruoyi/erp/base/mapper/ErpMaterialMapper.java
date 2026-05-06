package com.ruoyi.erp.base.mapper;

import java.util.List;
import com.ruoyi.erp.base.domain.ErpMaterial;
import org.apache.ibatis.annotations.Param;

public interface ErpMaterialMapper {

    List<ErpMaterial> selectMaterialList(ErpMaterial material);

    ErpMaterial selectMaterialById(Long materialId);

    ErpMaterial selectMaterialByCode(String materialCode);

    int insertMaterial(ErpMaterial material);

    int updateMaterial(ErpMaterial material);

    int deleteMaterialById(Long materialId);

    int deleteMaterialByIds(Long[] materialIds);

    int countMaterialByCategory(Long categoryId);

    List<ErpMaterial> selectMaterialByType(@Param("materialType") String materialType);

    String selectMaxMaterialCode();
}
