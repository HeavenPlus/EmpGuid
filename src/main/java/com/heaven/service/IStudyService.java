package com.heaven.service;

import java.util.List;

import com.heaven.bean.Notes;

public interface IStudyService {
	List<Notes> selectAllNotes();
	Notes selectById(Integer id);
}
