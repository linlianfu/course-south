package local.gateway.web.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.llf.ability.course.south.arg.UserSelectCourseQuery;
import priv.llf.ability.course.south.dto.UserSelectCourseDto;
import priv.llf.ability.course.south.service.IUserSelectCourseService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Eleven
 * @Since: 2018/4/6 13:03
 * @Description:
 */
@Slf4j
@Controller
@RequestMapping(value = "userSelectCourseManage")
public class UserSelectCourseManageAction {

    @Autowired
    IUserSelectCourseService userSelectCourseService;

    /**
     * 用户选课
     * @param query
     */
    @ResponseBody
    @RequestMapping("chooseCourse")
    public String chooseCourse(@RequestBody UserSelectCourseQuery query){
        userSelectCourseService.selectCourseQuery(query);
        return "选课成功";
    }
    /**
     * 查询用户已选课程
     * @param
     */
    @ResponseBody
    @RequestMapping("listUserSelectCourse")
    public List<UserSelectCourseDto> listUserSelectCourse(HttpServletRequest request){

        return  userSelectCourseService.listUserSelectCourse();
    }
}
