package com.ruoyi.hq.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hq.mapper.ApplyMapper;
import com.ruoyi.hq.domain.Apply;
import com.ruoyi.hq.service.IApplyService;

/**
 * 公司申请培训Service业务层处理
 *
 * @author chenxinyang
 * @date 2023-12-02
 */
@Service
public class ApplyServiceImpl implements IApplyService
{
    @Autowired
    private ApplyMapper applyMapper;

    /**
     * 查询公司申请培训
     *
     * @param deptId 公司申请培训主键
     * @return 公司申请培训
     */
    @Override
    public Apply selectApplyByDeptId(Long deptId)
    {
        return applyMapper.selectApplyByDeptId(deptId);
    }

    /**
     * 查询公司申请培训列表
     *
     * @param apply 公司申请培训
     * @return 公司申请培训
     */
    @Override
    public List<Apply> selectApplyList(Apply apply)
    {
        return applyMapper.selectApplyList(apply);
    }

    /**
     * 新增公司申请培训
     *
     * @param apply 公司申请培训
     * @return 结果
     */
    @Override
    public int insertApply(Apply apply)
    {
        apply.setCreateTime(DateUtils.getNowDate());
        return applyMapper.insertApply(apply);
    }

    /**
     * 修改公司申请培训
     *
     * @param apply 公司申请培训
     * @return 结果
     */
    @Override
    public int updateApply(Apply apply)
    {
        apply.setUpdateTime(DateUtils.getNowDate());
        return applyMapper.updateApply(apply);
    }

    /**
     * 批量删除公司申请培训
     *
     * @param deptIds 需要删除的公司申请培训主键
     * @return 结果
     */
    @Override
    public int deleteApplyByDeptIds(Long[] deptIds)
    {
        return applyMapper.deleteApplyByDeptIds(deptIds);
    }

    @Override
    public int apply(Apply apply) {
        System.out.println("apply");

        System.out.println(apply);
        System.out.println("apply");

        return applyMapper.apply(apply);
    }

    /**
     * 删除公司申请培训信息
     *
     * @param deptId 公司申请培训主键
     * @return 结果
     */
    @Override
    public int deleteApplyByDeptId(Long deptId)
    {
        return applyMapper.deleteApplyByDeptId(deptId);

    }
}
