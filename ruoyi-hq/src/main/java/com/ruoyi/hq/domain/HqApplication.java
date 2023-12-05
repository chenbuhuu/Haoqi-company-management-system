package com.ruoyi.hq.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 培训申请管理对象 hq_application
 * 
 * @author chenxinyang
 * @date 2023-12-05
 */
public class HqApplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long applicationId;

    /** 申请课程名 */
    @Excel(name = "申请课程名")
    private String applicationCourseName;

    /** 申请课程内容 */
    @Excel(name = "申请课程内容")
    private String applicationContent;

    /** 申请公司 */
    @Excel(name = "申请公司")
    private String applicant;

    /** 申请结果 */
    @Excel(name = "申请结果")
    private Integer result;

    /** 执行人 */
    @Excel(name = "执行人")
    private String executor;

    public void setApplicationId(Long applicationId) 
    {
        this.applicationId = applicationId;
    }

    public Long getApplicationId() 
    {
        return applicationId;
    }
    public void setApplicationCourseName(String applicationCourseName) 
    {
        this.applicationCourseName = applicationCourseName;
    }

    public String getApplicationCourseName() 
    {
        return applicationCourseName;
    }
    public void setApplicationContent(String applicationContent) 
    {
        this.applicationContent = applicationContent;
    }

    public String getApplicationContent() 
    {
        return applicationContent;
    }
    public void setApplicant(String applicant) 
    {
        this.applicant = applicant;
    }

    public String getApplicant() 
    {
        return applicant;
    }
    public void setResult(Integer result) 
    {
        this.result = result;
    }

    public Integer getResult() 
    {
        return result;
    }
    public void setExecutor(String executor) 
    {
        this.executor = executor;
    }

    public String getExecutor() 
    {
        return executor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("applicationId", getApplicationId())
            .append("applicationCourseName", getApplicationCourseName())
            .append("applicationContent", getApplicationContent())
            .append("applicant", getApplicant())
            .append("result", getResult())
            .append("executor", getExecutor())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
