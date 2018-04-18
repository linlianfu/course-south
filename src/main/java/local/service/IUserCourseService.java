package local.service;

import local.service.dto.UserCourseDto;
import org.springframework.validation.annotation.Validated;
import priv.llf.ability.course.south.arg.UserSelectCourseQuery;

import javax.validation.Valid;
import java.util.List;

/**
 * @author: eleven
 * @date: 2018/4/13 11:23
 * @description:
 */
@Validated
public interface IUserCourseService {

    void selectCourseQuery(@Valid UserSelectCourseQuery query);

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
