package priv.llf.ability.course.south.service;

import priv.llf.ability.course.south.arg.CourseQuery;
import priv.llf.ability.course.south.dto.CourseDto;

import java.util.List;

/**
 * @Author: calvin
 * @Since: 2018/3/18 16:31
 * @Description:
 */
public interface ICourseService {

    List<CourseDto> listCourse(CourseQuery query);
}
