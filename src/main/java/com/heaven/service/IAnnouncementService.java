package com.heaven.service;

import java.util.List;

import com.heaven.bean.Announcement;

public interface IAnnouncementService {
	/**
	 * 查询所有数据
	 * @return
	 */
	List<Announcement> findAll(); 
	
	/**
	 * 根据recruId查询
	 * @return
	 */
	List<Announcement> findByRecruId(Integer recruId);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Announcement findById(Integer id);
	
	/**
	 * 查询每个分类前8条数据
	 * @return
	 */
	List<Announcement> selectEight();
}
