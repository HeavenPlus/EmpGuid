package com.heaven.service;

import java.util.List;

import com.heaven.bean.VideoComment;
import com.heaven.bean.extend.VideoCommentVO;

public interface IVideoCommentService {
	/**
	 * 插入
	 * @param videoComment
	 */
	void insert(VideoComment videoComment);
	/**
	 * 查询所有
	 * @return
	 */
	List<VideoCommentVO> selectAll();
	/**
	 * 根据id删除
	 * @param id
	 */
	void deleteById(Integer id);
}
