package com.bootdo.common.dao;

import com.bootdo.common.domain.PictureDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface PictureDao {

	PictureDO get(Long id);

	List<PictureDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(PictureDO dict);

	int update(PictureDO dict);

	int remove(Long id);

	int batchRemove(Long[] ids);

	List<PictureDO> listType();
}
