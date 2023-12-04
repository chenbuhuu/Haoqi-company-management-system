package com.ruoyi.hq.service;

import java.util.List;

import com.ruoyi.hq.domain.HqStudent;
import com.ruoyi.hq.domain.HqTeacher;

/**
 * 讲师信息管理Service接口
 *
 * @author chenxinyang
 * @date 2023-11-27
 */
public interface IHqTeacherService
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
     * 批量删除讲师信息管理
     *
     * @param teacherIds 需要删除的讲师信息管理主键集合
     * @return 结果
     */
    public int deleteHqTeacherByTeacherIds(Long[] teacherIds);

    /**
     * 删除讲师信息管理信息
     *
     * @param teacherId 讲师信息管理主键
     * @return 结果
     */
    public int deleteHqTeacherByTeacherId(Long teacherId);
    public String importTeacher(List<HqTeacher> userList, Boolean isUpdateSupport, String operName);

}
