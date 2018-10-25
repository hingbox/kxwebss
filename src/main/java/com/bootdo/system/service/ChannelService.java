package com.bootdo.system.service;

import com.bootdo.system.domain.ChannelDO;

import java.util.List;
import java.util.Map;

/**
 * 渠道表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-09-10 23:35:32
 */
public interface ChannelService {
	
	ChannelDO get(Integer id);
	
	List<ChannelDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ChannelDO channelDO);
	
	int update(ChannelDO channelDO);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
