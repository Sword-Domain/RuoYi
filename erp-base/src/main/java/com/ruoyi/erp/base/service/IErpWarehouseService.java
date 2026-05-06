package com.ruoyi.erp.base.service;

import java.util.List;
import com.ruoyi.erp.base.domain.ErpWarehouse;

public interface IErpWarehouseService {

    List<ErpWarehouse> selectWarehouseList(ErpWarehouse warehouse);

    ErpWarehouse selectWarehouseById(Long warehouseId);

    ErpWarehouse selectWarehouseByCode(String warehouseCode);

    ErpWarehouse selectDefaultWarehouse();

    int insertWarehouse(ErpWarehouse warehouse);

    int updateWarehouse(ErpWarehouse warehouse);

    int deleteWarehouseById(Long warehouseId);

    int deleteWarehouseByIds(Long[] warehouseIds);

    List<ErpWarehouse> selectWarehouseByType(String warehouseType);

    String generateWarehouseCode();
}
