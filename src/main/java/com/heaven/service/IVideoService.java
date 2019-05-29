package com.heaven.service;

import java.util.List;

import com.heaven.bean.Video;
import com.heaven.bean.extend.VideoVO;

public interface IVideoService {
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	VideoVO selectById(Integer id);
	/**
	 * 查询所有
	 * @return
	 */
	List<VideoVO> selectAll();
	/**
	 * 更新
	 * @param video
	 */
	void update(Video video);
	/**
	 * 根据id删除
	 * @param id
	 */
	void deleteById(Integer id);
	/**
	 * 插入
	 * @param video
	 */
	void insert(Video video);
	/**
	 * 根据关键字查询
	 * @param keyWord
	 * @return
	 */
	List<VideoVO> searchByKeyWord(String keyWord);
}
