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
import com.ruoyi.hq.domain.HqNotice;
import com.ruoyi.hq.service.IHqNoticeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 培训通知信息管理Controller
 *
 * @author chenxinyang
 * @date 2023-11-28
 */
@RestController
@RequestMapping("/notice/notice")
public class HqNoticeController extends BaseController
{
    @Autowired
    private IHqNoticeService hqNoticeService;

    /**
     * 查询培训通知信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('notice:notice:list')")
    @GetMapping("/list")
    public TableDataInfo list(HqNotice hqNotice)
    {
        startPage();
        List<HqNotice> list = hqNoticeService.selectHqNoticeList(hqNotice);
        return getDataTable(list);
    }

    /**
     * 导出培训通知信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('notice:notice:export')")
    @Log(title = "培训通知信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HqNotice hqNotice)
    {
        List<HqNotice> list = hqNoticeService.selectHqNoticeList(hqNotice);
        ExcelUtil<HqNotice> util = new ExcelUtil<HqNotice>(HqNotice.class);
        util.exportExcel(response, list, "培训通知信息管理数据");
    }

    /**
     * 获取培训通知信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('notice:notice:query')")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable("noticeId") Long noticeId)
    {
        return success(hqNoticeService.selectHqNoticeByNoticeId(noticeId));
    }

    /**
     * 新增培训通知信息管理
     */
    @PreAuthorize("@ss.hasPermi('notice:notice:add')")
    @Log(title = "培训通知信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HqNotice hqNotice)
    {
        return toAjax(hqNoticeService.insertHqNotice(hqNotice));
    }

    /**
     * 修改培训通知信息管理
     */
    @PreAuthorize("@ss.hasPermi('notice:notice:edit')")
    @Log(title = "培训通知信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HqNotice hqNotice)
    {
        return toAjax(hqNoticeService.updateHqNotice(hqNotice));
    }

    /**
     * 删除培训通知信息管理
     */
    @PreAuthorize("@ss.hasPermi('notice:notice:remove')")
    @Log(title = "培训通知信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds)
    {
        return toAjax(hqNoticeService.deleteHqNoticeByNoticeIds(noticeIds));
    }
}
