package com.ruoyi.hq.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hq.mapper.HqTeacherMapper;
import com.ruoyi.hq.domain.HqTeacher;
import com.ruoyi.hq.service.IHqTeacherService;

/**
 * 讲师信息管理Service业务层处理
 * 
 * @author chenxinyang
 * @date 2023-11-27
 */
@Service
public class HqTeacherServiceImpl implements IHqTeacherService 
{
    @Autowired
    private HqTeacherMapper hqTeacherMapper;

    /**
     * 查询讲师信息管理
     * 
     * @param teacherId 讲师信息管理主键
     * @return 讲师信息管理
     */
    @Override
    public HqTeacher selectHqTeacherByTeacherId(Long teacherId)
    {
        return hqTeacherMapper.selectHqTeacherByTeacherId(teacherId);
    }

    /**
     * 查询讲师信息管理列表
     * 
     * @param hqTeacher 讲师信息管理
     * @return 讲师信息管理
     */
    @Override
    public List<HqTeacher> selectHqTeacherList(HqTeacher hqTeacher)
    {
        return hqTeacherMapper.selectHqTeacherList(hqTeacher);
    }

    /**
     * 新增讲师信息管理
     * 
     * @param hqTeacher 讲师信息管理
     * @return 结果
     */
    @Override
    public int insertHqTeacher(HqTeacher hqTeacher)
    {
        hqTeacher.setCreateTime(DateUtils.getNowDate());
        return hqTeacherMapper.insertHqTeacher(hqTeacher);
    }

    /**
     * 修改讲师信息管理
     * 
     * @param hqTeacher 讲师信息管理
     * @return 结果
     */
    @Override
    public int updateHqTeacher(HqTeacher hqTeacher)
    {
        hqTeacher.setUpdateTime(DateUtils.getNowDate());
        return hqTeacherMapper.updateHqTeacher(hqTeacher);
    }

    /**
     * 批量删除讲师信息管理
     * 
     * @param teacherIds 需要删除的讲师信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHqTeacherByTeacherIds(Long[] teacherIds)
    {
        return hqTeacherMapper.deleteHqTeacherByTeacherIds(teacherIds);
    }

    /**
     * 删除讲师信息管理信息
     * 
     * @param teacherId 讲师信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHqTeacherByTeacherId(Long teacherId)
    {
        return hqTeacherMapper.deleteHqTeacherByTeacherId(teacherId);
    }
}
