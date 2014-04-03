package com.thang.entity.application;

/**
 * 部门
 * @author gandilong
 *
 */
public class Dept {

	private int id;
	private String title;
	private int person;//部门主管
	private int operson;//部门副主管
	private int parent;//上一部门
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;  
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public int getOperson() {
		return operson;
	}
	public void setOperson(int operson) {
		this.operson = operson;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	
}
