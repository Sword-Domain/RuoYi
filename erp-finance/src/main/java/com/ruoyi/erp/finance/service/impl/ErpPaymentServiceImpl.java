package com.ruoyi.erp.finance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.erp.finance.domain.ErpPayment;
import com.ruoyi.erp.finance.mapper.ErpPaymentMapper;
import com.ruoyi.erp.finance.service.IErpPaymentService;

/**
 * 付款单Service实现
 *
 * @author ruoyi
 * @date 2024-01-01
 */
@Service
public class ErpPaymentServiceImpl implements IErpPaymentService {

    @Autowired
    private ErpPaymentMapper paymentMapper;

    @Override
    public ErpPayment selectById(Long paymentId) {
        return paymentMapper.selectById(paymentId);
    }

    @Override
    public List<ErpPayment> selectList(ErpPayment payment) {
        return paymentMapper.selectList(payment);
    }

    @Override
    public int insert(ErpPayment payment) {
        return paymentMapper.insert(payment);
    }

    @Override
    public int update(ErpPayment payment) {
        return paymentMapper.update(payment);
    }

    @Override
    public int delete(Long paymentId) {
        return paymentMapper.delete(paymentId);
    }

    @Override
    public int delete(String ids) {
        return paymentMapper.deleteByIds(ids);
    }

}
