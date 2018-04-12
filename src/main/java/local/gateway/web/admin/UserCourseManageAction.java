package local.gateway.web.admin;

import local.service.IUserCourseService;
import local.service.dto.UserCourseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.llf.ability.course.south.arg.UserSelectCourseQuery;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: eleven
 * @since: 2018/4/6 13:03
 * @Description:
 */
@Slf4j
@Controller
@RequestMapping(value = "userSelectCourseManage")
public class UserCourseManageAction {

    @Autowired
    IUserCourseService userCourseService;

    /**
     * 用户选课
     * @param query
     */
    @ResponseBody
    @RequestMapping("chooseCourse")
    public String chooseCourse(@RequestBody UserSelectCourseQuery query){
        userCourseService.selectCourseQuery(query);
        return "选课成功";
    }
    /**
     * 查询用户已选课程
     * @param
     */
    @ResponseBody
    @RequestMapping("listUserSelectCourse")
    public List<UserCourseDto> listUserSelectCourse(HttpServletRequest request){

        return  userCourseService.listUserSelectCourse();
    }
}
