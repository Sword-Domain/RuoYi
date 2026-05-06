package com.ruoyi.erp.sales.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.erp.sales.mapper.ErpSalesOrderMapper;
import com.ruoyi.erp.sales.domain.ErpSalesOrder;
import com.ruoyi.erp.sales.service.IErpSalesOrderService;

@Service
public class ErpSalesOrderServiceImpl implements IErpSalesOrderService
{
    @Autowired
    private ErpSalesOrderMapper erpSalesOrderMapper;

    private static final String ORDER_NO_PREFIX = "SO";

    @Override
    public ErpSalesOrder selectSalesOrderById(Long orderId)
    {
        return erpSalesOrderMapper.selectSalesOrderById(orderId);
    }

    @Override
    public java.util.List<ErpSalesOrder> selectSalesOrderList(ErpSalesOrder erpSalesOrder)
    {
        return erpSalesOrderMapper.selectSalesOrderList(erpSalesOrder);
    }

    @Override
    public int insertSalesOrder(ErpSalesOrder erpSalesOrder)
    {
        erpSalesOrder.setOrderNo(generateOrderNo());
        erpSalesOrder.setStatus("10");
        return erpSalesOrderMapper.insertSalesOrder(erpSalesOrder);
    }

    @Override
    public int updateSalesOrder(ErpSalesOrder erpSalesOrder)
    {
        return erpSalesOrderMapper.updateSalesOrder(erpSalesOrder);
    }

    @Override
    public int deleteSalesOrderByIds(Long[] orderIds)
    {
        return erpSalesOrderMapper.deleteSalesOrderByIds(orderIds);
    }

    @Override
    public String generateOrderNo()
    {
        String maxOrderNo = erpSalesOrderMapper.selectMaxOrderNo();
        String newOrderNo;
        if (maxOrderNo == null || maxOrderNo.isEmpty())
        {
            newOrderNo = ORDER_NO_PREFIX + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "0001";
        }
        else
        {
            String dateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
            String maxDateStr = maxOrderNo.substring(ORDER_NO_PREFIX.length(), ORDER_NO_PREFIX.length() + 8);
            if (dateStr.equals(maxDateStr))
            {
                String serialNo = maxOrderNo.substring(ORDER_NO_PREFIX.length() + 8);
                int nextSerial = Integer.parseInt(serialNo) + 1;
                newOrderNo = ORDER_NO_PREFIX + dateStr + String.format("%04d", nextSerial);
            }
            else
            {
                newOrderNo = ORDER_NO_PREFIX + dateStr + "0001";
            }
        }
        return newOrderNo;
    }

    @Override
    public int release(Long orderId)
    {
        ErpSalesOrder salesOrder = new ErpSalesOrder();
        salesOrder.setOrderId(orderId);
        salesOrder.setStatus("20");
        return erpSalesOrderMapper.updateSalesOrder(salesOrder);
    }

    @Override
    public int close(Long orderId)
    {
        ErpSalesOrder salesOrder = new ErpSalesOrder();
        salesOrder.setOrderId(orderId);
        salesOrder.setStatus("30");
        return erpSalesOrderMapper.updateSalesOrder(salesOrder);
    }

    @Override
    public int cancel(Long orderId)
    {
        ErpSalesOrder salesOrder = new ErpSalesOrder();
        salesOrder.setOrderId(orderId);
        salesOrder.setStatus("40");
        return erpSalesOrderMapper.updateSalesOrder(salesOrder);
    }
}
