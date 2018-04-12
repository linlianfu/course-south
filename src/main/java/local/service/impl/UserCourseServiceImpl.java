package local.service.impl;

import local.service.IUserCourseService;
import local.service.dto.UserCourseDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.llf.ability.course.south.arg.CourseQuery;
import priv.llf.ability.course.south.arg.UserSelectCourseQuery;
import priv.llf.ability.course.south.dto.CourseDto;
import priv.llf.ability.course.south.dto.UserSelectCourseDto;
import priv.llf.ability.course.south.service.ICourseService;
import priv.llf.ability.course.south.service.IUserSelectCourseService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: eleven
 * @since: 2018/4/12 22:14
 * @description:
 */
@Slf4j
@Service("userCourseServiceImpl")
public class UserCourseServiceImpl implements IUserCourseService{

    @Autowired
    ICourseService courseService;

    @Autowired
    IUserSelectCourseService userSelectCourseService;

    public static final ModelMapper mapper = new ModelMapper();


    @Override
    public void selectCourseQuery(UserSelectCourseQuery query) {
        userSelectCourseService.selectCourseQuery(query);
    }

    @Override
    public List<UserCourseDto> listUserSelectCourse() {

        List<UserSelectCourseDto> userSelectCourseDtoList = userSelectCourseService.listUserSelectCourse();

        if (CollectionUtils.isEmpty(userSelectCourseDtoList))
        return Collections.emptyList();

        List<UserCourseDto> resultList = new ArrayList<>();
        //查询课程名
        List<String> courseIdList = userSelectCourseDtoList.stream().map(UserSelectCourseDto::getEntityId).collect(Collectors.toList());
        CourseQuery courseQuery = new CourseQuery();
        courseQuery.setCourseIdList(courseIdList);
        List<CourseDto> courseDtoList = courseService.listCourse(courseQuery);

        Map<String,String> courseMap = courseDtoList.stream().collect(Collectors.toMap(CourseDto::getId,CourseDto::getName));

        userSelectCourseDtoList.forEach(p->
        {
            UserCourseDto userCourseDto = mapper.map(p,UserCourseDto.class);
            if (courseMap.containsKey(p.getEntityId())){
                userCourseDto.setCoursenName(courseMap.get(p.getEntityId()));
            }
            resultList.add(userCourseDto);
        });
        return resultList;

    }
}
