package com.thang.service.system;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thang.tools.dao.BaseDao;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;
@Service
public class DictManager extends BaseDao{

	
	/**
	 * 通用常询方法
	 * @param values
	 * @return
	 */
	public List<ResultValues> query(ActionValues values){
		return list("system.dict.query", values);
	}
	
	public void toInsert(ActionValues values){
		getSqlSession().insert("system.dict.toInsert", values);
	}
	
	public void toUpate(ActionValues values){
		getSqlSession().update("system.dict.toUpdate", values);
	}
}
