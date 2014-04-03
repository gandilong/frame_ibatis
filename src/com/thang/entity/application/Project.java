package com.thang.entity.application;

/**
 * 项目
 * @author gandilong
 *
 */
public class Project {

	private int id;
	private String title;//项目名称
	private String code;//项目代号
	private int person;//项目经理
	private int status;
	private String devPerson;//参与项目的开发人员，有逗号分隔
	private String testPerson;//参与项目的测试人员，有逗号分隔
	private String createTime;//项目启动时间
	private String overTime;//项目结束时间
	private String opt;//备注
	
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
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDevPerson() {
		return devPerson;
	}
	public void setDevPerson(String devPerson) {
		this.devPerson = devPerson;
	}
	public String getTestPerson() {
		return testPerson;
	}
	public void setTestPerson(String testPerson) {
		this.testPerson = testPerson;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getOverTime() {
		return overTime;
	}
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	
}
