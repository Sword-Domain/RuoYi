package com.ruoyi.erp.sales.service;

import java.util.List;
import com.ruoyi.erp.sales.domain.ErpSalesOrder;

public interface IErpSalesOrderService
{
    ErpSalesOrder selectSalesOrderById(Long orderId);

    List<ErpSalesOrder> selectSalesOrderList(ErpSalesOrder erpSalesOrder);

    int insertSalesOrder(ErpSalesOrder erpSalesOrder);

    int updateSalesOrder(ErpSalesOrder erpSalesOrder);

    int deleteSalesOrderByIds(Long[] orderIds);

    String generateOrderNo();

    int release(Long orderId);

    int close(Long orderId);

    int cancel(Long orderId);
}
