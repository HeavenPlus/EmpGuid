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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.heaven.bean.Announcement;
import com.heaven.bean.General;
import com.heaven.bean.extend.UserVO;
import com.heaven.service.IAnnouncementService;
import com.heaven.service.IGeneralService;
import com.heaven.service.IUserService;
import com.heaven.utils.CookieUtil;

@RestController
@RequestMapping("/manager")
public class ManagerLoginController {
	@Autowired
	private IAnnouncementService announcementService;
	@Autowired
	private IGeneralService generalService;
	@Autowired
	private IUserService userService;
	@PostMapping("/login")
	public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String result = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserVO user = userService.login(username);
		if (user == null || user.getUserType().getId() != 2) {
			result = "<font color='red'>用户不存在</font>";
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(result);
			return;
		} else if (password.equals(user.getPassword())) {
			CookieUtil.setCookie(response, "guser", username, 7200);
		} else {
			result = "<font color='red'>密码不正确</font>";
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(result);
	}
	@GetMapping("/doLogin")
	public ModelAndView index(HttpServletRequest request, Map<String, Object> map) throws IOException {
		Cookie userName_cookie = CookieUtil.getCookie(request, "guser");
		if(userName_cookie!=null){
			String username = userName_cookie.getValue();
			map.put("guser", username);
		}
		return new ModelAndView("backstage/index", map);
	}
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletResponse response,Map<String, Object> map){
		CookieUtil.setCookie(response, "guser", null, 0);
		List<Announcement> announcementList = announcementService.selectEight();
		List<General> generalList = generalService.findAll();
		map.put("announcementList", announcementList);
		map.put("generalList", generalList);
		return new ModelAndView("reception/index", map);
	}
}
