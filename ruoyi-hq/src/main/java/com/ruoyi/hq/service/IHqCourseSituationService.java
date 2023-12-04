package com.ruoyi.hq.service;

import java.util.List;
import com.ruoyi.hq.domain.HqCourseSituation;

/**
 * 学员上课信息管理Service接口
 *
 * @author chenxinyang
 * @date 2023-11-29
 */
public interface IHqCourseSituationService
{
    /**
     * 查询学员上课信息管理
     *
     * @param id 学员上课信息管理主键
     * @return 学员上课信息管理
     */
    public HqCourseSituation selectHqCourseSituationById(Long id);

    /**
     * 查询学员上课信息管理列表
     *
     * @param hqCourseSituation 学员上课信息管理
     * @return 学员上课信息管理集合
     */
    public List<HqCourseSituation> selectHqCourseSituationList(HqCourseSituation hqCourseSituation);

    /**
     * 新增学员上课信息管理
     *
     * @param hqCourseSituation 学员上课信息管理
     * @return 结果
     */
    public int insertHqCourseSituation(HqCourseSituation hqCourseSituation);

    /**
     * 修改学员上课信息管理
     *
     * @param hqCourseSituation 学员上课信息管理
     * @return 结果
     */
    public int updateHqCourseSituation(HqCourseSituation hqCourseSituation);
    public int pay(HqCourseSituation hqCourseSituation);
    public int sign(HqCourseSituation hqCourseSituation);

    /**
     * 批量删除学员上课信息管理
     *
     * @param ids 需要删除的学员上课信息管理主键集合
     * @return 结果
     */
    public int deleteHqCourseSituationByIds(Long[] ids);

    /**
     * 删除学员上课信息管理信息
     *
     * @param id 学员上课信息管理主键
     * @return 结果
     */
    public int deleteHqCourseSituationById(Long id);
}
