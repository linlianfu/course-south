package priv.llf.ability.course.south.model.mybatis;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: eleven
 * @Since: 2018/3/18 11:52
 * @Description:
 */
@Data
@Alias("course")
@Table(name = "cre_course")
public class  Course {
    /**
     * 课程id
     */
    @Column(name = "CSE_ID")
    private String id;
    /**
     * 课程名字
     */
    @Column(name = "CSE_NAME")
    private String name;
    /**
     * 学时
     */
    @Column(name = "CSE_PERIOD")
    private BigDecimal period;
    /**
     * 简介
     */
    @Column(name = "CSE_ABOUTS")
    private String abouts;
    /**
     * 是否删除
     */
    @Column(name = "CSE_IS_DELETE")
    private boolean isDelete;
    /**
     * 是否启用
     */
    @Column(name = "CSE_IS_ENABLED")
    private boolean isEnable;
    /**
     * 图片路径
     */
    @Column(name = "CSE_ICON_PATH")
    private String path;

    private List<CourseMarker> markerList;
}
