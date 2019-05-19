package com.heaven.dao.extend;

import java.util.List;

import com.heaven.bean.GuidInfo;

public interface GuidInfoVOMapper {
	/**
	 * 根据类型查找
	 * @param typeId
	 * @return
	 */
	List<GuidInfo> selectByTypeId(Integer typeId);
	/**
	 * 更新
	 * @param guidInfo
	 */
	void update(GuidInfo guidInfo);
	/**
	 * 保存
	 * @param guidInfo
	 */
	void save(GuidInfo guidInfo);
}
