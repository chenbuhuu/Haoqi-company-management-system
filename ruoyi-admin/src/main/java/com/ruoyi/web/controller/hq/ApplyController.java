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
import com.ruoyi.hq.domain.Apply;
import com.ruoyi.hq.service.IApplyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公司申请培训Controller
 *
 * @author chenxinyang
 * @date 2023-12-02
 */
@RestController
@RequestMapping("/apply/apply")
public class ApplyController extends BaseController
{
    @Autowired
    private IApplyService applyService;

    /**
     * 查询公司申请培训列表
     */
    @PreAuthorize("@ss.hasPermi('apply:apply:list')")
    @GetMapping("/list")
    public TableDataInfo list(Apply apply)
    {
        startPage();
        List<Apply> list = applyService.selectApplyList(apply);
        return getDataTable(list);
    }

    /**
     * 导出公司申请培训列表
     */
    @PreAuthorize("@ss.hasPermi('apply:apply:export')")
    @Log(title = "公司申请培训", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Apply apply)
    {
        List<Apply> list = applyService.selectApplyList(apply);
        ExcelUtil<Apply> util = new ExcelUtil<Apply>(Apply.class);
        util.exportExcel(response, list, "公司申请培训数据");
    }

    /**
     * 获取公司申请培训详细信息
     */
    @PreAuthorize("@ss.hasPermi('apply:apply:query')")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable("deptId") Long deptId)
    {
        return success(applyService.selectApplyByDeptId(deptId));
    }

    /**
     * 新增公司申请培训
     */
//    @PreAuthorize("@ss.hasPermi('apply:apply:add')")
//    @Log(title = "公司申请培训", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody Apply apply)
//    {
//        return toAjax(applyService.insertApply(apply));
//    }

    /**
     * 修改公司申请培训
     */
    @PreAuthorize("@ss.hasPermi('apply:apply:edit')")
    @Log(title = "公司申请培训", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Apply apply)
    {
        return toAjax(applyService.updateApply(apply));
    }

    /**
     * 删除公司申请培训
     */
    @PreAuthorize("@ss.hasPermi('apply:apply:remove')")
    @Log(title = "公司申请培训", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(applyService.deleteApplyByDeptIds(deptIds));
    }

    @PreAuthorize("@ss.hasPermi('apply:apply:add')")
    @Log(title = "公司申请培训", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult apply(@RequestBody Apply apply)
    {
        return toAjax(applyService.apply(apply));
    }
}
