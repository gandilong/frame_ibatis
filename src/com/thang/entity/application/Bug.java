package com.thang.entity.application;

public class Bug {

	private long id;
	private int project;//项目id
	private int fixed;//是否修正，0否，1是
	private int reopen;//是否重新开启，0否，1是；重新开启后 fixed也要变成0
	private int fixer;//修改人
	private int tester;//测试人
	private String createTime;//创建时间
	private String submitTime;//提交时间
	private String closeTime;//关闭时间
    private String opt;//创建时添加的备注	
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}
	public int getFixed() {
		return fixed;
	}
	public void setFixed(int fixed) {
		this.fixed = fixed;
	}
	public int getReopen() {
		return reopen;
	}
	public void setReopen(int reopen) {
		this.reopen = reopen;
	}
	public int getFixer() {
		return fixer;
	}
	public void setFixer(int fixer) {
		this.fixer = fixer;
	}
	public int getTester() {
		return tester;
	}
	public void setTester(int tester) {
		this.tester = tester;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
    
}
