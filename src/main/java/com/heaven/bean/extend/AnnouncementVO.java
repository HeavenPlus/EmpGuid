package com.heaven.bean.extend;

import java.util.Date;

import com.heaven.bean.Recruit;

public class AnnouncementVO {
	private Integer id;
	private String name;
	private String content;
	private String author;
	private Date date;
	private Recruit recruit;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Recruit getRecruit() {
		return recruit;
	}
	public void setRecruit(Recruit recruit) {
		this.recruit = recruit;
	}
	@Override
	public String toString() {
		return "AnnouncementVO [id=" + id + ", name=" + name + ", content=" + content + ", author=" + author + ", date="
				+ date + ", recruit=" + recruit + "]";
	}
	
}
