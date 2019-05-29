package com.heaven.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heaven.bean.VideoType;
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
	/**
	 * 根据类别名称查询
	 * @return
	 */
	VideoType selectByName(String typeName);
	/**
	 * 插入
	 * @param videoType
	 */
	void insert(VideoType videoType);
	/**
	 * 根据关键字查询
	 * @param keyWord
	 * @return
	 */
	List<VideoTypeVO> searchByKeyWord(@Param("keyWord")String keyWord);
}
