package priv.llf.ability.course.south.arg;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

/**
 * @author: eleven
 * @since: 2018/3/18 16:33
 * @Description:
 */
@Data
public class CourseQuery implements Serializable{
    @NotBlank(message = "课程id不能为空")
    private String courseId;

    private List<String> courseIdList;
}
