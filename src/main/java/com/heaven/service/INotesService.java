package com.heaven.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heaven.bean.Notes;

public interface INotesService {
	
	/**
	 * 查询所有
	 * @return
	 */
	List<Notes> selectAll();
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Notes selectById(Integer id);
	/**
	 * 根据id删除
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 修改
	 * @param noes
	 */
	void update(Notes noes);
	/**
	 * 保存
	 * @param notes
	 */
	void save(Notes notes);
	/**
	 * 随机查询
	 * @return
	 */
	List<Notes> selectByRandom();
	/**
	 * 根据关键字查询
	 * @param keyWord
	 * @return
	 */
	List<Notes> searchByKeyWord(@Param("keyWord")String keyWord);
}
