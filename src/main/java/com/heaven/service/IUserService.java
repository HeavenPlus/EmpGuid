package com.heaven.service;

import com.heaven.bean.User;
import com.heaven.bean.extend.UserVO;

public interface IUserService {
	/**
	 * 根据名称查询
	 * @param username
	 * @return
	 */
	UserVO login(String username);
	/**
	 * 保存
	 * @param user
	 */
	void save(User user);
	/**
	 * 更新
	 * @param user
	 */
	void update(User user);
}
