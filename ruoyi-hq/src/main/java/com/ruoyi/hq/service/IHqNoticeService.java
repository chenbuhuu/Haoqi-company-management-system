package com.ruoyi.hq.service;

import java.util.List;
import com.ruoyi.hq.domain.HqNotice;

/**
 * 培训通知信息管理Service接口
 * 
 * @author chenxinyang
 * @date 2023-11-28
 */
public interface IHqNoticeService 
{
    /**
     * 查询培训通知信息管理
     * 
     * @param noticeId 培训通知信息管理主键
     * @return 培训通知信息管理
     */
    public HqNotice selectHqNoticeByNoticeId(Long noticeId);

    /**
     * 查询培训通知信息管理列表
     * 
     * @param hqNotice 培训通知信息管理
     * @return 培训通知信息管理集合
     */
    public List<HqNotice> selectHqNoticeList(HqNotice hqNotice);

    /**
     * 新增培训通知信息管理
     * 
     * @param hqNotice 培训通知信息管理
     * @return 结果
     */
    public int insertHqNotice(HqNotice hqNotice);

    /**
     * 修改培训通知信息管理
     * 
     * @param hqNotice 培训通知信息管理
     * @return 结果
     */
    public int updateHqNotice(HqNotice hqNotice);

    /**
     * 批量删除培训通知信息管理
     * 
     * @param noticeIds 需要删除的培训通知信息管理主键集合
     * @return 结果
     */
    public int deleteHqNoticeByNoticeIds(Long[] noticeIds);

    /**
     * 删除培训通知信息管理信息
     * 
     * @param noticeId 培训通知信息管理主键
     * @return 结果
     */
    public int deleteHqNoticeByNoticeId(Long noticeId);
}
