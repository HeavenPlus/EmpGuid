package com.heaven.dao.extend;

import java.util.List;

import com.heaven.bean.GuidInfo;
import com.heaven.bean.extend.GuidInfoVO;

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
	/**
	 * 随机查询
	 * @return
	 */
	List<GuidInfoVO> selectByRandom();
	/**
	 * 查询每种前六
	 * @return
	 */
	List<GuidInfoVO> selectSixByType();
}
