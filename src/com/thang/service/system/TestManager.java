package com.thang.service.system;

import org.springframework.stereotype.Component;

import com.thang.tools.dao.Dao;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.DataValues;

@Component
public class TestManager extends Dao {

	
	public DataValues getTest(Integer id){
		ActionValues values=new ActionValues();
		values.put("id", id);
		return getSqlSession().selectOne("system.test", values);
	}
	
}
