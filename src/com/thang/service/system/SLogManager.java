package com.thang.service.system;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thang.entity.system.SLog;
import com.thang.tools.dao.BaseDao;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;

@Service
public class SLogManager extends BaseDao{

	
	public void toDelete(SLog log){
		
	}
	
	public String total(ActionValues values){
		return getSqlSession().selectOne("system.slog.total", values);
	}
	
	public List<ResultValues> query(ActionValues values){
		return getSqlSession().selectList("system.slog.query", values);
	}
	
	
}
