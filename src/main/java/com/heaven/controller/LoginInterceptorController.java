package com.heaven.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.heaven.bean.Notes;
import com.heaven.bean.extend.GuidInfoVO;
import com.heaven.bean.extend.TecTypeVO;
import com.heaven.service.IGuidInfoService;
import com.heaven.service.INotesService;
import com.heaven.service.ITecTypeService;

@RestController
@RequestMapping("/loginInterceptor")
public class LoginInterceptorController {
	@Autowired
	private IGuidInfoService guidInforService;
	@Autowired
	private INotesService notesService;
	@Autowired
	private ITecTypeService tecTypeService;
	@GetMapping("/showGuidInfo")
	public ModelAndView notes(Map<String, Object> map){
		List<GuidInfoVO> selectByRandom = guidInforService.selectByRandom();
		List<GuidInfoVO> selectSixByType = guidInforService.selectSixByType();
		map.put("selectByRandom", selectByRandom);
		map.put("selectSixByType", selectSixByType);
		return new ModelAndView("reception/showGuidInfo",map);
	}
	@GetMapping("/showNotes")
	public ModelAndView showNotes(Map<String,Object> map){
		List<Notes> selectByRandom = notesService.selectByRandom();
		map.put("selectByRandom", selectByRandom);
		return new ModelAndView("reception/showNotes",map);
	}
	@GetMapping("/videos")
	public ModelAndView videos(Map<String,Object> map){
		List<TecTypeVO> tecTypeVORandom2List = tecTypeService.selectRandom2();
		List<TecTypeVO> tecTypeVORandom3List = tecTypeService.selectRandom3();
		map.put("tecTypeVORandom2List", tecTypeVORandom2List);
		map.put("tecTypeVORandom3List", tecTypeVORandom3List);
		return new ModelAndView("reception/videos_index",map);
	}
//	@PostMapping("/upload")
//	@ResponseBody
//	public String upload(@RequestParam MultipartFile file,HttpServletRequest request){
//		String dir = request.getServletContext().getRealPath("/upload");
//		File fileDir = new File(dir);
//		System.out.println(dir);
//		if(!fileDir.exists()){
//			fileDir.mkdirs();
//		}
//		String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//		String fileName = UUID.randomUUID().toString() + fileSuffix;
//		File files = new File(fileDir + "/" + fileName);
//		System.err.println(fileName);
//		try {
//			file.transferTo(files);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "上传失败";
//		}
//		return "上传成功";
//	}
}
