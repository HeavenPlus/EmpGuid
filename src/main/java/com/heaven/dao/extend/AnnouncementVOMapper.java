package com.heaven.dao.extend;

import java.util.List;

import com.heaven.bean.Announcement;

public interface AnnouncementVOMapper {
	List<Announcement> selectByRecruId(int recruId);
	
	List<Announcement> selectEight();
}
