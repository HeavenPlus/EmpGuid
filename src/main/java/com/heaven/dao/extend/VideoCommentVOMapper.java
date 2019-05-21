package com.heaven.dao.extend;

import com.heaven.bean.extend.VideoCommentVO;

public interface VideoCommentVOMapper {
	/**
	 * 根据种类查询
	 * @param videoId
	 * @return
	 */
	VideoCommentVO selectByVideoId(Integer videoId);
}
