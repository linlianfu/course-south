package local.service;

import local.service.dto.UserCourseDto;
import priv.llf.ability.course.south.arg.UserSelectCourseQuery;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: eleven
 * @since: 2018/4/12 22:13
 * @description:
 */
public interface IUserCourseService {

    /**
     * 用户选课
     * @param query
     */
    void selectCourseQuery(@Valid UserSelectCourseQuery query);

    /**
     * 查询用户已选课程
     * @param
     */
    List<UserCourseDto> listUserSelectCourse();
}
