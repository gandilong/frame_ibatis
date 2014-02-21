package com.thang.service.system;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thang.entity.system.Resource;
import com.thang.tools.dao.BaseDao;
import com.thang.tools.model.ActionValues;

@Service
public class ResourceManager extends BaseDao{

	/**
	 * 资源查询
	 * @param values
	 * @return
	 */
	public List<Resource> query(ActionValues values){
		return getSqlSession().selectList("system.resource.query", values);
	}
	
	public void toInsert(ActionValues values){
		getSqlSession().insert("system.resource.toInsert", values);
	}
	
	public void toUpate(ActionValues values){
		getSqlSession().update("system.resource.toUpdate", values);
	}
	
	public void toDelete(ActionValues id){
		getSqlSession().update("system.resource.toDelete", id);
	}
	

	/**
	 * 资源的字符串集合
	 * @param id
	 * @return
	 */
	public List<String> getResourceNameByUser(long uid){
		return getSqlSession().selectList("system.resource.getResourceNameByUser", uid);
	}
	
}
