package com.bootdo.system.service.impl;

import com.bootdo.system.dao.ChannelDao;
import com.bootdo.system.domain.ChannelDO;
import com.bootdo.system.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;



@org.springframework.stereotype.Service
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	private ChannelDao channelDao;
	
	@Override
	public ChannelDO get(Integer id){
		return channelDao.get(id);
	}
	
	@Override
	public List<ChannelDO> list(Map<String, Object> map){
		return channelDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return channelDao.count(map);
	}
	
	@Override
	public int save(ChannelDO channelDO){
		return channelDao.save(channelDO);
	}
	
	@Override
	public int update(ChannelDO channelDO){
		return channelDao.update(channelDO);
	}
	
	@Override
	public int remove(Integer id){
		return channelDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return channelDao.batchRemove(ids);
	}
	
}
