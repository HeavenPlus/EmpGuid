package com.heaven.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heaven.bean.User;
import com.heaven.bean.extend.UserVO;
import com.heaven.dao.UserMapper;
import com.heaven.dao.extend.UserVOMapper;
import com.heaven.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserVOMapper userVOMapper;
	@Autowired
	private UserMapper userMapper;
	@Override
	public UserVO login(String username) {
		
		return userVOMapper.selectByName(username);
	}
	@Override
	public void save(User user) {
		userMapper.insert(user);
	}
	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKey(user);
	}

}
