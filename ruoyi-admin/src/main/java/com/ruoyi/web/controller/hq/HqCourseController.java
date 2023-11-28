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
import com.ruoyi.hq.domain.HqCourse;
import com.ruoyi.hq.service.IHqCourseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 课程计划管理Controller
 *
 * @author chenxinyang
 * @date 2023-11-28
 */
@RestController
@RequestMapping("/course/course")
public class HqCourseController extends BaseController
{
    @Autowired
    private IHqCourseService hqCourseService;

    /**
     * 查询课程计划管理列表
     */
    @PreAuthorize("@ss.hasPermi('course:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(HqCourse hqCourse)
    {
        startPage();
        List<HqCourse> list = hqCourseService.selectHqCourseList(hqCourse);
        return getDataTable(list);
    }

    /**
     * 导出课程计划管理列表
     */
    @PreAuthorize("@ss.hasPermi('course:course:export')")
    @Log(title = "课程计划管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HqCourse hqCourse)
    {
        List<HqCourse> list = hqCourseService.selectHqCourseList(hqCourse);
        ExcelUtil<HqCourse> util = new ExcelUtil<HqCourse>(HqCourse.class);
        util.exportExcel(response, list, "课程计划管理数据");
    }

    /**
     * 获取课程计划管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('course:course:query')")
    @GetMapping(value = "/{courseId}")
    public AjaxResult getInfo(@PathVariable("courseId") Long courseId)
    {
        return success(hqCourseService.selectHqCourseByCourseId(courseId));
    }

    /**
     * 新增课程计划管理
     */
    @PreAuthorize("@ss.hasPermi('course:course:add')")
    @Log(title = "课程计划管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HqCourse hqCourse)
    {
        return toAjax(hqCourseService.insertHqCourse(hqCourse));
    }

    /**
     * 修改课程计划管理
     */
    @PreAuthorize("@ss.hasPermi('course:course:edit')")
    @Log(title = "课程计划管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HqCourse hqCourse)
    {
        return toAjax(hqCourseService.updateHqCourse(hqCourse));
    }

    /**
     * 删除课程计划管理
     */
    @PreAuthorize("@ss.hasPermi('course:course:remove')")
    @Log(title = "课程计划管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{courseIds}")
    public AjaxResult remove(@PathVariable Long[] courseIds)
    {
        return toAjax(hqCourseService.deleteHqCourseByCourseIds(courseIds));
    }
}
