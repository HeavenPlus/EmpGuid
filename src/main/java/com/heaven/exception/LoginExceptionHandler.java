package com.heaven.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class LoginExceptionHandler {
	@ExceptionHandler(value=LoginException.class)
	public ModelAndView handlerException(HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script language=\"javascript\">alert('请先登录！');window.location.href='/EmpGuid/recruit/index'</script>");
		return new ModelAndView("reception/index");
	}
}
