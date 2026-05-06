package com.ruoyi.erp.base.service;

import java.util.List;
import com.ruoyi.erp.base.domain.ErpSupplier;

public interface IErpSupplierService {

    List<ErpSupplier> selectSupplierList(ErpSupplier supplier);

    ErpSupplier selectSupplierById(Long supplierId);

    ErpSupplier selectSupplierByCode(String supplierCode);

    int insertSupplier(ErpSupplier supplier);

    int updateSupplier(ErpSupplier supplier);

    int deleteSupplierById(Long supplierId);

    int deleteSupplierByIds(Long[] supplierIds);

    List<ErpSupplier> selectSupplierByType(String supplierType);

    String generateSupplierCode();
}
