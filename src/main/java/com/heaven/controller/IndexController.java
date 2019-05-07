package com.heaven.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.heaven.bean.Announcement;
import com.heaven.bean.General;
import com.heaven.service.IAnnouncementService;
import com.heaven.service.IGeneralService;

@Controller
@RequestMapping("/recruit")
public class IndexController {
	@Autowired
	private IAnnouncementService announcementService;
	@Autowired
	private IGeneralService generalService;

	@GetMapping("/index")
	public ModelAndView login(Map<String, Object> map) {
		List<Announcement> announcementList = announcementService.selectEight();
		List<General> generalList = generalService.findAll();
		map.put("announcementList", announcementList);
		map.put("generalList", generalList);
		map.put("username", null);
		return new ModelAndView("index", map);
	}
}
