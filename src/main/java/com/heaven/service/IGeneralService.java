package com.heaven.service;

import java.util.List;

import com.heaven.bean.General;

public interface IGeneralService {

	/**
	 * 查询所有
	 * @return
	 */
	List<General> findAll();
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	General findById(Integer id);
	/**
	 * 根据id删除
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 修改
	 * @param general
	 */
	void update(General general);
	/**
	 * 保存
	 * @param eneral
	 */
	void save(General general);
}
