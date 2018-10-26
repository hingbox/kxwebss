package com.bootdo.common.controller;

import com.bootdo.common.config.Constant;
import com.bootdo.common.domain.PictureDO;
import com.bootdo.common.service.PictureService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.utils.StringUtils;
import com.bootdo.utils.HttpClientUtils;
import gui.ava.html.image.generator.HtmlImageGenerator;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/common/picture")
public class PictureController extends BaseController {
	//private static String tempPath = "e:/framework/webss/webss/src/main/resources/static/images/";
	private static String tempPath = "e:/OTA";
	//linux /home/software
	//private static String tempPath = "/home/software/images";
	@Autowired
	private PictureService pictureService;

	RestTemplate restTemplate = new RestTemplate();

	@GetMapping()
	@RequiresPermissions("common:picture:picture")
	String dict() {
		return "common/picture/picture";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:picture:picture")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<PictureDO> dictList = pictureService.list(query);
		int total = pictureService.count(query);
		PageUtils pageUtils = new PageUtils(dictList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("common:picture:add")
	String add() {
		return "common/picture/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:picture:edit")
	String edit(@PathVariable("id") Long id, Model model) {
		PictureDO dict = pictureService.get(id);
		model.addAttribute("picture", dict);
		return "common/picture/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:picture:add")
	public R save(PictureDO dict) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		//根据传过来的url 和关键字进行 搜索
		//得到url地址  请求
		if (StringUtils.isEmpty(dict.getUrl()) || StringUtils.isEmpty(dict.getKeyword())) {
			return R.error(1, "url与关键字不能为空");
		}
		//判断请求的url是否合法
		Pattern pattern = Pattern.compile("^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+$");
		boolean flag = pattern.matcher(dict.getUrl()).matches();
		if (flag) {
		} else {
			return R.error(1, "输入的url不合法，请从新输入");
		}

		//数据重复校验
		Map<String,Object> map = new HashMap<>();
		map.put("url",dict.getUrl());
		map.put("keyword",dict.getPicture());

		int resultCount = pictureService.count(map);
		if (resultCount>0) {
			return R.error(1, "url和关键字 重复,无法分析，请修改关键字或者url");
		}
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(dict.getUrl(), String.class);
		String body = responseEntity.getBody().toString();
		int result = body.indexOf(dict.getKeyword());
		if (result > 0) {
			dict.setPicture(dict.getKeyword()+".png");
			//截屏start==========================
			// html2image
			HtmlImageGenerator imageGenerator = new HtmlImageGenerator();

			//String url = "https://blog.csdn.net/luohaobubu/article/details/7414554";
			String url = dict.getUrl();

//        String htmlstr = "<table width='654' cellpadding='0' cellspacing='0' bordercolor='#FFFFFF'><tr><td><img       src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr><tr><td><img src='http://www.apkfather.com/yhqserver/images/mdl.jpg'/></td></tr></table>";
//        String htmlstr = "<body link=#0000cc> <div id=wrapper> <div id=head> <div class=head_wrapper> <div class=s_form> <div class=s_form_wrapper> <div id=lg> <img hidefocus=true src=//www.baidu.com/img/bd_logo1.png width=270 height=129> </div> <form id=form name=f action=//www.baidu.com/s class=fm> <input type=hidden name=bdorz_come value=1> <input type=hidden name=ie value=utf-8> <input type=hidden name=f value=8> <input type=hidden name=rsv_bp value=1> <input type=hidden name=rsv_idx value=1> <input type=hidden name=tn value=baidu><span class=\"bg s_ipt_wr\"><input id=kw name=wd class=s_ipt value maxlength=255 autocomplete=off autofocus></span><span class=\"bg s_btn_wr\"><input type=submit id=su value=百度一下 class=\"bg s_btn\"></span> </form> </div> </div> <div id=u1> <a href=http://news.baidu.com name=tj_trnews class=mnav>新闻</a> <a href=http://www.hao123.com name=tj_trhao123 class=mnav>hao123</a> <a href=http://map.baidu.com name=tj_trmap class=mnav>地图</a> <a href=http://v.baidu.com name=tj_trvideo class=mnav>视频</a> <a href=http://tieba.baidu.com name=tj_trtieba class=mnav>贴吧</a> <noscript> <a href=http://www.baidu.com/bdorz/login.gif?login&amp;tpl=mn&amp;u=http%3A%2F%2Fwww.baidu.com%2f%3fbdorz_come%3d1 name=tj_login class=lb>登录</a> </noscript> <script>document.write('<a href=\"http://www.baidu.com/bdorz/login.gif?login&tpl=mn&u='+ encodeURIComponent(window.location.href+ (window.location.search === \"\" ? \"?\" : \"&\")+ \"bdorz_come=1\")+ '\" name=\"tj_login\" class=\"lb\">登录</a>');</script> <a href=//www.baidu.com/more/ name=tj_briicon class=bri style=\"display: block;\">更多产品</a> </div> </div> </div> <div id=ftCon> <div id=ftConw> <p id=lh> <a href=http://home.baidu.com>关于百度</a> <a href=http://ir.baidu.com>About Baidu</a> </p> <p id=cp>&copy;2017&nbsp;Baidu&nbsp;<a href=http://www.baidu.com/duty/>使用百度前必读</a>&nbsp; <a href=http://jianyi.baidu.com/ class=cp-feedback>意见反馈</a>&nbsp;京ICP证030173号&nbsp; <img src=//www.baidu.com/img/gs.gif> </p> </div> </div> </div> </body>";
			String htmlstr = HttpClientUtils.doGet(url);
			int beginIndex = htmlstr.indexOf("<body");
			int endIndex = htmlstr.indexOf("</body>");
			imageGenerator.loadHtml(htmlstr.substring(beginIndex,endIndex+7));
			imageGenerator.getBufferedImage();
			imageGenerator.saveAsImage(tempPath+dict.getKeyword()+".png");
			//imageGenerator.saveAsHtmlWithMap("hello-world.html", dict.getKeyword()+".png");
			//截屏end==========================
			if (pictureService.save(dict) > 0) {
				return R.ok();
			} else {
				return R.error(1, "数据保存失败");
			}
		}
		return R.error(1,"暂无匹配数据，请重新输入");
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:picture:edit")
	public R update(PictureDO dict) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		pictureService.update(dict);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("common:picture:remove")
	public R remove(Long id) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (pictureService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:picture:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		pictureService.batchRemove(ids);
		return R.ok();
	}

	@GetMapping("/picture")
	@ResponseBody
	public List<PictureDO> listType() {
		return pictureService.listType();
	};

	// 类别已经指定增加
	@GetMapping("/add/{type}/{description}")
	@RequiresPermissions("common:picture:add")
	String addD(Model model, @PathVariable("type") String type, @PathVariable("description") String description) {
		model.addAttribute("type", type);
		model.addAttribute("description", description);
		return "common/picture/add";
	}

	@ResponseBody
	@GetMapping("/list/{keyword}")
	public List<PictureDO> listByType(@PathVariable("keyword") String type) {
		// 查询列表数据
		Map<String, Object> map = new HashMap<>(16);
		map.put("keyword", type);
		List<PictureDO> dictList = pictureService.list(map);
		return dictList;
	}
}
