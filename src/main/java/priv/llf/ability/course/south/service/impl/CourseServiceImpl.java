package priv.llf.ability.course.south.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.llf.ability.course.south.arg.CourseQuery;
import priv.llf.ability.course.south.dao.mybatis.CourseDaoImpl;
import priv.llf.ability.course.south.dao.mybatis.CourseMarkerDaoImpl;
import priv.llf.ability.course.south.dto.CourseDto;
import priv.llf.ability.course.south.dto.MarkerDto;
import priv.llf.ability.course.south.model.mybatis.Course;
import priv.llf.ability.course.south.model.mybatis.CourseMarker;
import priv.llf.ability.course.south.service.ICourseService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: eleven
 * @Since: 2018/3/18 16:31
 * @Description:
 */
@Slf4j
@Service("courseService")
public class CourseServiceImpl implements ICourseService{

    @Autowired
    CourseDaoImpl courseDaoImpl;

    @Autowired
    CourseMarkerDaoImpl courseMarkerDao;

    public static  final ModelMapper mapper = new ModelMapper();

    @Override
    public List<priv.llf.ability.course.south.dto.CourseDto> listCourse(CourseQuery query) {
        List<Course> courseList = courseDaoImpl.selectList("listCourse","CSE_ID","");
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

        Course courseModel = mapper.map(dto,Course.class);
        int result = courseDaoImpl.getSqlSession().insert("addCourse",courseModel);
        if (result ==1){
            log.info("课程保存成功,开始保存特征标记");
            List<MarkerDto> markerQueryList = dto.getMarkerList();
            if (CollectionUtils.isNotEmpty(markerQueryList))
            {
                List<CourseMarker> courseMarkerList = new ArrayList<>(markerQueryList.size());
                markerQueryList.forEach(p->
                {
                    CourseMarker marker = mapper.map(p,CourseMarker.class);
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
