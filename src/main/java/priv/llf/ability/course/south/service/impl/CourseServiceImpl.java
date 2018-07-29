package priv.llf.ability.course.south.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import priv.llf.ability.course.south.arg.CourseQuery;
import priv.llf.ability.course.south.dao.mybatis.CourseDaoImpl;
import priv.llf.ability.course.south.dao.mybatis.CourseMarkerDaoImpl;
import priv.llf.ability.course.south.dto.CourseDto;
import priv.llf.ability.course.south.dto.MarkerDto;
import priv.llf.ability.course.south.model.mybatis.Course;
import priv.llf.ability.course.south.model.mybatis.CourseMarker;
import priv.llf.ability.course.south.service.ICourseService;
import priv.llf.ability.course.south.utils.ILogService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: eleven
 * @since: 2018/3/18 16:31
 * @Description:
 */
@Slf4j
@Service("courseService")
public class CourseServiceImpl implements ICourseService{

    @Autowired
    ILogService logService;

    @Autowired
    CourseDaoImpl courseDao;

    @Autowired
    CourseMarkerDaoImpl courseMarkerDao;

    public static  final ModelMapper mapper = new ModelMapper();

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public CourseDto getCourse(String courseId) {
        log.info("测试mybatis默认开启的二级缓存");
        Course course = courseDao.getSqlSession().selectOne("listCourseByAutoMapping", courseId);
        log.info("第一次查询结果：{}",course.toString());
        Course course1 = courseDao.getSqlSession().selectOne("listCourseByAutoMapping", courseId);
        log.info("第二次执行查询完毕:{}",course1.toString());
        CourseDto courseDto = mapper.map(course, CourseDto.class);

        return courseDto;
    }

    @Override
    public List<CourseDto> listCourse(CourseQuery query) {
        query.setCourseId("890b4dc64d2011e8b509a81e84e02b6e");
        List<Course> courseList = courseDao.selectList("listCourseToMap","CSE_ID",query);
        if (CollectionUtils.isEmpty(courseList)) return Collections.emptyList();
        List<CourseDto> result = new ArrayList<>();

        courseList.forEach(object->{
         CourseDto courseDto = mapper.map(object, CourseDto.class);
          result.add(courseDto);
        });

        log.info("课程服务收到课程查询请求。。。。");
        return result;
    }

    @Override
    public List<CourseDto> listCourseByQuery(CourseQuery query) {

        List<Course> courseList = courseDao.getSqlSession().selectList("listCourseByQuery");
        if (CollectionUtils.isEmpty(courseList)) return Collections.emptyList();
        List<CourseDto> result;
        result = mapper.map(courseList,new TypeToken<List<CourseDto>>(){}.getType());
        return result;
    }

    @Override
    public List<CourseDto> listCourseDetail(CourseQuery query) {

        List<Course> courseList =  courseDao.getSqlSession().selectList("listCourseDetail");
        if (CollectionUtils.isEmpty(courseList)) return Collections.emptyList();
        List<CourseDto> result;
        result = mapper.map(courseList,new TypeToken<List<CourseDto>>(){}.getType());
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addCourse(CourseDto dto) {
        Course courseModel = mapper.map(dto,Course.class);
        int result = courseDao.getSqlSession().insert("addCourse",courseModel);
        if (result ==1){
            log.info("课程保存成功,开始保存特征标记");
            List<MarkerDto> markerQueryList = dto.getMarkerList();
            if (CollectionUtils.isNotEmpty(markerQueryList))
            {
                List<CourseMarker> courseMarkerList = new ArrayList<>(markerQueryList.size());
                markerQueryList.forEach(p->
                {
                    CourseMarker marker = new CourseMarker();
                    marker.setCourseKey(p.getKey());
                    marker.setCourseValue(p.getValue());
                    marker.setCourseId(courseModel.getId());
                    courseMarkerList.add(marker);
                });
                //批量插入数据
                courseMarkerDao.getSqlSession().insert("addCourseMarkerBatch",courseMarkerList);
            }
        }
        else
            log.info("保存失败");
        return result;
    }
}
