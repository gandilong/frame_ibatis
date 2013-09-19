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
		return getSqlSession().selectList("system.role.query", values);
	}
}
