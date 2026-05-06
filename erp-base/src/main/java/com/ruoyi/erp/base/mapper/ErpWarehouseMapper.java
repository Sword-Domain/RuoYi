package com.ruoyi.erp.base.mapper;

import java.util.List;
import com.ruoyi.erp.base.domain.ErpWarehouse;
import org.apache.ibatis.annotations.Param;

public interface ErpWarehouseMapper {

    List<ErpWarehouse> selectWarehouseList(ErpWarehouse warehouse);

    ErpWarehouse selectWarehouseById(Long warehouseId);

    ErpWarehouse selectWarehouseByCode(String warehouseCode);

    ErpWarehouse selectDefaultWarehouse();

    int insertWarehouse(ErpWarehouse warehouse);

    int updateWarehouse(ErpWarehouse warehouse);

    int deleteWarehouseById(Long warehouseId);

    int deleteWarehouseByIds(Long[] warehouseIds);

    List<ErpWarehouse> selectWarehouseByType(@Param("warehouseType") String warehouseType);

    String selectMaxWarehouseCode();
}
