package com.heaven.bean.extend;

import java.util.Date;

public class VideoCommentVO {
	private Integer id;
	private String content;
	private Date date;
	private String username;
	private VideoVO videoVO;
	private UserVO userVO;

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

	public VideoVO getVideoVO() {
		return videoVO;
	}

	public void setVideoVO(VideoVO videoVO) {
		this.videoVO = videoVO;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}

	@Override
	public String toString() {
		return "VideoCommentVO [id=" + id + ", content=" + content + ", date=" + date + ", username=" + username
				+ ", videoVO=" + videoVO + ", userVO=" + userVO + "]";
	}

}
