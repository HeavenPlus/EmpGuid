package com.heaven.dao.extend;

import java.util.List;

import com.heaven.bean.extend.VideoVO;

public interface VideoVOMapper {
	/**
	 * 查询所有
	 * @return
	 */
	List<VideoVO> selectAll();
	/**
	 * 根据类型查询
	 * @param videoTypeId
	 * @return
	 */
	VideoVO selectByVideoTypeId(Integer videoTypeId);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	VideoVO selectById(Integer id);
	/**
	 * 随机查询两条
	 * @return
	 */
	List<VideoVO> selectRandom2();
	/**
	 * 随机查询3条
	 * @return
	 */
	List<VideoVO> selectRandom3();
}
