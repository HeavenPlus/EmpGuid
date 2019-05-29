package com.heaven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heaven.bean.General;
import com.heaven.bean.GeneralExample;
import com.heaven.dao.GeneralMapper;
import com.heaven.dao.extend.GeneralVOMapper;
import com.heaven.service.IGeneralService;

@Service
public class GeneralServiceImpl implements IGeneralService {

	
	@Autowired
	private GeneralMapper generalMapper;
	@Autowired
	private GeneralVOMapper generalVOMapper;
	@Override
	public List<General> findAll() {
		GeneralExample example = new GeneralExample();
		return generalMapper.selectByExampleWithBLOBs(example);
	}
	@Override
	public General findById(Integer id) {
		return generalMapper.selectByPrimaryKey(id);
	}
	@Override
	public void deleteById(Integer id) {
		generalMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void update(General general) {
		generalVOMapper.update(general);
	}
	@Override
	public void save(General general) {
		generalVOMapper.save(general);
	}
	@Override
	public List<General> searchByKeyWord(String keyWord) {
		return generalVOMapper.searchByKeyWord(keyWord);
	}

}
