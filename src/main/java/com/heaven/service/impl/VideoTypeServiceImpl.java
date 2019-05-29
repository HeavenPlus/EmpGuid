package com.heaven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heaven.bean.VideoType;
import com.heaven.bean.VideoTypeExample;
import com.heaven.bean.extend.VideoTypeVO;
import com.heaven.dao.VideoTypeMapper;
import com.heaven.dao.extend.VideoTypeVOMapper;
import com.heaven.service.IVideoTypeService;

@Service
public class VideoTypeServiceImpl implements IVideoTypeService {

	@Autowired
	private VideoTypeVOMapper videoTypeVOMapper;
	@Autowired
	private VideoTypeMapper videoTypeMapper;
	@Override
	public List<VideoTypeVO> selectAll() {
		return videoTypeVOMapper.selectAll();
	}

	@Override
	public VideoTypeVO selectById(Integer id) {
		return videoTypeVOMapper.selectById(id);
	}

	@Override
	public List<VideoType> findAll() {
		VideoTypeExample example = new VideoTypeExample();
		return videoTypeMapper.selectByExample(example );
	}

	@Override
	public void update(VideoType videoType) {
		videoTypeMapper.updateByPrimaryKey(videoType);
	}

	@Override
	public void delete(Integer id) {
		videoTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public VideoType selectByName(String typeName) {
		return videoTypeVOMapper.selectByName(typeName);
	}

	@Override
	public void insert(VideoType videoType) {
		videoTypeVOMapper.insert(videoType);
	}

	@Override
	public List<VideoTypeVO> searchByKeyWord(String keyWord) {
		return videoTypeVOMapper.searchByKeyWord(keyWord);
	}

}
