package local.gateway.web.admin;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.llf.ability.course.south.dto.UnitExtDto;
import priv.llf.ability.course.south.service.IUnitManagerService;

import java.util.Date;
import java.util.List;

/**
 * @author: eleven
 * @since: 2018/4/7 23:41
 * @Description:
 */
@Slf4j
@Controller
@RequestMapping("unitManager")
public class UnitManagerAction {

    @Autowired
    IUnitManagerService unitManagerService;


    @ResponseBody
    @RequestMapping("addUnitExt")
    public void addUnitExt(){
        UnitExtDto dto = new UnitExtDto();
        dto.setAvailable(true);
        dto.setCreateDate(new Date());
        dto.setCreateId("林连福");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type","teacher");
        jsonObject.put("source","flow");
        dto.setValue(jsonObject);
        unitManagerService.addUnitExt(dto);
    }
    @ResponseBody
    @RequestMapping("listUnitExt")
    public List<UnitExtDto> listUnitExt(){
        return  unitManagerService.listUnitExt();
    }

}
