package com.heaven.dao.extend;

import java.util.List;

import com.heaven.bean.extend.VideoTypeVO;

public interface VideoTypeVOMapper {
	/**
	 * 查询所有
	 * @return
	 */
	List<VideoTypeVO> selectAll();
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	VideoTypeVO selectById(Integer id);
	/**
	 * 根据类型查询
	 * @param tecTypeId
	 * @return
	 */
	VideoTypeVO selectByTecTypeId(Integer tecTypeId);
	/**
	 * 随机查询2条
	 * @return
	 */
	List<VideoTypeVO> selectRandom2();
	/**
	 * 随机查询3条
	 * @return
	 */
	List<VideoTypeVO> selectRandom3();
}
