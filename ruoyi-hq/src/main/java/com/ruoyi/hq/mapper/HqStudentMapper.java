package com.ruoyi.hq.mapper;

import java.util.List;
import com.ruoyi.hq.domain.HqStudent;

/**
 * 学员信息管理Mapper接口
 * 
 * @author chenxinyang
 * @date 2023-11-29
 */
public interface HqStudentMapper 
{
    /**
     * 查询学员信息管理
     * 
     * @param id 学员信息管理主键
     * @return 学员信息管理
     */
    public HqStudent selectHqStudentById(Long id);

    /**
     * 查询学员信息管理列表
     * 
     * @param hqStudent 学员信息管理
     * @return 学员信息管理集合
     */
    public List<HqStudent> selectHqStudentList(HqStudent hqStudent);

    /**
     * 新增学员信息管理
     * 
     * @param hqStudent 学员信息管理
     * @return 结果
     */
    public int insertHqStudent(HqStudent hqStudent);

    /**
     * 修改学员信息管理
     * 
     * @param hqStudent 学员信息管理
     * @return 结果
     */
    public int updateHqStudent(HqStudent hqStudent);

    /**
     * 删除学员信息管理
     * 
     * @param id 学员信息管理主键
     * @return 结果
     */
    public int deleteHqStudentById(Long id);

    /**
     * 批量删除学员信息管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHqStudentByIds(Long[] ids);
}
