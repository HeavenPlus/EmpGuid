package com.heaven.bean.extend;

import java.util.List;

public class VideoVO {
	private Integer id;
	private String title;
	private String description;
	private String path;
	private String image;
	private VideoTypeVO videoTypeVO;
	private List<VideoCommentVO> videoCommentVOs;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public VideoTypeVO getVideoTypeVO() {
		return videoTypeVO;
	}

	public void setVideoTypeVO(VideoTypeVO videoTypeVO) {
		this.videoTypeVO = videoTypeVO;
	}

	public List<VideoCommentVO> getVideoCommentVOs() {
		return videoCommentVOs;
	}

	public void setVideoCommentVOs(List<VideoCommentVO> videoCommentVOs) {
		this.videoCommentVOs = videoCommentVOs;
	}

	@Override
	public String toString() {
		return "VideoVO [id=" + id + ", title=" + title + ", description=" + description + ", path=" + path + ", image="
				+ image + ", videoTypeVO=" + videoTypeVO + ", videoCommentVOs=" + videoCommentVOs + "]";
	}



}
