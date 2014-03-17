package com.thang.tools.dao;


import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;

/**
 * 底层采用Mybatis
 * @author Gandilong
 */
public class MDao extends SqlSessionDaoSupport {
    
	
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
	public ResultValues get(String namespace,ActionValues values){
		ResultValues d=getSqlSession().selectOne(namespace, values);
		if(null!=d){
			d.formatKey();
		}
		return d;
	}
	
	public List<ResultValues> list(String namespace,ActionValues values){
		List<ResultValues> list=getSqlSession().selectList(namespace, values);
		for(ResultValues d:list){
			d.formatKey();
		}
		return list;
	}
	
}
