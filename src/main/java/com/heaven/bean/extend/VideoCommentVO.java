package com.heaven.bean.extend;

import java.util.Date;

import com.heaven.bean.Video;

public class VideoCommentVO {
	private Integer id;
	private String content;
	private Date date;
	private String username;
	private Video video;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "VideoCommentVO [id=" + id + ", content=" + content + ", date=" + date + ", username=" + username
				+ ", video=" + video + "]";
	}

}
