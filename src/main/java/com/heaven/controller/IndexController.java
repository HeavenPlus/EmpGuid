package com.heaven.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heaven.bean.Announcement;
import com.heaven.service.IAnnouncementService;
import com.heaven.utils.MsgResponse;

@Controller
public class IndexController {
	@Autowired
	private IAnnouncementService announcementService;
	
	@GetMapping("/index")
	public ModelAndView login(@RequestParam(value = "page", defaultValue = "1") Integer page,Map<String, Object> map){
		PageHelper.startPage(page, 8);
		List<Announcement> announcementList = announcementService.findAll();
		PageInfo<Announcement> pageInfo = new PageInfo<>(announcementList);
		List<Announcement> pageList = pageInfo.getList();
		map.put("announcementList", pageList);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		return new ModelAndView("index",map);
	}
	@RequestMapping("/test")
    public ModelAndView articlePageBean() {
        return new ModelAndView("index1");
    }
	
	@RequestMapping("/hello")
	@ResponseBody
	public ModelAndView getAll(@RequestParam(value="page",defaultValue="1") Integer page,Map<String,Object> map){
		PageHelper.startPage(page,8);
		List<Announcement> list = announcementService.findAll();
		PageInfo<Announcement> pageInfo = new PageInfo<>(list,5);
		map.put("pageInfo", pageInfo);
		return new ModelAndView("hello",map);
	}
}
