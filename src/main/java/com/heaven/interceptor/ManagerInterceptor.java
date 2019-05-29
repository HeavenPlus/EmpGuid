package com.heaven.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.heaven.exception.LoginException;
import com.heaven.utils.CookieUtil;

@Configuration
@Aspect
public class ManagerInterceptor {
	
	@Pointcut("execution(* com.heaven.controller.ManagerController.*(..))")
	public void verify() {}
	
	@Before("verify()")
	public void doVerify() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		Cookie cookie = CookieUtil.getCookie(request, "guser");
		if (cookie == null) {
			throw new LoginException();
		}
		String username = cookie.getValue();
		request.setAttribute("guser", username);
	}
	
}
