package local.service.dto;

import lombok.Data;
import priv.llf.ability.course.south.dto.UserSelectCourseDto;

/**
 * @author: eleven
 * @since: 2018/4/12 22:18
 * @description:
 */
@Data
public class UserCourseDto extends UserSelectCourseDto {
    /**
     * 课程名字
     */
    private String coursenName;
}
