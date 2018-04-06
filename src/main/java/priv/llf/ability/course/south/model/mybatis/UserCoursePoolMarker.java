package priv.llf.ability.course.south.model.mybatis;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author: Eleven
 * @Since: 2018/4/4 20:51
 * @Description:
 */
@Data
@Table(name = "crp_user_courses_pool_marker")
public class UserCoursePoolMarker {
    /**
     * 特征标记编号
     */
    @Column(name = "CUM_ID")
    private String id;
    /**
     * 个人课程池编号
     */
    @Column(name = "CUM_CUP_ID")
    private String userCoursePoolId;
    /**
     * 特征标记键
     */
    @Column(name = "CUM_KEY")
    private String userCourseKey;
    /**
     * 特征标记值
     */
    @Column(name = "CUM_VALUE")
    private String userCourseValue;
}
