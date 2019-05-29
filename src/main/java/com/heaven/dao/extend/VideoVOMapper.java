package com.heaven.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heaven.bean.Video;
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
	/**
	 * 插入
	 * @param video
	 */
	void insert(Video video);
	/**
	 * 根据关键字查询
	 * @param keyWord
	 * @return
	 */
	List<VideoVO> searchByKeyWord(@Param("keyWord")String keyWord);
}
