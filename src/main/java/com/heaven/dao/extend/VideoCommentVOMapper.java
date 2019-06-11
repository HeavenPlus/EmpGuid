package com.heaven.dao.extend;

import java.util.List;

import com.heaven.bean.User;
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
	/**
	 * 根据用户名修改
	 * @param user
	 */
	void updateUserName(User user);
	/**
	 * 根据用户名查询
	 * @param username
	 * @return
	 */
	List<VideoCommentVO> selectByUserName(String username);
	/**
	 * 修改
	 * @param videoComment
	 */
	void updateComment(VideoComment videoComment);
}
