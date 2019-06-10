package com.heaven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heaven.bean.Banner;
import com.heaven.bean.BannerExample;
import com.heaven.dao.BannerMapper;
import com.heaven.dao.extend.BannerVOMapper;
import com.heaven.service.IBannerService;
@Service
public class BannerServiceImpl implements IBannerService {
	@Autowired
	private BannerMapper bannerMapper;
	@Autowired
	private BannerVOMapper bannerVOMapper;
	@Override
	public void insert(Banner banner) {
		bannerMapper.insertSelective(banner);
	}
	@Override
	public List<Banner> selectAll() {
		BannerExample example = new BannerExample();
		return bannerMapper.selectByExample(example);
	}
	@Override
	public void deleteById(Integer id) {
		bannerMapper.deleteByPrimaryKey(id);
	}
	@Override
	public List<Banner> selectByName(String imgPage) {
		return bannerVOMapper.selectByName(imgPage);
	}
	@Override
	public Banner selectById(Integer id) {
		return bannerMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<Banner> selectGuidRandom() {
		return bannerVOMapper.selectGuidRandom();
	}
	@Override
	public List<Banner> selectNotesRandom() {
		return bannerVOMapper.selectNotesRandom();
	}

}
