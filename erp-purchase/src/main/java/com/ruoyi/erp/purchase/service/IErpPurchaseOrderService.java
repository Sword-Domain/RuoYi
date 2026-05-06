package com.ruoyi.erp.purchase.service;

import java.util.List;
import com.ruoyi.erp.purchase.domain.ErpPurchaseOrder;

public interface IErpPurchaseOrderService {

    List<ErpPurchaseOrder> selectPurchaseOrderList(ErpPurchaseOrder purchaseOrder);

    ErpPurchaseOrder selectPurchaseOrderById(Long orderId);

    int insertPurchaseOrder(ErpPurchaseOrder purchaseOrder);

    int updatePurchaseOrder(ErpPurchaseOrder purchaseOrder);

    int deletePurchaseOrderById(Long orderId);

    int deletePurchaseOrderByIds(Long[] orderIds);

    String generateOrderNo();

    int release(Long orderId);

    int close(Long orderId);

    int cancel(Long orderId);
}
