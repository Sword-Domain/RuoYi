package com.ruoyi.erp.base.service.impl;

import java.util.List;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.erp.base.domain.ErpMaterial;
import com.ruoyi.erp.base.mapper.ErpMaterialMapper;
import com.ruoyi.erp.base.service.IErpMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

@Service
public class ErpMaterialServiceImpl implements IErpMaterialService {

    @Autowired
    private ErpMaterialMapper materialMapper;

    @Override
    public List<ErpMaterial> selectMaterialList(ErpMaterial material) {
        return materialMapper.selectMaterialList(material);
    }

    @Override
    public ErpMaterial selectMaterialById(Long materialId) {
        return materialMapper.selectMaterialById(materialId);
    }

    @Override
    public ErpMaterial selectMaterialByCode(String materialCode) {
        return materialMapper.selectMaterialByCode(materialCode);
    }

    @Override
    public int insertMaterial(ErpMaterial material) {
        if (StringUtils.isNotNull(material.getMaterialCode())) {
            ErpMaterial exist = materialMapper.selectMaterialByCode(material.getMaterialCode());
            if (exist != null) {
                throw new ServiceException("物料编码已存在");
            }
        } else {
            material.setMaterialCode(generateMaterialCode());
        }
        material.setDelFlag("0");
        return materialMapper.insertMaterial(material);
    }

    @Override
    public int updateMaterial(ErpMaterial material) {
        return materialMapper.updateMaterial(material);
    }

    @Override
    public int deleteMaterialById(Long materialId) {
        return materialMapper.deleteMaterialById(materialId);
    }

    @Override
    public int deleteMaterialByIds(Long[] materialIds) {
        return materialMapper.deleteMaterialByIds(materialIds);
    }

    @Override
    public List<ErpMaterial> selectMaterialByType(String materialType) {
        return materialMapper.selectMaterialByType(materialType);
    }

    @Override
    public String generateMaterialCode() {
        String maxCode = materialMapper.selectMaxMaterialCode();
        if (StringUtils.isNull(maxCode)) {
            return "MAT001";
        }
        int num = Integer.parseInt(maxCode.substring(3));
        return String.format("MAT%03d", num + 1);
    }
}
