package com.thang.tools.dao;


import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;


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

}
