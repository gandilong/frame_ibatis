package com.thang.entity.project;

/**
 * 项目文档
 * @author gandilong
 *
 */
public class Document {

	private int id;  
	private int project;
	private String title;
	private String path;
	
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
