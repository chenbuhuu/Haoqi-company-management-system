package com.ruoyi.hq.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学员信息管理对象 hq_student
 * 
 * @author chenxinyang
 * @date 2023-11-27
 */
public class HqStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private Long studentId;

    /** 学员姓名 */
    @Excel(name = "学员姓名")
    private String studentName;

    /** 学员电话 */
    @Excel(name = "学员电话")
    private Long studentPhone;

    /** 学员邮箱 */
    @Excel(name = "学员邮箱")
    private String studentEmail;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 所属单位 */
    @Excel(name = "所属单位")
    private String unit;

    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setStudentName(String studentName) 
    {
        this.studentName = studentName;
    }

    public String getStudentName() 
    {
        return studentName;
    }
    public void setStudentPhone(Long studentPhone) 
    {
        this.studentPhone = studentPhone;
    }

    public Long getStudentPhone() 
    {
        return studentPhone;
    }
    public void setStudentEmail(String studentEmail) 
    {
        this.studentEmail = studentEmail;
    }

    public String getStudentEmail() 
    {
        return studentEmail;
    }
    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("studentId", getStudentId())
            .append("studentName", getStudentName())
            .append("studentPhone", getStudentPhone())
            .append("studentEmail", getStudentEmail())
            .append("education", getEducation())
            .append("unit", getUnit())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
