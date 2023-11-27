package com.ruoyi.hq.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hq.mapper.HqStudentMapper;
import com.ruoyi.hq.domain.HqStudent;
import com.ruoyi.hq.service.IHqStudentService;

/**
 * 学员信息管理Service业务层处理
 * 
 * @author chenxinyang
 * @date 2023-11-27
 */
@Service
public class HqStudentServiceImpl implements IHqStudentService 
{
    @Autowired
    private HqStudentMapper hqStudentMapper;

    /**
     * 查询学员信息管理
     * 
     * @param studentId 学员信息管理主键
     * @return 学员信息管理
     */
    @Override
    public HqStudent selectHqStudentByStudentId(Long studentId)
    {
        return hqStudentMapper.selectHqStudentByStudentId(studentId);
    }

    /**
     * 查询学员信息管理列表
     * 
     * @param hqStudent 学员信息管理
     * @return 学员信息管理
     */
    @Override
    public List<HqStudent> selectHqStudentList(HqStudent hqStudent)
    {
        return hqStudentMapper.selectHqStudentList(hqStudent);
    }

    /**
     * 新增学员信息管理
     * 
     * @param hqStudent 学员信息管理
     * @return 结果
     */
    @Override
    public int insertHqStudent(HqStudent hqStudent)
    {
        hqStudent.setCreateTime(DateUtils.getNowDate());
        return hqStudentMapper.insertHqStudent(hqStudent);
    }

    /**
     * 修改学员信息管理
     * 
     * @param hqStudent 学员信息管理
     * @return 结果
     */
    @Override
    public int updateHqStudent(HqStudent hqStudent)
    {
        hqStudent.setUpdateTime(DateUtils.getNowDate());
        return hqStudentMapper.updateHqStudent(hqStudent);
    }

    /**
     * 批量删除学员信息管理
     * 
     * @param studentIds 需要删除的学员信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHqStudentByStudentIds(Long[] studentIds)
    {
        return hqStudentMapper.deleteHqStudentByStudentIds(studentIds);
    }

    /**
     * 删除学员信息管理信息
     * 
     * @param studentId 学员信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHqStudentByStudentId(Long studentId)
    {
        return hqStudentMapper.deleteHqStudentByStudentId(studentId);
    }
}
