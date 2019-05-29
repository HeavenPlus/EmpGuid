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
import com.heaven.bean.GuidInfo;
import com.heaven.bean.extend.GuidInfoVO;
import com.heaven.service.IGuidInfoService;

@RestController
@RequestMapping("/guidInfo")
public class GuidInfoController {

	@Autowired
	private IGuidInfoService guidInfoService;
	
	@GetMapping("/guidInfo")
	public ModelAndView guidInfo(@RequestParam(value = "page",defaultValue="1" ) Integer page,HttpServletRequest request,Map<String, Object> map){
		String typeId = request.getParameter("typeId");
		String guidName = request.getParameter("guidName");
		PageHelper.startPage(page,10);
		List<GuidInfo> guidInfoList = guidInfoService.selectByTypeId(Integer.parseInt(typeId));
		PageInfo<GuidInfo> pageInfo = new PageInfo<>(guidInfoList);
		List<GuidInfo> list = pageInfo.getList();
		map.put("guidInfoList", list);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		map.put("guidName", guidName);
		return new ModelAndView("reception/guidInfo",map);
	}
	@GetMapping("/guidInfoDetails")
	public ModelAndView recruitDetails(HttpServletRequest request, Map<String, Object> map) {
		String id = request.getParameter("id");
		String guidName = request.getParameter("guidName");
		GuidInfo guidInfo = guidInfoService.selectById(Integer.parseInt(id));
		map.put("guidInfo", guidInfo);
		map.put("guidName", guidName);
		return new ModelAndView("reception/guidInfo_detail", map);
	}
	@GetMapping("/guidSearch")
	public ModelAndView guidSearch(@RequestParam(value = "keyWord", defaultValue = "") String keyWord,
			Map<String, Object> map){
		List<GuidInfoVO> guidInfoVOList = guidInfoService.searchByKeyWord(keyWord);
		map.put("guidInfoVOList", guidInfoVOList);
		return new ModelAndView("reception/guidSearch",map);
	}
}
