package com.heaven.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heaven.bean.General;

public interface GeneralVOMapper {

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	General selectById(Integer id);
	/**
	 * 更新
	 * @param general
	 */
	void update(General general);
	/**
	 * 保存
	 * @param general
	 */
	void save(General general);
	/**
	 * 根据关键字查询
	 * @param keyWord
	 * @return
	 */
	List<General> searchByKeyWord(@Param("keyWord") String keyWord);
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
