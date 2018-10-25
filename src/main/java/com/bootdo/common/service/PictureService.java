package com.bootdo.common.service;

import com.bootdo.common.domain.PictureDO;

import java.util.List;
import java.util.Map;

public interface PictureService {
	
	PictureDO get(Long id);
	
	List<PictureDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PictureDO dict);
	
	int update(PictureDO dict);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	List<PictureDO> listType();
	
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
	List<PictureDO> getSexList();

	/**
	 * 根据type获取数据
	 * @param
	 * @return
	 */
	List<PictureDO> listByType(String type);

}
