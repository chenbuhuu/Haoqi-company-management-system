package com.ruoyi.hq.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 培训通知信息管理对象 hq_notice
 *
 * @author chenxinyang
 * @date 2023-11-28
 */
public class HqNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long noticeId;

    /** 通知课程名 */
    @Excel(name = "通知课程名")
    private Long noticeCourseId;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseTime;

    /** 通知内容 */
    @Excel(name = "通知内容")
    private String noticeContent;

    private HqCourse hqCourse;

    public HqCourse getHqCourse() {
        return hqCourse;
    }

    public void setHqCourse(HqCourse hqCourse) {
        this.hqCourse = hqCourse;
    }

    public void setNoticeId(Long noticeId)
    {
        this.noticeId = noticeId;
    }

    public Long getNoticeId()
    {
        return noticeId;
    }
    public void setNoticeCourseId(Long noticeCourseId)
    {
        this.noticeCourseId = noticeCourseId;
    }

    public Long getNoticeCourseId()
    {
        return noticeCourseId;
    }
    public void setReleaseTime(Date releaseTime)
    {
        this.releaseTime = releaseTime;
    }

    public Date getReleaseTime()
    {
        return releaseTime;
    }
    public void setNoticeContent(String noticeContent)
    {
        this.noticeContent = noticeContent;
    }

    public String getNoticeContent()
    {
        return noticeContent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("noticeId", getNoticeId())
            .append("noticeCourseId", getNoticeCourseId())
            .append("releaseTime", getReleaseTime())
            .append("noticeContent", getNoticeContent())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
                .append("hqCourse", getHqCourse())
            .toString();
    }
}
