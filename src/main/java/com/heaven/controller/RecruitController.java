package com.heaven.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heaven.bean.Announcement;
import com.heaven.bean.General;
import com.heaven.service.IAnnouncementService;
import com.heaven.service.IGeneralService;

@RestController
@RequestMapping("/recruit")
public class RecruitController {

	@Autowired
	private IAnnouncementService announcementService;
	@Autowired
	private IGeneralService generalService;

	@GetMapping("/more")
	public ModelAndView more(@RequestParam(value = "page", defaultValue = "1") Integer page, HttpServletRequest request,
			Map<String, Object> map) {
		PageHelper.startPage(page, 10);
		String recruitName = request.getParameter("recruitName");
		String recruId = request.getParameter("recruidId");
		List<Announcement> announcementList = announcementService.findByRecruId(Integer.parseInt(recruId));
		PageInfo<Announcement> pageInfo = new PageInfo<>(announcementList);
		List<Announcement> pageList = pageInfo.getList();
		map.put("announcementList", pageList);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		map.put("recruId", recruId);
		map.put("recruitName", recruitName);
		return new ModelAndView("reception/recruit_more", map);
	}

	@GetMapping("/recruitDetails")
	public ModelAndView recruitDetails(HttpServletRequest request, Map<String, Object> map) {
		String id = request.getParameter("id");
		String recruitName = request.getParameter("recruitName");
		Announcement announcement = announcementService.findById(Integer.parseInt(id));
		map.put("announcement", announcement);
		map.put("recruitName", recruitName);
		return new ModelAndView("reception/recruit_detail", map);
	}

	@GetMapping("/generalMore")
	public ModelAndView generalMore(@RequestParam(value = "page", defaultValue = "1") Integer page,
			Map<String, Object> map) {
		PageHelper.startPage(page, 10);
		List<General> generalList = generalService.selectAll();
		PageInfo<General> pageInfo = new PageInfo<>(generalList);
		List<General> list = pageInfo.getList();
		map.put("generalList", list);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		return new ModelAndView("reception/general_more", map);
	}

	@GetMapping("/generalDetails")
	public ModelAndView generalDetails(Integer id, Map<String, Object> map) {
		General general = generalService.selectById(id);
		map.put("general", general);
		return new ModelAndView("reception/general_detail", map);
	}
	@GetMapping("/showInfo")
	public ModelAndView showInfo(Map<String,Object> map){
		return new ModelAndView("reception/myinfo",map);
	}
}