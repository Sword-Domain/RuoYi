package com.ruoyi.erp.base.service.impl;

import java.util.List;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.erp.base.domain.ErpWarehouse;
import com.ruoyi.erp.base.mapper.ErpWarehouseMapper;
import com.ruoyi.erp.base.service.IErpWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErpWarehouseServiceImpl implements IErpWarehouseService {

    @Autowired
    private ErpWarehouseMapper warehouseMapper;

    @Override
    public List<ErpWarehouse> selectWarehouseList(ErpWarehouse warehouse) {
        return warehouseMapper.selectWarehouseList(warehouse);
    }

    @Override
    public ErpWarehouse selectWarehouseById(Long warehouseId) {
        return warehouseMapper.selectWarehouseById(warehouseId);
    }

    @Override
    public ErpWarehouse selectWarehouseByCode(String warehouseCode) {
        return warehouseMapper.selectWarehouseByCode(warehouseCode);
    }

    @Override
    public ErpWarehouse selectDefaultWarehouse() {
        return warehouseMapper.selectDefaultWarehouse();
    }

    @Override
    public int insertWarehouse(ErpWarehouse warehouse) {
        if (StringUtils.isNotNull(warehouse.getWarehouseCode())) {
            ErpWarehouse exist = warehouseMapper.selectWarehouseByCode(warehouse.getWarehouseCode());
            if (exist != null) {
                throw new ServiceException("仓库编码已存在");
            }
        } else {
            warehouse.setWarehouseCode(generateWarehouseCode());
        }
        if ("1".equals(warehouse.getIsDefault())) {
            ErpWarehouse defaultWarehouse = warehouseMapper.selectDefaultWarehouse();
            if (defaultWarehouse != null) {
                defaultWarehouse.setIsDefault("0");
                warehouseMapper.updateWarehouse(defaultWarehouse);
            }
        }
        return warehouseMapper.insertWarehouse(warehouse);
    }

    @Override
    public int updateWarehouse(ErpWarehouse warehouse) {
        if ("1".equals(warehouse.getIsDefault())) {
            ErpWarehouse defaultWarehouse = warehouseMapper.selectDefaultWarehouse();
            if (defaultWarehouse != null && !defaultWarehouse.getWarehouseId().equals(warehouse.getWarehouseId())) {
                defaultWarehouse.setIsDefault("0");
                warehouseMapper.updateWarehouse(defaultWarehouse);
            }
        }
        return warehouseMapper.updateWarehouse(warehouse);
    }

    @Override
    public int deleteWarehouseById(Long warehouseId) {
        return warehouseMapper.deleteWarehouseById(warehouseId);
    }

    @Override
    public int deleteWarehouseByIds(Long[] warehouseIds) {
        return warehouseMapper.deleteWarehouseByIds(warehouseIds);
    }

    @Override
    public List<ErpWarehouse> selectWarehouseByType(String warehouseType) {
        return warehouseMapper.selectWarehouseByType(warehouseType);
    }

    @Override
    public String generateWarehouseCode() {
        String maxCode = warehouseMapper.selectMaxWarehouseCode();
        if (StringUtils.isNull(maxCode)) {
            return "WH001";
        }
        int num = Integer.parseInt(maxCode.substring(2));
        return String.format("WH%03d", num + 1);
    }
}
