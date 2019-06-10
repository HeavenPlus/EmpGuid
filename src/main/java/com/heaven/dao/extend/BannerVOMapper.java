package com.heaven.dao.extend;

import java.util.List;

import com.heaven.bean.Banner;

public interface BannerVOMapper {
	/**
	 * 根据名称随机查询3条数据
	 * @param imgPage
	 * @return
	 */
	List<Banner> selectByName(String imgPage);
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
