package com.thang.entity.application;

/**
 * 部门
 * @author gandilong
 *
 */
public class Dept {

	private int id;
	private String title;
	private String code;//部门编号
	private String phone;
	private int person;//部门主管
	private int operson;//部门副主管
	private int parent;//上一部门
	private String opt;
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	
}
