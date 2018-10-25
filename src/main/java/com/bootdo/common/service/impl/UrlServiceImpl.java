package com.bootdo.common.service.impl;

import com.bootdo.common.dao.UrlDao;
import com.bootdo.common.domain.UrlDO;
import com.bootdo.common.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
    private UrlDao urlDao;

    @Override
    public UrlDO get(Long id) {
        return urlDao.get(id);
    }

    @Override
    public List<UrlDO> list(Map<String, Object> map) {
        return urlDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return urlDao.count(map);
    }

    @Override
    public int save(UrlDO dict) {
        return urlDao.save(dict);
    }

    @Override
    public int update(UrlDO dict) {
        return urlDao.update(dict);
    }

    @Override
    public int remove(Long id) {
        return urlDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return urlDao.batchRemove(ids);
    }

    @Override

    public List<UrlDO> listType() {
        return urlDao.listType();
    }

//    @Override
//    public String getName(String type, String value) {
//        Map<String, Object> param = new HashMap<String, Object>(16);
//        param.put("type", type);
//        param.put("value", value);
//        String rString = urlDao.list(param).get(0).getName();
//        return rString;
//    }

//    @Override
//    public List<UrlDO> getHobbyList(UserDO userDO) {
//        Map<String, Object> param = new HashMap<>(16);
//        param.put("type", "hobby");
//        List<UrlDO> hobbyList = urlDao.list(param);
//
//        if (StringUtils.isNotEmpty(userDO.getHobby())) {
//            String userHobbys[] = userDO.getHobby().split(";");
//            for (String userHobby : userHobbys) {
//                for (UrlDO hobby : hobbyList) {
//                    if (!Objects.equals(userHobby, hobby.getId().toString())) {
//                        continue;
//                    }
//                    hobby.setRemarks("true");
//                    break;
//                }
//            }
//        }
//
//        return hobbyList;
//    }

    @Override
    public List<UrlDO> getSexList() {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", "sex");
        return urlDao.list(param);
    }

    @Override
    public List<UrlDO> listByType(String type) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", type);
        return urlDao.list(param);
    }

}
