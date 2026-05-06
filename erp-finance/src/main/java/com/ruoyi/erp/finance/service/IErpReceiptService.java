package com.ruoyi.erp.finance.service;

import java.util.List;

import com.ruoyi.erp.finance.domain.ErpReceipt;

/**
 * 收款单Service接口
 *
 * @author ruoyi
 * @date 2024-01-01
 */
public interface IErpReceiptService {

    /**
     * 查询收款单
     *
     * @param receiptId 收款单ID
     * @return 收款单
     */
    ErpReceipt selectById(Long receiptId);

    /**
     * 查询收款单列表
     *
     * @param receipt 收款单
     * @return 收款单集合
     */
    List<ErpReceipt> selectList(ErpReceipt receipt);

    /**
     * 新增收款单
     *
     * @param receipt 收款单
     * @return 结果
     */
    int insert(ErpReceipt receipt);

    /**
     * 修改收款单
     *
     * @param receipt 收款单
     * @return 结果
     */
    int update(ErpReceipt receipt);

    /**
     * 删除收款单
     *
     * @param receiptId 收款单ID
     * @return 结果
     */
    int delete(Long receiptId);

    /**
     * 批量删除收款单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int delete(String ids);

}
