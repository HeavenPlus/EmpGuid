package com.heaven.dao.extend;

import com.heaven.bean.extend.UserVO;

public interface UserVOMapper {
	/**
	 * 根据姓名查找
	 * @param username
	 * @return
	 */
	UserVO selectByName(String username);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	UserVO selectById(Integer id);
}
