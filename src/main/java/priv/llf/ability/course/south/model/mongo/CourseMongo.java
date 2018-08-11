package priv.llf.ability.course.south.model.mongo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: eleven
 * @date: 2018/8/11 14:15
 * @description:
 */
@Data
public class CourseMongo implements Serializable {
    private String id;
    private String name;
}
