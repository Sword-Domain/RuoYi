package com.ruoyi.erp.production.mapper;

import java.util.List;
import com.ruoyi.erp.production.domain.ErpProductionOrder;

public interface ErpProductionOrderMapper {

    List<ErpProductionOrder> selectProductionOrderList(ErpProductionOrder order);

    ErpProductionOrder selectProductionOrderById(Long orderId);

    ErpProductionOrder selectProductionOrderByNo(String orderNo);

    int insertProductionOrder(ErpProductionOrder order);

    int updateProductionOrder(ErpProductionOrder order);

    int updateProductionOrderStatus(ErpProductionOrder order);

    int deleteProductionOrderById(Long orderId);

    int deleteProductionOrderByIds(Long[] orderIds);

    String selectMaxOrderNo();
}
