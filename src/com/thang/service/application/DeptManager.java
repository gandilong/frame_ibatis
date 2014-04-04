package com.thang.service.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thang.tools.dao.BaseDao;
import com.thang.tools.model.ActionValues;
import com.thang.tools.model.ResultValues;

@Service
public class DeptManager extends BaseDao{

	/**
	 * 查询一级部门，即公司
	 * @param values
	 * @return
	 */
	public ResultValues queryTop(){
		ActionValues values=new ActionValues();
		values.put("parent",0);
		return get("application.dept.query", values);
	}
	
	/**
	 * 查询二级部门
	 * @param values
	 * @return
	 */
	public List<ResultValues> querySub(ActionValues values){
		return list("application.dept.query", values);
	}
	
	
}
