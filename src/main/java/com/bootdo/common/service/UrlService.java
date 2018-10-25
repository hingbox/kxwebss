package com.bootdo.common.service;

import com.bootdo.common.domain.UrlDO;

import java.util.List;
import java.util.Map;
public interface UrlService {
	
	UrlDO get(Long id);
	
	List<UrlDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UrlDO dict);
	
	int update(UrlDO dict);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<UrlDO> listType();
	
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
	List<UrlDO> getSexList();

	/**
	 * 根据type获取数据
	 * @param
	 * @return
	 */
	List<UrlDO> listByType(String type);

}
