package com.bootdo.common.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.domain.UrlDO;
import com.bootdo.common.service.UrlService;
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
import java.util.regex.Pattern;

@Controller
@RequestMapping("/common/url")
public class UrlController extends BaseController {
	@Autowired
	private UrlService urlService;

	@GetMapping()
	@RequiresPermissions("common:url:url")
	String dict() {
		return "common/url/url";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:url:url")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<UrlDO> dictList = urlService.list(query);
		int total = urlService.count(query);
		PageUtils pageUtils = new PageUtils(dictList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("common:url:add")
	String add() {
		return "common/url/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:url:edit")
	String edit(@PathVariable("id") Long id, Model model) {
		UrlDO dict = urlService.get(id);
		model.addAttribute("url", dict);
		return "common/url/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:url:add")
	public R save(UrlDO dict) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		//判断请求的url是否合法
		Pattern pattern = Pattern.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");
		boolean flag = pattern.matcher(dict.getUrl()).matches();
		if (flag) {
		} else {
			return R.error(1, "输入的url不合法，请从新输入");
		}
		//数据重复校验
		Map<String, Object> map = new HashMap<>();
		map.put("url", dict.getUrl());
		int resultCount = urlService.count(map);
		if (resultCount > 0) {
			return R.error(1, "数据重复，无法重复添加");
		}
		if (urlService.save(dict) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:url:edit")
	public R update(UrlDO dict) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		urlService.update(dict);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("common:url:remove")
	public R remove(Long id) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (urlService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:url:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		urlService.batchRemove(ids);
		return R.ok();
	}

	@GetMapping("/url")
	@ResponseBody
	public List<UrlDO> listType() {
		return urlService.listType();
	};

	// 类别已经指定增加
	@GetMapping("/add/{type}/{description}")
	@RequiresPermissions("common:url:add")
	String addD(Model model, @PathVariable("type") String type, @PathVariable("description") String description) {
		model.addAttribute("type", type);
		model.addAttribute("description", description);
		return "common/url/add";
	}

	@ResponseBody
	@GetMapping("/list/{url}")
	public List<UrlDO> listByType(@PathVariable("url") String type) {
		// 查询列表数据
		Map<String, Object> map = new HashMap<>(16);
		map.put("url", type);
		List<UrlDO> dictList = urlService.list(map);
		return dictList;
	}
}
