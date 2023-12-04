package com.ruoyi.web.controller.hq;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.hq.domain.HqStudent;
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
import com.ruoyi.hq.domain.HqTeacher;
import com.ruoyi.hq.service.IHqTeacherService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 讲师信息管理Controller
 *
 * @author chenxinyang
 * @date 2023-11-27
 */
@RestController
@RequestMapping("/teacher/teacher")
public class HqTeacherController extends BaseController
{
    @Autowired
    private IHqTeacherService hqTeacherService;

    /**
     * 查询讲师信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('teacher:teacher:list')")
    @GetMapping("/list")
    public TableDataInfo list(HqTeacher hqTeacher)
    {
        startPage();
        List<HqTeacher> list = hqTeacherService.selectHqTeacherList(hqTeacher);
        return getDataTable(list);
    }

    /**
     * 导出讲师信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('teacher:teacher:export')")
    @Log(title = "讲师信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HqTeacher hqTeacher)
    {
        List<HqTeacher> list = hqTeacherService.selectHqTeacherList(hqTeacher);
        ExcelUtil<HqTeacher> util = new ExcelUtil<HqTeacher>(HqTeacher.class);
        util.exportExcel(response, list, "讲师信息管理数据");
    }

    /**
     * 获取讲师信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('teacher:teacher:query')")
    @GetMapping(value = "/{teacherId}")
    public AjaxResult getInfo(@PathVariable("teacherId") Long teacherId)
    {
        return success(hqTeacherService.selectHqTeacherByTeacherId(teacherId));
    }

    /**
     * 新增讲师信息管理
     */
    @PreAuthorize("@ss.hasPermi('teacher:teacher:add')")
    @Log(title = "讲师信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HqTeacher hqTeacher)
    {
        return toAjax(hqTeacherService.insertHqTeacher(hqTeacher));
    }

    /**
     * 修改讲师信息管理
     */
    @PreAuthorize("@ss.hasPermi('teacher:teacher:edit')")
    @Log(title = "讲师信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HqTeacher hqTeacher)
    {
        return toAjax(hqTeacherService.updateHqTeacher(hqTeacher));
    }

    /**
     * 删除讲师信息管理
     */
    @PreAuthorize("@ss.hasPermi('teacher:teacher:remove')")
    @Log(title = "讲师信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{teacherIds}")
    public AjaxResult remove(@PathVariable Long[] teacherIds)
    {
        return toAjax(hqTeacherService.deleteHqTeacherByTeacherIds(teacherIds));
    }

    @PreAuthorize("@ss.hasPermi('student:student:import')")
    @Log(title = "学员信息管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<HqTeacher> util = new ExcelUtil<HqTeacher>(HqTeacher.class);
        List<HqTeacher> userList = util.importExcel(file.getInputStream());
        LoginUser loginUser = getLoginUser();
        String operName = loginUser.getUsername();
        String message = hqTeacherService.importTeacher(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @PostMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<HqTeacher> util = new ExcelUtil<HqTeacher>(HqTeacher.class);
        return util.importTemplateExcel("用户数据");
    }

}
