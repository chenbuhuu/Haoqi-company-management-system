package com.ruoyi.hq.service.impl;

import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hq.mapper.SignUpMapper;
import com.ruoyi.hq.domain.SignUp;
import com.ruoyi.hq.service.ISignUpService;

/**
 * 学员报名课程Service业务层处理
 *
 * @author chenxinyang
 * @date 2023-11-30
 */
@Service
public class SignUpServiceImpl implements ISignUpService
{
    @Autowired
    private SignUpMapper signUpMapper;

    /**
     * 查询学员报名课程
     *
     * @param deptId 学员报名课程主键
     * @return 学员报名课程
     */
    @Override
    public SignUp selectSignUpByDeptId(Long deptId)
    {
        return signUpMapper.selectSignUpByDeptId(deptId);
    }

    /**
     * 查询学员报名课程列表
     *
     * @param signUp 学员报名课程
     * @return 学员报名课程
     */
    @Override
    public List<SignUp> selectSignUpList(SignUp signUp)
    {
        return signUpMapper.selectSignUpList(signUp);
    }

    /**
     * 新增学员报名课程
     *
     * @param signUp 学员报名课程
     * @return 结果
     */
    @Override
    public int insertSignUp(SignUp signUp)
    {
        signUp.setCreateTime(DateUtils.getNowDate());
        return signUpMapper.insertSignUp(signUp);
    }

    /**
     * 修改学员报名课程
     *
     * @param signUp 学员报名课程
     * @return 结果
     */
    @Override
    public int updateSignUp(SignUp signUp)
    {
        signUp.setUpdateTime(DateUtils.getNowDate());
        return signUpMapper.updateSignUp(signUp);
    }

    /**
     * 批量删除学员报名课程
     *
     * @param deptIds 需要删除的学员报名课程主键
     * @return 结果
     */
    @Override
    public int deleteSignUpByDeptIds(Long[] deptIds)
    {
        return signUpMapper.deleteSignUpByDeptIds(deptIds);
    }

    /**
     * 删除学员报名课程信息
     *
     * @param deptId 学员报名课程主键
     * @return 结果
     */
    @Override
    public int deleteSignUpByDeptId(Long deptId)
    {
        return signUpMapper.deleteSignUpByDeptId(deptId);
    }

    @Override
    public List<SignUp> searchSuitableCourse(List<Date> dateRange) {
        System.out.println("------------------------------------");

        System.out.println(dateRange);
        System.out.println("------------------------------------");

        return signUpMapper.searchSuitableCourse(dateRange);
    }
}
