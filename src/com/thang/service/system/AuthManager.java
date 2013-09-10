package com.thang.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thang.entity.system.Role;
import com.thang.entity.system.User;
import com.thang.entity.system.UserRole;
import com.thang.executor.DBExecutor;
import com.thang.model.Condition;

@Component
public class AuthManager {

	private DBExecutor dbe;
	/**
	 * 角色的字符串集合
	 * @param id
	 * @return
	 */
	public List<String> getRoleByUser(long id){
		List<String> roles_id=dbe.columns(UserRole.class, "role", new Condition(UserRole.class,null).eq("user", id));
		List<String> roles_name=dbe.columns(Role.class, "name",  new Condition(Role.class,null).in("id", roles_id.toArray()));
		return roles_name;
	}
	
	public User getUserByName(String uname){
		List<User> users=dbe.list(User.class,new Condition(User.class,null).eq("loginName", uname));
		if(null!=users&&users.size()>0){
			return users.get(0);
		}
		return null;
	}

	@Autowired
	public void setDbe(DBExecutor dbe) {
		this.dbe = dbe;
	}
	
	
	
}
