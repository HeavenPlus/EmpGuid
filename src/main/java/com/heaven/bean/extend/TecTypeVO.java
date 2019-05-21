package com.heaven.bean.extend;

import java.util.List;

public class TecTypeVO {
	private Integer id;
	private String typeName;
	private List<VideoTypeVO> videoTypeVOs;

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

	public List<VideoTypeVO> getVideoTypeVOs() {
		return videoTypeVOs;
	}

	public void setVideoTypeVOs(List<VideoTypeVO> videoTypeVOs) {
		this.videoTypeVOs = videoTypeVOs;
	}

	@Override
	public String toString() {
		return "TecTypeVO [id=" + id + ", typeName=" + typeName + ", videoTypeVOs=" + videoTypeVOs + "]";
	}


}
