package com.thang.service.system;

import java.util.List;

import org.springframework.stereotype.Component;

import com.thang.tools.dao.Dao;

@Component
public class AuthManager extends Dao{

	/**
	 * 角色的字符串集合
	 * @param id
	 * @return
	 */
	public List<String> getRoleNameByUser(long uid){
		return getSqlSession().selectList("system.auth.getRoleNameByUser",uid);
	}
	
	/**
	 * 资源的字符串集合
	 * @param id
	 * @return
	 */
	public List<String> getResourceNameByUser(long uid){
		return getSqlSession().selectList("system.auth.getResourceNameByUser", uid);
	}
	
	
	
	
	
	
}
