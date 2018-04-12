package priv.llf.ability.course.south.service;

import priv.llf.ability.course.south.dto.UnitExtDto;

import java.util.List;

/**
 * @author: eleven
 * @since: 2018/4/7 23:35
 * @Description:
 */
public interface IUnitManagerService {

    void addUnitExt(UnitExtDto ext);

    List<UnitExtDto> listUnitExt();
}
