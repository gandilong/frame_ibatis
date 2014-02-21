package com.thang.tools.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * 底层采用Mybatis
 * @author gandilong
 */
@Deprecated
public abstract class BatchDao extends SqlSessionDaoSupport{

	@Override
	@Resource(name="sqlBatchSession")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
}
