package com.ruoyi.hq.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hq.mapper.HqStudentMapper;
import com.ruoyi.hq.domain.HqStudent;
import com.ruoyi.hq.service.IHqStudentService;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 学员信息管理Service业务层处理
 *
 * @author chenxinyang
 * @date 2023-11-29
 */
@Service
public class HqStudentServiceImpl implements IHqStudentService
{
    @Autowired
    private HqStudentMapper hqStudentMapper;

    // 获取 ValidatorFactory
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    // 获取 Validator
    Validator validator = validatorFactory.getValidator();

    /**
     * 查询学员信息管理
     *
     * @param id 学员信息管理主键
     * @return 学员信息管理
     */
    @Override
    public HqStudent selectHqStudentById(Long id)
    {
        return hqStudentMapper.selectHqStudentById(id);
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
     * @param ids 需要删除的学员信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHqStudentByIds(Long[] ids)
    {
        return hqStudentMapper.deleteHqStudentByIds(ids);
    }

    /**
     * 删除学员信息管理信息
     *
     * @param id 学员信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHqStudentById(Long id)
    {
        return hqStudentMapper.deleteHqStudentById(id);
    }
    @Override
    public String importStudent(List<HqStudent> userList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (HqStudent user : userList)
        {
            try
            {

                BeanValidators.validateWithException(validator, user);
                user.setCreateBy(operName);
                this.insertHqStudent(user);
                successNum++;
                successMsg.append("<br/>" + successNum + "、账号 " + user.getStudentId() + " 导入成功");

            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + user.getStudentId() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
