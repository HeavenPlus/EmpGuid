package com.heaven.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heaven.bean.General;

public interface GeneralVOMapper {
	/**
	 * 修改
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
	List<General> searchByKeyWord(@Param("keyWord")String keyWord);
}
