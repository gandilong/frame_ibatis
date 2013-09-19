package com.thang.service.system;

import java.util.List;

import org.springframework.stereotype.Component;

import com.thang.entity.system.Resource;
import com.thang.tools.dao.Dao;
import com.thang.tools.model.ActionValues;

@Component
public class ResourceManager extends Dao{

	
	
	/**
	 * 资源查询
	 * @param values
	 * @return
	 */
	public List<Resource> query(ActionValues values){
		return getSqlSession().selectList("system.resource.query", values);
	}
	
}
