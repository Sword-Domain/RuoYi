package com.ruoyi.erp.finance.mapper;

import java.util.List;

import com.ruoyi.erp.finance.domain.ErpPayment;

/**
 * 付款单Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-01
 */
public interface ErpPaymentMapper {

    /**
     * 查询付款单
     *
     * @param paymentId 付款单ID
     * @return 付款单
     */
    ErpPayment selectById(Long paymentId);

    /**
     * 查询付款单列表
     *
     * @param payment 付款单
     * @return 付款单集合
     */
    List<ErpPayment> selectList(ErpPayment payment);

    /**
     * 新增付款单
     *
     * @param payment 付款单
     * @return 结果
     */
    int insert(ErpPayment payment);

    /**
     * 修改付款单
     *
     * @param payment 付款单
     * @return 结果
     */
    int update(ErpPayment payment);

    /**
     * 删除付款单
     *
     * @param paymentId 付款单ID
     * @return 结果
     */
    int delete(Long paymentId);

    /**
     * 批量删除付款单
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteByIds(String ids);

}
