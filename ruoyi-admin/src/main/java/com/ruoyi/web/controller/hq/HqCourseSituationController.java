package com.ruoyi.web.controller.hq;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.hq.domain.HqCourseSituation;
import com.ruoyi.hq.service.IHqCourseSituationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学员上课信息管理Controller
 *
 * @author chenxinyang
 * @date 2023-11-29
 */
@RestController
@RequestMapping("/studying/studying")
public class HqCourseSituationController extends BaseController
{
    @Autowired
    private IHqCourseSituationService hqCourseSituationService;

    /**
     * 查询学员上课信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('studying:studying:list')")
    @GetMapping("/list")
    public TableDataInfo list(HqCourseSituation hqCourseSituation)
    {
        startPage();
        List<HqCourseSituation> list = hqCourseSituationService.selectHqCourseSituationList(hqCourseSituation);
        return getDataTable(list);
    }

    /**
     * 导出学员上课信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('studying:studying:export')")
    @Log(title = "学员上课信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HqCourseSituation hqCourseSituation)
    {
        List<HqCourseSituation> list = hqCourseSituationService.selectHqCourseSituationList(hqCourseSituation);
        ExcelUtil<HqCourseSituation> util = new ExcelUtil<HqCourseSituation>(HqCourseSituation.class);
        util.exportExcel(response, list, "学员上课信息管理数据");
    }

    /**
     * 获取学员上课信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('studying:studying:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hqCourseSituationService.selectHqCourseSituationById(id));
    }

    /**
     * 新增学员上课信息管理
     */
    @PreAuthorize("@ss.hasPermi('studying:studying:add')")
    @Log(title = "学员上课信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HqCourseSituation hqCourseSituation)
    {
        return toAjax(hqCourseSituationService.insertHqCourseSituation(hqCourseSituation));
    }

    /**
     * 修改学员上课信息管理
     */
    @PreAuthorize("@ss.hasPermi('studying:studying:edit')")
    @Log(title = "学员上课信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HqCourseSituation hqCourseSituation)
    {
        return toAjax(hqCourseSituationService.updateHqCourseSituation(hqCourseSituation));
    }

    /**
     * 删除学员上课信息管理
     */
    @PreAuthorize("@ss.hasPermi('studying:studying:remove')")
    @Log(title = "学员上课信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hqCourseSituationService.deleteHqCourseSituationByIds(ids));
    }
}
