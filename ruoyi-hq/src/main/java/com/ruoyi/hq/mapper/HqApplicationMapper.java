package com.ruoyi.hq.mapper;

import java.util.List;
import com.ruoyi.hq.domain.HqApplication;

/**
 * 培训申请管理Mapper接口
 *
 * @author chenxinyang
 * @date 2023-12-05
 */
public interface HqApplicationMapper
{
    /**
     * 查询培训申请管理
     *
     * @param applicationId 培训申请管理主键
     * @return 培训申请管理
     */
    public HqApplication selectHqApplicationByApplicationId(Long applicationId);

    /**
     * 查询培训申请管理列表
     *
     * @param hqApplication 培训申请管理
     * @return 培训申请管理集合
     */
    public List<HqApplication> selectHqApplicationList(HqApplication hqApplication);

    /**
     * 新增培训申请管理
     *
     * @param hqApplication 培训申请管理
     * @return 结果
     */
    public int insertHqApplication(HqApplication hqApplication);

    /**
     * 修改培训申请管理
     *
     * @param hqApplication 培训申请管理
     * @return 结果
     */
    public int updateHqApplication(HqApplication hqApplication);
    public int commit(HqApplication hqApplication);
    /**
     * 删除培训申请管理
     *
     * @param applicationId 培训申请管理主键
     * @return 结果
     */
    public int deleteHqApplicationByApplicationId(Long applicationId);

    /**
     * 批量删除培训申请管理
     *
     * @param applicationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHqApplicationByApplicationIds(Long[] applicationIds);
}
