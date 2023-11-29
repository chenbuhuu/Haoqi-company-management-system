package com.ruoyi.hq.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hq.mapper.HqTeachingInformMapper;
import com.ruoyi.hq.domain.HqTeachingInform;
import com.ruoyi.hq.service.IHqTeachingInformService;

/**
 * 讲师代课信息管理Service业务层处理
 * 
 * @author chenxinyang
 * @date 2023-11-29
 */
@Service
public class HqTeachingInformServiceImpl implements IHqTeachingInformService 
{
    @Autowired
    private HqTeachingInformMapper hqTeachingInformMapper;

    /**
     * 查询讲师代课信息管理
     * 
     * @param id 讲师代课信息管理主键
     * @return 讲师代课信息管理
     */
    @Override
    public HqTeachingInform selectHqTeachingInformById(Long id)
    {
        return hqTeachingInformMapper.selectHqTeachingInformById(id);
    }

    /**
     * 查询讲师代课信息管理列表
     * 
     * @param hqTeachingInform 讲师代课信息管理
     * @return 讲师代课信息管理
     */
    @Override
    public List<HqTeachingInform> selectHqTeachingInformList(HqTeachingInform hqTeachingInform)
    {
        return hqTeachingInformMapper.selectHqTeachingInformList(hqTeachingInform);
    }

    /**
     * 新增讲师代课信息管理
     * 
     * @param hqTeachingInform 讲师代课信息管理
     * @return 结果
     */
    @Override
    public int insertHqTeachingInform(HqTeachingInform hqTeachingInform)
    {
        hqTeachingInform.setCreateTime(DateUtils.getNowDate());
        return hqTeachingInformMapper.insertHqTeachingInform(hqTeachingInform);
    }

    /**
     * 修改讲师代课信息管理
     * 
     * @param hqTeachingInform 讲师代课信息管理
     * @return 结果
     */
    @Override
    public int updateHqTeachingInform(HqTeachingInform hqTeachingInform)
    {
        hqTeachingInform.setUpdateTime(DateUtils.getNowDate());
        return hqTeachingInformMapper.updateHqTeachingInform(hqTeachingInform);
    }

    /**
     * 批量删除讲师代课信息管理
     * 
     * @param ids 需要删除的讲师代课信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHqTeachingInformByIds(Long[] ids)
    {
        return hqTeachingInformMapper.deleteHqTeachingInformByIds(ids);
    }

    /**
     * 删除讲师代课信息管理信息
     * 
     * @param id 讲师代课信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHqTeachingInformById(Long id)
    {
        return hqTeachingInformMapper.deleteHqTeachingInformById(id);
    }
}
