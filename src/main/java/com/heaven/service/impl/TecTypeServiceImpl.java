package com.heaven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heaven.bean.extend.TecTypeVO;
import com.heaven.dao.extend.TecTypeVOMapper;
import com.heaven.service.ITecTypeService;

@Service
public class TecTypeServiceImpl implements ITecTypeService {

	@Autowired
	private TecTypeVOMapper tecTypeVOMapper;
	@Override
	public List<TecTypeVO> selectAll() {
		return tecTypeVOMapper.selectAll();
	}
	@Override
	public List<TecTypeVO> selectRandom2() {
		return tecTypeVOMapper.selectRandom2();
	}
	@Override
	public List<TecTypeVO> selectRandom3() {
		return tecTypeVOMapper.selectRandom3();
	}
	@Override
	public TecTypeVO selectById(Integer id) {
		return tecTypeVOMapper.selectById(id);
	}

}
