package com.heaven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heaven.bean.GuidInfo;
import com.heaven.bean.GuidInfoExample;
import com.heaven.bean.extend.GuidInfoVO;
import com.heaven.dao.GuidInfoMapper;
import com.heaven.dao.extend.GuidInfoVOMapper;
import com.heaven.service.IGuidInfoService;

@Service
public class GuidInfoServiceImpl implements IGuidInfoService {
	@Autowired
	private GuidInfoVOMapper guidInfoVOMapper;
	@Autowired
	private GuidInfoMapper guidInfoMapper;

	@Override
	public List<GuidInfo> selectByTypeId(Integer typeId) {
		return guidInfoVOMapper.selectByTypeId(typeId);
	}

	@Override
	public GuidInfo selectById(Integer id) {
		return guidInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<GuidInfo> selectAll() {
		GuidInfoExample example = new GuidInfoExample();
		return guidInfoMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void deleteById(Integer id) {
		guidInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(GuidInfo guidInfo) {
		guidInfoVOMapper.update(guidInfo);
	}

	@Override
	public void save(GuidInfo guidInfo) {
		guidInfoVOMapper.save(guidInfo);
	}

	@Override
	public List<GuidInfoVO> selectByRandom() {
		return guidInfoVOMapper.selectByRandom();
	}

	@Override
	public List<GuidInfoVO> selectSixByType() {
		return guidInfoVOMapper.selectSixByType();
	}

	@Override
	public List<GuidInfoVO> searchByKeyWord(String keyWord) {
		return guidInfoVOMapper.searchByKeyWord(keyWord);
	}

}
