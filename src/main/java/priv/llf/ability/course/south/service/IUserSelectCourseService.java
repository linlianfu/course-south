package priv.llf.ability.course.south.service;

import org.springframework.validation.annotation.Validated;
import priv.llf.ability.course.south.arg.UserSelectCourseQuery;
import priv.llf.ability.course.south.dto.UserSelectCourseDto;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: Eleven
 * @Since: 2018/4/6 13:02
 * @Description:
 */
@Validated
public interface IUserSelectCourseService {

    /**
     * 用户选课
     * @param query
     */
    void selectCourseQuery(@Valid UserSelectCourseQuery query);

    /**
     * 查询用户已选课程
     * @param
     */
    List<UserSelectCourseDto> listUserSelectCourse();
}
