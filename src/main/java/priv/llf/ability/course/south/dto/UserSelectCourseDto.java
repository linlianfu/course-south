package priv.llf.ability.course.south.dto;

import java.util.List;

/**
 * @Author: Eleven
 * @Since: 2018/4/4 21:09
 * @Description: 用户课程池信息
 */
public class UserSelectCourseDto {
    /**
     * 个人课程池编号
     */
    private String id;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 课程池编号
     */
    private String coursePoolId;
    /**
     * 元素类型|0/1，课程/课程池，用户选择的元素类型
     */
    private String type;
    /**
     * 元素编号|课程编号或课程池编号
     */
    private String entityId;
    /**
     * 课程状态|0/1/2，正常/冻结/过期，课程在用户个人选课池中的状态
     */
    private String state;
    /**
     * 课程学时|用户选课时，课程的学时或课程池的总学时
     */
    private String period;
    /**
     * 冻结时间|最后一次标注为被冻结状态的时间
     */
    private String freezeTime;
    /**
     * 选课时间
     */
    private String chooseTime;
    /**
     * 选课特征标记
     */
    private List<MarkerDto> markerDtoList;
}
