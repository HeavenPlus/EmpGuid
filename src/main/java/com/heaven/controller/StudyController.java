package com.heaven.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heaven.bean.Notes;
import com.heaven.bean.VideoComment;
import com.heaven.bean.extend.TecTypeVO;
import com.heaven.bean.extend.UserVO;
import com.heaven.bean.extend.VideoTypeVO;
import com.heaven.bean.extend.VideoVO;
import com.heaven.service.INotesService;
import com.heaven.service.ITecTypeService;
import com.heaven.service.IUserService;
import com.heaven.service.IVideoCommentService;
import com.heaven.service.IVideoService;
import com.heaven.service.IVideoTypeService;

@RestController
@RequestMapping("/study")
public class StudyController {

	@Autowired
	private INotesService notesService;
	@Autowired
	private ITecTypeService tecTypeService;
	@Autowired
	private IVideoTypeService videoTypeVOService;
	@Autowired
	private IVideoService videoService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IVideoCommentService videoCommentService;

	@GetMapping("/selectAllNotes")
	public ModelAndView selectAllNotes(@RequestParam(value = "page", defaultValue = "1") Integer page,
			Map<String, Object> map) {
		PageHelper.startPage(page, 10);
		List<Notes> notesList = notesService.selectAll();
		PageInfo<Notes> pageInfo = new PageInfo<>(notesList);
		List<Notes> list = pageInfo.getList();
		map.put("notesList", list);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		return new ModelAndView("reception/notes", map);
	}

	@GetMapping("/notesDetails")
	public ModelAndView notesDetails(HttpServletRequest request, Map<String, Object> map) {
		String id = request.getParameter("id");
		Notes notes = notesService.selectById(Integer.parseInt(id));
		map.put("notes", notes);
		return new ModelAndView("reception/notes_detail", map);
	}

	@GetMapping("/showVideos")
	public ModelAndView showVideos(@RequestParam(value = "typeId", defaultValue = "0") Integer typeId,
			Map<String, Object> map) {
		List<TecTypeVO> allTecTypeList = tecTypeService.selectAll();
		List<TecTypeVO> tecTypeVOs = new ArrayList<>();
		String tecType = null;
		if (typeId == 0) {
			tecTypeVOs = tecTypeService.selectAll();
			tecType = "全部";
		} else if (typeId > 5) {
			return showVideos(0, map);
		} else {
			TecTypeVO tecTypeVO = tecTypeService.selectById(typeId);
			tecTypeVOs.add(tecTypeVO);
			tecType = tecTypeVO.getTypeName();
		}
		map.put("allTecTypeList", allTecTypeList);
		map.put("tecTypeVOs", tecTypeVOs);
		map.put("tecType", tecType);
		return new ModelAndView("reception/videos");
	}

	@GetMapping("/showVideosByType")
	public ModelAndView showVideosByType(@RequestParam(value = "typeId", defaultValue = "0") Integer typeId,
			Map<String, Object> map) {
		List<TecTypeVO> allTecTypeList = tecTypeService.selectAll();
		List<TecTypeVO> tecTypeVOList = new ArrayList<>();
		List<VideoTypeVO> videoTypeVOList = new ArrayList<>();
		String tecType = null;
		String videoType = null;
		TecTypeVO tecTypeVO = new TecTypeVO();
		if (typeId == 0) {
			List<VideoTypeVO> allVideoType = videoTypeVOService.selectAll();
			tecTypeVO.setVideoTypeVOs(allVideoType);
			tecType = "全部";
		} else {
			VideoTypeVO videoTypeVO = videoTypeVOService.selectById(typeId);
			videoTypeVOList.add(videoTypeVO);
			tecTypeVO.setVideoTypeVOs(videoTypeVOList);
			tecType = videoTypeVO.getTecTypeVO().getTypeName();
			videoType = videoTypeVO.getTypeName();
		}
		tecTypeVOList.add(tecTypeVO);
		map.put("allTecTypeList", allTecTypeList);
		map.put("tecTypeVOs", tecTypeVOList);
		map.put("tecType", tecType);
		map.put("videoType", videoType);
		return new ModelAndView("reception/videos");
	}
	@GetMapping("/showVideoDetails")
	public ModelAndView showVideoDetails(@RequestParam Integer id,Map<String,Object> map){
		VideoVO videoVO = videoService.selectById(id);
		map.put("videoVO", videoVO);
		return new ModelAndView("reception/video_detail",map);
	}
	@PostMapping("/commitComment")
	public ModelAndView commitComment(Integer id,String comment,String username,Map<String,Object> map){
		UserVO userVO = userService.login(username);
		VideoComment videoComment = new VideoComment();
		videoComment.setContent(comment);
		videoComment.setVideoId(id);
		videoComment.setUserId(userVO.getId());
		videoComment.setUsername(username);
		videoCommentService.insert(videoComment);
		return showVideoDetails(id, map);
	}
	@GetMapping("/notesSearch")
	public ModelAndView notesSearch(@RequestParam(value = "keyWord", defaultValue = "") String keyWord,
			Map<String, Object> map){
		List<Notes> notesList = notesService.searchByKeyWord(keyWord);
		map.put("notesList", notesList);
		return new ModelAndView("reception/notesSearch",map);
	}
	@GetMapping("/videoSearch")
	public ModelAndView videoSearch(@RequestParam(value = "keyWord", defaultValue = "") String keyWord,
			Map<String, Object> map){
		List<VideoVO> videoVOList = videoService.searchByKeyWord(keyWord);
		map.put("videoVOList", videoVOList);
		return new ModelAndView("reception/videoSearch",map);
	}
}
