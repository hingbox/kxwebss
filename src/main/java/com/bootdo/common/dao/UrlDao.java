package com.bootdo.common.dao;

import com.bootdo.common.domain.UrlDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface UrlDao {

	UrlDO get(Long id);

	List<UrlDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(UrlDO dict);

	int update(UrlDO dict);

	int remove(Long id);

	int batchRemove(Long[] ids);

	List<UrlDO> listType();
}
