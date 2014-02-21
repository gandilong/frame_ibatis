package com.thang.entity.system;

import com.thang.tools.mate.Table;
import com.thang.tools.util.DateUtils;


@Table("sys_slog_info")
public class SLog {

	private long id;
	private String operator;
	private String action;
	private String time;
	
	public SLog(){};
	
	public SLog(String operator, String action, String time) {
		super();
		this.operator = operator;
		this.action = action;
		this.time = time;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public static SLog getLog(String operator,String action){
		return new SLog(operator,action,DateUtils.getSystime());
	}
	
}
