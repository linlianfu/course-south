package priv.llf.ability.course.south.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.llf.ability.course.south.arg.CourseQuery;
import priv.llf.ability.course.south.dao.mybatis.CourseDao;
import priv.llf.ability.course.south.dto.CourseDto;
import priv.llf.ability.course.south.model.mybatis.Course;
import priv.llf.ability.course.south.service.ICourseService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @Author: calvin
 * @Since: 2018/3/18 16:31
 * @Description:
 */
@Slf4j
@Service("courseService")
public class CourseServiceImpl implements ICourseService{

    @Autowired
    CourseDao courseDao;

    ModelMapper mapper = new ModelMapper();

    @Override
    public List<priv.llf.ability.course.south.dto.CourseDto> listCourse(CourseQuery query) {
        List<Course> courseList = courseDao.selectList("listCourse","id","");
        if (CollectionUtils.isEmpty(courseList)) return Collections.emptyList();
        List<priv.llf.ability.course.south.dto.CourseDto> result = new ArrayList<>();

        courseList.forEach(object->{
          priv.llf.ability.course.south.dto.CourseDto courseDto = mapper.map(object, priv.llf.ability.course.south.dto.CourseDto.class);
          result.add(courseDto);
        });

        log.info("课程服务收到课程查询请求。。。。");
        return result;
    }

    @Override
    public int addCourse(CourseDto dto) {

        Course courseModel =mapper.map(dto,Course.class);
        courseModel.setId(UUID.randomUUID().toString().replaceAll("-",""));
        int result = courseDao.getSqlSession().insert("addCourse",courseModel);
        if (result ==1)
            log.info("课程保存成功");
        else
            log.info("保存失败");
        return result;
    }
}
