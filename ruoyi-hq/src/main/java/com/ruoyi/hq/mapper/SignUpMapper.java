package com.ruoyi.hq.mapper;

import java.util.Date;
import java.util.List;
import com.ruoyi.hq.domain.SignUp;

import org.apache.ibatis.annotations.Param;

/**
 * 学员报名课程Mapper接口
 *
 * @author chenxinyang
 * @date 2023-11-30
 */
public interface SignUpMapper
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
     * 删除学员报名课程
     *
     * @param deptId 学员报名课程主键
     * @return 结果
     */
    public int deleteSignUpByDeptId(Long deptId);

    /**
     * 批量删除学员报名课程
     *
     * @param deptIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSignUpByDeptIds(Long[] deptIds);
    public List<SignUp> searchSuitableCourse( @Param("dateRange") List<Date> dateRange);
}
