package com.heaven.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heaven.bean.Announcement;
import com.heaven.bean.Banner;
import com.heaven.bean.General;
import com.heaven.bean.GuidInfo;
import com.heaven.bean.Notes;
import com.heaven.bean.User;
import com.heaven.bean.Video;
import com.heaven.bean.VideoType;
import com.heaven.bean.extend.TecTypeVO;
import com.heaven.bean.extend.UserVO;
import com.heaven.bean.extend.VideoCommentVO;
import com.heaven.bean.extend.VideoTypeVO;
import com.heaven.bean.extend.VideoVO;
import com.heaven.service.IAnnouncementService;
import com.heaven.service.IBannerService;
import com.heaven.service.IGeneralService;
import com.heaven.service.IGuidInfoService;
import com.heaven.service.INotesService;
import com.heaven.service.ITecTypeService;
import com.heaven.service.IUserService;
import com.heaven.service.IVideoCommentService;
import com.heaven.service.IVideoService;
import com.heaven.service.IVideoTypeService;
import com.heaven.utils.FileUploadUtil;

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
	@Autowired
	private IVideoService videoService;
	@Autowired
	private IVideoTypeService videoTypeService;
	@Autowired
	private ITecTypeService tecTypeService;
	@Autowired
	private IVideoCommentService videoCommentService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IBannerService bannerService;

	@GetMapping("/welcome")
	public ModelAndView welcome() {
		return new ModelAndView("backstage/welcome");
	}

	@GetMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("backstage/index");
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
		List<General> generalList = generalService.selectAll();
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
	public ModelAndView annoDetail(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map) {
		Announcement announcement = announcementService.findById(id);
		map.put("announcement", announcement);
		map.put("currentPage", page);
		return new ModelAndView("backstage/anno_detail", map);
	}

	@PostMapping("/editAnno")
	public void editAnno(@RequestParam Integer id, String title, String author, String content, Integer typeId) {
		Announcement anno = new Announcement();
		anno.setId(id);
		anno.setName(title);
		anno.setAuthor(author);
		anno.setContent(content);
		anno.setRecruidId(typeId);
		announcementService.update(anno);
	}

	@GetMapping("/generDetail")
	public ModelAndView generDetail(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map) {
		General general = generalService.selectById(id);
		map.put("general", general);
		map.put("currentPage", page);
		return new ModelAndView("backstage/gener_detail", map);
	}

	@PostMapping("/editGener")
	public String editGener(General general) {
		try{
			generalService.update(general);
			return "修改成功";
		}catch(Exception e){
			e.printStackTrace();
			return "修改失败，请稍后再试";
		}
	}
	@GetMapping("/addGeneral")
	public ModelAndView addGeneral(){
		return new ModelAndView("backstage/addGeneral");
	}
	@PostMapping("/doAddGeneral")
	public String doAddGeneral(General general){
		try{
			generalService.insert(general);
			return "添加成功";
		}catch(Exception e){
			e.printStackTrace();
			return "添加失败，请稍后重试";
		}
	}
	@GetMapping("/guidInfoDetail")
	public ModelAndView guidInfoDetail(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map) {
		GuidInfo guidInfo = guidInfoService.selectById(id);
		map.put("guidInfo", guidInfo);
		map.put("currentPage", page);
		return new ModelAndView("backstage/guidInfo_detail", map);
	}

	@PostMapping("/editGuidInfo")
	public void editGuidInfo(@RequestParam Integer id, String title, String author, String content, Integer typeId) {
		GuidInfo guidInfo = new GuidInfo();
		guidInfo.setId(id);
		guidInfo.setTitle(title);
		guidInfo.setAuthor(author);
		guidInfo.setContent(content);
		guidInfo.setTypeId(typeId);
		guidInfoService.update(guidInfo);
	}

	@GetMapping("/notesDetail")
	public ModelAndView notesDetail(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map) {
		Notes notes = notesService.selectById(id);
		map.put("notes", notes);
		map.put("currentPage", page);
		return new ModelAndView("backstage/notes_detail", map);
	}

	@PostMapping("/editNotes")
	public void editNotes(@RequestParam Integer id, String title, String author, String content) {
		Notes notes = new Notes();
		notes.setId(id);
		notes.setTitle(title);
		notes.setAuthor(author);
		notes.setContent(content);
		notesService.update(notes);
	}

	@GetMapping("/addAnno")
	public ModelAndView addAnno() {
		return new ModelAndView("backstage/addAnno");
	}

	@PostMapping("/doAddAnno")
	public void doAddAnno(@RequestParam String title, String author, String content, Integer typeId) {
		Announcement announcement = new Announcement();
		announcement.setName(title);
		announcement.setAuthor(author);
		announcement.setContent(content);
		announcement.setRecruidId(typeId);
		announcementService.insert(announcement);
	}

	@GetMapping("/addGuidInfo")
	public ModelAndView addGuidInfo() {
		return new ModelAndView("backstage/addGuidInfo");
	}

	@PostMapping("/doAddGuidInfo")
	public void doAddGuidInfo(@RequestParam String title, String author, String content, Integer typeId) {
		GuidInfo guidInfo = new GuidInfo();
		guidInfo.setTitle(title);
		guidInfo.setAuthor(author);
		guidInfo.setContent(content);
		guidInfo.setTypeId(typeId);
		guidInfoService.save(guidInfo);
	}

	@GetMapping("/addNotes")
	public ModelAndView addNotes() {
		return new ModelAndView("backstage/addNotes");
	}

	@PostMapping("/doAddNotes")
	public void doAddNotes(@RequestParam String title, String author, String content) {
		Notes notes = new Notes();
		notes.setTitle(title);
		notes.setAuthor(author);
		notes.setContent(content);
		notesService.save(notes);
	}

	@GetMapping("/showVideoList")
	public ModelAndView showVideoList(@RequestParam(defaultValue = "1", value = "page") Integer page,
			Map<String, Object> map) {
		PageHelper.startPage(page, 5);
		List<VideoVO> videoVOList = videoService.selectAll();
		PageInfo<VideoVO> pageInfo = new PageInfo<>(videoVOList);
		List<VideoVO> list = pageInfo.getList();
		map.put("videoVOList", list);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		return new ModelAndView("backstage/video_list", map);
	}

	@GetMapping("/videoDetail")
	public ModelAndView videoDetail(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map) {
		VideoVO videoVO = videoService.selectById(id);
		List<VideoType> videoTypes = videoTypeService.findAll();
		map.put("videoVO", videoVO);
		map.put("videoTypes", videoTypes);
		map.put("currentPage", page);
		return new ModelAndView("backstage/video_detail", map);
	}

	@PostMapping("/editVideoDetail")
	public void editVideoDetail(Video video, @RequestParam MultipartFile ifile, MultipartFile vfile,
			HttpServletRequest request) throws Exception {
		if (ifile.getSize() > 0) {
			String oldImagePath = video.getImage();
			String imagePath = FileUploadUtil.upload(oldImagePath, ifile, request);
			video.setImage(imagePath);
		}
		if (vfile.getSize() > 0) {
			String oldVideoPath = video.getPath();
			String videoPath = FileUploadUtil.upload(oldVideoPath, vfile, request);
			video.setPath(videoPath);
			String realPath = request.getServletContext().getRealPath("/videos");
			File file = new File(realPath + "/" + videoPath);
			String videoTime = FileUploadUtil.ReadVideoTime(file);
			video.setTime(videoTime);
		}
		videoService.update(video);
	}

	@GetMapping("/deleteVideo")
	public ModelAndView deleteVideo(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map, HttpServletRequest request) {
		VideoVO videoVO = videoService.selectById(id);
		String imgPath = videoVO.getImage();
		String videoPath = videoVO.getPath();
		String realImgPath = request.getServletContext().getRealPath("/upload");
		String realVideoPath = request.getServletContext().getRealPath("/videos");
		File imgFile = new File(realImgPath + "/" + imgPath);
		File videoFile = new File(realVideoPath + "/" + videoPath);
		if (imgFile.exists()) {
			imgFile.delete();
		}
		if (videoFile.exists()) {
			videoFile.delete();
		}
		videoService.deleteById(id);
		return showVideoList(page, map);
	}

	@GetMapping("/addVideo")
	public ModelAndView addVideo(Map<String, Object> map) {
		List<VideoType> videoTypeList = videoTypeService.findAll();
		map.put("videoTypeList", videoTypeList);
		return new ModelAndView("backstage/addVideo", map);
	}

	@PostMapping("/doAddVideo")
	public String doAddVideo(Video video, MultipartFile ifile, MultipartFile vfile, HttpServletRequest request)
			throws Exception {
		if (ifile.isEmpty()) {
			return "请选择要上传的封面";
		}
		if (vfile.isEmpty()) {
			return "请选择要上传的视频";
		}
		String oldImagePath = video.getImage();
		String imagePath = FileUploadUtil.upload(oldImagePath, ifile, request);
		video.setImage(imagePath);
		String oldVideoPath = video.getPath();
		String videoPath = FileUploadUtil.upload(oldVideoPath, vfile, request);
		video.setPath(videoPath);
		String realPath = request.getServletContext().getRealPath("/videos");
		File file = new File(realPath + "/" + videoPath);
		String videoTime = FileUploadUtil.ReadVideoTime(file);
		video.setTime(videoTime);
		videoService.insert(video);
		return "上传成功";
	}

	@GetMapping("/showCategory")
	public ModelAndView showCategory(@RequestParam(defaultValue = "1", value = "page") Integer page,
			Map<String, Object> map) {
		PageHelper.startPage(page, 6);
		List<VideoTypeVO> videoTypeVOs = videoTypeService.selectAll();
		PageInfo<VideoTypeVO> pageInfo = new PageInfo<>(videoTypeVOs);
		List<VideoTypeVO> list = pageInfo.getList();
		map.put("videoTypeVOs", list);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		return new ModelAndView("backstage/category", map);
	}

	@GetMapping("/videoTypeDetail")
	public ModelAndView videoTypeDetail(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map) {
		VideoTypeVO videoTypeVO = videoTypeService.selectById(id);
		List<TecTypeVO> tecTypeVOs = tecTypeService.selectAll();
		map.put("tecTypeVOs", tecTypeVOs);
		map.put("videoTypeVO", videoTypeVO);
		map.put("currentPage", page);
		return new ModelAndView("backstage/category_detail", map);
	}

	@PostMapping("/editVideoType")
	public void editVideoType(VideoType videoType) {
		videoTypeService.update(videoType);
	}

	@GetMapping("/deleteVideoType")
	public ModelAndView deleteVideoType(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map) {
		videoTypeService.delete(id);
		return showCategory(page, map);
	}

	@GetMapping("/addVideoType")
	public ModelAndView addVideoType(Map<String, Object> map) {
		List<TecTypeVO> tecTypeVOs = tecTypeService.selectAll();
		map.put("tecTypeVOs", tecTypeVOs);
		return new ModelAndView("backstage/addVideoType");
	}

	@PostMapping("/doAddVideoType")
	public String doAddVideoType(VideoType videoType) {
		VideoType type = videoTypeService.selectByName(videoType.getTypeName());
		if (type != null) {
			return "分类已存在";
		}
		videoTypeService.insert(videoType);
		return "success";
	}

	@GetMapping("/showComment")
	public ModelAndView showComment(@RequestParam(defaultValue = "1", value = "page") Integer page,
			Map<String, Object> map) {
		List<VideoCommentVO> VideoCommentVOList = videoCommentService.selectAll();
		PageHelper.startPage(page, 5);
		PageInfo<VideoCommentVO> pageInfo = new PageInfo<>(VideoCommentVOList);
		List<VideoCommentVO> list = pageInfo.getList();
		map.put("VideoCommentVOList", list);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		return new ModelAndView("backstage/showComment");
	}

	@GetMapping("/delComment")
	public ModelAndView delComment(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map) {
		videoCommentService.deleteById(id);
		return showComment(page, map);
	}

	@GetMapping("/showPersonInfo")
	public ModelAndView showPersonInfo(@RequestParam String username, Map<String, Object> map) {
		UserVO userVO = userService.login(username);
		map.put("userVO", userVO);
		return new ModelAndView("backstage/showPersonInfo", map);
	}

	@PostMapping("/editInfo")
	public String editInfo(User user) {
		UserVO userVO = userService.login(user.getUsername());
		if (userVO != null && !userVO.getUsername().equals(user.getUsername())) {
			return "用户名已被占用";
		}
		userService.update(user);
		return "信息修改成功";
	}
	@GetMapping("/showBanner")
	public ModelAndView showBanner(@RequestParam(defaultValue = "1", value = "page") Integer page,Map<String,Object> map){
		PageHelper.startPage(page,5);
		List<Banner> bannerList = bannerService.selectAll();
		PageInfo<Banner> pageInfo = new PageInfo<>(bannerList);
		List<Banner> list = pageInfo.getList();
		map.put("bannerList", list);
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPages());
		return new ModelAndView("backstage/showBanner",map);
	}
	@GetMapping("/addBanner")
	public ModelAndView addBanner(){
		return new ModelAndView("backstage/addBanner");
	}
	@PostMapping("/doAddBanner")
	public String doAddBanner(String imgPage,MultipartFile file,HttpServletRequest request){
		if(file.isEmpty()){
			return "请选择图片";
		}
		try{
			String filePath = FileUploadUtil.upload(null, file, request);
			Banner banner = new Banner();
			banner.setImgPage(imgPage);
			banner.setImage(filePath);
			bannerService.insert(banner);
			return "上传成功";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "上传失败，请稍后再试";
	}
	@GetMapping("/delBanner")
	public ModelAndView delBanner(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer id,
			Map<String, Object> map,HttpServletRequest request) {
		Banner banner = bannerService.selectById(id);
		String imagePath = banner.getImage();
		String realPath = request.getServletContext().getRealPath("/upload");
		File imgFile = new File(realPath + "/" + imagePath);
		if(imgFile.exists()){
			imgFile.delete();
		}
		bannerService.deleteById(id);
		return showBanner(page, map);
	}
}
