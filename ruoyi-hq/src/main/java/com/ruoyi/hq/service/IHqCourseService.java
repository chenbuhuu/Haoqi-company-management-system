package com.ruoyi.hq.service;

import java.util.List;
import com.ruoyi.hq.domain.HqCourse;

/**
 * 课程计划管理Service接口
 * 
 * @author chenxinyang
 * @date 2023-11-28
 */
public interface IHqCourseService 
{
    /**
     * 查询课程计划管理
     * 
     * @param courseId 课程计划管理主键
     * @return 课程计划管理
     */
    public HqCourse selectHqCourseByCourseId(Long courseId);

    /**
     * 查询课程计划管理列表
     * 
     * @param hqCourse 课程计划管理
     * @return 课程计划管理集合
     */
    public List<HqCourse> selectHqCourseList(HqCourse hqCourse);

    /**
     * 新增课程计划管理
     * 
     * @param hqCourse 课程计划管理
     * @return 结果
     */
    public int insertHqCourse(HqCourse hqCourse);

    /**
     * 修改课程计划管理
     * 
     * @param hqCourse 课程计划管理
     * @return 结果
     */
    public int updateHqCourse(HqCourse hqCourse);

    /**
     * 批量删除课程计划管理
     * 
     * @param courseIds 需要删除的课程计划管理主键集合
     * @return 结果
     */
    public int deleteHqCourseByCourseIds(Long[] courseIds);

    /**
     * 删除课程计划管理信息
     * 
     * @param courseId 课程计划管理主键
     * @return 结果
     */
    public int deleteHqCourseByCourseId(Long courseId);
}
