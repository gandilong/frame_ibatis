package com.thang.entity.system;

/**
 * 
 * @author gandilong
 * 用户角色类
 *
 */
public class UserRole {

	private int id;
	private int user;//用户ID
	private int role;//角色ID
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
}
