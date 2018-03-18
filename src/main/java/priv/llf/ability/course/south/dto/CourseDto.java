package priv.llf.ability.course.south.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: calvin
 * @Since: 2018/3/18 16:33
 * @Description:
 */
@Data
public class CourseDto implements Serializable{
    /**
     * id
     */
    private String id;
    /**
     * 课程名字
     */
    private String name;

}
