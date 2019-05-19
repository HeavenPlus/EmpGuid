package com.heaven.bean.extend;

import java.util.List;

import com.heaven.bean.VideoType;

public class TecTypeVO {
	private Integer id;
	private String typeName;
	private List<VideoType> videoTypes;

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

	public List<VideoType> getVideoTypes() {
		return videoTypes;
	}

	public void setVideoTypes(List<VideoType> videoTypes) {
		this.videoTypes = videoTypes;
	}

	@Override
	public String toString() {
		return "TecTypeVO [id=" + id + ", typeName=" + typeName + ", videoTypes=" + videoTypes + "]";
	}

}
