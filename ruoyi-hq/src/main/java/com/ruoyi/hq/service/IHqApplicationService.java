package com.ruoyi.hq.service;

import java.util.List;
import com.ruoyi.hq.domain.HqApplication;

/**
 * 培训申请管理Service接口
 * 
 * @author chenxinyang
 * @date 2023-11-28
 */
public interface IHqApplicationService 
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

    /**
     * 批量删除培训申请管理
     * 
     * @param applicationIds 需要删除的培训申请管理主键集合
     * @return 结果
     */
    public int deleteHqApplicationByApplicationIds(Long[] applicationIds);

    /**
     * 删除培训申请管理信息
     * 
     * @param applicationId 培训申请管理主键
     * @return 结果
     */
    public int deleteHqApplicationByApplicationId(Long applicationId);
}
