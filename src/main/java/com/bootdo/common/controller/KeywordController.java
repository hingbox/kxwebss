package com.bootdo.common.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.domain.KeywordDO;
import com.bootdo.common.service.KeywordService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/common/keyword")
public class KeywordController extends BaseController {
	@Autowired
	private KeywordService keywordService;

	@GetMapping()
	@RequiresPermissions("common:keyword:keyword")
	String dict() {
		return "common/keyword/keyword";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:keyword:keyword")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<KeywordDO> dictList = keywordService.list(query);
		int total = keywordService.count(query);
		PageUtils pageUtils = new PageUtils(dictList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("common:keyword:add")
	String add() {
		return "common/keyword/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:keyword:edit")
	String edit(@PathVariable("id") Long id, Model model) {
		KeywordDO dict = keywordService.get(id);
		model.addAttribute("keyword", dict);
		return "common/keyword/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:keyword:add")
	public R save(KeywordDO dict) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		//去重校验
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("keyword",dict.getKeyword());
		int resultCount = keywordService.count(map);
		if (resultCount>0){
			return R.error(1, "数据重复，无法重复添加!");
		}
		if (keywordService.save(dict) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:keyword:edit")
	public R update(KeywordDO dict) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		keywordService.update(dict);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("common:keyword:remove")
	public R remove(Long id) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (keywordService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:keyword:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		keywordService.batchRemove(ids);
		return R.ok();
	}

	@GetMapping("/keyword")
	@ResponseBody
	public List<KeywordDO> listType() {
		return keywordService.listType();
	};

	// 类别已经指定增加
	@GetMapping("/add/{type}/{description}")
	@RequiresPermissions("common:keyword:add")
	String addD(Model model, @PathVariable("type") String type, @PathVariable("description") String description) {
		model.addAttribute("type", type);
		model.addAttribute("description", description);
		return "common/keyword/add";
	}

	@ResponseBody
	@GetMapping("/list/{keyword}")
	public List<KeywordDO> listByType(@PathVariable("keyword") String keyword) {
		// 查询列表数据
		Map<String, Object> map = new HashMap<>(16);
		map.put("keyword", keyword);
		List<KeywordDO> dictList = keywordService.list(map);
		return dictList;
	}
}
