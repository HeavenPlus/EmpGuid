package com.heaven.bean.extend;

import java.util.List;

public class VideoTypeVO {
	private Integer id;
	private String typeName;
	private TecTypeVO tecTypeVO;
	private List<VideoVO> videoVOs;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	

	public List<VideoVO> getVideoVOs() {
		return videoVOs;
	}

	public void setVideoVOs(List<VideoVO> videoVOs) {
		this.videoVOs = videoVOs;
	}

	public TecTypeVO getTecTypeVO() {
		return tecTypeVO;
	}

	public void setTecTypeVO(TecTypeVO tecTypeVO) {
		this.tecTypeVO = tecTypeVO;
	}

	@Override
	public String toString() {
		return "VideoTypeVO [id=" + id + ", typeName=" + typeName + ", tecTypeVO=" + tecTypeVO + ", videoVOs="
				+ videoVOs + "]";
	}





}
