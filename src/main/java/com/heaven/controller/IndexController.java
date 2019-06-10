package com.heaven.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heaven.bean.Announcement;
import com.heaven.bean.Banner;
import com.heaven.bean.General;
import com.heaven.bean.extend.AnnouncementVO;
import com.heaven.service.IAnnouncementService;
import com.heaven.service.IBannerService;
import com.heaven.service.IGeneralService;

@Controller
@RequestMapping("/recruit")
public class IndexController {
	@Autowired
	private IAnnouncementService announcementService;
	@Autowired
	private IGeneralService generalService;
	@Autowired
	private IBannerService bannerSerice;
	@GetMapping("/index")
	public ModelAndView login(Map<String, Object> map) {
		List<Announcement> announcementList = announcementService.selectEight();
		List<Banner> genImgList = bannerSerice.selectByName("招聘简章");
		List<Banner> annoImgList = bannerSerice.selectByName("招聘宣传");
		PageHelper.startPage(1,8);
		List<General> generalList = generalService.selectAll();
		PageInfo<General> pageInfo = new PageInfo<>(generalList);
		List<General> list = pageInfo.getList();
		map.put("announcementList", announcementList);
		map.put("generalList", list);
		map.put("genImgList", genImgList);
		map.put("annoImgList", annoImgList);
		return new ModelAndView("reception/index", map);
	}

	@GetMapping("/indexSearch")
	public ModelAndView indexSearch(@RequestParam(value = "keyWord", defaultValue = "") String keyWord,
			Map<String, Object> map) {
		List<AnnouncementVO> announcementList = announcementService.searchByKeyWord(keyWord);
		List<General> generalList = generalService.searchByKeyWord(keyWord);
		List<Object> list = new ArrayList<>();
		list.addAll(announcementList);
		list.addAll(generalList);
		map.put("list", list);
		return new ModelAndView("reception/indexSearch", map);
	}
}
