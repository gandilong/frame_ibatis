package com.thang.service.system;

import java.util.List;

import org.springframework.stereotype.Component;

import com.thang.entity.system.Role;
import com.thang.tools.dao.Dao;
import com.thang.tools.model.ActionValues;

@Component
public class RoleManager extends Dao{

	
	/**
	 * 角色查询
	 * @param values
	 * @return
	 */
	public List<Role> query(ActionValues values){
		values.generPage();//把easyui里的分页排序参数 转到 ActionValues里
		return getSqlSession().selectList("system.role.query", values);
	}
	
	public void toInsert(ActionValues values){
		getSqlSession().insert("system.role.toInsert", values);
	}
	
	public void toUpate(ActionValues values){
		getSqlSession().update("system.role.toUpdate", values);
	}
	
	public void toDelete(ActionValues id){
		getSqlSession().update("system.role.toDelete", id);
	}
}
