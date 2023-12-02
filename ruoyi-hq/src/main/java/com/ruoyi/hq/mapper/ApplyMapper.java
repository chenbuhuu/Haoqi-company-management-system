package com.ruoyi.hq.mapper;

import java.util.List;
import com.ruoyi.hq.domain.Apply;

/**
 * 公司申请培训Mapper接口
 *
 * @author chenxinyang
 * @date 2023-12-02
 */
public interface ApplyMapper
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
     * 删除公司申请培训
     *
     * @param deptId 公司申请培训主键
     * @return 结果
     */
    public int deleteApplyByDeptId(Long deptId);

    /**
     * 批量删除公司申请培训
     *
     * @param deptIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApplyByDeptIds(Long[] deptIds);
    public int apply(Apply apply);
}
