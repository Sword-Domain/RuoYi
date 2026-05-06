package com.ruoyi.erp.finance.service;

import java.util.List;

import com.ruoyi.erp.finance.domain.ErpPayable;

/**
 * 应付款Service接口
 *
 * @author ruoyi
 * @date 2024-01-01
 */
public interface IErpPayableService {

    /**
     * 查询应付款
     *
     * @param payableId 应付款ID
     * @return 应付款
     */
    ErpPayable selectById(Long payableId);

    /**
     * 查询应付款列表
     *
     * @param payable 应付款
     * @return 应付款集合
     */
    List<ErpPayable> selectList(ErpPayable payable);

    /**
     * 新增应付款
     *
     * @param payable 应付款
     * @return 结果
     */
    int insert(ErpPayable payable);

    /**
     * 修改应付款
     *
     * @param payable 应付款
     * @return 结果
     */
    int update(ErpPayable payable);

    /**
     * 删除应付款
     *
     * @param payableId 应付款ID
     * @return 结果
     */
    int delete(Long payableId);

    /**
     * 批量删除应付款
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int delete(String ids);

}
