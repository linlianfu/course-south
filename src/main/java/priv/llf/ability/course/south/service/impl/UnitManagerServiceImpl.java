package priv.llf.ability.course.south.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.llf.ability.course.south.dao.mybatis.UnitExtDaoImpl;
import priv.llf.ability.course.south.dto.UnitExtDto;
import priv.llf.ability.course.south.model.mybatis.UnitExt;
import priv.llf.ability.course.south.service.IUnitManagerService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Eleven
 * @Since: 2018/4/7 23:35
 * @Description:
 */
@Service("unitManagerService")
public class UnitManagerServiceImpl implements IUnitManagerService {

    @Autowired
    UnitExtDaoImpl unitExtDao;

    public static  final  ModelMapper map = new ModelMapper();

    @Override
    public void addUnitExt(UnitExtDto ext) {

        UnitExt extModel = new UnitExt();
        BeanUtils.copyProperties(ext,extModel);
        unitExtDao.getSqlSession().insert("insertUnitExt",extModel);
    }
    @Override
    public List<UnitExtDto> listUnitExt() {

        List<UnitExt> resultList = unitExtDao.getSqlSession().selectList("listUnitExt");
        if(CollectionUtils.isNotEmpty(resultList))
        {
            List<UnitExtDto> result = new ArrayList<>(resultList.size());
            resultList.forEach(p->{
                UnitExtDto dto = new UnitExtDto();
                dto.setType(p.getType());
                dto.setValue(p.getValue());
                dto.setCreateDate(p.getCreateDate());
                dto.setId(p.getId());
                dto.setUnitId(p.getUnitId());
                dto.setCreateId(p.getCreateId());
                result.add(dto);
            });
            return result;
        }
        return null;
    }
}
