package com.ruoyi.erp.finance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.erp.finance.domain.ErpPayable;
import com.ruoyi.erp.finance.mapper.ErpPayableMapper;
import com.ruoyi.erp.finance.service.IErpPayableService;

/**
 * 应付款Service实现
 *
 * @author ruoyi
 * @date 2024-01-01
 */
@Service
public class ErpPayableServiceImpl implements IErpPayableService {

    @Autowired
    private ErpPayableMapper payableMapper;

    @Override
    public ErpPayable selectById(Long payableId) {
        return payableMapper.selectById(payableId);
    }

    @Override
    public List<ErpPayable> selectList(ErpPayable payable) {
        return payableMapper.selectList(payable);
    }

    @Override
    public int insert(ErpPayable payable) {
        return payableMapper.insert(payable);
    }

    @Override
    public int update(ErpPayable payable) {
        return payableMapper.update(payable);
    }

    @Override
    public int delete(Long payableId) {
        return payableMapper.delete(payableId);
    }

    @Override
    public int delete(String ids) {
        return payableMapper.deleteByIds(ids);
    }

}
