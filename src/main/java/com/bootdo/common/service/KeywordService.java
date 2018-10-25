package com.bootdo.common.service;

import com.bootdo.common.domain.KeywordDO;

import java.util.List;
import java.util.Map;

public interface KeywordService {
	
	KeywordDO get(Long id);
	
	List<KeywordDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(KeywordDO dict);
	
	int update(KeywordDO dict);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<KeywordDO> listType();
	
//	String getName(String type, String value);

//	/**
//	 * 获取爱好列表
//	 * @return
//     * @param userDO
//	 */
//	List<UrlDO> getHobbyList(UserDO userDO);

	/**
	 * 获取性别列表
 	 * @return
	 */
	List<KeywordDO> getSexList();

	/**
	 * 根据type获取数据
	 * @param
	 * @return
	 */
	List<KeywordDO> listByType(String type);

}
