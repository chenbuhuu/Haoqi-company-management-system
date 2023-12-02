package com.ruoyi.hq.service;

import java.util.List;
import com.ruoyi.hq.domain.Apply;

/**
 * 公司申请培训Service接口
 *
 * @author chenxinyang
 * @date 2023-12-02
 */
public interface IApplyService
{
    /**
     * 查询公司申请培训
     *
     * @param deptId 公司申请培训主键
     * @return 公司申请培训
     */
    public Apply selectApplyByDeptId(Long deptId);

    /**
     * 查询公司申请培训列表
     *
     * @param apply 公司申请培训
     * @return 公司申请培训集合
     */
    public List<Apply> selectApplyList(Apply apply);

    /**
     * 新增公司申请培训
     *
     * @param apply 公司申请培训
     * @return 结果
     */
    public int insertApply(Apply apply);

    /**
     * 修改公司申请培训
     *
     * @param apply 公司申请培训
     * @return 结果
     */
    public int updateApply(Apply apply);

    /**
     * 批量删除公司申请培训
     *
     * @param deptIds 需要删除的公司申请培训主键集合
     * @return 结果
     */
    public int deleteApplyByDeptIds(Long[] deptIds);

    /**
     * 删除公司申请培训信息
     *
     * @param deptId 公司申请培训主键
     * @return 结果
     */
    public int deleteApplyByDeptId(Long deptId);
    public int apply(Apply apply);

}
