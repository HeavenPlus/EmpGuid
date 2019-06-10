package com.heaven.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heaven.bean.Announcement;
import com.heaven.bean.Banner;
import com.heaven.bean.General;
import com.heaven.bean.extend.UserVO;
import com.heaven.service.IAnnouncementService;
import com.heaven.service.IBannerService;
import com.heaven.service.IGeneralService;
import com.heaven.service.IUserService;
import com.heaven.utils.CookieUtil;

@RestController
public class LoginController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IAnnouncementService announcementService;
	@Autowired
	private IGeneralService generalService;
	@Autowired
	private IBannerService bannerSerice;
	@GetMapping("/doLogin")
	public ModelAndView login(HttpServletRequest request, Map<String, Object> map) throws IOException {
		List<Announcement> announcementList = announcementService.selectEight();
		Cookie userName_cookie = CookieUtil.getCookie(request, "username");
		List<Banner> genImgList = bannerSerice.selectByName("招聘简章");
		List<Banner> annoImgList = bannerSerice.selectByName("招聘宣传");
		PageHelper.startPage(1,8);
		List<General> generalList = generalService.selectAll();
		PageInfo<General> pageInfo = new PageInfo<>(generalList);
		List<General> list = pageInfo.getList();
		String username = userName_cookie.getValue();
		map.put("announcementList", announcementList);
		map.put("generalList", list);
		map.put("username", username);
		map.put("genImgList", genImgList);
		map.put("annoImgList", annoImgList);
		return new ModelAndView("reception/index", map);
	}

	@PostMapping("/login")
	public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username == null || username.trim().equals("")) {
			result = "<font color='red'>用户名不能为空</font>";
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(result);
			return;
		} else if (password == null || password.trim().equals("")) {
			result = "<font color='red'>密码不能为空</font>";
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(result);
			return;
		}
		UserVO user = userService.login(username);
		if (user == null || user.getUserType().getId() != 1) {
			result = "<font color='red'>用户不存在</font>";
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(result);
			return;
		} else if (password.equals(user.getPassword())) {
			CookieUtil.setCookie(response, "username", username, 7200);
		} else {
			result = "<font color='red'>密码不正确</font>";
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(result);
			return;
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(result);
	}
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletResponse response,Map<String, Object> map){
		List<Banner> genImgList = bannerSerice.selectByName("招聘简章");
		List<Banner> annoImgList = bannerSerice.selectByName("招聘宣传");
		CookieUtil.setCookie(response, "username", null, 0);
		List<Announcement> announcementList = announcementService.selectEight();
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
}
