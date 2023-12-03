package com.ruoyi.hq.service;

import java.util.List;
import com.ruoyi.hq.domain.HqStudent;

/**
 * 学员信息管理Service接口
 *
 * @author chenxinyang
 * @date 2023-11-29
 */
public interface IHqStudentService
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
     * 批量删除学员信息管理
     *
     * @param ids 需要删除的学员信息管理主键集合
     * @return 结果
     */
    public int deleteHqStudentByIds(Long[] ids);

    /**
     * 删除学员信息管理信息
     *
     * @param id 学员信息管理主键
     * @return 结果
     */
    public int deleteHqStudentById(Long id);
    public String importStudent(List<HqStudent> userList, Boolean isUpdateSupport, String operName);
}
