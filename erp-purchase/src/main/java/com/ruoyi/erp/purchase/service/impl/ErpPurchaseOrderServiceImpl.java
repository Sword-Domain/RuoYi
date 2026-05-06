package com.ruoyi.erp.purchase.service.impl;

import java.util.List;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.erp.purchase.domain.ErpPurchaseOrder;
import com.ruoyi.erp.purchase.mapper.ErpPurchaseOrderMapper;
import com.ruoyi.erp.purchase.service.IErpPurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErpPurchaseOrderServiceImpl implements IErpPurchaseOrderService {

    @Autowired
    private ErpPurchaseOrderMapper purchaseOrderMapper;

    @Override
    public List<ErpPurchaseOrder> selectPurchaseOrderList(ErpPurchaseOrder purchaseOrder) {
        return purchaseOrderMapper.selectPurchaseOrderList(purchaseOrder);
    }

    @Override
    public ErpPurchaseOrder selectPurchaseOrderById(Long orderId) {
        return purchaseOrderMapper.selectPurchaseOrderById(orderId);
    }

    @Override
    public int insertPurchaseOrder(ErpPurchaseOrder purchaseOrder) {
        purchaseOrder.setOrderNo(generateOrderNo());
        purchaseOrder.setDelFlag("0");
        if (StringUtils.isNull(purchaseOrder.getStatus())) {
            purchaseOrder.setStatus("0");
        }
        return purchaseOrderMapper.insertPurchaseOrder(purchaseOrder);
    }

    @Override
    public int updatePurchaseOrder(ErpPurchaseOrder purchaseOrder) {
        ErpPurchaseOrder exist = purchaseOrderMapper.selectPurchaseOrderById(purchaseOrder.getOrderId());
        if (exist == null) {
            throw new ServiceException("采购订单不存在");
        }
        if (!"0".equals(exist.getStatus()) && !"9".equals(exist.getStatus())) {
            throw new ServiceException("只有草稿或已取消状态的订单可以修改");
        }
        return purchaseOrderMapper.updatePurchaseOrder(purchaseOrder);
    }

    @Override
    public int deletePurchaseOrderById(Long orderId) {
        return purchaseOrderMapper.deletePurchaseOrderById(orderId);
    }

    @Override
    public int deletePurchaseOrderByIds(Long[] orderIds) {
        return purchaseOrderMapper.deletePurchaseOrderByIds(orderIds);
    }

    @Override
    public String generateOrderNo() {
        String maxOrderNo = purchaseOrderMapper.selectMaxOrderNo();
        if (StringUtils.isNull(maxOrderNo)) {
            return "PO" + "001";
        }
        int num = Integer.parseInt(maxOrderNo.substring(2));
        return String.format("PO%03d", num + 1);
    }

    @Override
    public int release(Long orderId) {
        ErpPurchaseOrder purchaseOrder = purchaseOrderMapper.selectPurchaseOrderById(orderId);
        if (purchaseOrder == null) {
            throw new ServiceException("采购订单不存在");
        }
        if (!"0".equals(purchaseOrder.getStatus())) {
            throw new ServiceException("只有草稿状态的订单可以发布");
        }
        purchaseOrder.setStatus("1");
        return purchaseOrderMapper.updatePurchaseOrder(purchaseOrder);
    }

    @Override
    public int close(Long orderId) {
        ErpPurchaseOrder purchaseOrder = purchaseOrderMapper.selectPurchaseOrderById(orderId);
        if (purchaseOrder == null) {
            throw new ServiceException("采购订单不存在");
        }
        if (!"1".equals(purchaseOrder.getStatus()) && !"2".equals(purchaseOrder.getStatus())) {
            throw new ServiceException("只有已发布或部分收货状态的订单可以关闭");
        }
        purchaseOrder.setStatus("3");
        return purchaseOrderMapper.updatePurchaseOrder(purchaseOrder);
    }

    @Override
    public int cancel(Long orderId) {
        ErpPurchaseOrder purchaseOrder = purchaseOrderMapper.selectPurchaseOrderById(orderId);
        if (purchaseOrder == null) {
            throw new ServiceException("采购订单不存在");
        }
        if (!"0".equals(purchaseOrder.getStatus())) {
            throw new ServiceException("只有草稿状态的订单可以取消");
        }
        purchaseOrder.setStatus("9");
        return purchaseOrderMapper.updatePurchaseOrder(purchaseOrder);
    }
}
