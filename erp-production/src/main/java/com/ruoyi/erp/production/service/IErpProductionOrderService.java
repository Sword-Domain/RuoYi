package com.ruoyi.erp.production.service;

import java.util.List;
import com.ruoyi.erp.production.domain.ErpProductionOrder;

public interface IErpProductionOrderService {

    List<ErpProductionOrder> selectProductionOrderList(ErpProductionOrder order);

    ErpProductionOrder selectProductionOrderById(Long orderId);

    ErpProductionOrder selectProductionOrderByNo(String orderNo);

    int insertProductionOrder(ErpProductionOrder order);

    int updateProductionOrder(ErpProductionOrder order);

    int releaseProductionOrder(Long orderId);

    int closeProductionOrder(Long orderId, String closeReason);

    int cancelProductionOrder(Long orderId);

    int deleteProductionOrderById(Long orderId);

    int deleteProductionOrderByIds(Long[] orderIds);

    String generateOrderNo();
}
