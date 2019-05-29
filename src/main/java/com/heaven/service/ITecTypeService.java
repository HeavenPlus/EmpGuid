package com.heaven.service;

import java.util.List;

import com.heaven.bean.extend.TecTypeVO;

public interface ITecTypeService {
	/**
	 * 查询所有
	 * @return
	 */
	List<TecTypeVO> selectAll();
	/**
	 * 随机查询2条
	 * @return
	 */
	List<TecTypeVO> selectRandom2();
	/**
	 * 随机查询3条
	 * @return
	 */
	List<TecTypeVO> selectRandom3();
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	TecTypeVO selectById(Integer id);
}
