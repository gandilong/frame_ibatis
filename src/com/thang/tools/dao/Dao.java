package com.thang.tools.dao;


import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.thang.tools.model.ActionValues;
import com.thang.tools.model.DataValues;


/**
 *
 * @author Gandilong
 */
public class Dao extends SqlSessionDaoSupport {
    
	
	@Override
	@Resource(name="sqlSession")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	/**
	 * 查询一条记录，并把key去掉下划线
	 * @param namespace
	 * @param values
	 * @return
	 */
	public DataValues get(String namespace,ActionValues values){
		DataValues d=getSqlSession().selectOne(namespace, values);
		d.formatKey();
		return d;
	}
	
	public List<DataValues> list(String namespace,ActionValues values){
		List<DataValues> list=getSqlSession().selectList("system.user.query", values);
		for(DataValues d:list){
			d.formatKey();
		}
		return list;
	}

}
