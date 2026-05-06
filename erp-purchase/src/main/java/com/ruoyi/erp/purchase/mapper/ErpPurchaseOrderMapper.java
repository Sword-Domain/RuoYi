package com.ruoyi.erp.purchase.mapper;

import java.util.List;
import com.ruoyi.erp.purchase.domain.ErpPurchaseOrder;
import org.apache.ibatis.annotations.Param;

public interface ErpPurchaseOrderMapper {

    List<ErpPurchaseOrder> selectPurchaseOrderList(ErpPurchaseOrder purchaseOrder);

    ErpPurchaseOrder selectPurchaseOrderById(Long orderId);

    int insertPurchaseOrder(ErpPurchaseOrder purchaseOrder);

    int updatePurchaseOrder(ErpPurchaseOrder purchaseOrder);

    int deletePurchaseOrderById(Long orderId);

    int deletePurchaseOrderByIds(Long[] orderIds);

    String selectMaxOrderNo();
}
