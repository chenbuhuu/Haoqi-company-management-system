package com.ruoyi.web.controller.hq;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
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
import com.ruoyi.hq.domain.SignUp;
import com.ruoyi.hq.service.ISignUpService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学员报名课程Controller
 *
 * @author chenxinyang
 * @date 2023-11-30
 */
@RestController
@RequestMapping("/signUp/signUp")
public class SignUpController extends BaseController
{
    @Autowired
    private ISignUpService signUpService;

    /**
     * 查询学员报名课程列表
     */
    @PreAuthorize("@ss.hasPermi('signUp:signUp:list')")
    @GetMapping("/list")
    public TableDataInfo list(SignUp signUp)
    {
        startPage();
        List<SignUp> list = signUpService.selectSignUpList(signUp);
        return getDataTable(list);
    }

    /**
     * 导出学员报名课程列表
     */
    @PreAuthorize("@ss.hasPermi('signUp:signUp:export')")
    @Log(title = "学员报名课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SignUp signUp)
    {
        List<SignUp> list = signUpService.selectSignUpList(signUp);
        ExcelUtil<SignUp> util = new ExcelUtil<SignUp>(SignUp.class);
        util.exportExcel(response, list, "学员报名课程数据");
    }

    /**
     * 获取学员报名课程详细信息
     */
//    @PreAuthorize("@ss.hasPermi('signUp:signUp:query')")
//    @GetMapping(value = "/{deptId}")
//    public AjaxResult getInfo(@PathVariable("deptId") Long deptId)
//    {
//        return success(signUpService.selectSignUpByDeptId(deptId));
//    }

    /**
     * 新增学员报名课程
     */
//    @PreAuthorize("@ss.hasPermi('signUp:signUp:add')")
//    @Log(title = "学员报名课程", businessType = BusinessType.INSERT)
//    @PostMapping
//    public AjaxResult add(@RequestBody SignUp signUp)
//    {
//        return toAjax(signUpService.insertSignUp(signUp));
//    }

    /**
     * 修改学员报名课程
     */
    @PreAuthorize("@ss.hasPermi('signUp:signUp:edit')")
    @Log(title = "学员报名课程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SignUp signUp)
    {
        return toAjax(signUpService.updateSignUp(signUp));
    }

    /**
     * 删除学员报名课程
     */
    @PreAuthorize("@ss.hasPermi('signUp:signUp:remove')")
    @Log(title = "学员报名课程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(signUpService.deleteSignUpByDeptIds(deptIds));
    }

    @PreAuthorize("@ss.hasPermi('signUp:signUp:query')")
    @GetMapping(value = "/{dateRange}")
    public AjaxResult searchSuitableCourse(@PathVariable String[] dateRange)
    {
        List<Date> d=new ArrayList<Date>();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            d.add(ft.parse(dateRange[0])) ;
            d.add(ft.parse(dateRange[1])) ;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return success(signUpService.searchSuitableCourse(d));
    }

    @PreAuthorize("@ss.hasPermi('signUp:signUp:add')")
    @Log(title = "学员报名课程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult signUp(@RequestBody SignUp signUp)
    {

        try {
            // 处理业务逻辑
            return toAjax(signUpService.signUp(signUp));
        } catch (Exception e) {
            // 处理其他异常
            return new AjaxResult(HttpStatus.INTERNAL_SERVER_ERROR.value(), "请勿重复报名");
        }
    }


}
