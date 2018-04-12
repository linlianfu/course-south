package priv.llf.ability.course.south.dto;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Date;

/**
 * @author: eleven
 * @since: 2018/4/7 23:36
 * @Description:
 */
@Data
public class UnitExtDto {

    private String id;

    private String unitId;

    private String type;

    private JSONObject value;

    private Date createDate;

    private String createId;

    private boolean available;


}
