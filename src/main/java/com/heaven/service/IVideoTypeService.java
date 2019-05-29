package com.heaven.service;

import java.util.List;

import com.heaven.bean.VideoType;
import com.heaven.bean.extend.VideoTypeVO;

public interface IVideoTypeService {
	/**
	 * 查询所有
	 * @return
	 */
	List<VideoTypeVO> selectAll();
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	VideoTypeVO selectById(Integer id);
	/**
	 * 查询所有
	 * @return
	 */
	List<VideoType> findAll();
	/**
	 * 更新
	 * @param videoType
	 */
	void update(VideoType videoType);
	/**
	 * 根据id删除
	 * @param id
	 */
	void delete(Integer id);
	/**
	 * 根据类别名称查询
	 * @return
	 */
	VideoType selectByName(String typeName);
	/**
	 * 插入
	 * @param videoType
	 */
	void insert(VideoType videoType);
	/**
	 * 根据关键字查询
	 * @param keyWord
	 * @return
	 */
	List<VideoTypeVO> searchByKeyWord(String keyWord);
}
