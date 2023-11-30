package com.ruoyi.hq.service;

import java.util.Date;
import java.util.List;
import com.ruoyi.hq.domain.SignUp;

/**
 * 学员报名课程Service接口
 *
 * @author chenxinyang
 * @date 2023-11-30
 */
public interface ISignUpService
{
    /**
     * 查询学员报名课程
     *
     * @param deptId 学员报名课程主键
     * @return 学员报名课程
     */
    public SignUp selectSignUpByDeptId(Long deptId);

    /**
     * 查询学员报名课程列表
     *
     * @param signUp 学员报名课程
     * @return 学员报名课程集合
     */
    public List<SignUp> selectSignUpList(SignUp signUp);

    /**
     * 新增学员报名课程
     *
     * @param signUp 学员报名课程
     * @return 结果
     */
    public int insertSignUp(SignUp signUp);

    /**
     * 修改学员报名课程
     *
     * @param signUp 学员报名课程
     * @return 结果
     */
    public int updateSignUp(SignUp signUp);

    /**
     * 批量删除学员报名课程
     *
     * @param deptIds 需要删除的学员报名课程主键集合
     * @return 结果
     */
    public int deleteSignUpByDeptIds(Long[] deptIds);

    /**
     * 删除学员报名课程信息
     *
     * @param deptId 学员报名课程主键
     * @return 结果
     */
    public int deleteSignUpByDeptId(Long deptId);

    public List<SignUp> searchSuitableCourse(List<Date> dateRange);
}
