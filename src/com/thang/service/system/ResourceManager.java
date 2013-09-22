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
		values.generPage();//把easyui里的分页排序参数 转到 ActionValues里
		return getSqlSession().selectList("system.resource.query", values);
	}
	
	public void toInsert(ActionValues values){
		getSqlSession().insert("system.resource.toInsert", values);
	}
	
	public void toUpate(ActionValues values){
		getSqlSession().update("system.resource.toUpdate", values);
	}
	
	public void toDelete(long id){
		getSqlSession().update("system.resource.toUpdate", id);
	}
	
}
