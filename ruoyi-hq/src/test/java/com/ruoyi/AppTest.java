package com.ruoyi;

import com.ruoyi.hq.domain.HqCourse;
import com.ruoyi.hq.domain.HqNotice;
import com.ruoyi.hq.service.IHqCourseService;
import com.ruoyi.hq.service.IHqNoticeService;
import com.ruoyi.hq.service.impl.HqCourseServiceImpl;
import com.ruoyi.hq.service.impl.HqNoticeServiceImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class AppTest

{

private IHqCourseService hqCourseService=new HqCourseServiceImpl();

private IHqNoticeService hqnoticeService=new HqNoticeServiceImpl();

public void testSelectnotice()
{
    HqNotice hqNotice=new HqNotice();
    HqCourse hqCourse=new HqCourse();
    hqCourse.setCourseName("数据结构");
    hqNotice.setHqCourse(hqCourse);
    List<HqNotice> hqNoticeList=hqnoticeService.selectHqNoticeList(hqNotice);
    System.out.println(hqNoticeList);
}

}
