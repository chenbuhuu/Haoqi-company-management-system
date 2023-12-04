package com.ruoyi.hq.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.hq.domain.HqStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hq.mapper.HqTeacherMapper;
import com.ruoyi.hq.domain.HqTeacher;
import com.ruoyi.hq.service.IHqTeacherService;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
    // 获取 ValidatorFactory
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    // 获取 Validator
    Validator validator = validatorFactory.getValidator();

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

    @Override
    public String importTeacher(List<HqTeacher> userList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (HqTeacher user : userList)
        {
            try
            {

                BeanValidators.validateWithException(validator, user);
                user.setCreateBy(operName);
                this.insertHqTeacher(user);
                successNum++;
                successMsg.append("<br/>" + successNum + "、账号 " + user.getTeacherId() + " 导入成功");

            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + user.getTeacherId() + " 导入失败：";
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
