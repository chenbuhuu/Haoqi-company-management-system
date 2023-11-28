package com.ruoyi.hq.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hq.mapper.HqNoticeMapper;
import com.ruoyi.hq.domain.HqNotice;
import com.ruoyi.hq.service.IHqNoticeService;

/**
 * 培训通知信息管理Service业务层处理
 * 
 * @author chenxinyang
 * @date 2023-11-28
 */
@Service
public class HqNoticeServiceImpl implements IHqNoticeService 
{
    @Autowired
    private HqNoticeMapper hqNoticeMapper;

    /**
     * 查询培训通知信息管理
     * 
     * @param noticeId 培训通知信息管理主键
     * @return 培训通知信息管理
     */
    @Override
    public HqNotice selectHqNoticeByNoticeId(Long noticeId)
    {
        return hqNoticeMapper.selectHqNoticeByNoticeId(noticeId);
    }

    /**
     * 查询培训通知信息管理列表
     * 
     * @param hqNotice 培训通知信息管理
     * @return 培训通知信息管理
     */
    @Override
    public List<HqNotice> selectHqNoticeList(HqNotice hqNotice)
    {
        return hqNoticeMapper.selectHqNoticeList(hqNotice);
    }

    /**
     * 新增培训通知信息管理
     * 
     * @param hqNotice 培训通知信息管理
     * @return 结果
     */
    @Override
    public int insertHqNotice(HqNotice hqNotice)
    {
        hqNotice.setCreateTime(DateUtils.getNowDate());
        return hqNoticeMapper.insertHqNotice(hqNotice);
    }

    /**
     * 修改培训通知信息管理
     * 
     * @param hqNotice 培训通知信息管理
     * @return 结果
     */
    @Override
    public int updateHqNotice(HqNotice hqNotice)
    {
        hqNotice.setUpdateTime(DateUtils.getNowDate());
        return hqNoticeMapper.updateHqNotice(hqNotice);
    }

    /**
     * 批量删除培训通知信息管理
     * 
     * @param noticeIds 需要删除的培训通知信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHqNoticeByNoticeIds(Long[] noticeIds)
    {
        return hqNoticeMapper.deleteHqNoticeByNoticeIds(noticeIds);
    }

    /**
     * 删除培训通知信息管理信息
     * 
     * @param noticeId 培训通知信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHqNoticeByNoticeId(Long noticeId)
    {
        return hqNoticeMapper.deleteHqNoticeByNoticeId(noticeId);
    }
}
