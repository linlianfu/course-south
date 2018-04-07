package priv.llf.ability.course.south.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.llf.ability.course.south.arg.UserSelectCourseQuery;
import priv.llf.ability.course.south.dao.mybatis.UserCoursePoolDaoImpl;
import priv.llf.ability.course.south.dao.mybatis.UserCoursePoolMarkerDaoImpl;
import priv.llf.ability.course.south.dto.MarkerDto;
import priv.llf.ability.course.south.dto.UserSelectCourseDto;
import priv.llf.ability.course.south.model.mybatis.UserCoursePool;
import priv.llf.ability.course.south.model.mybatis.UserCoursePoolMarker;
import priv.llf.ability.course.south.service.IUserSelectCourseService;
import priv.llf.commons.except.BasicRuntimeException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Eleven
 * @Since: 2018/4/6 13:02
 * @Description:
 */
@Slf4j
@Service
public class UserSelectCourseServiceImpl implements IUserSelectCourseService {

    @Autowired
    UserCoursePoolDaoImpl userCoursePoolDao;

    @Autowired
    UserCoursePoolMarkerDaoImpl userCoursePoolMarkerDao;

    public static final ModelMapper mapper = new ModelMapper();


    @Override
    public void selectCourseQuery(UserSelectCourseQuery query) {
        UserCoursePool userCoursePoolModel = new UserCoursePool();
        userCoursePoolModel.setUserId(query.getUserId());
        userCoursePoolModel.setCoursePoolId("");
        userCoursePoolModel.setEntityId(query.getCourseId());
        userCoursePoolModel.setPeriod("10");
        userCoursePoolModel.setChooseTime(new Date());
        int i = userCoursePoolDao.getSqlSession().insert("userSelectCourse",userCoursePoolModel);
        if (i == 1){
            List<MarkerDto> markerDtoList = query.getMarkerDtoList();
            if (CollectionUtils.isNotEmpty(markerDtoList)){
                List<UserCoursePoolMarker> userCoursePoolMarkerList = new ArrayList<>(markerDtoList.size());
                markerDtoList.forEach(p->{
                    UserCoursePoolMarker marker = new UserCoursePoolMarker();
                    marker.setUserCourseKey(p.getKey());
                    marker.setUserCourseValue(p.getValue());
                    marker.setUserCoursePoolId(userCoursePoolModel.getId());
                    userCoursePoolMarkerList.add(marker);
                });
                int result = userCoursePoolDao.getSqlSession().insert("insertUserSelectCourseMarkerBatch",userCoursePoolMarkerList);
            }
        }
    }


    @Override
    public List<UserSelectCourseDto> listUserSelectCourse() {

        List<UserCoursePool> userCoursePoolList = userCoursePoolDao.getSqlSession().selectList("listUserSelectCourse");
        if (CollectionUtils.isNotEmpty(userCoursePoolList))
            throw new BasicRuntimeException("111");


        if (CollectionUtils.isNotEmpty(userCoursePoolList)){
            List<UserSelectCourseDto> resultList = new ArrayList<>();
            userCoursePoolList.forEach(p->{
                UserSelectCourseDto  userSelectCourseDto = mapper.map(p,UserSelectCourseDto.class);
                List<UserCoursePoolMarker> markerModelList = p.getUserCoursePoolMarkerList();
                if (CollectionUtils.isNotEmpty(markerModelList)){
                    List<MarkerDto> resultMarkerList = new ArrayList<>(markerModelList.size());
                    markerModelList.forEach(markerModel->{
                        MarkerDto resultMarker = new MarkerDto();
                        resultMarker.setKey(markerModel.getUserCourseKey());
                        resultMarker.setValue(markerModel.getUserCourseValue());
                        resultMarkerList.add(resultMarker);
                    });
                    userSelectCourseDto.setMarkerDtoList(resultMarkerList);
                }
                resultList.add(userSelectCourseDto);
            });
            return resultList;
        }
        return null;
    }
}
