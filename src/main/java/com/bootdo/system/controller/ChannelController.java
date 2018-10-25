package com.bootdo.system.controller;

import com.bootdo.common.controller.BaseController;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.ChannelDO;
import com.bootdo.system.service.ChannelService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 渠道表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-09-10 23:35:32
 */
 
@Controller
@RequestMapping("/sys/channel")
public class ChannelController extends BaseController{
	private String prefix = "system/channel";
	@Autowired
	private ChannelService channelService;
	
	@GetMapping()
	@RequiresPermissions("sys:channel:channel")
	String channel(){
	    return prefix+"/channel";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sys:channel:channel")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ChannelDO> List = channelService.list(query);
		int total = channelService.count(query);
		PageUtils pageUtils = new PageUtils(List, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sys:channel:add")
	String add(){
	    return prefix+"/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sys:channel:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ChannelDO channelDO  = channelService.get(id);
		model.addAttribute("", channelDO);
	    return prefix+"/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sys:channel:add")
	public R save(ChannelDO channelDO){
		if(channelService.save(channelDO)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("sys:channel:edit")
	public R update(ChannelDO channelDO ){
		channelService.update(channelDO);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sys:channel:remove")
	public R remove( Integer id){
		if(channelService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("sys:channel:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		channelService.batchRemove(ids);
		return R.ok();
	}
	
}
