package priv.llf.ability.course.south.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: calvin
 * @Since: 2018/3/18 16:33
 * @Description: 课程信息
 */
@Data
public class CourseDto implements Serializable{
    /**
     * 课程id
     */
    private String id;
    /**
     * 课程名字
     */
    private String name;
    /**
     * 学时
     */
    private BigDecimal period;
    /**
     * 简介
     */
    private String abouts;
    /**
     * 是否删除
     */
    private boolean delete = false;
    /**
     * 是否启用
     */
    private boolean enable;
    /**
     * 图片路径
     */
    private String path;
    /**
     * 课程特征标记
     */
    private List<MarkerDto> markerList;

}
