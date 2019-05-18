package com.heaven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heaven.bean.Announcement;
import com.heaven.bean.AnnouncementExample;
import com.heaven.dao.AnnouncementMapper;
import com.heaven.dao.extend.AnnouncementVOMapper;
import com.heaven.service.IAnnouncementService;
@Service
public class AnnouncementServiceImpl implements IAnnouncementService {
	@Autowired
	private AnnouncementMapper announcementMapper;
	@Autowired
	private AnnouncementVOMapper announcementVOMapper;
	@Override
	public List<Announcement> findAll() {
		AnnouncementExample example = new AnnouncementExample();
		return announcementMapper.selectByExampleWithBLOBs(example);
	}
	@Override
	public List<Announcement> findByRecruId(Integer recruId) {
		
		return announcementVOMapper.selectByRecruId(recruId);
	}
	@Override
	public Announcement findById(Integer id) {
		return announcementMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<Announcement> selectEight() {
		return announcementVOMapper.selectEight();
	}
	@Override
	public void deleteById(Integer id) {
		announcementMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void update(Announcement anno) {
		announcementVOMapper.update(anno);
	}
	@Override
	public void insert(Announcement anno) {
		announcementVOMapper.save(anno);
	}
	
	
}
