package com.ruoyi.hq.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hq.mapper.HqApplicationMapper;
import com.ruoyi.hq.domain.HqApplication;
import com.ruoyi.hq.service.IHqApplicationService;

/**
 * 培训申请管理Service业务层处理
 * 
 * @author chenxinyang
 * @date 2023-11-28
 */
@Service
public class HqApplicationServiceImpl implements IHqApplicationService 
{
    @Autowired
    private HqApplicationMapper hqApplicationMapper;

    /**
     * 查询培训申请管理
     * 
     * @param applicationId 培训申请管理主键
     * @return 培训申请管理
     */
    @Override
    public HqApplication selectHqApplicationByApplicationId(Long applicationId)
    {
        return hqApplicationMapper.selectHqApplicationByApplicationId(applicationId);
    }

    /**
     * 查询培训申请管理列表
     * 
     * @param hqApplication 培训申请管理
     * @return 培训申请管理
     */
    @Override
    public List<HqApplication> selectHqApplicationList(HqApplication hqApplication)
    {
        return hqApplicationMapper.selectHqApplicationList(hqApplication);
    }

    /**
     * 新增培训申请管理
     * 
     * @param hqApplication 培训申请管理
     * @return 结果
     */
    @Override
    public int insertHqApplication(HqApplication hqApplication)
    {
        hqApplication.setCreateTime(DateUtils.getNowDate());
        return hqApplicationMapper.insertHqApplication(hqApplication);
    }

    /**
     * 修改培训申请管理
     * 
     * @param hqApplication 培训申请管理
     * @return 结果
     */
    @Override
    public int updateHqApplication(HqApplication hqApplication)
    {
        hqApplication.setUpdateTime(DateUtils.getNowDate());
        return hqApplicationMapper.updateHqApplication(hqApplication);
    }

    /**
     * 批量删除培训申请管理
     * 
     * @param applicationIds 需要删除的培训申请管理主键
     * @return 结果
     */
    @Override
    public int deleteHqApplicationByApplicationIds(Long[] applicationIds)
    {
        return hqApplicationMapper.deleteHqApplicationByApplicationIds(applicationIds);
    }

    /**
     * 删除培训申请管理信息
     * 
     * @param applicationId 培训申请管理主键
     * @return 结果
     */
    @Override
    public int deleteHqApplicationByApplicationId(Long applicationId)
    {
        return hqApplicationMapper.deleteHqApplicationByApplicationId(applicationId);
    }
}
