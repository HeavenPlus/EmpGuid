package com.heaven.bean.extend;

import java.util.List;

import com.heaven.bean.TecType;
import com.heaven.bean.Video;

public class VideoTypeVO {
	private Integer id;
	private String typeName;
	private TecType tecType;
	private List<Video> videos;
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

	public TecType getTecType() {
		return tecType;
	}

	public void setTecType(TecType tecType) {
		this.tecType = tecType;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	@Override
	public String toString() {
		return "VideoTypeVO [id=" + id + ", typeName=" + typeName + ", tecType=" + tecType + ", videos=" + videos + "]";
	}

	

}
