package priv.llf.ability.course.south.model.mybatis;

import lombok.Data;

import javax.persistence.Column;

/**
 * @Author: calvin
 * @Since: 2018/3/18 11:52
 * @Description:
 */
@Data
public class Course {

    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
}
