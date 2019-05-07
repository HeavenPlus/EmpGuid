package com.heaven.service;

import java.util.List;

import com.heaven.bean.General;

public interface IGeneralService {

	List<General> findAll();
	
	General findById(Integer id);
}
