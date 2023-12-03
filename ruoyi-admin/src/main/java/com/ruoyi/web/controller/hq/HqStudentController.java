package com.ruoyi.web.controller.hq;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.model.LoginUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.hq.domain.HqStudent;
import com.ruoyi.hq.service.IHqStudentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 学员信息管理Controller
 *
 * @author chenxinyang
 * @date 2023-11-29
 */
@RestController
@RequestMapping("/student/student")
public class HqStudentController extends BaseController
{
    @Autowired
    private IHqStudentService hqStudentService;

    /**
     * 查询学员信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('student:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(HqStudent hqStudent)
    {
        startPage();
        List<HqStudent> list = hqStudentService.selectHqStudentList(hqStudent);
        return getDataTable(list);
    }

    /**
     * 导出学员信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('student:student:export')")
    @Log(title = "学员信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HqStudent hqStudent)
    {
        List<HqStudent> list = hqStudentService.selectHqStudentList(hqStudent);
        ExcelUtil<HqStudent> util = new ExcelUtil<HqStudent>(HqStudent.class);
        util.exportExcel(response, list, "学员信息管理数据");
    }

    /**
     * 获取学员信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('student:student:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hqStudentService.selectHqStudentById(id));
    }

    /**
     * 新增学员信息管理
     */
    @PreAuthorize("@ss.hasPermi('student:student:add')")
    @Log(title = "学员信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HqStudent hqStudent)
    {
        return toAjax(hqStudentService.insertHqStudent(hqStudent));
    }

    /**
     * 修改学员信息管理
     */
    @PreAuthorize("@ss.hasPermi('student:student:edit')")
    @Log(title = "学员信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HqStudent hqStudent)
    {
        return toAjax(hqStudentService.updateHqStudent(hqStudent));
    }

    /**
     * 删除学员信息管理
     */
    @PreAuthorize("@ss.hasPermi('student:student:remove')")
    @Log(title = "学员信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hqStudentService.deleteHqStudentByIds(ids));
    }
    @PreAuthorize("@ss.hasPermi('student:student:import')")
    @Log(title = "学员信息管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<HqStudent> util = new ExcelUtil<HqStudent>(HqStudent.class);
        List<HqStudent> userList = util.importExcel(file.getInputStream());
        LoginUser loginUser = getLoginUser();
        String operName = loginUser.getUsername();
        String message = hqStudentService.importStudent(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<HqStudent> util = new ExcelUtil<HqStudent>(HqStudent.class);
        return util.importTemplateExcel("用户数据");
    }


}
