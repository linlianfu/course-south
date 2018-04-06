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
     * 课程分页查询（mybatis返回map数据，外围自己映射）
     * @param query
     * @return
     */
    List<CourseDto> listCourse(CourseQuery query);

    /**
     * 课程分页查询（查询另取别名-自动映射）
     * @param query
     * @return
     */
    List<CourseDto> listCourseByQuery(CourseQuery query);
    /**
     * 课程详情(mybatis一对多查询，采用mybatis内置映射框架)
     * @param query
     * @return
     */
    List<CourseDto> listCourseDetail(CourseQuery query);

    /**
     * 添加一门课程
     * @param dto
     * @return
     */
    int addCourse(CourseDto dto);
}
