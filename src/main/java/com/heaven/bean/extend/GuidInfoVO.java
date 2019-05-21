package com.heaven.bean.extend;

import java.util.Date;

import com.heaven.bean.GuidType;

public class GuidInfoVO {
	private Integer id;
	private String title;
	private String author;
	private String content;
	private Date date;
	private GuidType guidType;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public GuidType getGuidType() {
		return guidType;
	}
	public void setGuidType(GuidType guidType) {
		this.guidType = guidType;
	}
	@Override
	public String toString() {
		return "GuidInfoVO [id=" + id + ", title=" + title + ", author=" + author + ", content=" + content + ", date="
				+ date + ", guidType=" + guidType + "]";
	}
	
}
