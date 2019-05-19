package com.heaven.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heaven.bean.Notes;
import com.heaven.service.INotesService;

@RestController
@RequestMapping("/study")
public class StudyController {

	@Autowired
	private INotesService notesService;
	
	@GetMapping("/selectAllNotes")
	public ModelAndView selectAllNotes(@RequestParam(value = "page", defaultValue = "1") Integer page,
			Map<String, Object> map){
		PageHelper.startPage(page, 10);
		List<Notes> notesList = notesService.selectAll();
		PageInfo<Notes> pageInfo = new PageInfo<>(notesList);
		List<Notes> list = pageInfo.getList();
		map.put("notesList", list);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		return new ModelAndView("reception/notes",map);
	}
	
	@GetMapping("/notesDetails")
	public ModelAndView notesDetails(HttpServletRequest request, Map<String, Object> map) {
		String id = request.getParameter("id");
		Notes notes = notesService.selectById(Integer.parseInt(id));
		map.put("notes", notes);
		return new ModelAndView("reception/notes_detail", map);
	}
	@GetMapping("/videos")
	public ModelAndView videos(){
		return new ModelAndView("reception/videos_index");
	}
	
}
