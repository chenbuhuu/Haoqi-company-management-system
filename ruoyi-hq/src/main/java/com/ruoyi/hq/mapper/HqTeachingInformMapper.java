package com.ruoyi.hq.mapper;

import java.util.List;
import com.ruoyi.hq.domain.HqTeachingInform;

/**
 * 讲师代课信息管理Mapper接口
 * 
 * @author chenxinyang
 * @date 2023-11-29
 */
public interface HqTeachingInformMapper 
{
    /**
     * 查询讲师代课信息管理
     * 
     * @param id 讲师代课信息管理主键
     * @return 讲师代课信息管理
     */
    public HqTeachingInform selectHqTeachingInformById(Long id);

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
     * 删除讲师代课信息管理
     * 
     * @param id 讲师代课信息管理主键
     * @return 结果
     */
    public int deleteHqTeachingInformById(Long id);

    /**
     * 批量删除讲师代课信息管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHqTeachingInformByIds(Long[] ids);
}
