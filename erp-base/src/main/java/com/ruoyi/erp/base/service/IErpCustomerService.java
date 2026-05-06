package com.ruoyi.erp.base.service;

import java.util.List;
import com.ruoyi.erp.base.domain.ErpCustomer;

public interface IErpCustomerService {

    List<ErpCustomer> selectCustomerList(ErpCustomer customer);

    ErpCustomer selectCustomerById(Long customerId);

    ErpCustomer selectCustomerByCode(String customerCode);

    int insertCustomer(ErpCustomer customer);

    int updateCustomer(ErpCustomer customer);

    int deleteCustomerById(Long customerId);

    int deleteCustomerByIds(Long[] customerIds);

    List<ErpCustomer> selectCustomerByType(String customerType);

    String generateCustomerCode();
}
