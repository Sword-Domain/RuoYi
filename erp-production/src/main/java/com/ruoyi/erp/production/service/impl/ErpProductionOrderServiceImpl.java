package com.ruoyi.erp.production.service.impl;

import java.util.Date;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.erp.production.domain.ErpProductionOrder;
import com.ruoyi.erp.production.mapper.ErpProductionOrderMapper;
import com.ruoyi.erp.production.service.IErpBomService;
import com.ruoyi.erp.production.service.IErpProductionOrderService;
import com.ruoyi.erp.production.util.MrpCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ErpProductionOrderServiceImpl implements IErpProductionOrderService {

    @Autowired
    private ErpProductionOrderMapper productionOrderMapper;

    @Autowired
    private IErpBomService bomService;

    @Override
    public java.util.List<ErpProductionOrder> selectProductionOrderList(ErpProductionOrder order) {
        return productionOrderMapper.selectProductionOrderList(order);
    }

    @Override
    public ErpProductionOrder selectProductionOrderById(Long orderId) {
        return productionOrderMapper.selectProductionOrderById(orderId);
    }

    @Override
    public ErpProductionOrder selectProductionOrderByNo(String orderNo) {
        return productionOrderMapper.selectProductionOrderByNo(orderNo);
    }

    @Override
    @Transactional
    public int insertProductionOrder(ErpProductionOrder order) {
        if (StringUtils.isNull(order.getOrderNo())) {
            order.setOrderNo(generateOrderNo());
        }
        if (StringUtils.isNull(order.getStatus())) {
            order.setStatus("draft");
        }

        if (order.getBomId() != null) {
            ErpBom bom = bomService.selectBomById(order.getBomId());
            if (bom != null) {
                order.setBomVersion(bom.getVersion());
            }
        }

        return productionOrderMapper.insertProductionOrder(order);
    }

    @Override
    public int updateProductionOrder(ErpProductionOrder order) {
        return productionOrderMapper.updateProductionOrder(order);
    }

    @Override
    @Transactional
    public int releaseProductionOrder(Long orderId) {
        ErpProductionOrder order = productionOrderMapper.selectProductionOrderById(orderId);
        if (order == null) {
            throw new ServiceException("生产订单不存在");
        }
        if (!"draft".equals(order.getStatus())) {
            throw new ServiceException("只有草稿状态的生产订单可以下达");
        }

        order.setStatus("released");
        order.setActualStartDate(new Date());
        return productionOrderMapper.updateProductionOrderStatus(order);
    }

    @Override
    @Transactional
    public int closeProductionOrder(Long orderId, String closeReason) {
        ErpProductionOrder order = productionOrderMapper.selectProductionOrderById(orderId);
        if (order == null) {
            throw new ServiceException("生产订单不存在");
        }
        if ("closed".equals(order.getStatus()) || "cancelled".equals(order.getStatus())) {
            throw new ServiceException("订单已关闭或已取消");
        }

        order.setStatus("closed");
        order.setClosedBy(ShiroUtils.getLoginName());
        order.setClosedTime(new Date());
        order.setCloseReason(closeReason);
        return productionOrderMapper.updateProductionOrderStatus(order);
    }

    @Override
    @Transactional
    public int cancelProductionOrder(Long orderId) {
        ErpProductionOrder order = productionOrderMapper.selectProductionOrderById(orderId);
        if (order == null) {
            throw new ServiceException("生产订单不存在");
        }
        if (!"draft".equals(order.getStatus())) {
            throw new ServiceException("只有草稿状态的生产订单可以取消");
        }

        order.setStatus("cancelled");
        return productionOrderMapper.updateProductionOrderStatus(order);
    }

    @Override
    public int deleteProductionOrderById(Long orderId) {
        return productionOrderMapper.deleteProductionOrderById(orderId);
    }

    @Override
    public int deleteProductionOrderByIds(Long[] orderIds) {
        return productionOrderMapper.deleteProductionOrderByIds(orderIds);
    }

    @Override
    public String generateOrderNo() {
        String maxNo = productionOrderMapper.selectMaxOrderNo();
        String dateStr = DateUtils.dateTime();
        if (StringUtils.isNull(maxNo)) {
            return "PD" + dateStr + "001";
        }
        String datePart = maxNo.substring(2, 10);
        if (datePart.equals(dateStr)) {
            int num = Integer.parseInt(maxNo.substring(10));
            return String.format("PD%s%03d", dateStr, num + 1);
        } else {
            return "PD" + dateStr + "001";
        }
    }
}
