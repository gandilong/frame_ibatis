package com.thang.entity.system;

import com.thang.tools.mate.Table;

@Table("sys_user_info")
public class User {

	private int id;
	private String userName;
	private String loginName;
	private String loginNass;
	
	private int used;
	private String email;
	private String createTime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginNass() {
		return loginNass;
	}
	public void setLoginNass(String loginNass) {
		this.loginNass = loginNass;
	}
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
