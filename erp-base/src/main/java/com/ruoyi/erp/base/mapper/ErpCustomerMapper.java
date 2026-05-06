package com.ruoyi.erp.base.mapper;

import java.util.List;
import com.ruoyi.erp.base.domain.ErpCustomer;
import org.apache.ibatis.annotations.Param;

public interface ErpCustomerMapper {

    List<ErpCustomer> selectCustomerList(ErpCustomer customer);

    ErpCustomer selectCustomerById(Long customerId);

    ErpCustomer selectCustomerByCode(String customerCode);

    int insertCustomer(ErpCustomer customer);

    int updateCustomer(ErpCustomer customer);

    int deleteCustomerById(Long customerId);

    int deleteCustomerByIds(Long[] customerIds);

    List<ErpCustomer> selectCustomerByType(@Param("customerType") String customerType);

    String selectMaxCustomerCode();
}
