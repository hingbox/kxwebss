package com.bootdo.common.service.impl;

import com.bootdo.common.dao.KeywordDao;
import com.bootdo.common.domain.KeywordDO;
import com.bootdo.common.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class KeywordServiceImpl implements KeywordService {
    @Autowired
    private KeywordDao keywordDao;

    @Override
    public KeywordDO get(Long id) {
        return keywordDao.get(id);
    }

    @Override
    public List<KeywordDO> list(Map<String, Object> map) {
        return keywordDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return keywordDao.count(map);
    }

    @Override
    public int save(KeywordDO dict) {
        return keywordDao.save(dict);
    }

    @Override
    public int update(KeywordDO dict) {
        return keywordDao.update(dict);
    }

    @Override
    public int remove(Long id) {
        return keywordDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return keywordDao.batchRemove(ids);
    }

    @Override

    public List<KeywordDO> listType() {
        return keywordDao.listType();
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
    public List<KeywordDO> getSexList() {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", "sex");
        return keywordDao.list(param);
    }

    @Override
    public List<KeywordDO> listByType(String type) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", type);
        return keywordDao.list(param);
    }

}
