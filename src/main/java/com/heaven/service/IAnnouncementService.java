package com.heaven.service;

import java.util.List;

import com.heaven.bean.Announcement;
import com.heaven.utils.PageUtil;

public interface IAnnouncementService {
	/**
	 * 查询所有数据
	 * @return
	 */
	List<Announcement> findAll(); 
	
	PageUtil<Announcement> selectArticleList(int pageNum, int pageSize);
}
