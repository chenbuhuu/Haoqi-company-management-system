package com.ruoyi.hq.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 讲师信息管理对象 hq_teacher
 * 
 * @author chenxinyang
 * @date 2023-11-27
 */
public class HqTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long teacherId;

    /** 讲师姓名 */
    @Excel(name = "讲师姓名")
    private String teacherName;

    /** 教龄 */
    @Excel(name = "教龄")
    private Long teachingLength;

    /** 讲师电话 */
    @Excel(name = "讲师电话")
    private Long teacherPhone;

    /** 讲师邮箱 */
    @Excel(name = "讲师邮箱")
    private String teacherEmail;

    /** 擅长课程 */
    @Excel(name = "擅长课程")
    private String skilledCourse;

    public void setTeacherId(Long teacherId) 
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() 
    {
        return teacherId;
    }
    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }
    public void setTeachingLength(Long teachingLength) 
    {
        this.teachingLength = teachingLength;
    }

    public Long getTeachingLength() 
    {
        return teachingLength;
    }
    public void setTeacherPhone(Long teacherPhone) 
    {
        this.teacherPhone = teacherPhone;
    }

    public Long getTeacherPhone() 
    {
        return teacherPhone;
    }
    public void setTeacherEmail(String teacherEmail) 
    {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherEmail() 
    {
        return teacherEmail;
    }
    public void setSkilledCourse(String skilledCourse) 
    {
        this.skilledCourse = skilledCourse;
    }

    public String getSkilledCourse() 
    {
        return skilledCourse;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("teacherId", getTeacherId())
            .append("teacherName", getTeacherName())
            .append("teachingLength", getTeachingLength())
            .append("teacherPhone", getTeacherPhone())
            .append("teacherEmail", getTeacherEmail())
            .append("skilledCourse", getSkilledCourse())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
