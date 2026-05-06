package com.ruoyi.erp.sales.mapper;

import java.util.List;
import com.ruoyi.erp.sales.domain.ErpSalesOrder;
import org.apache.ibatis.annotations.Param;

public interface ErpSalesOrderMapper
{
    List<ErpSalesOrder> selectSalesOrderList(ErpSalesOrder erpSalesOrder);

    ErpSalesOrder selectSalesOrderById(Long orderId);

    int insertSalesOrder(ErpSalesOrder erpSalesOrder);

    int updateSalesOrder(ErpSalesOrder erpSalesOrder);

    int deleteSalesOrderByIds(Long[] orderIds);

    String selectMaxOrderNo();
}
