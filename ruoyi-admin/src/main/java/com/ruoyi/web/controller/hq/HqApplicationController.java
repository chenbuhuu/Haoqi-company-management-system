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
import com.ruoyi.hq.domain.HqApplication;
import com.ruoyi.hq.service.IHqApplicationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 培训申请管理Controller
 *
 * @author chenxinyang
 * @date 2023-11-28
 */
@RestController
@RequestMapping("/application/application")
public class HqApplicationController extends BaseController
{
    @Autowired
    private IHqApplicationService hqApplicationService;

    /**
     * 查询培训申请管理列表
     */
    @PreAuthorize("@ss.hasPermi('application:application:list')")
    @GetMapping("/list")
    public TableDataInfo list(HqApplication hqApplication)
    {
        startPage();
        List<HqApplication> list = hqApplicationService.selectHqApplicationList(hqApplication);
        return getDataTable(list);
    }

    /**
     * 导出培训申请管理列表
     */
    @PreAuthorize("@ss.hasPermi('application:application:export')")
    @Log(title = "培训申请管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HqApplication hqApplication)
    {
        List<HqApplication> list = hqApplicationService.selectHqApplicationList(hqApplication);
        ExcelUtil<HqApplication> util = new ExcelUtil<HqApplication>(HqApplication.class);
        util.exportExcel(response, list, "培训申请管理数据");
    }

    /**
     * 获取培训申请管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('application:application:query')")
    @GetMapping(value = "/{applicationId}")
    public AjaxResult getInfo(@PathVariable("applicationId") Long applicationId)
    {
        return success(hqApplicationService.selectHqApplicationByApplicationId(applicationId));
    }

    /**
     * 新增培训申请管理
     */
    @PreAuthorize("@ss.hasPermi('application:application:add')")
    @Log(title = "培训申请管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HqApplication hqApplication)
    {
        return toAjax(hqApplicationService.insertHqApplication(hqApplication));
    }

    /**
     * 修改培训申请管理
     */
    @PreAuthorize("@ss.hasPermi('application:application:edit')")
    @Log(title = "培训申请管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HqApplication hqApplication)
    {
        return toAjax(hqApplicationService.updateHqApplication(hqApplication));
    }

    /**
     * 删除培训申请管理
     */
    @PreAuthorize("@ss.hasPermi('application:application:remove')")
    @Log(title = "培训申请管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{applicationIds}")
    public AjaxResult remove(@PathVariable Long[] applicationIds)
    {
        return toAjax(hqApplicationService.deleteHqApplicationByApplicationIds(applicationIds));
    }
}
