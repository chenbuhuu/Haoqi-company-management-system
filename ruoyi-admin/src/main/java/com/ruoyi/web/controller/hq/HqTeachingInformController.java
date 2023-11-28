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
import com.ruoyi.hq.domain.HqTeachingInform;
import com.ruoyi.hq.service.IHqTeachingInformService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 讲师代课信息管理Controller
 *
 * @author chenxinyang
 * @date 2023-11-28
 */
@RestController
@RequestMapping("/teaching/teaching")
public class HqTeachingInformController extends BaseController
{
    @Autowired
    private IHqTeachingInformService hqTeachingInformService;

    /**
     * 查询讲师代课信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('teaching:teaching:list')")
    @GetMapping("/list")
    public TableDataInfo list(HqTeachingInform hqTeachingInform)
    {
        startPage();
        List<HqTeachingInform> list = hqTeachingInformService.selectHqTeachingInformList(hqTeachingInform);
        return getDataTable(list);
    }

    /**
     * 导出讲师代课信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('teaching:teaching:export')")
    @Log(title = "讲师代课信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HqTeachingInform hqTeachingInform)
    {
        List<HqTeachingInform> list = hqTeachingInformService.selectHqTeachingInformList(hqTeachingInform);
        ExcelUtil<HqTeachingInform> util = new ExcelUtil<HqTeachingInform>(HqTeachingInform.class);
        util.exportExcel(response, list, "讲师代课信息管理数据");
    }

    /**
     * 获取讲师代课信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('teaching:teaching:query')")
    @GetMapping(value = "/{tiCourseId}")
    public AjaxResult getInfo(@PathVariable("tiCourseId") Long tiCourseId)
    {
        return success(hqTeachingInformService.selectHqTeachingInformByTiCourseId(tiCourseId));
    }

    /**
     * 新增讲师代课信息管理
     */
    @PreAuthorize("@ss.hasPermi('teaching:teaching:add')")
    @Log(title = "讲师代课信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HqTeachingInform hqTeachingInform)
    {
        return toAjax(hqTeachingInformService.insertHqTeachingInform(hqTeachingInform));
    }

    /**
     * 修改讲师代课信息管理
     */
    @PreAuthorize("@ss.hasPermi('teaching:teaching:edit')")
    @Log(title = "讲师代课信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HqTeachingInform hqTeachingInform)
    {
        return toAjax(hqTeachingInformService.updateHqTeachingInform(hqTeachingInform));
    }

    /**
     * 删除讲师代课信息管理
     */
    @PreAuthorize("@ss.hasPermi('teaching:teaching:remove')")
    @Log(title = "讲师代课信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tiCourseIds}")
    public AjaxResult remove(@PathVariable Long[] tiCourseIds)
    {
        return toAjax(hqTeachingInformService.deleteHqTeachingInformByTiCourseIds(tiCourseIds));
    }
}
