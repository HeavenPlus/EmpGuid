package com.heaven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heaven.bean.Notes;
import com.heaven.bean.NotesExample;
import com.heaven.dao.NotesMapper;
import com.heaven.service.IStudyService;
@Service
public class StudyServiceImpl implements IStudyService{

	@Autowired
	private NotesMapper notesMapper;
	@Override
	public List<Notes> selectAllNotes() {
		NotesExample example = new NotesExample();
		return notesMapper.selectByExampleWithBLOBs(example );
	}

	@Override
	public Notes selectById(Integer id) {
		return notesMapper.selectByPrimaryKey(id);
	}

}
