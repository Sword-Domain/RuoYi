package com.ruoyi.erp.base.service.impl;

import java.util.List;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.erp.base.domain.ErpCustomer;
import com.ruoyi.erp.base.mapper.ErpCustomerMapper;
import com.ruoyi.erp.base.service.IErpCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErpCustomerServiceImpl implements IErpCustomerService {

    @Autowired
    private ErpCustomerMapper customerMapper;

    @Override
    public List<ErpCustomer> selectCustomerList(ErpCustomer customer) {
        return customerMapper.selectCustomerList(customer);
    }

    @Override
    public ErpCustomer selectCustomerById(Long customerId) {
        return customerMapper.selectCustomerById(customerId);
    }

    @Override
    public ErpCustomer selectCustomerByCode(String customerCode) {
        return customerMapper.selectCustomerByCode(customerCode);
    }

    @Override
    public int insertCustomer(ErpCustomer customer) {
        if (StringUtils.isNotNull(customer.getCustomerCode())) {
            ErpCustomer exist = customerMapper.selectCustomerByCode(customer.getCustomerCode());
            if (exist != null) {
                throw new ServiceException("客户编码已存在");
            }
        } else {
            customer.setCustomerCode(generateCustomerCode());
        }
        customer.setDelFlag("0");
        return customerMapper.insertCustomer(customer);
    }

    @Override
    public int updateCustomer(ErpCustomer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public int deleteCustomerById(Long customerId) {
        return customerMapper.deleteCustomerById(customerId);
    }

    @Override
    public int deleteCustomerByIds(Long[] customerIds) {
        return customerMapper.deleteCustomerByIds(customerIds);
    }

    @Override
    public List<ErpCustomer> selectCustomerByType(String customerType) {
        return customerMapper.selectCustomerByType(customerType);
    }

    @Override
    public String generateCustomerCode() {
        String maxCode = customerMapper.selectMaxCustomerCode();
        if (StringUtils.isNull(maxCode)) {
            return "CUS001";
        }
        int num = Integer.parseInt(maxCode.substring(3));
        return String.format("CUS%03d", num + 1);
    }
}
