package com.heaven.bean.extend;

import java.util.List;

import com.heaven.bean.VideoComment;
import com.heaven.bean.VideoType;

public class VideoVO {
	private Integer id;
	private String title;
	private String description;
	private String path;
	private String image;
	private VideoType videoType;
	private List<VideoComment> videoComments;

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

	public VideoType getVideoType() {
		return videoType;
	}

	public void setVideoType(VideoType videoType) {
		this.videoType = videoType;
	}

	public List<VideoComment> getVideoComments() {
		return videoComments;
	}

	public void setVideoComments(List<VideoComment> videoComments) {
		this.videoComments = videoComments;
	}

	@Override
	public String toString() {
		return "VideoVO [id=" + id + ", title=" + title + ", description=" + description + ", path=" + path + ", image="
				+ image + ", videoType=" + videoType + ", videoComments=" + videoComments + "]";
	}

}
