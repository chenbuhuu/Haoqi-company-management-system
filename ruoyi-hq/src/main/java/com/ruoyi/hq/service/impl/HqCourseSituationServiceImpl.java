package com.ruoyi.hq.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hq.mapper.HqCourseSituationMapper;
import com.ruoyi.hq.domain.HqCourseSituation;
import com.ruoyi.hq.service.IHqCourseSituationService;

/**
 * 学员上课信息管理Service业务层处理
 *
 * @author chenxinyang
 * @date 2023-11-29
 */
@Service
public class HqCourseSituationServiceImpl implements IHqCourseSituationService
{
    @Autowired
    private HqCourseSituationMapper hqCourseSituationMapper;

    /**
     * 查询学员上课信息管理
     *
     * @param id 学员上课信息管理主键
     * @return 学员上课信息管理
     */
    @Override
    public HqCourseSituation selectHqCourseSituationById(Long id)
    {
        return hqCourseSituationMapper.selectHqCourseSituationById(id);
    }

    /**
     * 查询学员上课信息管理列表
     *
     * @param hqCourseSituation 学员上课信息管理
     * @return 学员上课信息管理
     */
    @Override
    public List<HqCourseSituation> selectHqCourseSituationList(HqCourseSituation hqCourseSituation)
    {
        return hqCourseSituationMapper.selectHqCourseSituationList(hqCourseSituation);
    }

    /**
     * 新增学员上课信息管理
     *
     * @param hqCourseSituation 学员上课信息管理
     * @return 结果
     */
    @Override
    public int insertHqCourseSituation(HqCourseSituation hqCourseSituation)
    {
        hqCourseSituation.setCreateTime(DateUtils.getNowDate());
        return hqCourseSituationMapper.insertHqCourseSituation(hqCourseSituation);
    }

    /**
     * 修改学员上课信息管理
     *
     * @param hqCourseSituation 学员上课信息管理
     * @return 结果
     */
    @Override
    public int updateHqCourseSituation(HqCourseSituation hqCourseSituation)
    {
        hqCourseSituation.setUpdateTime(DateUtils.getNowDate());
        return hqCourseSituationMapper.updateHqCourseSituation(hqCourseSituation);
    }

    @Override
    public int pay(HqCourseSituation hqCourseSituation) {
        hqCourseSituation.setUpdateTime(DateUtils.getNowDate());
        return hqCourseSituationMapper.pay(hqCourseSituation);
    }

    @Override
    public int sign(HqCourseSituation hqCourseSituation) {
        hqCourseSituation.setUpdateTime(DateUtils.getNowDate());
        return hqCourseSituationMapper.sign(hqCourseSituation);
    }

    @Override
    public int evaluate(HqCourseSituation hqCourseSituation) {
        hqCourseSituation.setUpdateTime(DateUtils.getNowDate());
        return hqCourseSituationMapper.evaluate(hqCourseSituation);
    }

    /**
     * 批量删除学员上课信息管理
     *
     * @param ids 需要删除的学员上课信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHqCourseSituationByIds(Long[] ids)
    {
        return hqCourseSituationMapper.deleteHqCourseSituationByIds(ids);
    }

    /**
     * 删除学员上课信息管理信息
     *
     * @param id 学员上课信息管理主键
     * @return 结果
     */
    @Override
    public int deleteHqCourseSituationById(Long id)
    {
        return hqCourseSituationMapper.deleteHqCourseSituationById(id);
    }
}
