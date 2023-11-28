package com.ruoyi.hq.service;

import java.util.List;
import com.ruoyi.hq.domain.HqTeachingInform;

/**
 * 讲师代课信息管理Service接口
 * 
 * @author chenxinyang
 * @date 2023-11-28
 */
public interface IHqTeachingInformService 
{
    /**
     * 查询讲师代课信息管理
     * 
     * @param tiCourseId 讲师代课信息管理主键
     * @return 讲师代课信息管理
     */
    public HqTeachingInform selectHqTeachingInformByTiCourseId(Long tiCourseId);

    /**
     * 查询讲师代课信息管理列表
     * 
     * @param hqTeachingInform 讲师代课信息管理
     * @return 讲师代课信息管理集合
     */
    public List<HqTeachingInform> selectHqTeachingInformList(HqTeachingInform hqTeachingInform);

    /**
     * 新增讲师代课信息管理
     * 
     * @param hqTeachingInform 讲师代课信息管理
     * @return 结果
     */
    public int insertHqTeachingInform(HqTeachingInform hqTeachingInform);

    /**
     * 修改讲师代课信息管理
     * 
     * @param hqTeachingInform 讲师代课信息管理
     * @return 结果
     */
    public int updateHqTeachingInform(HqTeachingInform hqTeachingInform);

    /**
     * 批量删除讲师代课信息管理
     * 
     * @param tiCourseIds 需要删除的讲师代课信息管理主键集合
     * @return 结果
     */
    public int deleteHqTeachingInformByTiCourseIds(Long[] tiCourseIds);

    /**
     * 删除讲师代课信息管理信息
     * 
     * @param tiCourseId 讲师代课信息管理主键
     * @return 结果
     */
    public int deleteHqTeachingInformByTiCourseId(Long tiCourseId);
}
