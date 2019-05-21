package com.heaven.dao.extend;

import java.util.List;

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
}
