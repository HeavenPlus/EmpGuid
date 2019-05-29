package com.heaven.dao.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heaven.bean.Notes;

public interface NotesVOMapper {
	/**
	 * 更新
	 * @param notes
	 */
	void update(Notes notes);
	/**
	 * 保存
	 * @param notes
	 */
	void save(Notes notes);
	/**
	 * 随机查询
	 * @return
	 */
	List<Notes> selectByRandom();
	/**
	 * 根据关键字查询
	 * @param keyWord
	 * @return
	 */
	List<Notes> searchByKeyWord(@Param("keyWord")String keyWord);
}
