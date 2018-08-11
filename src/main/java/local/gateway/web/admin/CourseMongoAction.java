package local.gateway.web.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.llf.ability.course.south.dao.mongo.CourseMongoDao;
import priv.llf.ability.course.south.model.mongo.CourseMongo;

/**
 * @author: eleven
 * @date: 2018/8/11 14:17
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("courseMongo")
public class CourseMongoAction {

    @Autowired
    CourseMongoDao dao;

    @GetMapping("saveCourseToMongo")
    public void saveCourseToMongo(){
        CourseMongo courseMongo = new CourseMongo();
        courseMongo.setName("111111");
        dao.save(courseMongo);

    }
}
