package com.heaven.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heaven.bean.Announcement;
import com.heaven.bean.General;
import com.heaven.bean.GuidInfo;
import com.heaven.bean.Notes;
import com.heaven.service.IAnnouncementService;
import com.heaven.service.IGeneralService;
import com.heaven.service.IGuidInfoService;
import com.heaven.service.INotesService;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private IAnnouncementService announcementService;
	@Autowired
	private IGeneralService generalService;
	@Autowired
	private INotesService notesService;
	@Autowired
	private IGuidInfoService guidInfoService;

	@GetMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("backstage/index");
	}

	@GetMapping("/welcome")
	public ModelAndView welcome() {
		return new ModelAndView("backstage/welcome");
	}

	@GetMapping("/annoList")
	public ModelAndView annoList(@RequestParam(defaultValue = "1", value = "page") Integer page,
			Map<String, Object> map) {
		PageHelper.startPage(page, 9);
		List<Announcement> announcementList = announcementService.findAll();
		PageInfo<Announcement> pageInfo = new PageInfo<>(announcementList);
		List<Announcement> list = pageInfo.getList();
		map.put("announcementList", list);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		return new ModelAndView("backstage/anno_list", map);
	}

	@GetMapping("/generList")
	public ModelAndView generList(@RequestParam(defaultValue = "1", value = "page") Integer page,
			Map<String, Object> map) {
		PageHelper.startPage(page, 9);
		List<General> generalList = generalService.findAll();
		PageInfo<General> pageInfo = new PageInfo<>(generalList);
		List<General> list = pageInfo.getList();
		map.put("generalList", list);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		return new ModelAndView("backstage/gener_list", map);
	}

	@GetMapping("/notesList")
	public ModelAndView notesList(@RequestParam(defaultValue = "1", value = "page") Integer page,
			Map<String, Object> map) {
		PageHelper.startPage(page, 9);
		List<Notes> notesList = notesService.selectAll();
		PageInfo<Notes> pageInfo = new PageInfo<>(notesList);
		List<Notes> list = pageInfo.getList();
		map.put("notesList", list);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		return new ModelAndView("backstage/notes_list", map);
	}

	@GetMapping("/guidInfoList")
	public ModelAndView guidInfoList(@RequestParam(defaultValue = "1", value = "page") Integer page,
			Map<String, Object> map) {
		PageHelper.startPage(page, 9);
		List<GuidInfo> guidInfoList = guidInfoService.selectAll();
		PageInfo<GuidInfo> pageInfo = new PageInfo<>(guidInfoList);
		List<GuidInfo> list = pageInfo.getList();
		map.put("guidInfoList", list);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		return new ModelAndView("backstage/guidinfo_list", map);
	}

	@GetMapping("/deleteAnno")
	public ModelAndView deleteAnno(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map) {
		announcementService.deleteById(id);
		return annoList(page, map);
	}

	@GetMapping("/deleteGener")
	public ModelAndView deleteGener(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map) {
		generalService.deleteById(id);
		return generList(page, map);
	}

	@GetMapping("/deleteNotes")
	public ModelAndView deleteNotes(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map) {
		notesService.deleteById(id);
		return notesList(page, map);
	}

	@GetMapping("/deleteGuidInfo")
	public ModelAndView deleteGuidInfo(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map) {
		guidInfoService.deleteById(id);
		return guidInfoList(page, map);
	}

	@GetMapping("/annoDetail")
	public ModelAndView annoDetail(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,Map<String,Object> map){
		Announcement announcement = announcementService.findById(id);
		map.put("announcement", announcement);
		map.put("currentPage", page);
		return new ModelAndView("backstage/anno_detail",map);
	}
	@PostMapping("/editAnno")
	public void editAnno(@RequestParam Integer id, String title,String author,String content,Integer typeId){
		Announcement anno = new Announcement();
		anno.setId(id);
		anno.setName(title);
		anno.setAuthor(author);
		anno.setContent(content);
		anno.setRecruidId(typeId);
		announcementService.update(anno);
	}
	@GetMapping("/generDetail")
	public ModelAndView generDetail(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,Map<String,Object> map){
		General general = generalService.findById(id);
		map.put("general", general);
		map.put("currentPage", page);
		return new ModelAndView("backstage/gener_detail",map);
	}
	
	@PostMapping("/editGener")
	public void editGener(@RequestParam Integer id, String title,String author,String content){
		General general = new General();
		general.setId(id);
		general.setTitle(title);
		general.setAuthor(author);
		general.setContent(content);
		generalService.update(general);
	}
	@GetMapping("/guidInfoDetail")
	public ModelAndView guidInfoDetail(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,Map<String,Object> map){
		GuidInfo guidInfo = guidInfoService.selectById(id);
		map.put("guidInfo", guidInfo);
		map.put("currentPage", page);
		return new ModelAndView("backstage/guidInfo_detail",map);
	}
	
	@PostMapping("/editGuidInfo")
	public void editGuidInfo(@RequestParam Integer id, String title,String author,String content,Integer typeId){
		GuidInfo guidInfo = new GuidInfo();
		guidInfo.setId(id);
		guidInfo.setTitle(title);
		guidInfo.setAuthor(author);
		guidInfo.setContent(content);
		guidInfo.setTypeId(typeId);
		guidInfoService.update(guidInfo);
	}
	@GetMapping("/notesDetail")
	public ModelAndView notesDetail(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,Map<String,Object> map){
		Notes notes = notesService.selectById(id);
		map.put("notes", notes);
		map.put("currentPage", page);
		return new ModelAndView("backstage/notes_detail",map);
	}
	@PostMapping("/editNotes")
	public void editNotes(@RequestParam Integer id, String title,String author,String content){
		Notes notes = new Notes();
		notes.setId(id);
		notes.setTitle(title);
		notes.setAuthor(author);
		notes.setContent(content);
		notesService.update(notes);
	}
	@GetMapping("/addAnno")
	public ModelAndView addAnno(){
		return new ModelAndView("backstage/addAnno");
	}
	@PostMapping("/doAddAnno")
	public void doAddAnno(@RequestParam String title,String author,String content,Integer typeId){
		if(typeId==6){
			General general = new General();
			general.setTitle(title);
			general.setAuthor(author);
			general.setContent(content);
			generalService.save(general);
		}else{
			Announcement announcement = new Announcement();
			announcement.setName(title);
			announcement.setAuthor(author);
			announcement.setContent(content);
			announcement.setRecruidId(typeId);
			announcementService.insert(announcement);
		}
		
	}
	@GetMapping("/addGuidInfo")
	public ModelAndView addGuidInfo(){
		return new ModelAndView("backstage/addGuidInfo");
	}
	@PostMapping("/doAddGuidInfo")
	public void doAddGuidInfo(@RequestParam String title,String author,String content,Integer typeId){
		GuidInfo guidInfo = new GuidInfo();
		guidInfo.setTitle(title);
		guidInfo.setAuthor(author);
		guidInfo.setContent(content);
		guidInfo.setTypeId(typeId);
		guidInfoService.save(guidInfo);
	}
	@GetMapping("/addNotes")
	public ModelAndView addNotes(){
		return new ModelAndView("backstage/addNotes");
	}
	@PostMapping("/doAddNotes")
	public void doAddNotes(@RequestParam String title,String author,String content){
		Notes notes = new Notes();
		notes.setTitle(title);
		notes.setAuthor(author);
		notes.setContent(content);
		notesService.save(notes);
	}
}
