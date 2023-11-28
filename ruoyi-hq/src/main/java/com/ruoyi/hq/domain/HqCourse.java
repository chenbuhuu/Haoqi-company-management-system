package com.ruoyi.hq.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 课程计划管理对象 hq_course
 * 
 * @author chenxinyang
 * @date 2023-11-28
 */
public class HqCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long courseId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 课程时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "课程时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 课程地点 */
    @Excel(name = "课程地点")
    private String place;

    /** 课程内容 */
    @Excel(name = "课程内容")
    private String courseContent;

    /** 课程单次费用 */
    @Excel(name = "课程单次费用")
    private BigDecimal cost;

    /** 总收入 */
    @Excel(name = "总收入")
    private Long totalIncome;

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setPlace(String place) 
    {
        this.place = place;
    }

    public String getPlace() 
    {
        return place;
    }
    public void setCourseContent(String courseContent) 
    {
        this.courseContent = courseContent;
    }

    public String getCourseContent() 
    {
        return courseContent;
    }
    public void setCost(BigDecimal cost) 
    {
        this.cost = cost;
    }

    public BigDecimal getCost() 
    {
        return cost;
    }
    public void setTotalIncome(Long totalIncome) 
    {
        this.totalIncome = totalIncome;
    }

    public Long getTotalIncome() 
    {
        return totalIncome;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("courseId", getCourseId())
            .append("courseName", getCourseName())
            .append("time", getTime())
            .append("place", getPlace())
            .append("courseContent", getCourseContent())
            .append("cost", getCost())
            .append("totalIncome", getTotalIncome())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
