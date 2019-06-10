package com.heaven.service;

import java.util.List;

import com.heaven.bean.General;

public interface IGeneralService {
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	General selectById(Integer id);
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
	/**
	 * 按关键字查询
	 * @param keyWord
	 * @return
	 */
	List<General> searchByKeyWord(String keyWord);
	/**
	 * 查询所有
	 * @return
	 */
	List<General> selectAll();
	/**
	 * 插入
	 * @param general
	 */
	void insert(General general);
}
