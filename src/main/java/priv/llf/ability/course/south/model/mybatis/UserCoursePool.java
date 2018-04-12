package priv.llf.ability.course.south.model.mybatis;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

/**
 * @author: eleven
 * @since: 2018/4/4 20:51
 * @Description:
 */
@Data
@Table(name = "crp_user_courses_pool")
public class UserCoursePool {
    /**
     * 个人课程池编号
     */
    @Column(name = "CUP_ID")
    private String id;
    /**
     * 用户编号
     */
    @Column(name = "CUP_USER_ID")
    private String userId;
    /**
     * 课程池编号
     */
    @Column(name = "CUP_CCP_ID")
    private String coursePoolId;
    /**
     * 元素类型|0/1，课程/课程池，用户选择的元素类型
     */
    @Column(name = "CUP_ENTITY_TYPE")
    private int type;
    /**
     * 元素编号|课程编号或课程池编号
     */
    @Column(name = "CUP_ENTITY_ID")
    private String entityId;
    /**
     * 课程状态|0/1/2，正常/冻结/过期，课程在用户个人选课池中的状态
     */
    @Column(name = "CUP_STATE")
    private int state;
    /**
     * 课程学时|用户选课时，课程的学时或课程池的总学时
     */
    @Column(name = "CUP_PERIOD")
    private String period;
    /**
     * 冻结时间|最后一次标注为被冻结状态的时间
     */
    @Column(name = "CUP_FREEZE_TIME")
    private String freezeTime;
    /**
     * 选课时间
     */
    @Column(name = "CUP_CHOOSE_TIME")
    private String chooseTime;

    private List<UserCoursePoolMarker> userCoursePoolMarkerList;
}
