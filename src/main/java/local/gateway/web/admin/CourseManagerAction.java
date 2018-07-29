package local.gateway.web.admin;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.llf.ability.course.south.arg.CourseQuery;
import priv.llf.ability.course.south.dto.CourseDto;
import priv.llf.ability.course.south.service.ICourseService;

import java.util.List;

/**
 * @Author: calvin
 * @Since: 2018/3/15 0:18
 * @Description:
 */
@Slf4j
@Controller
@RequestMapping(value = "courseManager")
public class CourseManagerAction {

    @Autowired
    ICourseService courseService;

    /**
     * 查询课程（类反射机制映射）
     * @return
     */
    @ResponseBody
    @RequestMapping("getCourse")
    public CourseDto getCourse(@NotBlank(message = "课程id不能为空") String courseId){
        return courseService.getCourse(courseId);
    }

    /**
     * 查询课程（类反射机制映射）
     * @return
     */
    @ResponseBody
    @RequestMapping("listCourse")
    public List<CourseDto> list(){
        log.info("获取课程详情");
        return courseService.listCourse(new CourseQuery());
    }
    /**
     * 查询课程(mybatis别名映射)
     * @return
     */
    @ResponseBody
    @RequestMapping("listCourseByQuery")
    public List<CourseDto> listByQuery(){
        log.info("通过mybatis的动态sql实现数据查询");
        return courseService.listCourseByQuery(new CourseQuery());
    }
    /**
     * 查询课程(mybatis别名映射)
     * @return
     */
    @ResponseBody
    @RequestMapping("listCourseDetail")
    public List<CourseDto> listCourseDetail(){
        log.info("通过mybatis的动态sql实现数据查询");
        return courseService.listCourseDetail(new CourseQuery());
    }

    /**
     * 添加课程
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addCourse" ,method = RequestMethod.POST)
    public int add(@RequestBody CourseDto dto){
        log.info("添加课程");
        return courseService.addCourse(dto);
    }

}
