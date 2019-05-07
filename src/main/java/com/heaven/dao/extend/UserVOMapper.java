package com.heaven.dao.extend;

import com.heaven.bean.extend.UserVO;

public interface UserVOMapper {
	UserVO selectByName(String username);
}
