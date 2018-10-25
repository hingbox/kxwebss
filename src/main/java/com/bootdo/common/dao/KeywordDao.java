package com.bootdo.common.dao;

import com.bootdo.common.domain.KeywordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface KeywordDao {

	KeywordDO get(Long id);

	List<KeywordDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(KeywordDO dict);

	int update(KeywordDO dict);

	int remove(Long id);

	int batchRemove(Long[] ids);

	List<KeywordDO> listType();
}
