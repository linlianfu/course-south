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
@Table(name = "crp_courses_pool")
public class CoursePool {
    /**
     * 课程池id
     */
    @Column(name = "CCP_ID")
    private String id;
    /**
     * 名称
     */
    @Column(name = "CCP_POOL_NAME")
    private String coursePoolName;
    /**
     * 课程池状态|0/1/2，正常/无效/过期
     */
    @Column(name = "CCP_STATE")
    private String state;
    /**
     * 创建人
     */
    @Column(name = "CCP_CREATE_USER_ID")
    private String createUserId;
    /**
     * 描述
     */
    @Column(name = "CCP_POOL_DESCRIPTION")
    private String description;
}
