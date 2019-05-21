package com.heaven.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heaven.bean.Notes;
import com.heaven.bean.NotesExample;
import com.heaven.dao.NotesMapper;
import com.heaven.dao.extend.NotesVOMapper;
import com.heaven.service.INotesService;
@Service
public class NotesServiceImpl implements INotesService{

	@Autowired
	private NotesMapper notesMapper;
	@Autowired
	private NotesVOMapper notesVOMapper;
	@Override
	public List<Notes> selectAll() {
		NotesExample example = new NotesExample();
		return notesMapper.selectByExampleWithBLOBs(example );
	}

	@Override
	public Notes selectById(Integer id) {
		return notesMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteById(Integer id) {
		notesMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Notes noes) {
		notesVOMapper.update(noes);
	}

	@Override
	public void save(Notes notes) {
		notesVOMapper.save(notes);
	}

	@Override
	public List<Notes> selectByRandom() {
		return notesVOMapper.selectByRandom();
	}

}
