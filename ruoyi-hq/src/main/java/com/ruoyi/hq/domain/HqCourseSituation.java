package com.ruoyi.hq.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学员上课信息管理对象 hq_course_situation
 *
 * @author chenxinyang
 * @date 2023-11-29
 */
public class HqCourseSituation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 学生身份证 */
    @Excel(name = "学生身份证")
    private Long csStudentId;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private Long csCourseId;

    /** 缴费状态 */
    @Excel(name = "缴费状态")
    private Integer payment;

    /** 签到状态 */
    @Excel(name = "签到状态")
    private Integer sign;

    /** 报名状态 */
    @Excel(name = "报名状态")
    private Integer registStatus;

    /** 课程评价 */
    @Excel(name = "课程评价")
    private String evaluate;
    private HqStudent hqStudent;
    private HqCourse hqCourse;

    public HqStudent getHqStudent() {
        return hqStudent;
    }

    public void setHqStudent(HqStudent hqStudent) {
        this.hqStudent = hqStudent;
    }

    public HqCourse getHqCourse() {
        return hqCourse;
    }

    public void setHqCourse(HqCourse hqCourse) {
        this.hqCourse = hqCourse;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCsStudentId(Long csStudentId)
    {
        this.csStudentId = csStudentId;
    }

    public Long getCsStudentId()
    {
        return csStudentId;
    }
    public void setCsCourseId(Long csCourseId)
    {
        this.csCourseId = csCourseId;
    }

    public Long getCsCourseId()
    {
        return csCourseId;
    }
    public void setPayment(Integer payment)
    {
        this.payment = payment;
    }

    public Integer getPayment()
    {
        return payment;
    }
    public void setSign(Integer sign)
    {
        this.sign = sign;
    }

    public Integer getSign()
    {
        return sign;
    }
    public void setRegistStatus(Integer registStatus)
    {
        this.registStatus = registStatus;
    }

    public Integer getRegistStatus()
    {
        return registStatus;
    }
    public void setEvaluate(String evaluate)
    {
        this.evaluate = evaluate;
    }

    public String getEvaluate()
    {
        return evaluate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("csStudentId", getCsStudentId())
            .append("csCourseId", getCsCourseId())
            .append("payment", getPayment())
            .append("sign", getSign())
            .append("registStatus", getRegistStatus())
            .append("evaluate", getEvaluate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
