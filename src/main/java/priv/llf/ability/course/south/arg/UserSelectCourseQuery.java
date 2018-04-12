package priv.llf.ability.course.south.arg;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import priv.llf.ability.course.south.dto.MarkerDto;

import java.io.Serializable;
import java.util.List;

/**
 * @author: eleven
 * @since: 2018/4/6 13:08
 * @Description:
 */
@Data
public class UserSelectCourseQuery implements Serializable {

    @NotBlank(message = "userId不能为空")

    private String userId;

    @NotBlank(message = "courseId不能为空")
    private String courseId;

    @NotBlank(message = "learningId不能为空")
    private String learningId;
    /**
     * 用户选课特征标记
     */
    private List<MarkerDto> markerDtoList;

}
