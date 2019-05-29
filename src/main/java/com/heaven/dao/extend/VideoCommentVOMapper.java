package com.heaven.dao.extend;

import java.util.List;

import com.heaven.bean.VideoComment;
import com.heaven.bean.extend.VideoCommentVO;

public interface VideoCommentVOMapper {
	/**
	 * 根据种类查询
	 * @param videoId
	 * @return
	 */
	VideoCommentVO selectByVideoId(Integer videoId);
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
}
