package com.thang.entity.system;

/**
 * 
 * @author gandilong
 *
 */
public class Resource {

	private int id;
	private String name;//英文名称
	private String title;//中文名称
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
