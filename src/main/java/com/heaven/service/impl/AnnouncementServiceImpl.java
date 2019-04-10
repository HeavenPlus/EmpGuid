package com.heaven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.heaven.bean.Announcement;
import com.heaven.bean.AnnouncementExample;
import com.heaven.dao.AnnouncementMapper;
import com.heaven.service.IAnnouncementService;
import com.heaven.utils.PageUtil;
@Service
public class AnnouncementServiceImpl implements IAnnouncementService {
	@Autowired
	private AnnouncementMapper announcementMapper;
	@Override
	public List<Announcement> findAll() {
		AnnouncementExample example = new AnnouncementExample();
		return announcementMapper.selectByExampleWithBLOBs(example);
	}
	@Override
	public PageUtil<Announcement> selectArticleList(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		AnnouncementExample example = new AnnouncementExample();
		List<Announcement> list = this.announcementMapper.selectByExampleWithBLOBs(example);
		return new PageUtil<>(list);
	}

}
