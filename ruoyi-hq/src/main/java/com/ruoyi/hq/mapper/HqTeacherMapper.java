package com.ruoyi.hq.mapper;

import java.util.List;
import com.ruoyi.hq.domain.HqTeacher;

/**
 * 讲师信息管理Mapper接口
 * 
 * @author chenxinyang
 * @date 2023-11-27
 */
public interface HqTeacherMapper 
{
    /**
     * 查询讲师信息管理
     * 
     * @param teacherId 讲师信息管理主键
     * @return 讲师信息管理
     */
    public HqTeacher selectHqTeacherByTeacherId(Long teacherId);

    /**
     * 查询讲师信息管理列表
     * 
     * @param hqTeacher 讲师信息管理
     * @return 讲师信息管理集合
     */
    public List<HqTeacher> selectHqTeacherList(HqTeacher hqTeacher);

    /**
     * 新增讲师信息管理
     * 
     * @param hqTeacher 讲师信息管理
     * @return 结果
     */
    public int insertHqTeacher(HqTeacher hqTeacher);

    /**
     * 修改讲师信息管理
     * 
     * @param hqTeacher 讲师信息管理
     * @return 结果
     */
    public int updateHqTeacher(HqTeacher hqTeacher);

    /**
     * 删除讲师信息管理
     * 
     * @param teacherId 讲师信息管理主键
     * @return 结果
     */
    public int deleteHqTeacherByTeacherId(Long teacherId);

    /**
     * 批量删除讲师信息管理
     * 
     * @param teacherIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHqTeacherByTeacherIds(Long[] teacherIds);
}
