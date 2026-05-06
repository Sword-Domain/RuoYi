package com.ruoyi.erp.base.service.impl;

import java.util.List;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.erp.base.domain.ErpSupplier;
import com.ruoyi.erp.base.mapper.ErpSupplierMapper;
import com.ruoyi.erp.base.service.IErpSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErpSupplierServiceImpl implements IErpSupplierService {

    @Autowired
    private ErpSupplierMapper supplierMapper;

    @Override
    public List<ErpSupplier> selectSupplierList(ErpSupplier supplier) {
        return supplierMapper.selectSupplierList(supplier);
    }

    @Override
    public ErpSupplier selectSupplierById(Long supplierId) {
        return supplierMapper.selectSupplierById(supplierId);
    }

    @Override
    public ErpSupplier selectSupplierByCode(String supplierCode) {
        return supplierMapper.selectSupplierByCode(supplierCode);
    }

    @Override
    public int insertSupplier(ErpSupplier supplier) {
        if (StringUtils.isNotNull(supplier.getSupplierCode())) {
            ErpSupplier exist = supplierMapper.selectSupplierByCode(supplier.getSupplierCode());
            if (exist != null) {
                throw new ServiceException("供应商编码已存在");
            }
        } else {
            supplier.setSupplierCode(generateSupplierCode());
        }
        supplier.setDelFlag("0");
        return supplierMapper.insertSupplier(supplier);
    }

    @Override
    public int updateSupplier(ErpSupplier supplier) {
        return supplierMapper.updateSupplier(supplier);
    }

    @Override
    public int deleteSupplierById(Long supplierId) {
        return supplierMapper.deleteSupplierById(supplierId);
    }

    @Override
    public int deleteSupplierByIds(Long[] supplierIds) {
        return supplierMapper.deleteSupplierByIds(supplierIds);
    }

    @Override
    public List<ErpSupplier> selectSupplierByType(String supplierType) {
        return supplierMapper.selectSupplierByType(supplierType);
    }

    @Override
    public String generateSupplierCode() {
        String maxCode = supplierMapper.selectMaxSupplierCode();
        if (StringUtils.isNull(maxCode)) {
            return "SUP001";
        }
        int num = Integer.parseInt(maxCode.substring(3));
        return String.format("SUP%03d", num + 1);
    }
}
