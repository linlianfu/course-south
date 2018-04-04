package priv.llf.ability.course.south.service;

import org.springframework.validation.annotation.Validated;
import priv.llf.ability.course.south.arg.CourseQuery;
import priv.llf.ability.course.south.dto.CourseDto;

import java.util.List;

/**
 * @Author: eleven
 * @Since: 2018/3/18 16:31
 * @Description:
 */
@Validated
public interface ICourseService {
    /**
     * 课程分页查询
     * @param query
     * @return
     */
    List<CourseDto> listCourse(CourseQuery query);

    /**
     * 添加一门课程
     * @param dto
     * @return
     */
    int addCourse(CourseDto dto);
}
