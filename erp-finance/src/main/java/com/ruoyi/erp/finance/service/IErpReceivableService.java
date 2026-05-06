package com.ruoyi.erp.finance.service;

import java.util.List;

import com.ruoyi.erp.finance.domain.ErpReceivable;

/**
 * 应收款Service接口
 *
 * @author ruoyi
 * @date 2024-01-01
 */
public interface IErpReceivableService {

    /**
     * 查询应收款
     *
     * @param receivableId 应收款ID
     * @return 应收款
     */
    ErpReceivable selectById(Long receivableId);

    /**
     * 查询应收款列表
     *
     * @param receivable 应收款
     * @return 应收款集合
     */
    List<ErpReceivable> selectList(ErpReceivable receivable);

    /**
     * 新增应收款
     *
     * @param receivable 应收款
     * @return 结果
     */
    int insert(ErpReceivable receivable);

    /**
     * 修改应收款
     *
     * @param receivable 应收款
     * @return 结果
     */
    int update(ErpReceivable receivable);

    /**
     * 删除应收款
     *
     * @param receivableId 应收款ID
     * @return 结果
     */
    int delete(Long receivableId);

    /**
     * 批量删除应收款
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int delete(String ids);

}
