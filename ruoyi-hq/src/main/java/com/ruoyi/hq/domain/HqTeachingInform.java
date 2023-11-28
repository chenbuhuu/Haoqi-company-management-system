package com.ruoyi.hq.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 讲师代课信息管理对象 hq_teaching_inform
 *
 * @author chenxinyang
 * @date 2023-11-28
 */
public class HqTeachingInform extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private Long tiCourseId;

    /** 老师编号 */
    @Excel(name = "老师编号")
    private Long tiTeacherId;
    private HqTeacher hqTeacher;
    private HqCourse hqCourse;

    public HqTeacher getHqTeacher() {
        return hqTeacher;
    }

    public void setHqTeacher(HqTeacher hqTeacher) {
        this.hqTeacher = hqTeacher;
    }

    public HqCourse getHqCourse() {
        return hqCourse;
    }

    public void setHqCourse(HqCourse hqCourse) {
        this.hqCourse = hqCourse;
    }

    public void setTiCourseId(Long tiCourseId)
    {
        this.tiCourseId = tiCourseId;
    }

    public Long getTiCourseId()
    {
        return tiCourseId;
    }
    public void setTiTeacherId(Long tiTeacherId)
    {
        this.tiTeacherId = tiTeacherId;
    }

    public Long getTiTeacherId()
    {
        return tiTeacherId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tiCourseId", getTiCourseId())
            .append("tiTeacherId", getTiTeacherId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
                .append("hqTeacher", getHqTeacher())
                .append("hqCourse", getHqCourse())

            .toString();
    }
}
