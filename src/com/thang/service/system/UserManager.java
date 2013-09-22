package com.thang.service.system;

import java.util.List;

import org.springframework.stereotype.Component;

import com.thang.entity.system.User;
import com.thang.tools.dao.Dao;
import com.thang.tools.model.ActionValues;

@Component
public class UserManager extends Dao{

	
	public User login(String login_name,String login_pass){
		ActionValues values=new ActionValues();
		values.put("login_name", login_name);
		values.put("login_pass", login_pass);
		return getSqlSession().selectOne("system.user.login",values);
	}
	
	public List<User> query(ActionValues values){
		values.generPage();//把easyui里的分页排序参数 转到 ActionValues里
		return getSqlSession().selectList("system.user.query", values);
	}
	
	public void toInsert(ActionValues values){
		getSqlSession().insert("system.user.toInsert", values);
	}
	
	public void toUpate(ActionValues values){
		getSqlSession().update("system.user.toUpdate", values);
	}
	
	public void toDelete(long id){
		getSqlSession().update("system.user.toUpdate", id);
	}
	
	
}
