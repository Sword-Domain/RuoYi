package com.ruoyi.erp.finance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.erp.finance.domain.ErpReceipt;
import com.ruoyi.erp.finance.mapper.ErpReceiptMapper;
import com.ruoyi.erp.finance.service.IErpReceiptService;

/**
 * 收款单Service实现
 *
 * @author ruoyi
 * @date 2024-01-01
 */
@Service
public class ErpReceiptServiceImpl implements IErpReceiptService {

    @Autowired
    private ErpReceiptMapper receiptMapper;

    @Override
    public ErpReceipt selectById(Long receiptId) {
        return receiptMapper.selectById(receiptId);
    }

    @Override
    public List<ErpReceipt> selectList(ErpReceipt receipt) {
        return receiptMapper.selectList(receipt);
    }

    @Override
    public int insert(ErpReceipt receipt) {
        return receiptMapper.insert(receipt);
    }

    @Override
    public int update(ErpReceipt receipt) {
        return receiptMapper.update(receipt);
    }

    @Override
    public int delete(Long receiptId) {
        return receiptMapper.delete(receiptId);
    }

    @Override
    public int delete(String ids) {
        return receiptMapper.deleteByIds(ids);
    }

}
