package com.heaven.service;

import java.util.List;

import com.heaven.bean.GuidInfo;

public interface IGuidInfoService {
	/**
	 * 根据类型查询
	 * @param typeId
	 * @return
	 */
	List<GuidInfo> selectByTypeId(Integer typeId);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	GuidInfo selectById(Integer id);
	/**
	 * 查询所有
	 * @return
	 */
	List<GuidInfo> selectAll();
	/**
	 * 根据id删除
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 修改
	 * @param guidInfo
	 */
	void update(GuidInfo guidInfo);
	/**
	 * 保存
	 * @param guidInfo
	 */
	void save(GuidInfo guidInfo);
}
