package com.bootdo.common.service.impl;

import com.bootdo.common.dao.PictureDao;
import com.bootdo.common.domain.PictureDO;
import com.bootdo.common.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pictureDao;

    @Override
    public PictureDO get(Long id) {
        return pictureDao.get(id);
    }

    @Override
    public List<PictureDO> list(Map<String, Object> map) {
        return pictureDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return pictureDao.count(map);
    }

    @Override
    public int save(PictureDO dict) {
        return pictureDao.save(dict);
    }

    @Override
    public int update(PictureDO dict) {
        return pictureDao.update(dict);
    }

    @Override
    public int remove(Long id) {
        return pictureDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return pictureDao.batchRemove(ids);
    }

    @Override

    public List<PictureDO> listType() {
        return pictureDao.listType();
    }

    @Override
    public List<PictureDO> getSexList() {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", "sex");
        return pictureDao.list(param);
    }

    @Override
    public List<PictureDO> listByType(String type) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", type);
        return pictureDao.list(param);
    }

}
