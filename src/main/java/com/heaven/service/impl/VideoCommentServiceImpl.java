package com.heaven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heaven.bean.VideoComment;
import com.heaven.bean.extend.VideoCommentVO;
import com.heaven.dao.VideoCommentMapper;
import com.heaven.dao.extend.VideoCommentVOMapper;
import com.heaven.service.IVideoCommentService;

@Service
public class VideoCommentServiceImpl implements IVideoCommentService {
	@Autowired
	private VideoCommentVOMapper videoCommentVOMapper;
	@Autowired
	private VideoCommentMapper videoCommentNapper;

	@Override
	public void insert(VideoComment videoComment) {
		videoCommentVOMapper.insert(videoComment);
	}

	@Override
	public List<VideoCommentVO> selectAll() {
		return videoCommentVOMapper.selectAll();
	}

	@Override
	public void deleteById(Integer id) {
		videoCommentNapper.deleteByPrimaryKey(id);
	}

}
