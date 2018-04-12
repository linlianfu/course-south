package priv.llf.ability.course.south.model.mybatis;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author: eleven
 * @since: 2018/4/4 20:50
 * @Description:
 */
@Data
@Alias("courseMarker")
@Table(name = "cre_course_masker")
public class CourseMarker {
    /**
     * 特征标记编号
     */
    @Column(name = "CCM_ID")
    private String id;
    /**
     * 所属课程编号
     */
    @Column(name = "CCM_CSE_ID")
    private String courseId;
    /**
     * 特征标记键
     */
    @Column(name = "CCM_KEY")
    private String courseKey;
    /**
     * 特征标记值
     */
    @Column(name = "CCM_VALUE")
    private String courseValue;
}
