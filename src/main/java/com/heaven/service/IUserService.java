package com.heaven.service;

import com.heaven.bean.User;
import com.heaven.bean.extend.UserVO;

public interface IUserService {
	
	UserVO login(String username);
	
	void save(User user);
}
