package com.thang.service.system;

import java.util.List;

import org.springframework.stereotype.Component;

import com.thang.entity.system.SLog;
import com.thang.tools.dao.Dao;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.DataValues;

@Component
public class SLogManager extends Dao{

	
	public void toDelete(SLog log){
		
	}
	
	public String total(ActionValues values){
		return getSqlSession().selectOne("system.slog.total", values);
	}
	
	public List<DataValues> query(ActionValues values){
		return getSqlSession().selectList("system.slog.query", values);
	}
	
	
}
