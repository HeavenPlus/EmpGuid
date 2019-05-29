package com.heaven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heaven.bean.Video;
import com.heaven.bean.extend.VideoVO;
import com.heaven.dao.VideoMapper;
import com.heaven.dao.extend.VideoVOMapper;
import com.heaven.service.IVideoService;
@Service
public class VideoServiceImpl implements IVideoService {
	
	@Autowired
	private VideoVOMapper videoVOMapper;
	@Autowired
	private VideoMapper videoMapper;
	@Override
	public VideoVO selectById(Integer id) {
		return videoVOMapper.selectById(id);
	}
	@Override
	public List<VideoVO> selectAll() {
		return videoVOMapper.selectAll();
	}
	@Override
	public void update(Video video) {
		videoMapper.updateByPrimaryKey(video);
	}
	@Override
	public void deleteById(Integer id) {
		videoMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void insert(Video video) {
		videoVOMapper.insert(video);
	}
	@Override
	public List<VideoVO> searchByKeyWord(String keyWord) {
		return videoVOMapper.searchByKeyWord(keyWord);
	}

}
