package com.heaven.dao.extend;

import java.util.List;

import com.heaven.bean.Announcement;

public interface AnnouncementVOMapper {
	/**
	 * 根据类型查询
	 * @param recruId
	 * @return
	 */
	List<Announcement> selectByRecruId(int recruId);
	/**
	 * 查询前八条
	 * @return
	 */
	List<Announcement> selectEight();
	/**
	 * 更新
	 * @param anno
	 */
	void update(Announcement anno);
	/**
	 * 保存
	 * @param anno
	 */
	void save(Announcement anno);
}
