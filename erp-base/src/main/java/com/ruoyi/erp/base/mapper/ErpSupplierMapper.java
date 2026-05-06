package com.ruoyi.erp.base.mapper;

import java.util.List;
import com.ruoyi.erp.base.domain.ErpSupplier;
import org.apache.ibatis.annotations.Param;

public interface ErpSupplierMapper {

    List<ErpSupplier> selectSupplierList(ErpSupplier supplier);

    ErpSupplier selectSupplierById(Long supplierId);

    ErpSupplier selectSupplierByCode(String supplierCode);

    int insertSupplier(ErpSupplier supplier);

    int updateSupplier(ErpSupplier supplier);

    int deleteSupplierById(Long supplierId);

    int deleteSupplierByIds(Long[] supplierIds);

    List<ErpSupplier> selectSupplierByType(@Param("supplierType") String supplierType);

    String selectMaxSupplierCode();
}
