package priv.llf.ability.course.south.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.llf.ability.course.south.dao.mybatis.UnitExtDaoImpl;
import priv.llf.ability.course.south.dto.UnitExtDto;
import priv.llf.ability.course.south.model.mybatis.UnitExt;
import priv.llf.ability.course.south.service.IUnitManagerService;

/**
 * @Author: Eleven
 * @Since: 2018/4/7 23:35
 * @Description:
 */
@Service("unitManagerService")
public class IUnitManagerServiceImpl implements IUnitManagerService {

    @Autowired
    UnitExtDaoImpl unitExtDao;

    public static  final  ModelMapper map = new ModelMapper();

    @Override
    public void addUnitExt(UnitExtDto ext) {

        UnitExt extModel = map.map(ext,UnitExt.class);
        unitExtDao.getSqlSession().insert("insertUnitExt",extModel);
    }
}
