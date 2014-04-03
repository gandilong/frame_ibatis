package com.thang.entity.application;

/**
 * 部门员工
 * @author gandilong
 *
 */
public class Person {

	private int id;
	private String name;//姓名
	private String loginName;//系统账号
	private int sex;
	private String birthday;//出生日期
	private String email;//公司邮箱
	private String address;
	private int dept;//部门
	private int type;//人员类型，如开发人员，测试人员等
	private String comeTime;//入职时间
	private String awayTime;//离职时间
	private String opt;//备注
	
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
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getComeTime() {
		return comeTime;
	}
	public void setComeTime(String comeTime) {
		this.comeTime = comeTime;
	}
	public String getAwayTime() {
		return awayTime;
	}
	public void setAwayTime(String awayTime) {
		this.awayTime = awayTime;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	
}
