package com.thang.service.system;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thang.tools.dao.BaseDao;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;

@Service
public class RoleManager extends BaseDao{

	
	/**
	 * 角色查询
	 * @param values
	 * @return
	 */
	public List<ResultValues> query(ActionValues values){
		return list("system.role.query", values);
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
	
	/**
	 * 角色的字符串集合
	 * @param id
	 * @return
	 */
	public List<String> getRoleNameByUser(long uid){
		return getSqlSession().selectList("system.role.getRoleNameByUser",uid);
	}
}
