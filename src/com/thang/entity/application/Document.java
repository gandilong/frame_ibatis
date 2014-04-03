package com.thang.entity.application;

/**
 * 项目文档
 * @author gandilong
 *
 */
public class Document {

	private int id;  
	private int project;//绑定项目id
	private String title;//标题
	private String path;//存放位置
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
