package priv.llf.ability.course.south.model.mybatis;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Date;

/**
 * @author: eleven
 * @since: 2018/4/7 23:27
 * @Description:
 */
@Data
public class UnitExt {

    private String id;

    private String unitId;

    private String type;

    private JSONObject value;

    private Date createDate;

    private String createId;

    private boolean available;

}
