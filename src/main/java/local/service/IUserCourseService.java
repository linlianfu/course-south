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

    List<UserCourseDto> listUserSelectCourse();
}
