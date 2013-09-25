package com.thang.service.system;

import java.util.List;

import org.springframework.stereotype.Component;

import com.thang.tools.dao.Dao;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.DataValues;
import com.thang.utils.lang.DateUtils;

@Component
public class UserManager extends Dao{

	/**
	 * 登陆查询方法
	 * @param login_name
	 * @param login_pass
	 * @return
	 */
	public DataValues login(String login_name,String login_pass){
		ActionValues values=new ActionValues();
		values.put("loginName", login_name);
		values.put("loginPass", login_pass);
		return get("system.user.login",values);
	}
	
	/**
	 * 通用常询方法
	 * @param values
	 * @return
	 */
	public List<DataValues> query(ActionValues values){
		values.generPage();//把easyui里的分页排序参数 转到 ActionValues里
		return list("system.user.query", values);
	}
	
	/**
	 * 保存方法
	 * @param values
	 */
	public void toInsert(ActionValues values){
		values.put("createTime", DateUtils.getSystime());
		getSqlSession().insert("system.user.toInsert", values);
	}
	
	/**
	 * 更新方法
	 * @param values
	 */
	public void toUpate(ActionValues values){
		getSqlSession().update("system.user.toUpdate", values);
	}
	
	public void toDelete(long id){
		getSqlSession().update("system.user.toUpdate", id);
	}
	
	
}
