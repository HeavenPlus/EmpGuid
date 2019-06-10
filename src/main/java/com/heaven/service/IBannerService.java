package com.heaven.service;

import java.util.List;

import com.heaven.bean.Banner;

public interface IBannerService {
	/**
	 * 插入
	 * @param banner
	 */
	void insert(Banner banner);
	/**
	 * 查询所有
	 * @return
	 */
	List<Banner> selectAll();
	/**
	 * 根据id删除
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 根据名称随机查询3条数据
	 * @param imgPage
	 * @return
	 */
	List<Banner> selectByName(String imgPage);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Banner selectById(Integer id);
	/**
	 * 随机查询3条
	 * @return
	 */
	List<Banner> selectGuidRandom();
	/**
	 * 随机查询2条
	 * @return
	 */
	List<Banner> selectNotesRandom();
}
