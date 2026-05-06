package com.ruoyi.erp.finance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.erp.finance.domain.ErpReceivable;
import com.ruoyi.erp.finance.mapper.ErpReceivableMapper;
import com.ruoyi.erp.finance.service.IErpReceivableService;

/**
 * 应收款Service实现
 *
 * @author ruoyi
 * @date 2024-01-01
 */
@Service
public class ErpReceivableServiceImpl implements IErpReceivableService {

    @Autowired
    private ErpReceivableMapper receivableMapper;

    @Override
    public ErpReceivable selectById(Long receivableId) {
        return receivableMapper.selectById(receivableId);
    }

    @Override
    public List<ErpReceivable> selectList(ErpReceivable receivable) {
        return receivableMapper.selectList(receivable);
    }

    @Override
    public int insert(ErpReceivable receivable) {
        return receivableMapper.insert(receivable);
    }

    @Override
    public int update(ErpReceivable receivable) {
        return receivableMapper.update(receivable);
    }

    @Override
    public int delete(Long receivableId) {
        return receivableMapper.delete(receivableId);
    }

    @Override
    public int delete(String ids) {
        return receivableMapper.deleteByIds(ids);
    }

}
