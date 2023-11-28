package com.ruoyi.hq.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hq.mapper.HqCourseMapper;
import com.ruoyi.hq.domain.HqCourse;
import com.ruoyi.hq.service.IHqCourseService;

/**
 * 课程计划管理Service业务层处理
 * 
 * @author chenxinyang
 * @date 2023-11-28
 */
@Service
public class HqCourseServiceImpl implements IHqCourseService 
{
    @Autowired
    private HqCourseMapper hqCourseMapper;

    /**
     * 查询课程计划管理
     * 
     * @param courseId 课程计划管理主键
     * @return 课程计划管理
     */
    @Override
    public HqCourse selectHqCourseByCourseId(Long courseId)
    {
        return hqCourseMapper.selectHqCourseByCourseId(courseId);
    }

    /**
     * 查询课程计划管理列表
     * 
     * @param hqCourse 课程计划管理
     * @return 课程计划管理
     */
    @Override
    public List<HqCourse> selectHqCourseList(HqCourse hqCourse)
    {
        return hqCourseMapper.selectHqCourseList(hqCourse);
    }

    /**
     * 新增课程计划管理
     * 
     * @param hqCourse 课程计划管理
     * @return 结果
     */
    @Override
    public int insertHqCourse(HqCourse hqCourse)
    {
        hqCourse.setCreateTime(DateUtils.getNowDate());
        return hqCourseMapper.insertHqCourse(hqCourse);
    }

    /**
     * 修改课程计划管理
     * 
     * @param hqCourse 课程计划管理
     * @return 结果
     */
    @Override
    public int updateHqCourse(HqCourse hqCourse)
    {
        hqCourse.setUpdateTime(DateUtils.getNowDate());
        return hqCourseMapper.updateHqCourse(hqCourse);
    }

    /**
     * 批量删除课程计划管理
     * 
     * @param courseIds 需要删除的课程计划管理主键
     * @return 结果
     */
    @Override
    public int deleteHqCourseByCourseIds(Long[] courseIds)
    {
        return hqCourseMapper.deleteHqCourseByCourseIds(courseIds);
    }

    /**
     * 删除课程计划管理信息
     * 
     * @param courseId 课程计划管理主键
     * @return 结果
     */
    @Override
    public int deleteHqCourseByCourseId(Long courseId)
    {
        return hqCourseMapper.deleteHqCourseByCourseId(courseId);
    }
}
