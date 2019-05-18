package com.heaven.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.heaven.bean.User;
import com.heaven.bean.extend.UserVO;
import com.heaven.service.impl.UserServiceImpl;

@RestController
public class RegistController {
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Autowired
	private UserServiceImpl userService;
	@GetMapping("/regist")
	public ModelAndView regist(){
		return new ModelAndView("reception/regist");
	}
	@PostMapping("/checkRegist")
	public void checkRegist(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String result = "";
		String username = request.getParameter("username");
		UserVO userVO = userService.login(username);
		if(userVO!=null){
			result = "<font color='red'>用户名已被占用</font>";
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(result);
			return; 
		}
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String typeId = request.getParameter("typeId");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setEmail(email);
		
		user.setTypeId(Integer.parseInt(typeId));
		setUser(user);
		result = "ok";
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(result);
	}
	@GetMapping("/doRegist")
	public ModelAndView doRegist(){
		User us = getUser();
		userService.save(us);
		return new ModelAndView("reception/index");
	}
}
